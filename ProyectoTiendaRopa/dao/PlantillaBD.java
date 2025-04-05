package com.iescamp.tienda.dao;

import com.iescamp.tienda.ConsoleReader;
import com.iescamp.tienda.model.usuario.empleado.Empleado;

import java.util.List;

public class PlantillaBD {
    public static void cargarEmpleados(){
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> clientes = dao.obtenerTodos();
        System.out.println("Clientes obtenidos desde la BD: " + clientes.size());
        for (Empleado e : clientes) {
            System.out.println("Dni: " + e.getDni());
            System.out.println("Nombre: " + e.getNombre());
        }
    }
    public static void validarContraseña(){
        String email = ConsoleReader.readString("Introduce el email: ");
        String pass = ConsoleReader.readString("Introduce la contraseña: ");
        EmpleadoDAO dao = new EmpleadoDAO();
        Empleado empleado = dao.autenticarEmpleado(email, pass);

        if (empleado != null) {
            System.out.println("Contraseña correcta. Validación correcta " + empleado.getNombre());
        } else {
            System.out.println("Email o contraseña incorrectos.");
        }
    }
}
