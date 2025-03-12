package com.iescamp.tienda;

import java.time.LocalDate;
import java.util.Objects;

abstract class Usuario {

    /**
     * @param {User}
     * @returns este codigo contien todos los datos que seran utilizados en otras clase, porfavor no lo modifique
     *
     */



    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String e_mail;
    private LocalDate f_nacimiento;
    private String pass;
    private boolean activo;

    public Usuario(String dni, String nombre, String apellidos, String direccion, String telefono, String e_mail, LocalDate f_nacimiento, String pass, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.e_mail = e_mail;
        this.f_nacimiento = f_nacimiento;
        this.pass = pass;
        this.activo = activo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public LocalDate getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(LocalDate f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return activo == usuario.activo && Objects.equals(dni, usuario.dni) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(direccion, usuario.direccion) && Objects.equals(telefono, usuario.telefono) && Objects.equals(e_mail, usuario.e_mail) && Objects.equals(f_nacimiento, usuario.f_nacimiento) && Objects.equals(pass, usuario.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellidos, direccion, telefono, e_mail, f_nacimiento, pass, activo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", f_nacimiento=" + f_nacimiento +
                ", pass='" + pass + '\'' +
                ", activo=" + activo +
                '}';
    }
}
