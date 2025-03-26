package com.iescamp.tienda.dao;

import com.iescamp.tienda.MetodoPago;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodoPagoDAO implements GenericDAO <MetodoPago, Integer> {
    @Override
    public void insertar(MetodoPago obj) {

    }

    @Override
    public MetodoPago obtenerPorId(Integer codigo) {
        String sql = "SELECT * FROM METODO_PAGO WHERE codigo = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
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
    public List<MetodoPago> obtenerTodos() {
        List<MetodoPago> metodosPago = new ArrayList<>();
        String sql = "SELECT * FROM METODO_PAGO";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                metodosPago.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metodosPago;
    }

    @Override
    public void actualizar(MetodoPago obj) {

    }

    @Override
    public void eliminar(Integer codigo) {

    }

    @Override
    public MetodoPago construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new MetodoPago(
                rs.getInt("codigo"),
                rs.getString("descripcion")
        );
    }
}
