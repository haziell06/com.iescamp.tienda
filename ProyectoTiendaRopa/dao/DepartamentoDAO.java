package com.iescamp.tienda.dao;


import com.iescamp.tienda.model.usuario.empleado.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements GenericDAO<Departamento, Integer>{
    @Override
    public boolean insertar(Departamento obj) {

        return false;
    }

    @Override
    public Departamento obtenerPorId(Integer codigo) {
        String sql = "SELECT * FROM CLIENTE WHERE codigo = ?";
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
    public List<Departamento> obtenerTodos() {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM DEPARTAMENTO";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                departamentos.add(construirDesdeResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    @Override
    public boolean actualizar(Departamento obj) {

        return false;
    }

    @Override
    public boolean eliminar(Integer codigo) {

        return false;
    }

    @Override
    public Departamento construirDesdeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
