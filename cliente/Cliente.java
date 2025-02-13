package com.iescamp.tienda;

import java.time.LocalDate;

public class Cliente extends Usuario {
    public Cliente(String DNI, String nombre, String direccion, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String password, boolean activo) {
        super(DNI, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo);
    }

    private String direccionEnvio;
    private float saldoCuenta=0;
    private boolean tarjetaFidelidad=false;
    private int numeroPedidos=1;
    private String metodoPago="tajeta";

    @Override
    public void setNombre(String nombre) {
        super.setNombre("juan");
    }

    public Cliente() {
        super();
    }

    public void realizarPedido(String pedido) {
        if (pedido == null || pedido.isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío.");
        }

        pedido = pedido.toUpperCase(); // Mantiene la transformación a mayúsculas por si es útil
        System.out.println("Pedido registrado: " + pedido);
    }



}
