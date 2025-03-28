package com.iescamp.tienda.model.articulo.ropa;

import com.iescamp.tienda.model.articulo.Material;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Camisa extends Ropa {

    @JsonProperty("tipo_manga")
    private String tipoManga;

    @JsonProperty("estampada")
    private boolean esEstampada;

    // Constructor vacío para Jackson
    public Camisa() {
        super();
    }

    public Camisa(
            @JsonProperty("talla") String talla,
            @JsonProperty("color") String color,
            @JsonProperty("tipo_cierre") String tipoCierre,
            @JsonProperty("tipo_manga") String tipoManga,
            @JsonProperty("estampada") boolean esEstampada
    ) {
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
