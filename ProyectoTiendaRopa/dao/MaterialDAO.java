package com.iescamp.tienda.dao;


import com.iescamp.tienda.model.articulo.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO implements GenericDAO <Material, Integer>{

    @Override
    public boolean insertar(Material obj) {

        return false;
    }

    @Override
    public Material obtenerPorId(Integer codigo) {
        String sql = "SELECT * FROM MATERIAL WHERE codigo = ?";
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
    public List<Material> obtenerTodos() {
        List<Material> materiales = new ArrayList<>();
        String sql = "SELECT * FROM MATERIAL";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                materiales.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiales;
    }

    @Override
    public boolean actualizar(Material obj) {
        return false;
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }

    @Override
    public Material construirDesdeResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    //unique
    public Material obtenerPorDenominacion(String denominacion) {
        String sql = "SELECT * FROM MATERIAL WHERE denominacion = ?";
        Material material = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1,denominacion);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                material = construirDesdeResultSet(rs);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return material;
    }


}
