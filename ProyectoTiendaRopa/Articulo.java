package com.iescamp.tienda;

import java.util.Objects;

public class Accesorio {

    private String estilo;
    private boolean esPersonalizado;

    public Accesorio(String estilo, boolean esPersonalizado) {
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

    public boolean isEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(boolean esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accesorio accesorio = (Accesorio) o;
        return esPersonalizado == accesorio.esPersonalizado && Objects.equals(estilo, accesorio.estilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estilo, esPersonalizado);
    }

    @Override
    public String toString() {
        return "Accesorio{" +
                "estilo='" + estilo + '\'' +
                ", esPersonalizado=" + esPersonalizado +
                '}';
    }
}
