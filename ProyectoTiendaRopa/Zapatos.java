package com.iescamp.tienda;

import java.math.BigDecimal;

public class Zapatos extends Accesorio {
    private int tallaZapato;
    private String tipoSuela;

    public Zapatos(String estilo, String esPersonalizado, int tallaZapato, String tipoSuela) {
        super(estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, boolean b, String imagen, String color, Material material, String estilo, boolean activo, boolean personalizado, TipoAccesorio tipoAccesorio, String tipoSuela, int tallaZapato) {
        super();
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
