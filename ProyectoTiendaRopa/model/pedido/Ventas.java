package com.iescamp.tienda.model.pedido;

import java.io.Serializable;
import java.util.ArrayList;

public class Ventas implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Pedido> pedidos;

    public Ventas(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Ventas() {
        pedidos = new ArrayList<>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido buscarNum(int num){
        for (Pedido pedido : pedidos){
            if (pedido.getNumero() == (num))
                return pedido;
        }
        return null; //esto será cuando no se encuentre al cliente
    }

    public ArrayList<Pedido> filtarCliente(String cliente) {
        ArrayList<Pedido> clienteBuscado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getDNI_cliente().equals(cliente)) {
                clienteBuscado.add(pedido);
            }
        }
        return clienteBuscado;
    }
}
