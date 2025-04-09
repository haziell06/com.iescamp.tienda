package com.iescamp.tienda.dao;


import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.articulo.Material;
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
    public boolean actualizar(Pedido obj) {
        // metodo void, se hará más adelante
        return false;
    }

    @Override
    public boolean eliminar(Integer numero) {
        // metodo void, se hará más adelante
        return false;
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

    public List<Pedido> obtenerPedidosPorCliente(String dniCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM PEDIDO WHERE dni_cliente = ?"; // Cambié CLIENTE.DNI por dni_cliente

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dniCliente);  // Establecemos el DNI del cliente
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Crear el objeto Pedido sin las líneas de pedido
                Pedido pedido = construirDesdeResultSet(rs);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    public List<LineaPedido> obtenerLineasDePedido(int numeroPedido) {
        List<LineaPedido> lineas = new ArrayList<>();
        String sql = "SELECT * FROM LINEA_PEDIDO WHERE numero_pedido = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroPedido);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Obtenemos los detalles del artículo directamente desde la línea de pedido
                int codigoProducto = rs.getInt("codigo_producto");

                // Consulta para obtener los detalles del Articulo
                String sqlArticulo = "SELECT * FROM ARTICULO WHERE codigoArticulo = ?";
                try (PreparedStatement stmtArticulo = conn.prepareStatement(sqlArticulo)) {
                    stmtArticulo.setInt(1, codigoProducto);
                    ResultSet rsArticulo = stmtArticulo.executeQuery();

                    if (rsArticulo.next()) {
                        Articulo articulo = new Articulo(
                                rsArticulo.getInt("codigoArticulo"),
                                rsArticulo.getString("nombre"),
                                rsArticulo.getFloat("precio"),
                                rsArticulo.getString("descripcion"),
                                rsArticulo.getString("imagen"),
                                rsArticulo.getBoolean("activo"),
                                rsArticulo.getString("marca"),
                                rsArticulo.getString("color"),
                                (Material) rsArticulo.getObject("material")
                        );

                        // Crear línea de pedido con el artículo obtenido
                        LineaPedido linea = new LineaPedido(articulo);
                        lineas.add(linea);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineas;
    }
}
