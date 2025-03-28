package com.iescamp.tienda.model.articulo.ropa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true) // Evita errores con campos desconocidos
public class Chaqueta extends Ropa {
    private boolean impermeable;

    public Chaqueta(String talla, String color, BigDecimal precio, String tipoCierre, String descripcion, String imagen, String s, String estilo, boolean impermeable, String string, String cierre, boolean b) {
        super(talla, color, tipoCierre);
        this.impermeable = impermeable;
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
