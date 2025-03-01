package com.iescamp.tienda.com.iescamp.tienda;

import java.util.Scanner;

public class MENU {


    public class TiendaConsola {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("--- Menú Tienda ---");
                System.out.println("1. Gestionar Plantilla");
                System.out.println("2. Gestionar Clientela");
                System.out.println("3. Gestionar Catálogo");
                System.out.println("4. Gestionar Ventas");
                System.out.println("5. Crear Bolso");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("Gestionando Plantilla...");
                        Plantilla plantilla = new Plantilla();
                        // Aquí puedes agregar más métodos de gestión de empleados
                        break;
                    case 2:
                        System.out.println("Gestionando Clientela...");
                        Clientela clientela = new Clientela();
                        // Aquí puedes agregar más métodos de gestión de clientes
                        break;
                    case 3:
                        System.out.println("Gestionando Catálogo...");
                        Catalogo catalogo = new Catalogo();
                        // Aquí puedes agregar más métodos de gestión de artículos
                        break;
                    case 4:
                        System.out.println("Gestionando Ventas...");
                        Ventas ventas = new Ventas();
                        // Aquí puedes agregar más métodos de gestión de pedidos
                        break;
                    case 5:
                        System.out.println("Creando un Bolso...");
                        ConsoleUtil.crearBolso();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 6);
            scanner.close();
        }
    }





}
