package com.iescamp.tienda.dao;

import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO <Cliente, String> {

    @Override
    public void insertar(Cliente obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Cliente obtenerPorId(String DNI) {
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
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(String DNI) {
        // metodo void, se hará más adelante
    }

    @Override
    public Cliente construirDesdeResultSet(ResultSet rs) throws SQLException {
        java.sql.Date sqlDate = rs.getDate("fecha");
        LocalDate f_nacimiento = (sqlDate != null) ? sqlDate.toLocalDate() : null;
        Array array = rs.getArray("pedidos");
        Pedido[] pedidosArray = (array != null) ? (Pedido[]) array.getArray() : new Pedido[0];

        // Convertir el arreglo a un ArrayList
        ArrayList<Pedido> pedidos = new ArrayList<>();
        for (Pedido pedido : pedidosArray) {
            pedidos.add(pedido);
        }
        return  new Cliente(
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("e_mail"),
                f_nacimiento,
                rs.getString("pass"),
                rs.getBoolean("activo"),
                rs.getString("dir_envio"),
                rs.getFloat("saldo_cuenta"),
                rs.getBoolean("tarjeta_fidelizacion"),
                rs.getInt("numeroPedidos"),
                (MetodoPago) rs.getObject("m_pago"),
                pedidos
        );
    }

    public Cliente autenticarCliente(String email, String password) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE e_mail = ? AND pass = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String dni = rs.getString("dni");

                List<Pedido> pedidos = new ArrayList<>();

                cliente = construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // unique
    public Cliente obtenerPorEmail(String email) {
        Cliente cliente = null;
        String sql = "SELECT * FROM CLIENTE WHERE email = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cliente = construirDesdeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

}
