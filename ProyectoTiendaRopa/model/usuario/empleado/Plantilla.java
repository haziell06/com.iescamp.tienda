package com.iescamp.tienda.model.usuario.empleado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Plantilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Empleado> plantillas;

    public Plantilla() {
        plantillas = new ArrayList<>();
    }

    public Plantilla(ArrayList<Empleado> plantillas) {
        this.plantillas = plantillas;
    }

    public ArrayList<Empleado> getPlantillas() {
        return plantillas;
    }

    public void setPlantillas(ArrayList<Empleado> plantillas) {
        this.plantillas = plantillas;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plantillas);
    }

    public Empleado buscarDNI(String DNI) {
        for (Empleado empleado : plantillas) {
            if (empleado.getDni().equals(DNI)) {
                return empleado;
            }
        }
        return null;
    }

    public ArrayList<Empleado> filtarDep(String Dep) {
        ArrayList<Empleado> DepBuscado = new ArrayList<>();
        for (Empleado empleado : plantillas) {
            if (empleado.getDepartamento().equals(Dep)) {
                DepBuscado.add(empleado);
            }
        }
        return DepBuscado;
    }

    public ArrayList<Empleado> filtarAdmin() {
        ArrayList<Empleado> Administradores = new ArrayList<>();
        for (Empleado empleado : plantillas) {
            if (empleado.isTienePrivilegios()) {
                Administradores.add(empleado);
            }
        }
        return Administradores;
    }

    public ArrayList<Empleado> filtarNom(String Nom, String Apellidos) {
        ArrayList<Empleado> NomBuscado = new ArrayList<>();
        for (Empleado empleado : plantillas) {
            if (empleado.getNombre().equals(Nom) && (empleado.getApellidos().equals(Apellidos))) {
                NomBuscado.add(empleado);
            }
        }
        return NomBuscado;
    }

    // metodo para añadir empleados
    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            plantillas.add(empleado);
        } else {
            System.out.println("Error");
        }
    }

    public Empleado buscarEmpleadoPorDNI(String dni) {
        return null;
    }

    public Empleado[] getListaEmpleados() {
        return null;
    }
}
