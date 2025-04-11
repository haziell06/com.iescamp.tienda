package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
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
// modificar empleado
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

