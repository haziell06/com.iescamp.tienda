package com.iescamp.tienda.dao;

import com.iescamp.tienda.Articulo;
import com.iescamp.tienda.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticuloDAO implements GenericDAO <Articulo, Integer> {

    @Override
    public void insertar(Articulo obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Articulo obtenerPorId(Integer id) {
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
    public void actualizar(Articulo obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(Integer id) {
        // metodo void, se hará más adelante
    }

    @Override
    public Articulo construirDesdeResultSet(ResultSet rs) throws SQLException {
        return new Articulo(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getFloat("precio"),
                rs.getString("descripcion"),
                rs.getString("imagen"),
                rs.getBoolean("activo"),
                rs.getString("marca"),
                rs.getString("color"),
                (Material) rs.getObject("Material")
        );
    }
}
