package com.iescamp.tienda.dao;

import com.iescamp.tienda.Cliente;
import com.iescamp.tienda.MetodoPago;
import com.iescamp.tienda.Pedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO implements GenericDAO <Cliente, String> {

    @Override
    public void insertar(Cliente obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Cliente obtenerPorId(String id) {
        String sql = "SELECT * FROM libro WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));
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
    public void actualizar(Cliente obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(String id) {
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

}
