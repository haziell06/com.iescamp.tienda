package com.iescamp.tienda.model.articulo.ropa;

import java.math.BigDecimal;

public class Camisa extends Ropa {
    private String tipoManga;
    private boolean esEstampada;

    public Camisa(String talla, String color, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, color, tipoCierre);
        this.tipoManga = tipoManga;
        this.esEstampada = esEstampada;
    }

    public Camisa(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String talla, String color, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, color, tipoCierre);
    }

    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    public boolean isEsEstampada() {
        return esEstampada;
    }

    public void setEsEstampada(boolean esEstampada) {
        this.esEstampada = esEstampada;
    }

    @Override
    public String toString() {
        return "Camisa" +
                "tipoManga:'" + tipoManga +
                ", esEstampada:" + esEstampada;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
