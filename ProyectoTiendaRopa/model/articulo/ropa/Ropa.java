package com.iescamp.tienda.model.articulo.ropa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iescamp.tienda.model.articulo.Articulo;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos desconocidos en JSON
public class Ropa extends Articulo {

    private String talla;
    private String color;
    private String tipoCierre;

    // Constructor vacío para Jackson
    public Ropa() {
        super();
    }

    public Ropa(
            @JsonProperty("talla") String talla,
            @JsonProperty("color") String color,
            @JsonProperty("tipoCierre") String tipoCierre) {
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
