package com.iescamp.clasesSinComposicion;

import java.util.Objects;

public class Material {
    private int codigo;
    private String descripcion;

    // getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // constructor
    public Material(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return codigo == material.codigo && Objects.equals(descripcion, material.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion);
    }
}
