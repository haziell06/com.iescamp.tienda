package com.iescamp.tienda.dao;
//christian
import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.enums.TipoAccesorio;
import com.iescamp.tienda.enums.TipoRopa;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.articulo.Catalogo;
import com.iescamp.tienda.model.articulo.accesorio.Bolso;
import com.iescamp.tienda.model.articulo.accesorio.Zapato;
import com.iescamp.tienda.model.articulo.Material;
import com.iescamp.tienda.model.articulo.ropa.Camisa;
import com.iescamp.tienda.model.articulo.ropa.Chaqueta;
import com.iescamp.tienda.model.articulo.ropa.Pantalon;

import java.math.BigDecimal;
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
        List<Articulo> articulos = new ArrayList<>();
        String sql = "select *\n" +
                "from articulo a \n" +
                "left join accesorio ac on a.cod_art = ac.cod_art\n" +
                "left join ropa r on a.cod_art = r.cod_art\n" +
                "left join material m on a.cod_art = m.codigo;";
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
    public boolean actualizar(Articulo obj) {
        // metodo void, se hará más adelante
        return false;
    }

    @Override
    public void eliminar(Integer cod_art) {
        // metodo void, se hará más adelante
    }

    @Override
    public Articulo construirDesdeResultSet(ResultSet rs) throws SQLException {

        // Definicion de los atributos básicos de todos los artículos para usarlos luego al construir las subclases
        int cod_art = rs.getInt("cod_art");
        String nombre = rs.getString("nombre");
        BigDecimal precio = rs.getBigDecimal("precio");
        String descripcion = rs.getString("descripcion");
        String imagen = rs.getString("imagen");
        boolean activo = rs.getBoolean("activo");
        String marca = rs.getString("marca");
        String color = rs.getString("color");
        Material material = (Material) rs.getObject("Material");
        // Buscamos si el articulo que estamos construyendo es un accesorio y, si lo es, de que tipo
        String tipoAccesorio = rs.getString("Tipo_accesorio");
        TipoAccesorio tipo_accesorio = TipoAccesorio.desdeString(tipoAccesorio);
        if (tipoAccesorio != null) {
            // Definicion de los atributos básicos de todos los accesorios para usarlos luego al construir las subclases
            String estilo = rs.getString("estilo");
            boolean esPersonalizado = rs.getBoolean("esPersonalizado");
            switch (tipo_accesorio) {
                case ZAPATOS:
                    String tipoSuela = rs.getString("tipoSuela");
                    int tallaZapato = rs.getInt("tallaZapato");
                    new Zapato(
                            cod_art,
                            nombre,
                            precio,
                            descripcion,
                            imagen,
                            activo,
                            marca,
                            color,
                            material,
                            estilo,
                            esPersonalizado,
                            tipo_accesorio,
                            tipoSuela,
                            tallaZapato
                    );
                    break;
                case BOLSO:
                    String tipoCierre = rs.getString("tipoCierre");
                    int capacidad = rs.getInt("capacidad");
                    new Bolso(
                            cod_art,
                            nombre,
                            precio,
                            descripcion,
                            imagen,
                            activo,
                            marca,
                            color,
                            material,
                            estilo,
                            esPersonalizado,
                            tipo_accesorio,
                            tipoCierre,
                            capacidad
                    );
                    break;
            }
        }
        // Buscamos si el articulo que estamos construyendo es ropa y, si lo es, de que tipo
        String tipoRopa = rs.getString("Tipo_ropa");
        TipoRopa tipo_ropa = TipoRopa.desdeString(tipoRopa);
        if (tipo_ropa != null) {
            String talla = rs.getString("talla");
            String tipoCierre = rs.getString("tipoCierre");
            switch (tipo_ropa) {
                case CAMISA:
                    String tipoManga = rs.getString("tipoManga");
                    boolean esEstampada = rs.getBoolean("esEstampada");
                    new Camisa(
                            cod_art,
                            nombre,
                            precio,
                            descripcion,
                            imagen,
                            activo,
                            marca,
                            color,
                            material,
                            talla,
                            tipoCierre,
                            tipoManga,
                            esEstampada
                    );
                    break;
                case CHAQUETA:
                    boolean impermeable = rs.getBoolean("impermeable");
                    new Chaqueta(
                            cod_art,
                            nombre,
                            precio,
                            descripcion,
                            imagen,
                            activo,
                            marca,
                            color,
                            material,
                            talla,
                            tipoCierre,
                            impermeable
                    );
                    break;
                case PANTALON:
                    boolean tieneBolsillo = rs.getBoolean("tieneBolsillo");
                    String tipoPantalon = rs.getString("tipoPantalon");
                    new Pantalon(
                            cod_art,
                            nombre,
                            precio,
                            descripcion,
                            imagen,
                            activo,
                            marca,
                            color,
                            material,
                            talla,
                            tipoCierre,
                            tieneBolsillo,
                            tipoPantalon
                    );
            }
        }
        return null;
    }

    public static void modificarArticulo(Articulo art) {
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
    public void eliminarArticuloYRecargar(String codArtic) {
        String sql = "DELETE FROM ARTICULO WHERE cod_artic = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
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



}