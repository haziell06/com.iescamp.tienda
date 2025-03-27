package com.iescamp.tienda.model.articulo.accesorio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bolso extends Accesorio {
    @JsonProperty("cierre")
    private String tipoCierre;

    @JsonProperty("capacidad")
    private int capacidad;

    // Constructor vacío para deserialización
    public Bolso() {
    }

    public Bolso(
            @JsonProperty("estilo") String estilo,
            @JsonProperty("personalizado") Boolean esPersonalizado,
            @JsonProperty("cierre") String tipoCierre,
            @JsonProperty("capacidad") int capacidad
    ) {
        super(estilo, String.valueOf(esPersonalizado));
        this.tipoCierre = tipoCierre;
        this.capacidad = capacidad;
    }
    public Bolso(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, String imagen, boolean activo, String estilo, boolean personalizado, String tipoCierre, int capacidad) {
    }
    
    public Bolso(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String estilo, boolean esPersonalizado, TipoAccesorio tipoAccesorio, String tipoCierre, int capacidad) {
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Bolso" +
                "tipoCierre:" + tipoCierre +
                ", capacidad:" + capacidad;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
