package com.iescamp.tienda.console;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.MetodoPago;
import com.iescamp.tienda.model.pedido.Pedido;
import com.iescamp.tienda.model.usuario.cliente.Cliente;
import com.iescamp.tienda.model.usuario.cliente.Clientela;
import com.iescamp.tienda.model.usuario.empleado.Empleado;
import com.iescamp.tienda.model.usuario.empleado.Plantilla;
import com.iescamp.tienda.util.FileUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("2- Listar empleados");
        System.out.println("3- Buscar empleado por DNI");
        System.out.println("4- Validar contraseña");
        System.out.println("5- Volver");

        int opcion = ConsoleReader.readInt("Elige una opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Introduzca los datos del empleado:");

                // Pedir los datos del empleado
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

                // Crear el empleado
                Empleado empleado = new Empleado(nombre, apellidos, dni, telefono, direccion, email, fechaNacimiento, password, activo, tienePrivilegios, departamento);

                // Añadir el empleado a la plantilla
                Plantilla plantilla = new Plantilla();  // Asume que tienes la plantilla cargada
                plantilla.agregarEmpleado(empleado);

                System.out.println("Empleado añadido con éxito.");
            break;
            case 2:
                listarEmpleados();
                break;
            case 3:
                buscarEmpleadoPorDNI();
                break;
            case 4:
                validarContraseñaEmpleado();
                break;
            case 5:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void listarEmpleados() {
        // Lógica para listar todos los empleados
        Plantilla plantilla = new Plantilla();  // Asume que tienes la plantilla cargada de la base de datos o lista
        for (Empleado empleado : plantilla.getListaEmpleados()) {
            System.out.println(empleado);
        }
    }

    public static void buscarEmpleadoPorDNI() {
        String dni = ConsoleReader.readString("Introduce el DNI del empleado: ");
        Plantilla plantilla = new Plantilla();  // Asume que tienes la plantilla cargada de la base de datos o lista
        Empleado empleado = plantilla.buscarEmpleadoPorDNI(dni);
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void validarContraseñaEmpleado() {
        String dni = ConsoleReader.readString("Introduce el DNI del empleado: ");
        String password = ConsoleReader.readString("Introduce la contraseña del empleado: ");
        Plantilla plantilla = new Plantilla();  // Asume que tienes la plantilla cargada de la base de datos o lista
        Empleado empleado = plantilla.buscarEmpleadoPorDNI(dni);
        if (empleado != null && empleado.getPassword().equals(password)) {
            System.out.println("Contraseña válida.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }


    public static void menuClientela() {
        System.out.println("Menú Clientela");
        System.out.println("1- Añadir cliente");
        System.out.println("2- Listar clientes");
        System.out.println("3- Buscar cliente por DNI");
        System.out.println("4- Listar pedidos de un cliente");
        System.out.println("5- Validar contraseña");
        System.out.println("6- Volver");

        int opcion = ConsoleReader.readInt("Seleccione una opción:");

        switch (opcion) {
            case 1:
                System.out.println("Introduzca los datos del cliente:");

                String dni = ConsoleReader.readString("Ingrese el DNI del cliente: ");
                String nombre = ConsoleReader.readString("Ingrese el nombre del cliente: ");
                String apellidos = ConsoleReader.readString("Ingrese los apellidos del cliente: ");
                String direccion = ConsoleReader.readString("Ingrese la dirección del cliente: ");
                String telefono = ConsoleReader.readString("Ingrese el teléfono del cliente: ");
                String email = ConsoleReader.readString("Ingrese el email del cliente: ");
                LocalDate fechaNacimiento = LocalDate.parse(ConsoleReader.readString("Ingrese la fecha de nacimiento (YYYY-MM-DD): "));
                String password = ConsoleReader.readString("Ingrese la contraseña del cliente: ");
                boolean activo = ConsoleReader.readBoolean("¿Está activo el cliente? (true/false): ");
                String dir_envio = ConsoleReader.readString("Ingrese la dirección de envío: ");
                float saldo_cuenta = ConsoleReader.readFloat("Ingrese el saldo de la cuenta: ");
                boolean tarjeta_fidelizacion = ConsoleReader.readBoolean("¿Tiene tarjeta de fidelización? (true/false): ");
                int numeroPedidos = ConsoleReader.readInt("Ingrese el número de pedidos: ");
                MetodoPago metodoPago = new MetodoPago(ConsoleReader.readInt("Ingrese el código del método de pago: "), ConsoleReader.readString("Ingrese la descripción del método de pago: "));
                ArrayList<Pedido> pedidos = new ArrayList<>();

                // Crear el cliente
                Cliente cliente = new Cliente(dni, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo, dir_envio, saldo_cuenta, tarjeta_fidelizacion, numeroPedidos, metodoPago, pedidos);

                // Añadir el cliente a la lista
                Clientela clientela = new Clientela();
                clientela.agregarCliente(cliente);

                System.out.println("Cliente añadido con éxito.");
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                buscarClientePorDNI();
                break;
            case 4:
                listarPedidosDeCliente();
                break;
            case 5:
                validarContraseñaCliente();
                break;
            case 6:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void listarClientes() {
        // Lógica para listar todos los clientes
        Clientela clientela = new Clientela();  // Asume que tienes la clientela cargada de la base de datos o lista
        for (Cliente cliente : clientela.getListaClientes()) {
            System.out.println(cliente);
        }
    }

    public static void buscarClientePorDNI() {
        String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
        Clientela clientela = new Clientela();  // Asume que tienes la clientela cargada de la base de datos o lista
        Cliente cliente = clientela.buscarClientePorDNI(dni);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void listarPedidosDeCliente() {
        String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
        Clientela clientela = new Clientela();  // Asume que tienes la clientela cargada de la base de datos o lista
        Cliente cliente = clientela.buscarClientePorDNI(dni);
        if (cliente != null) {
            System.out.println("Pedidos de " + cliente.getNombre() + ":");
            for (Pedido pedido : cliente.getPedidos()) {
                System.out.println(pedido);
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void validarContraseñaCliente() {
        String dni = ConsoleReader.readString("Introduce el DNI del cliente: ");
        String password = ConsoleReader.readString("Introduce la contraseña del cliente: ");
        Clientela clientela = new Clientela();  // Asume que tienes la clientela cargada de la base de datos o lista
        Cliente cliente = clientela.buscarClientePorDNI(dni);
        if (cliente != null && cliente.getPassword().equals(password)) {
            System.out.println("Contraseña válida.");
        } else {
            System.out.println("Contraseña incorrecta.");
        }
    }

    public static void menuCatálogo() {
        System.out.println("Menú Catálogo");
        System.out.println("1- Listar artículos");
        System.out.println("2- Listar ropa por tipo");
        System.out.println("3- Listar accesorios por tipo");
        System.out.println("4- Buscar artículo por código");
        System.out.println("5- Volver");

        int opcion = ConsoleReader.readInt("Seleccione una opción:");

        switch (opcion) {
            case 1:
                listarArticulos();
                break;
            case 2:
                listarRopaPorTipo();
                break;
            case 3:
                listarAccesoriosPorTipo();
                break;
            case 4:
                buscarArticuloPorCodigo();
                break;
            case 5:
                System.out.println("Volviendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void listarArticulos() {
        // Lógica para listar todos los artículos
        // Asumiendo que tienes los artículos cargados en alguna lista o base de datos
    }

    public static void listarRopaPorTipo() {
        String tipo = ConsoleReader.readString("Introduce el tipo de ropa (camisa, pantalón, etc.): ");
        // Lógica para filtrar y listar ropa por tipo
    }

    public static void listarAccesoriosPorTipo() {
        String tipo = ConsoleReader.readString("Introduce el tipo de accesorio (bolso, zapato, etc.): ");
        // Lógica para filtrar y listar accesorios por tipo
    }

    public static void buscarArticuloPorCodigo() {
        int codigo = ConsoleReader.readInt("Introduce el código del artículo: ");
        // Lógica para buscar el artículo por código
    }

    // CSV reader
    public class CSVReader {
        public static void leercsvConsola(){
            String filePath = ConsoleReader.readString("Introduce la ruta para el archivo CSV: ");
            List<String[]> datos = FileUtil.leerCSV(filePath);

            for (String[] fila : datos) {
                System.out.println(String.join(",", fila));
            }
        }
    }
}
