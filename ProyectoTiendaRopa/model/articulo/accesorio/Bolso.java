package com.iescamp.tienda.model.articulo.accesorio;

import com.iescamp.tienda.enums.TipoAccesorio;
import com.iescamp.tienda.model.articulo.Material;

import java.math.BigDecimal;

public class Bolso extends Accesorio {
    private String tipoCierre;
    private int capacidad;

    public Bolso(String estilo, Boolean esPersonalizado, String tipoCierre, int capacidad) {
        super(estilo, String.valueOf(esPersonalizado));
        this.tipoCierre = tipoCierre;
        this.capacidad = capacidad;
    }

    public Bolso(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, String imagen, boolean activo, String estilo, boolean personalizado, String tipoCierre, int capacidad) {
    }

    public Bolso(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String estilo, boolean esPersonalizado, TipoAccesorio tipoAccesorio, String tipoCierre, int capacidad) {
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Bolso" +
                "tipoCierre:" + tipoCierre +
                ", capacidad:" + capacidad;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
