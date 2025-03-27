package com.iescamp.tienda.dao;

import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.articulo.ropa.*;
import com.iescamp.tienda.model.articulo.accesorio.*;
import com.iescamp.tienda.model.articulo.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO implements GenericDAO <Articulo, Integer> {
    @Override
    public void insertar(Articulo obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public Articulo obtenerPorId(Integer cod_art) {
        String sql = "SELECT * FROM ARTICULO WHERE cod_art = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cod_art);
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
    public List<Articulo> obtenerTodos() {
        List <Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM ARTICULO";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                articulos.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articulos;
    }

    @Override
    public void actualizar(Articulo obj) {
        // metodo void, se hará más adelante
    }

    @Override
    public void eliminar(Integer cod_art) {
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
