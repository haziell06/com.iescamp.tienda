package com.iescamp.tienda.model.articulo.accesorio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Accesorio {

    @JsonProperty("estilo")
    private String estilo;

    @JsonProperty("personalizado")
    private String esPersonalizado;

    // Constructor vacío para Jackson
    public Accesorio() {
    }

    public Accesorio(
            @JsonProperty("estilo") String estilo,
            @JsonProperty("personalizado") String esPersonalizado
    ) {
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(String esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Accesorio accesorio = (Accesorio) o;
        return Objects.equals(estilo, accesorio.estilo) && Objects.equals(esPersonalizado, accesorio.esPersonalizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estilo, esPersonalizado);
    }

    @Override
    public String toString() {
        return "Accesorio" +
                "estilo:'" + estilo +
                ", esPersonalizado:'" + esPersonalizado;
    }
}
