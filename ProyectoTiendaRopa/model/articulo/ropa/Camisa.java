package com.iescamp.tienda.model.articulo.ropa;

import com.iescamp.tienda.model.articulo.Material;

import java.math.BigDecimal;

public class Camisa extends Ropa {
    private String tipoManga;
    private boolean esEstampada;

    public Camisa(String talla, String color, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, tipoCierre);
        this.tipoManga = tipoManga;
        this.esEstampada = esEstampada;
    }

    public Camisa(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, String imagen, boolean activo,  String talla, String color, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, tipoCierre);
    }

    public Camisa(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String talla, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, tipoCierre);
        this.tipoManga = tipoManga;
        this.esEstampada = esEstampada;
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
