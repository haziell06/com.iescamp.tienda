package com.iescamp.clasesSinComposicion;

import java.util.Objects;

public class Departamento {
    private int codigo;
    private String nombre;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // constructor
    public Departamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void crearDepartamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}
