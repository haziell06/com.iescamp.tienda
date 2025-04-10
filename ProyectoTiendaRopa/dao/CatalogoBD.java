package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
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


    // modificar Articulos
    public static void modificarArticulo() {
        ArticuloDAO dao = new ArticuloDAO();
        System.out.println("Modificando articulo");
        System.out.println("introduzca el codigo del articulo");
        int cod_art = 0;
        Articulo articuloExistente = null;

        String CodArt = ConsoleReader.readString();
        articuloExistente = dao.obtenerPorId(cod_art);
        if (articuloExistente != null) {
            System.out.println("Artículo encontrado. Procediendo a modificar.");

            // Modificar el nombre del artículo (si se proporciona uno nuevo)
            String nuevoNombre = ConsoleReader.readString("Nuevo nombre del artículo (deja vacío para no modificar): ");
            if (!nuevoNombre.isEmpty()) {
                articuloExistente.setNombre(nuevoNombre);
            }
            // Modificar el precio del artículo (si se proporciona uno nuevo)
            float nuevoPrecio = ConsoleReader.readFloat("Nuevo precio del artículo (deja 0 para no modificar): ");
            if (nuevoPrecio > 0) {
                articuloExistente.setPrecio(nuevoPrecio);
            }
            // Modificar la descripción del artículo (si se proporciona una nueva)
            String nuevaDescripcion = ConsoleReader.readString("Nueva descripción del artículo (deja vacío para no modificar): ");
            if (!nuevaDescripcion.isEmpty()) {
                articuloExistente.setDescripcion(nuevaDescripcion);
            }
            // Actualizar el artículo en la base de datos
            boolean actualizado = dao.actualizar(articuloExistente);
            // Verificar si la actualización fue exitosa
            if (actualizado) {
                System.out.println("Artículo modificado con éxito.");

                // Recargar el catálogo de artículos desde la BD
                List<Articulo> articulosRecargados = dao.obtenerTodos();
                System.out.println("Catálogo de artículos recargado. Total de artículos: " + articulosRecargados.size());

                // Actualizar el catálogo en la clase correspondiente (por ejemplo, en la clase Catalogo)
                Catalogo catalogo = new Catalogo();
                catalogo.setCatalogo((ArrayList<Articulo>) articulosRecargados);
            } else {
                System.out.println("Hubo un error al actualizar el artículo.");
            }
        } else {
            System.out.println("No se encontró un artículo con el código proporcionado.");
        }

    }
    //eliminar y recargar
    public static void eliminarArticuloYRecargar() {
        String sql = "DELETE FROM ARTICULO WHERE cod_artic = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String codArtic = "";
            stmt.setString(1, codArtic);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Artículo eliminado correctamente.");
                List<Articulo> articulos = obtenerTodos();
                System.out.println("Catálogo recargado. Total artículos: " + articulos.size());
            } else {
                System.out.println("No se encontró el artículo.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static List<Articulo> obtenerTodos() {
        return obtenerTodos();
    }
    public static void anadirArticulo() {
        ArticuloDAO dao = new ArticuloDAO();
        Articulo nuevo = dao.añadirArticulo();

        if (nuevo == null) {
            System.out.println("No se pudo crear el artículo. Operación cancelada.");
            return;
        }

        boolean insertado = dao.insertar(nuevo);
        if (insertado) {
            System.out.println("Artículo añadido correctamente.");
        } else {
            System.out.println("Error al añadir el artículo.");
            return;
        }
        List<Articulo> articulosActualizados = dao.obtenerTodos();
        Catalogo catalogo = new Catalogo();
        catalogo.setCatalogo(new ArrayList<>(articulosActualizados));
        System.out.println("Catálogo actualizado. Total artículos: " + articulosActualizados.size());
    }
}

