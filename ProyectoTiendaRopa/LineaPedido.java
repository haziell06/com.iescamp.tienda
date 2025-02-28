package com.iescamp.tienda;

public class LineaPedido {
    private int idLinea;
    private int cantidad;

    public LineaPedido(int idLinea, int cantidad) {
        this.idLinea = idLinea;
        this.cantidad = cantidad;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "idLinea=" + idLinea +
                ", cantidad=" + cantidad +
                '}';
    }
}