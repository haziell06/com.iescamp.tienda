package com.iescamp.tienda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido{

    private int numero;
    private LocalDate fecha;
    private String estado;
    private String dir_envio;
    private Cliente cliente;

    private ArrayList<LineaPedido> lineaPedidos;

    public Pedido(int numero, LocalDate fecha, String estado, String dir_envio, Cliente cliente, ArrayList<LineaPedido> lineaPedidos) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.dir_envio = dir_envio;
        this.cliente = cliente;
        this.lineaPedidos = lineaPedidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDir_envio() {
        return dir_envio;
    }

    public void setDir_envio(String dir_envio) {
        this.dir_envio = dir_envio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public void setLineaPedidos(ArrayList<LineaPedido> lineaPedidos) {
        this.lineaPedidos = lineaPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return numero == pedido.numero && Objects.equals(fecha, pedido.fecha) && Objects.equals(estado, pedido.estado) && Objects.equals(dir_envio, pedido.dir_envio) && Objects.equals(cliente, pedido.cliente) && Objects.equals(lineaPedidos, pedido.lineaPedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, fecha, estado, dir_envio, cliente, lineaPedidos);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", dir_envio='" + dir_envio + '\'' +
                ", cliente=" + cliente +
                ", lineaPedidos=" + lineaPedidos +
                '}';
    }
}
