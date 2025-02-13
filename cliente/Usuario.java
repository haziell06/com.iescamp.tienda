package com.iescamp.tienda;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

    /**
     * @param {User}
     * @returns este codigo contien todos los datos que seran utilizados en otras clase, porfavor no lo modifique
     *
     */



    private String DNI="12345678A";
    private String nombre="Manolo";
    private String apellidos="Garcia";
    private String direccion="calle 123";
    private String telefono="123456789";
    private String email="manolo@gmail.com";
    private LocalDate fechaNacimiento=LocalDate.now();
    private String password="123456";
    private boolean activo=true;


    public Usuario(String DNI, String nombre, String direccion, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String password, boolean activo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.activo = activo;
    }

    public Usuario() {}

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return Objects.equals(DNI, user.DNI) && Objects.equals(telefono, user.telefono) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI, telefono, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", activo=" + activo +
                '}';
    }
}

