package com.iescamp.tienda.model.usuario.cliente;

import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.Usuario;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends Usuario {
    private String dir_envio;
    private float saldo_cuenta;
    private boolean tarjeta_fidelizacion;
    private int numeroPedidos;
    private MetodoPago metodoPago;
    private ArrayList<Pedido> pedidos;

public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String e_mail, LocalDate f_nacimiento, String pass, boolean activo, String dir_envio, float saldo_cuenta, boolean tarjeta_fidelizacion, int numeroPedidos, MetodoPago metodoPago, ArrayList<Pedido> pedidos) {
        super(dni, nombre, apellidos, direccion, telefono, e_mail, f_nacimiento, pass, activo);
        this.dir_envio = dir_envio;
        this.saldo_cuenta = saldo_cuenta;
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
        this.numeroPedidos = numeroPedidos;
        this.metodoPago = metodoPago;
        this.pedidos = pedidos;
    }
    
    // Constructor sin parámetros para Jackson
    @JsonCreator
    public Cliente(
            @JsonProperty("dni") String dni,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("apellidos") String apellidos,
            @JsonProperty("direccion") String direccion,
            @JsonProperty("telefono") String telefono,
            @JsonProperty("e_mail") String e_mail,
            @JsonProperty("f_nacimiento") LocalDate f_nacimiento,
            @JsonProperty("pass") String pass,
            @JsonProperty("activo") boolean activo,
            @JsonProperty("dir_envio") String dir_envio,
            @JsonProperty("saldo_cuenta") float saldo_cuenta,
            @JsonProperty("tarjeta_fidelizacion") boolean tarjeta_fidelizacion,
            @JsonProperty("numeroPedidos") int numeroPedidos,
            @JsonProperty("metodoPago") MetodoPago metodoPago,
            @JsonProperty("pedidos") ArrayList<Pedido> pedidos) {
        super(dni, nombre, apellidos, direccion, telefono, e_mail, f_nacimiento, pass, activo);
        this.dir_envio = dir_envio;
        this.saldo_cuenta = saldo_cuenta;
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
        this.numeroPedidos = numeroPedidos;
        this.metodoPago = metodoPago;
        this.pedidos = pedidos;
    }


    public String getDir_envio() {
        return dir_envio;
    }

    public void setDir_envio(String dir_envio) {
        this.dir_envio = dir_envio;
    }

    public float getSaldo_cuenta() {
        return saldo_cuenta;
    }

    public void setSaldo_cuenta(float saldo_cuenta) {
        this.saldo_cuenta = saldo_cuenta;
    }

    public boolean isTarjeta_fidelizacion() {
        return tarjeta_fidelizacion;
    }

    public void setTarjeta_fidelizacion(boolean tarjeta_fidelizacion) {
        this.tarjeta_fidelizacion = tarjeta_fidelizacion;
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

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Float.compare(saldo_cuenta, cliente.saldo_cuenta) == 0 && tarjeta_fidelizacion == cliente.tarjeta_fidelizacion && numeroPedidos == cliente.numeroPedidos && Objects.equals(dir_envio, cliente.dir_envio) && Objects.equals(metodoPago, cliente.metodoPago) && Objects.equals(pedidos, cliente.pedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dir_envio, saldo_cuenta, tarjeta_fidelizacion, numeroPedidos, metodoPago, pedidos);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dir_envio='" + dir_envio + '\'' +
                ", saldo_cuenta=" + saldo_cuenta +
                ", tarjeta_fidelizacion=" + tarjeta_fidelizacion +
                ", numeroPedidos=" + numeroPedidos +
                ", metodoPago=" + metodoPago +
                ", pedidos=" + pedidos +
                '}';
    }

    public void realizarPedido(String pedido) {
        if (pedido == null || pedido.isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío.");
        }

        pedido = pedido.toUpperCase(); // Mantiene la transformación a mayúsculas por si es útil
        System.out.println("Pedido registrado: " + pedido);
    }

}
