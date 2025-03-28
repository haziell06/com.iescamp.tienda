package com.iescamp.tienda.model.articulo.accesorio;

import com.iescamp.tienda.enums.TipoAccesorio;
import com.iescamp.tienda.model.articulo.Material;

import java.math.BigDecimal;

public class Zapato extends Accesorio {
    private int tallaZapato;
    private String tipoSuela;

    public Zapato(String estilo, Boolean esPersonalizado, int tallaZapato, String tipoSuela) {
        super(estilo, String.valueOf(esPersonalizado));
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapato(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, String imagen, String color, Material material, String estilo, boolean activo, boolean personalizado, TipoAccesorio tipoAccesorio, String tipoSuela, int tallaZapato) {
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
