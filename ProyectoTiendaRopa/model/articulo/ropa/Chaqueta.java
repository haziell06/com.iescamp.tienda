package com.iescamp.tienda.model.articulo.ropa;

import com.iescamp.tienda.model.articulo.Material;

import java.math.BigDecimal;
public class Chaqueta extends Ropa {
    private boolean impermeable;

    public Chaqueta(String talla, String color, BigDecimal precio, String tipoCierre, String descripcion, String imagen, String s, String estilo, boolean impermeable, String string, String cierre, boolean b) {
        super(talla, tipoCierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(String talla, String color, BigDecimal precio, String tipoCierre, String descripcion, String imagen, boolean impermeable, int i, String cierre, boolean b) {
        super(talla, tipoCierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(int codArt, String nombre, BigDecimal precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material, String talla, String tipoCierre, boolean impermeable) {
        super(talla, tipoCierre);
        this.impermeable = impermeable;
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
