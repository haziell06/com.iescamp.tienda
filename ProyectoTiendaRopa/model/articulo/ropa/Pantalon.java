package com.iescamp.tienda.model.articulo.ropa;

import java.math.BigDecimal;

public class Pantalon extends Ropa {
    private boolean tieneBolsillo;
    private String tipoPantalon;

    public Pantalon(String talla, String color, String tipoCierre, boolean tieneBolsillo, String tipoPantalon) {
        super(talla, color, tipoCierre);
        this.tieneBolsillo = tieneBolsillo;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String talla, String color, String tipoCierre, String tipoPantalon, boolean tieneBolsillos) {
        super(talla, color, tipoCierre);
    }

    public boolean isTieneBolsillo() {
        return tieneBolsillo;
    }

    public void setTieneBolsillo(boolean tieneBolsillo) {
        this.tieneBolsillo = tieneBolsillo;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    @Override
    public String toString() {
        return "Pantalon" +
                "tieneBolsillo:" + tieneBolsillo +
                ", tipoPantalon:" + tipoPantalon;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
