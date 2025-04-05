package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.util.List;

public class ClientelaBD {
    public static void cargarClientes(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.obtenerTodos();
        System.out.println("Clientes obtenidos desde la BD: " + clientes.size());
        for (Cliente c : clientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
        }
    }
    public static void validarContraseña(){
        String email = ConsoleReader.readString("Introduce el email: ");
        String pass = ConsoleReader.readString("Introduce la contraseña: ");
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.autenticarCliente(email, pass);

        if (cliente != null) {
            System.out.println("Contraseña correcta. Validación correcta " + cliente.getNombre());
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }
}
