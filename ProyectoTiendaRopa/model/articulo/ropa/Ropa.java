package com.iescamp.tienda.model.articulo.ropa;

import com.iescamp.tienda.model.articulo.Articulo;

import java.util.Objects;

public class Ropa extends Articulo {

    private String talla;
    private String tipoCierre;


    public Ropa(String talla, String tipoCierre) {
        super();
        this.talla = talla;
        this.tipoCierre = tipoCierre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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
        return talla == ropa.talla && Objects.equals(tipoCierre, ropa.tipoCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(talla, tipoCierre);
    }

    @Override
    public String toString() {
        return "Ropa" +
                "talla:" + talla +
                ", tipoCierre:" + tipoCierre;
    }
}
