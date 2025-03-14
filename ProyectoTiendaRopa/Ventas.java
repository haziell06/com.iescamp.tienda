package com.iescamp.tienda;

import java.util.ArrayList;

public class Ventas {
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
            if (pedido.getCliente().equals(cliente)) {
                clienteBuscado.add(pedido);
            }
        }
        return clienteBuscado;
    }
}
