package com.iescamp.tienda.model.articulo.accesorio;

import com.iescamp.tienda.enums.TipoAccesorio;
import com.iescamp.tienda.model.articulo.Material;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Zapato extends Accesorio {
    @JsonProperty("talla")
    private int tallaZapato;

    @JsonProperty("suela")
    private String tipoSuela;

    public Zapato() {
        // Constructor vacío necesario para la deserialización
    }

    public Zapato(
            @JsonProperty("estilo") String estilo,
            @JsonProperty("personalizado") Boolean esPersonalizado,
            @JsonProperty("talla") int tallaZapato,
            String tipoSuela
    ) {
        super(estilo, String.valueOf(esPersonalizado));
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }
    public Zapato(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, boolean b, String imagen, String color, Material material, String estilo, boolean activo, boolean personalizado, TipoAccesorio tipoAccesorio, String tipoSuela, int tallaZapato) {
        super();
    }

    public Zapato(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String estilo, boolean esPersonalizado, TipoAccesorio tipoAccesorio, String tipoSuela, int tallaZapato) {
    }

    public int getTallaZapato() {
        return tallaZapato;
    }

    public void setTallaZapato(int tallaZapato) {
        this.tallaZapato = tallaZapato;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        this.tipoSuela = tipoSuela;
    }

    @Override
    public String toString() {
        return "Zapatos" +
                "tallaZapato:" + tallaZapato +
                ", tipoSuela:" + tipoSuela;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}

