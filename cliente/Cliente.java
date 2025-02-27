package com.iescamp.tienda;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public Cliente(String DNI, String nombre, String direccion, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String password, boolean activo) {
        super(DNI, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo);
    }

    private String direccionEnvio;
    private float saldoCuenta;
    private boolean tarjetaFidelidad;
    private int numeroPedidos;
    private MetodoPago metodoPago;

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public float getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public boolean isTarjetaFidelidad() {
        return tarjetaFidelidad;
    }

    public void setTarjetaFidelidad(boolean tarjetaFidelidad) {
        this.tarjetaFidelidad = tarjetaFidelidad;
    }

    public int getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(int numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarPedido(String pedido) {
        if (pedido == null || pedido.isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío.");
        }

        pedido = pedido.toUpperCase(); // Mantiene la transformación a mayúsculas por si es útil
        System.out.println("Pedido registrado: " + pedido);
    }
}
