package com.iescamp.tienda.model.pedido;

import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.articulo.Articulo;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido{

    private int numero;
    private LocalDate fecha;
    private String estado;
    private String dir_envio;
    private MetodoPago m_pago;
    private Cliente DNI_cliente;
    private ArrayList<LineaPedido> lineaPedidos;

    public Pedido(int numero, LocalDate fecha, String estado, String dir_envio, Cliente cliente, MetodoPago m_pago, ArrayList<LineaPedido> lineaPedidos) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.dir_envio = dir_envio;
        this.m_pago = m_pago;
        this.DNI_cliente = cliente;
        this.lineaPedidos = lineaPedidos;
    }

    public Pedido() {

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

    public MetodoPago getM_pago() {
        return m_pago;
    }

    public void setM_pago(MetodoPago m_pago) {
        this.m_pago = m_pago;
    }

    public Cliente getDNI_cliente() {
        return DNI_cliente;
    }

    public void setDNI_cliente(Cliente DNI_cliente) {
        this.DNI_cliente = DNI_cliente;
    }

    public ArrayList<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public void setLineaPedidos(ArrayList<LineaPedido> lineaPedidos) {
        this.lineaPedidos = lineaPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return numero == pedido.numero && Objects.equals(fecha, pedido.fecha) && Objects.equals(estado, pedido.estado) && Objects.equals(dir_envio, pedido.dir_envio) && Objects.equals(m_pago, pedido.m_pago) && Objects.equals(DNI_cliente, pedido.DNI_cliente) && Objects.equals(lineaPedidos, pedido.lineaPedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, fecha, estado, dir_envio, m_pago, DNI_cliente, lineaPedidos);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", dir_envio='" + dir_envio + '\'' +
                ", m_pago=" + m_pago +
                ", DNI_cliente=" + DNI_cliente +
                ", lineaPedidos=" + lineaPedidos +
                '}';
    }

    public void setCliente(Cliente cliente) {
    }

    public void agregarArticulo(Articulo articulo, int cantidad) {
    }
}

