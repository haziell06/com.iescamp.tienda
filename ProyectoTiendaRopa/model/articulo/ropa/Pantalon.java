package com.iescamp.tienda.model.articulo.ropa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos desconocidos en JSON
public class Pantalon extends Ropa {
    private boolean tieneBolsillo;
    private String tipoPantalon;

    // Constructor vacío para Jackson
    public Pantalon() {
        super();
    }

    public Pantalon(
            @JsonProperty("talla") String talla,
            @JsonProperty("color") String color,
            @JsonProperty("tipoCierre") String tipoCierre,
            @JsonProperty("tieneBolsillo") boolean tieneBolsillo,
            @JsonProperty("tipoPantalon") String tipoPantalon) {
        super(talla, color, tipoCierre);
        this.tieneBolsillo = tieneBolsillo;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String talla, String tipoCierre, boolean tieneBolsillo, String tipoPantalon) {
        super(talla, tipoCierre);
        this.tieneBolsillo = tieneBolsillo;
        this.tipoPantalon = tipoPantalon;
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

