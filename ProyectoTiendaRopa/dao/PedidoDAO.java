package com.iescamp.tienda.dao;


import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.pedido.LineaPedido;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements GenericDAO <Pedido, Integer> {

    @Override
    public void insertar(Pedido obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Pedido obtenerPorId(Integer numero) {
        String sql = "SELECT * FROM PEDIDO WHERE numero = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, numero);
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
    public List<Pedido> obtenerTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM PEDIDO";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pedidos.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> obtenerPedidosPorCliente() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM PEDIDO where CLIENTE.DNI = ?";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pedidos.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void actualizar(Pedido obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(Integer numero) {
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
