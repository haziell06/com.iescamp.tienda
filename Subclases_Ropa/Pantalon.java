package com.iescamp.tienda.Subclases_Ropa;

import com.iescamp.tienda.Ropa;

public class Pantalon extends Ropa {
    private boolean tieneBolsillo;
    private String tipoPantalon;

    public Pantalon(int talla, String color, String tipoCierre, boolean tieneBolsillo, String tipoPantalon) {
        super(talla, color, tipoCierre);
        this.tieneBolsillo = tieneBolsillo;
        this.tipoPantalon = tipoPantalon;
    }

    public boolean isTieneBolsillo() {
        return tieneBolsillo;
    }

    public void setTieneBolsillo(boolean tieneBolsillo) {
        this.tieneBolsillo = tieneBolsillo;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    @Override
    public String toString() {
        return "Pantalon" +
                "tieneBolsillo:" + tieneBolsillo +
                ", tipoPantalon:" + tipoPantalon;
    }
    public void mostrarDetalles() {
        System.out.println(toString());
    }
}
