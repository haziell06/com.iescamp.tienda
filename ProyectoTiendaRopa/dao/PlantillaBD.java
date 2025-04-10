package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.cliente.Clientela;
import com.iescamp.tienda.model.usuario.empleado.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantillaBD {
    public static void cargarEmpleados(){
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> clientes = dao.obtenerTodos();
        System.out.println("Clientes obtenidos desde la BD: " + clientes.size());
        for (Empleado e : clientes) {
            System.out.println("Dni: " + e.getDni());
            System.out.println("Nombre: " + e.getNombre());
        }
    }
    public static void validarContraseña(){
        String email = ConsoleReader.readString("Introduce el email: ");
        String pass = ConsoleReader.readString("Introduce la contraseña: ");
        EmpleadoDAO dao = new EmpleadoDAO();
        Empleado empleado = dao.autenticarEmpleado(email, pass);

        if (empleado != null) {
            System.out.println("Contraseña correcta. Validación correcta " + empleado.getNombre());
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }
    public static Empleado ListarEmpleadoPorDNI(String DNI) {
        String sql = "SELECT * FROM empleado WHERE DNI = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, DNI);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EmpleadoDAO dao = new EmpleadoDAO();
                    Empleado empleado = dao.construirDesdeResultSet(rs);
                    return empleado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Empleado> ListarEmpleadoPorDepartamento(int codigo) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * \n" +
                "FROM empleado e join departamento d\n" +
                "on e.dpto = d.codigo\n" +
                "where e.dpto = ?;";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EmpleadoDAO dao = new EmpleadoDAO();
                Empleado empleado = dao.construirDesdeResultSet(rs);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }


    // modificar usuario
    // mediante dni y correo
    public static void modificarCliente() {
        ClienteDAO dao = new ClienteDAO();
        Clientela Clientela = new Clientela();// puede estar mal

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
    public static void anadirEmpleado() {
        EmpleadoDAO dao = new EmpleadoDAO();
        Empleado nuevo = dao.añadirEmpleado();

        boolean insertado = dao.insertar(nuevo);
        if (insertado) {
            System.out.println("Empleado añadido correctamente.");
        } else {
            System.out.println("Error al añadir el empleado.");
            return;
        }

        List<Empleado> empleadosActualizados = dao.obtenerTodos();
        System.out.println("Empleados actualizados: " + empleadosActualizados.size());
        for (Empleado e : empleadosActualizados) {
            System.out.println("DNI: " + e.getDni() + " | Nombre: " + e.getNombre());
        }
    }
}

