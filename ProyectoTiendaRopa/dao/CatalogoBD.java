package com.iescamp.tienda.dao;

import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.articulo.Catalogo;

import java.util.ArrayList;
import java.util.List;

public class CatalogoBD {
    public static void cargarArticulos(){
        ArticuloDAO dao = new ArticuloDAO();
        List<Articulo> articulos = dao.obtenerTodos();

        Catalogo catalogo = new Catalogo();
        catalogo.setCatalogo(new ArrayList<>(articulos));

        System.out.println("Artículos cargados correctamente desde la BD.");
        System.out.println("Número de artículos: " + articulos.size());
    }
}
