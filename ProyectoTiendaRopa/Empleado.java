package com.iescamp.tienda;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Usuario {
    private boolean tienePrivilegios = false;
    private String departamento = "Sin asignar"; // Se inicializa para evitar null

    public Empleado(String DNI, String nombre, String direccion, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String password, boolean activo, boolean tienePrivilegios, String departamento) {
        super(DNI, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo);
        this.tienePrivilegios = tienePrivilegios;
        this.departamento = departamento;
    }

    // Getters y Setters
    public boolean isTienePrivilegios() {
        return tienePrivilegios;
    }

    public void setTienePrivilegios(boolean tienePrivilegios) {
        this.tienePrivilegios = tienePrivilegios;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento != null && !departamento.trim().isEmpty()) {
            this.departamento = departamento;
        } else {
            throw new IllegalArgumentException("El departamento no puede estar vacío.");
        }
    }

    // Métodos
    public void consultarUsuario() {
        System.out.println("Consultando usuario...");
    }

    public void altaArticulo() {
        System.out.println("Dando de alta un artículo...");
    }

    public void bajaArticulo() {
        System.out.println("Dando de baja un artículo...");
    }

    public void consultarArticulo() {
        System.out.println("El articulo" );

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true; // Si es la misma instancia, son iguales
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return tienePrivilegios == empleado.tienePrivilegios && Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tienePrivilegios, departamento);
    }
}
