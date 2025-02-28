package com.iescamp.tienda;

import java.util.Objects;

public class Accesorio {

    private String estilo;
    private String esPersonalizado;

    public Accesorio(String estilo, String esPersonalizado) {
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio() {

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
