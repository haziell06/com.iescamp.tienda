package com.iescamp.tienda.model.articulo.ropa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true) // Evita errores con campos desconocidos
public class Chaqueta extends Ropa {
    private boolean impermeable;

    // Constructor vacío para Jackson
    public Chaqueta() {
        super();
    }

    public Chaqueta(
            @JsonProperty("talla") String talla,
            @JsonProperty("color") String color,
            @JsonProperty("precio") BigDecimal precio,
            @JsonProperty("tipoCierre") String tipoCierre,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("imagen") String imagen,
            @JsonProperty("impermeable") boolean impermeable) {
        super(talla, color, tipoCierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String talla, String tipoCierre, boolean impermeable) {
        super(talla, tipoCierre);
        this.impermeable = impermeable;
    }

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }
    @Override
    public String toString() {
        return "Chaqueta" +
                "impermeable:" + impermeable;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
