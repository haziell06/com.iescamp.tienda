package com.iescamp.tienda.dao;


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
            stmt.setString(1, DNI);
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

    @Override
    public void actualizar(Empleado obj) {

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
}
