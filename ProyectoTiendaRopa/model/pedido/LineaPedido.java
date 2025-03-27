package com.iescamp.tienda.model.pedido;

import com.iescamp.tienda.model.articulo.Articulo;

import java.util.Objects;

public class LineaPedido {
    private Articulo articulo;

    public LineaPedido(Articulo articulo) {
        this.articulo = articulo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaPedido that = (LineaPedido) o;
        return Objects.equals(articulo, that.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo);
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "articulo=" + articulo +
                '}';
    }
}
