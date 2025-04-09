package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.cliente.Clientela;

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

    // modificar usuario
    // mediante dni y correo
    public static void modificarCliente(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        Clientela Clientela = new Clientela();// puede estar mal

        System.out.println("""
            Como deseas buscar el cliente:
            1-Por DNI
            2-Por Correo                    
            """);

        int opcion = ConsoleReader.readInt("Ingrese la opción: ");
        Cliente clienteExistente = null;

        switch (opcion) {
            case 1:
                // Buscar por DNI
                String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
                clienteExistente = dao.obtenerPorDNI(dni);
                break;
            case 2:
                // Buscar por correo electrónico
                String email = ConsoleReader.readString("Introduce el correo del cliente: ");
                clienteExistente = dao.obtenerPorEmail(email);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (clienteExistente != null) {
            // Modificación solo de DNI o correo
            System.out.println("Cliente encontrado. Procediendo a modificar.");

            switch (opcion) {
                case 1:
                    // Modificar DNI
                    String nuevoDNI = ConsoleReader.readString("Nuevo DNI (deja vacío para no modificar): ");
                    if (!nuevoDNI.isEmpty()) {
                        clienteExistente.setDni(nuevoDNI);
                    }
                    break;
                case 2:
                    // Modificar correo
                    String nuevoCorreo = ConsoleReader.readString("Nuevo correo (deja vacío para no modificar): ");
                    if (!nuevoCorreo.isEmpty()) {
                        clienteExistente.setE_mail(nuevoCorreo);
                    }
                    break;
            }

            // Actualizar en la base de datos
            dao.actualizar(clienteExistente);
            System.out.println("Cliente modificado con éxito.");

            // Recargar la lista de clientes desde la BD
            List<Cliente> clientesActualizados = dao.obtenerTodos();
            System.out.println("Clientes recargados desde la BD: " + clientesActualizados.size());

            // Actualizar la clase Clientela con la lista recargada de clientes
            Clientela.setClientes(clientesActualizados);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }


}
