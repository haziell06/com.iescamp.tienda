package com.iescamp.tienda;

import java.math.BigDecimal;

public class Chaqueta extends Ropa {
    private boolean impermeable;

    public Chaqueta(int talla, String color, BigDecimal precio, String tipoCierre, String descripcion, String imagen, String s, String estilo, boolean impermeable, String string, String cierre, boolean b) {
        super(talla, color, tipoCierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(int codArt, String nombre, BigDecimal precio, String marca, String descripcion, String imagen, boolean activo, int talla,String color, String tipoCierre, boolean impermeable) {
        super(talla, color, tipoCierre);
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
