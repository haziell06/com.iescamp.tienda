package com.iescamp.tienda;

import java.util.ArrayList;
import java.util.List;

public class Clientela {
    private List<Cliente> clientes;

    // constructor
    public Clientela(){
        this.clientes = new ArrayList<>();
    }

    // Buscar por DNI
    public Cliente buscarDNI(String dni){
        for (Cliente cliente : clientes){
            if (cliente.getDNI().equalsIgnoreCase(dni))
                return cliente;
        }
        return null; //esto será cuando no se encuentre al cliente
    }

    // Filtrar por metodo de pago
    public List<Cliente> filtrarPorMetodoPago(MetodoPago metodoPago) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getMetodoPago() == metodoPago) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    // Filtrar por nombre y apellidos
    public List<Cliente> filtrarPorNombreYApellidos(String nombre, String apellidos) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre) &&
                    cliente.getApellidos().equalsIgnoreCase(apellidos)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}