package com.iescamp.tienda;

import java.time.LocalDate;

public class TiendaConsola {
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú Principal");
            System.out.println("1- Plantillas");
            System.out.println("2- Clientela");
            System.out.println("3- Catálogo");
            System.out.println("4- Salir");
            int opcion = ConsoleReader.readInt("Seleccione una opción:");

            switch (opcion) {
                case 1:
                    // actualizar una vez se haga
                    break;
                case 2:
                    menuClientela();
                    break;
                case 3:
                    // actualizar una vez se haga
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
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

                Cliente cliente = new Cliente(dni, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo);
                Clientela.setClientes(cliente);

                System.out.println("Cliente añadido con éxito.");
            }
        }
    }
