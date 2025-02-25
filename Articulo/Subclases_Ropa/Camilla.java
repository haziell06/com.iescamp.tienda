package com.iescamp.tienda.Subclases_Ropa;

import com.iescamp.tienda.Ropa;

public class Camilla extends Ropa {
    private String tipoManga;
    private boolean esEstampada;

    public Camilla(int talla, String color, String tipoCierre, String tipoManga, boolean esEstampada) {
        super(talla, color, tipoCierre);
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
        return "Camilla" +
                "tipoManga:'" + tipoManga +
                ", esEstampada:" + esEstampada;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
