package com.iescamp.tienda.console;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.articulo.Material;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.cliente.Clientela;
import com.iescamp.tienda.model.usuario.empleado.Empleado;
import com.iescamp.tienda.model.usuario.empleado.Plantilla;
import com.iescamp.tienda.util.ConsoleUtil;

import java.time.LocalDate;
import java.util.ArrayList;

public class TiendaConsola {
    public static void main(String[] args) {
        boolean salir = false;
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        Plantilla plantilla = new Plantilla(listaEmpleados);

        while (!salir) {
            System.out.println("Menú Principal");
            System.out.println("1- Plantillas");
            System.out.println("2- Clientela");
            System.out.println("3- Catálogo");
            System.out.println("4- Salir");
            int opcion = ConsoleReader.readInt("Seleccione una opción:");

            switch (opcion) {
                case 1:
                    menuPlantilla();
                    break;
                case 2:
                    menuClientela();
                    break;
                case 3:
                    menuCatálogo();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
        public static void menuPlantilla() {
        System.out.println("Menu Plantilla");
        System.out.println("1- Añadir empleado");
        System.out.println("2- Volver");
        int opcion = ConsoleReader.readInt("Elige una opción: ");

        if (opcion == 1) {
            String nombre = ConsoleReader.readString("Introduce el nombre del empleado: ");
            String apellidos = ConsoleReader.readString("Introduce los apellidos del empleado: ");
            String dni = ConsoleReader.readString("Introduce el DNI del empleado: ");
            String telefono = ConsoleReader.readString("Introduce el teléfono del empleado: ");
            String direccion = ConsoleReader.readString("Introduce la dirección del empleado: ");
            String email = ConsoleReader.readString("Introduce el email del empleado: ");
            LocalDate fechaNacimiento = LocalDate.parse(ConsoleReader.readString("Introduce la fecha de nacimiento del empleado (YYYY-MM-DD): "));
            String password = ConsoleReader.readString("Introduce la contraseña del empleado: ");
            boolean activo = ConsoleReader.readBoolean("¿Sigue en activo el empleado? (true/false): ");
            boolean tienePrivilegios = ConsoleReader.readBoolean("¿Tiene privilegios? (true/false): ");
            String departamento = ConsoleReader.readString("Introduce el nombre del departamento: ");

            Empleado empleado = new Empleado(nombre, apellidos, dni, telefono, direccion, email, fechaNacimiento, password, activo, tienePrivilegios, departamento);
            
            //añadir empleado a plantilla
            Plantilla plantilla = new Plantilla();
            plantilla.agregarEmpleado(empleado);

            System.out.println("Empleado añadido con éxito.");
        }
    }

    public static void menuClientela() {
        System.out.println("Menú Clientela");
        System.out.println("1- Añadir cliente");
        System.out.println("2- Volver");
        int opcion = ConsoleReader.readInt("Seleccione una opción:");

        if (opcion == 1) {
            String dni = ConsoleReader.readString("Ingrese el DNI del cliente:");
            String nombre = ConsoleReader.readString("Ingrese el nombre del cliente:");
            String apellidos = ConsoleReader.readString("Ingrese los apellidos del cliente:");
            String direccion = ConsoleReader.readString("Ingrese la dirección del cliente:");
            String telefono = ConsoleReader.readString("Ingrese el teléfono del cliente:");
            String email = ConsoleReader.readString("Ingrese el email del cliente:");
            LocalDate fechaNacimiento = LocalDate.parse(ConsoleReader.readString("Ingrese la fecha de nacimiento (YYYY-MM-DD):"));
            String password = ConsoleReader.readString("Ingrese la contraseña del cliente:");
            boolean activo = ConsoleReader.readBoolean("¿Está activo el cliente? (true/false):");
            String dir_envio = ConsoleReader.readString("Ingrese la dirección de envío:");
            float saldo_cuenta = ConsoleReader.readFloat("Ingrese el saldo de la cuenta: ");
            boolean tarjeta_fidelizacion = ConsoleReader.readBoolean("¿Tiene tarjeta de fidelización? (true/false)");
            int numeroPedidos = ConsoleReader.readInt("Ingrese el número de pedidos: ");
            MetodoPago metodoPago = new MetodoPago(ConsoleReader.readInt("Ingrese el código del método de pago: "),ConsoleReader.readString("Ingrese la descripción del metodo de pago: "));
            ArrayList<Pedido> pedidos = new ArrayList<>();


            Cliente cliente = new Cliente(dni, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo, dir_envio, saldo_cuenta, tarjeta_fidelizacion, numeroPedidos, metodoPago, pedidos);
            // añadir cliente a clientela
            Clientela clientela = new Clientela();
            clientela.agregarCliente(cliente);
                    
            System.out.println("Cliente añadido con éxito.");
        }
    }
    public static void menuCatálogo() {
        System.out.println("Menú Catálogo");
        System.out.println("1- Añadir Chaqueta");
        System.out.println("2- Añadir Camisa");
        System.out.println("3- Añadir Pantalon");
        System.out.println("4- Añadir Bolso");
        System.out.println("5- Añadir Zapatos");
        System.out.println("6- Volver");
        int opcion = ConsoleReader.readInt("Seleccione una opción:");

        switch (opcion) {
            case 1:
                ConsoleUtil.crearChaqueta(new Material(ConsoleReader.readInt("Introduzca el codigo"), ConsoleReader.readString("Escriba una descripción")));
                break;
            case 2:
                ConsoleUtil.crearCamisa(new Material(ConsoleReader.readInt("Introduzca el codigo"), ConsoleReader.readString("Escriba una descripción")));
                break;
            case 3:
                ConsoleUtil.crearPantalon(new Material(ConsoleReader.readInt("Introduzca el codigo"), ConsoleReader.readString("Escriba una descripción")));
                break;
            case 4:
                ConsoleUtil.crearBolso(new Material(ConsoleReader.readInt("Introduzca el codigo"), ConsoleReader.readString("Escriba una descripción")));
                break;
            case 5:
                ConsoleUtil.crearZapato(new Material(ConsoleReader.readInt("Introduzca el codigo"), ConsoleReader.readString("Escriba una descripción")));
                break;
            case 6:
                System.out.println("Saliendo...");
        }
    }
}
