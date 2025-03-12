package com.iescamp.tienda;

import java.util.Objects;

public class Articulo {
    private int codigoArticulo;
    private String nombre;
    private  float precio;
    private String descripcion;
    private String imagen;
    private boolean activo;
    private String marca;
    private String color;
    private Material material;

    public Articulo(int codigoArticulo, String nombre, float precio, String descripcion, String imagen, boolean activo, String marca, String color, Material material) {
        this.codigoArticulo = codigoArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
        this.marca = marca;
        this.color = color;
        this.material = material;
    }

    public Articulo() {

    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return codigoArticulo == articulo.codigoArticulo && Float.compare(precio, articulo.precio) == 0 && activo == articulo.activo && Objects.equals(nombre, articulo.nombre) && Objects.equals(descripcion, articulo.descripcion) && Objects.equals(imagen, articulo.imagen) && Objects.equals(marca, articulo.marca) && Objects.equals(color, articulo.color) && Objects.equals(material, articulo.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoArticulo, nombre, precio, descripcion, imagen, activo, marca, color, material);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigoArticulo=" + codigoArticulo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", activo=" + activo +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", material=" + material +
                '}';
    }
}
