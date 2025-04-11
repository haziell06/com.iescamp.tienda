package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.cliente.Clientela;
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

    // modificar usuario
    // mediante dni y correo
    public static void modificarCliente() {
        ClienteDAO dao = new ClienteDAO();
        Clientela Clientela = new Clientela();

        System.out.println("""
             Como deseas buscar el cliente:
             1-Por DNI
             2-Por Correo                    
             """);

        int opcion = ConsoleReader.readInt("Ingrese la opción: ");
        Cliente clienteExistente = null;

        switch (opcion) {
            case 1:
                // Buscar por DNI
                String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
                clienteExistente = dao.obtenerPorDNI(dni);
                break;
            case 2:
                // Buscar por correo electrónico
                String email = ConsoleReader.readString("Introduce el correo del cliente: ");
                clienteExistente = dao.obtenerPorEmail(email);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (clienteExistente != null) {
            // Modificación solo de DNI o correo
            System.out.println("Cliente encontrado. Procediendo a modificar.");

            switch (opcion) {
                case 1:
                    // Modificar DNI
                    String nuevoDNI = ConsoleReader.readString("Nuevo DNI (deja vacío para no modificar): ");
                    if (!nuevoDNI.isEmpty()) {
                        clienteExistente.setDni(nuevoDNI);
                    }
                    break;
                case 2:
                    // Modificar correo
                    String nuevoCorreo = ConsoleReader.readString("Nuevo correo (deja vacío para no modificar): ");
                    if (!nuevoCorreo.isEmpty()) {
                        clienteExistente.setE_mail(nuevoCorreo);
                    }
                    break;
            }

            // Actualizar en la base de datos
            dao.actualizar(clienteExistente);
            System.out.println("Cliente modificado con éxito.");

            // Recargar la lista de clientes desde la BD
            List<Cliente> clientesActualizados = dao.obtenerTodos();
            System.out.println("Clientes recargados desde la BD: " + clientesActualizados.size());

            // Actualizar la clase Clientela con la lista recargada de clientes
            Clientela.setClientes(clientesActualizados);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    // Eliminar Usuario
    public static void eliminarCliente() {
        ClienteDAO dao = new ClienteDAO();
        Clientela Clientela = new Clientela();

        System.out.println("""
         ¿Cómo deseas buscar el cliente para eliminar?
         1 - Por DNI
         2 - Por Correo
         """);

        int opcion = ConsoleReader.readInt("Ingrese la opción: ");
        Cliente clienteExistente = null;

        switch (opcion) {
            case 1:
                String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
                clienteExistente = dao.obtenerPorDNI(dni);
                break;
            case 2:
                String email = ConsoleReader.readString("Introduce el correo del cliente: ");
                clienteExistente = dao.obtenerPorEmail(email);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (clienteExistente != null) {
            System.out.println("Cliente encontrado: " + clienteExistente);
            String confirmar = ConsoleReader.readString("¿Estás seguro de que deseas eliminar este cliente? (s/n): ");
            if (confirmar.equalsIgnoreCase("s")) {
                boolean eliminado = dao.eliminar(clienteExistente.getDni()); // Asumiendo que Cliente tiene un getId()
                if (eliminado) {
                    System.out.println("Cliente eliminado correctamente.");

                    List<Cliente> clientesActualizados = dao.obtenerTodos();
                    System.out.println("Lista recargada. Total clientes: " + clientesActualizados.size());

                    Clientela.setClientes(clientesActualizados);
                } else {
                    System.out.println("No se pudo eliminar el cliente.");
                }
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
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
