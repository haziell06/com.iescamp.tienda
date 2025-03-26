package com.iescamp.tienda.model.articulo.ropa;

import java.util.Objects;

public class Ropa extends Articulo {

    private String talla;
    private String color;
    private String tipoCierre;


    public Ropa(String talla, String color, String tipoCierre) {
        super();
        this.talla = talla;
        this.color = color;
        this.tipoCierre = tipoCierre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ropa ropa = (Ropa) o;
        return talla == ropa.talla && Objects.equals(color, ropa.color) && Objects.equals(tipoCierre, ropa.tipoCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(talla, color, tipoCierre);
    }

    @Override
    public String toString() {
        return "Ropa" +
                "talla:" + talla +
                ", color:'" + color +
                ", tipoCierre:" + tipoCierre;
    }
}
