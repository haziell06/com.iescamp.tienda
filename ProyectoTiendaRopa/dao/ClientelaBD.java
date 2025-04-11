package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.empleado.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientelaBD {
    public static void cargarClientes(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.obtenerTodos();
        System.out.println("Clientes obtenidos desde la BD: " + clientes.size());
        for (Cliente c : clientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
        }
    }
    public static void validarContraseña(){
        String email = ConsoleReader.readString("Introduce el email: ");
        String pass = ConsoleReader.readString("Introduce la contraseña: ");
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.autenticarCliente(email, pass);

        if (cliente != null) {
            System.out.println("Contraseña correcta. Validación correcta " + cliente.getNombre());
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }

    public static Cliente ListarPorPedido(String DNI) {
        String sql = "select p.* \n" +
                "from pedido p join cliente c\n" +
                "on  p.DNI_cliente = c.DNI\n" +
                "where c.DNI = ?;";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ClienteDAO dao = new ClienteDAO();
                    Cliente cliente = dao.construirDesdeResultSet(rs);
                    return cliente;                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Cliente ListarClientePorDNI(String DNI) {
        String sql = "SELECT * FROM CLIENTE WHERE DNI = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ClienteDAO dao = new ClienteDAO();
                    Cliente cliente = dao.construirDesdeResultSet(rs);
                    return cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //modificar empleado
    public static void modificarEmpleado() throws SQLException {
        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.println("""
        ¿Cómo deseas buscar el empleado?
        1 - Por DNI
        2 - Por Correo Electrónico
        """);

        int opcion = ConsoleReader.readInt("Seleccione una opción: ");
        Empleado empleadoExistente = null;

        switch (opcion) {
            case 1:
                String dni = ConsoleReader.readString("Introduce el DNI del empleado: ");
                empleadoExistente = dao.obtenerPorId(dni);
                break;
            case 2:
                String correo = ConsoleReader.readString("Introduce el correo electrónico del empleado: ");
                empleadoExistente = dao.obtenerPorEmail(correo);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (empleadoExistente != null) {
            System.out.println("Empleado encontrado. Procediendo a modificar.");

            // Modificación solo de nombre o email
            String nuevoDni = ConsoleReader.readString("Nuevo DNI (deja vacío para no modificar): ");
            if (!nuevoDni.isEmpty()) {
                empleadoExistente.setDni(nuevoDni);
            }

            String nuevoCorreo = ConsoleReader.readString("Nuevo email (deja vacío para no modificar): ");
            if (!nuevoCorreo.isEmpty()) {
                empleadoExistente.setE_mail(nuevoCorreo);
            }

            // Guardar en base de datos
            boolean actualizado = dao.actualizar(empleadoExistente);
            if (actualizado) {
                System.out.println("Empleado modificado correctamente:");
                System.out.println("DNI: " + empleadoExistente.getDni());
                System.out.println("Correo: " + empleadoExistente.getE_mail());
            } else {
                System.out.println("Error al actualizar el empleado.");
            }

        } else {
            System.out.println("No se encontró un empleado con los datos proporcionados.");
        }
    }
    // eliminar empleado
    public static void eliminarEmpleado() {
        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.println("""
        ¿Cómo deseas buscar el empleado a eliminar?
        1 - Por DNI
        2 - Por Correo Electrónico
        """);

        int opcion = ConsoleReader.readInt("Seleccione una opción: ");
        Empleado empleado = null;

        try {
            switch (opcion) {
                case 1:
                    String dni = ConsoleReader.readString("Introduce el DNI del empleado: ");
                    empleado = dao.obtenerPorId(dni);
                    break;
                case 2:
                    String correo = ConsoleReader.readString("Introduce el correo electrónico del empleado: ");
                    empleado = dao.obtenerPorEmail(correo);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            if (empleado != null) {
                System.out.println("Empleado encontrado: " + empleado.getNombre() + " " + empleado.getApellidos());
                String confirmacion = ConsoleReader.readString("¿Estás seguro de que deseas eliminarlo? (s/n): ");
                if (confirmacion.equalsIgnoreCase("s")) {
                    dao.eliminar(empleado.getDni());
                    System.out.println("Empleado eliminado correctamente.");
                } else {
                    System.out.println("Eliminación cancelada.");
                }
            } else {
                System.out.println("No se encontró un empleado con los datos proporcionados.");
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar el empleado.");
            e.printStackTrace();
        }
    }

    // añadir ciliente
    public static void anadirCliente() {
        ClienteDAO dao = new ClienteDAO();

        System.out.println("Añadiendo nuevo cliente...");
        String dni = ConsoleReader.readString("DNI: ");
        String nombre = ConsoleReader.readString("Nombre: ");
        String apellidos = ConsoleReader.readString("Apellidos: ");
        String email = ConsoleReader.readString("Email: ");
        String password = ConsoleReader.readString("Contraseña: ");
        String telefono = ConsoleReader.readString("Teléfono: ");

        Cliente cliente = new Cliente(dni, nombre, apellidos, email, password, telefono);

        if (dao.insertar(cliente)) {
            System.out.println("Cliente añadido correctamente.");
        } else {
            System.out.println("Error al añadir el cliente.");
        }
    }
    public static void anadirPedido() {
        PedidoDAO pedidoDAO = new PedidoDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("Creando un nuevo pedido...");

        String dniCliente = ConsoleReader.readString("DNI del cliente: ");
        Cliente cliente = clienteDAO.obtenerPorId(dniCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        boolean agregarMas = true;
        while (agregarMas) {
            int codArticulo = ConsoleReader.readInt("Código del artículo: ");
            Articulo articulo = articuloDAO.obtenerPorId(codArticulo);

            if (articulo != null) {
                int cantidad = ConsoleReader.readInt("Cantidad: ");
                pedido.agregarArticulo(articulo, cantidad);
                System.out.println("Artículo añadido al pedido.");
            } else {
                System.out.println("Artículo no encontrado.");
            }

            agregarMas = ConsoleReader.readBoolean("¿Deseas añadir otro artículo? (true/false): ");
        }

        if (pedidoDAO.insertar(pedido)) {
            System.out.println("Pedido registrado correctamente.");
        } else {
            System.out.println("Error al registrar el pedido.");
        }
    }
}
