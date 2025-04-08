package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientelaBD {
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
}
