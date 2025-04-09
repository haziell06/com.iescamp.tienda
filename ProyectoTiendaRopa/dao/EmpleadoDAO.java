package com.iescamp.tienda.dao;


import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.empleado.Empleado;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements GenericDAO<Empleado, String> {
    @Override
    public void insertar(Empleado obj) {

    }

    @Override
    public Empleado obtenerPorId(String DNI) {
        String sql = "SELECT * FROM CLIENTE WHERE DNI = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(DNI));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return construirDesdeResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empleado> obtenerTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empleados.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Empleado> obtenerEmpleadoPorDepartamento() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO where DEPARTAMENTO.codigo = ?";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empleados.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    @Override
    public boolean actualizar(Empleado obj) {

        return false;
    }

    @Override
    public void eliminar(String DNI) {

    }

    @Override
    public Empleado construirDesdeResultSet(ResultSet rs) throws SQLException {
        java.sql.Date sqlDate = rs.getDate("fecha");
        LocalDate f_nacimiento = (sqlDate != null) ? sqlDate.toLocalDate() : null;

        return  new Empleado(
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("e_mail"),
                f_nacimiento,
                rs.getString("pass"),
                rs.getBoolean("activo"),
                rs.getBoolean("tienePrivilegios"),
                rs.getString("departamento")
        );

    }

    public Empleado autenticarEmpleado(String email, String password) {
        Empleado empleado = null;
        String sql = "SELECT * FROM EMPLEADO WHERE e_mail = ?";  // Consulta de email

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { // Si el email existe comprobamos la contraseña
                String storedPassword = rs.getString("pass");

                if (storedPassword.equals(password)) { // Si la contraseña coincide creamos el objeto Empleado
                    empleado = construirDesdeResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;  // Si la contraseña no es correcta, return null
    }


    // unique
    public Empleado obtenerPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM EMPLEADO where email = ?";
        Empleado empleado = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                empleado = construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }
    //modificar empleado
    public void modificarEmpleado(Empleado obj) throws SQLException {
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
    public void eliminarEmpleado() {
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







}
