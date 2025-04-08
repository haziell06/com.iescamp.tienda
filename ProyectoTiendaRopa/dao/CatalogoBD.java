package com.iescamp.tienda.dao;

import com.iescamp.tienda.enums.TipoRopa;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.articulo.Catalogo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoBD {
    public static Articulo ListarArticuloPorID(int cod_art) {
        String sql = "SELECT * FROM CLIENTE WHERE DNI = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cod_art);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ArticuloDAO dao = new ArticuloDAO();
                    Articulo articulo = dao.construirDesdeResultSet(rs);
                    return articulo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void cargarArticulos(){
        ArticuloDAO dao = new ArticuloDAO();
        List<Articulo> articulos = dao.obtenerTodos();

        Catalogo catalogo = new Catalogo();
        catalogo.setCatalogo(new ArrayList<>(articulos));

        System.out.println("Artículos cargados correctamente desde la BD.");
        System.out.println("Número de artículos: " + articulos.size());
    }
    public static List<Articulo> ListarTodosPorTipo(String tipoRopa, String tipoAccesorio) {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM articulo a\n" +
                "LEFT JOIN accesorio ac ON a.cod_art = ac.cod_art\n" +
                "LEFT JOIN ropa r ON a.cod_art = r.cod_art AND ac.cod_art IS NULL\n" +
                "LEFT JOIN material m ON a.cod_art = m.codigo\n" +
                "WHERE r.tipo_ropa = ? OR ac.tipo_accesorio = ?;";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipoRopa);
            stmt.setString(2, tipoAccesorio);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ArticuloDAO dao = new ArticuloDAO();
                    Articulo articulo = dao.construirDesdeResultSet(rs);
                    articulos.add(articulo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articulos;
    }
}
