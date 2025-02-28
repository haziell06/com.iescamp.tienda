package com.iescamp.tienda;

public class Bolso extends Accesorio {
    private String tipoCierre;
    private int capacidad;

    public Bolso(String estilo, String esPersonalizado, String tipoCierre, int capacidad) {
        super(estilo, esPersonalizado);
        this.tipoCierre = tipoCierre;
        this.capacidad = capacidad;
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
