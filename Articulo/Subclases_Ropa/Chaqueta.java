package com.iescamp.tienda.Subclases_Ropa;

import com.iescamp.tienda.Ropa;

public class Chaqueta extends Ropa {
    private boolean impermeable;

    public Chaqueta(int talla, String color, String tipoCierre, boolean impermeable) {
        super(talla, color, tipoCierre);
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
    Chaqueta chaqueta = new Chaqueta(32, "Negro", "Botones", true);
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
