package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.cliente.Cliente;

import java.sql.SQLException;

public class MenuBD {
    public static void main(String[] args) throws SQLException {
        boolean salir = false;
        int opcion;
        while (!salir){
            System.out.println("Menú Principal");
            System.out.println("1- Menú ClientelaBD");
            System.out.println("2- Menú PlantillaBD");
            System.out.println("3- Menú CatálogoBD");
            System.out.println("4- Salir");
            opcion = ConsoleReader.readInt();
            switch (opcion){
                case 1:
                    menuClientelaBD();
                    break;
                case 2:
                    menuPlantillaBD();
                    break;
                case 3:
                    menuCatalogoBD();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    public static void menuClientelaBD() throws SQLException {
        int opcion;
        do {
            System.out.println("Menú ClientelaBD");
            System.out.println("1. Listar usuario por DNI");
            System.out.println("2. Añadir usuario");
            System.out.println("3. Cargar clientes desde BD");
            System.out.println("4. Modificar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Validar contraseña");
            System.out.println("7. Añadir pedido");
            System.out.println("8. Listar pedidos del cliente");
            System.out.println("9. Volver");
            opcion = ConsoleReader.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    ClientelaBD.ListarClientePorDNI(ConsoleReader.readString("Escriba el DNI del cliente: "));
                    break;
                case 2:
                    break;
                case 3:
                ClientelaBD.cargarClientes();
                    break;
                case 4:
                    // modificar usuario
                    ClientelaBD.modificarEmpleado();
                    break;
                case 5:
                    // eliminar usuario
                    ClientelaBD.eliminarEmpleado();

                    break;
                case 6:
                    ClientelaBD.validarContraseña();
                    break;
                case 7:

                    break;
                case 8:
                    ClientelaBD.ListarPorPedido(ConsoleReader.readString("Escriba el DNI del cliente: "));
                break;
                case 9:
                    System.out.println("Volviendo...");
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    public static void menuPlantillaBD(){
        int opcion;
        do {
            System.out.println("Menú PlantillaBD");
            System.out.println("1. Listar empleado por DNI");
            System.out.println("2. Cargar empleados desde BD");
            System.out.println("3. Añadir empleado");
            System.out.println("4. Modificar empleado");
            System.out.println("5. Validar contraseña");
            System.out.println("6. Eliminar empleado");
            System.out.println("7. Volver");
            opcion = ConsoleReader.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    PlantillaBD.ListarEmpleadoPorDNI(ConsoleReader.readString("Escriba el DNI del empleado: "));
                    break;
                case 2:
                PlantillaBD.cargarEmpleados();
                    break;
                case 3:
                    break;
                case 4:
                    PlantillaBD.modificarCliente();
                    break;
                case 5:
                PlantillaBD.validarContraseña();
                    break;
                case 6:
                    // eliminar usuario
                    PlantillaBD.eliminarCliente();
                    break;
                case 7:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    public static void menuCatalogoBD(){
        int opcion;
        do {
            System.out.println("Menú PlantillaBD");
            System.out.println("1. Listar artículo por código");
            System.out.println("2. Añadir artículo");
            System.out.println("3. Cargar todos los artículos desde BD");
            System.out.println("4. Listar todos los artículos de un tipo");
            System.out.println("5. Modificar artículo");
            System.out.println("6. Eliminar artículo y recargar catálogo");
            System.out.println("7. Volver");
            opcion = ConsoleReader.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    CatalogoBD.ListarArticuloPorID(ConsoleReader.readInt("Escriba el codigo del articulo: "));
                    break;
                case 2:
                    break;
                case 3:
                CatalogoBD.cargarArticulos();
                    break;
                case 4:
                    // La consulta de mysql solo funciona si uno de los dos tipos sea null si lo que quieres es devolver solo un tipo especifico de articulo
                    // probablemente se podria mejorar para que eso no sea necesario pero no se como
                    CatalogoBD.ListarTodosPorTipo(ConsoleReader.readString("Escribe el tipo de ropa que buscas: "), ConsoleReader.readString("Escribe el tipo de accesorio que buscas: "));
                    break;
                case 5:
                    CatalogoBD.modificarArticulo();
                    break;
                case 6:
                    CatalogoBD.eliminarArticuloYRecargar();
                    break;
                case 7:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
