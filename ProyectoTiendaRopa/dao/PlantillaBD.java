package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
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
}
