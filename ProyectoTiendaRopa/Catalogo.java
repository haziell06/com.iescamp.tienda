package com.iescamp.tienda;

import java.io.Serializable;
import java.util.ArrayList;

public class Catalogo implements Serializable {
     private static final long serialVersionUID = 1L;
    private ArrayList<Articulo> catalogo;

    public Catalogo(ArrayList<Articulo> catalogo) {
        this.catalogo = catalogo;
    }
    
    public Catalogo() {
        catalogo = new ArrayList<>();
    }

    public ArrayList<Articulo> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Articulo> catalogo) {
        this.catalogo = catalogo;
    }

    public Articulo buscarDni(int Cod) {
        for (Articulo articulo : catalogo) {
            if (articulo.getCodigoArticulo() == Cod) {
                return articulo;
            }
        }
        return null;
    }
    public ArrayList<Articulo> filtarActivo() {
        ArrayList<Articulo> filtroActivo = new ArrayList<>();
        for (Articulo articulo : catalogo) {
            if (articulo.isActivo()) {
                filtroActivo.add(articulo);
            }
        }
        return filtroActivo;
    }
    public ArrayList<Articulo> filtarMaterial(String material) {
        ArrayList<Articulo> filtroMaterial = new ArrayList<>();
        for (Articulo articulo : catalogo) {
            if (articulo.getMaterial().equals(material)) {
                filtroMaterial.add(articulo);
            }
        }
        return filtroMaterial;
    }
}
