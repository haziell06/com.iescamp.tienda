package com.iescamp.tienda.dao;

import com.iescamp.tienda.Cliente;
import com.iescamp.tienda.LineaPedido;
import com.iescamp.tienda.MetodoPago;
import com.iescamp.tienda.Pedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoDAO implements GenericDAO <Pedido, Integer> {

    @Override
    public void insertar(Pedido obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        String sql = "SELECT * FROM libro WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
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
    public void actualizar(Pedido obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(Integer id) {
        // metodo void, se hará más adelante
    }

    @Override
    public Pedido construirDesdeResultSet(ResultSet rs) throws SQLException {
        java.sql.Date sqlDate = rs.getDate("fecha");
        LocalDate fecha = (sqlDate != null) ? sqlDate.toLocalDate() : null;
        Array array = rs.getArray("lineaPedidos");
        LineaPedido[] lineaPedidosArray = (array != null) ? (LineaPedido[]) array.getArray() : new LineaPedido[0];
        ArrayList<LineaPedido> lineaPedidos = new ArrayList<>();
        for (LineaPedido lineaPedido : lineaPedidosArray) {
            lineaPedidos.add(lineaPedido);
        }
        return  new Pedido(
                rs.getInt("numero"),
                fecha,
                rs.getString("estado"),
                rs.getString("dir_envio"),
                (Cliente) rs.getObject("DNI_cliente"),
                (MetodoPago) rs.getObject("m_pago"),
                lineaPedidos
        );
    }
}
