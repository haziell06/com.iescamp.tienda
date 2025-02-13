package com.iescamp.tienda.Subclases_Articulo;

import com.iescamp.tienda.Accesorio;

public class Zapatos extends Accesorio {
    private int tallaZapato;
    private String tipoSuela;

    public Zapatos(String estilo, String esPersonalizado, int tallaZapato, String tipoSuela) {
        super(estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
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
