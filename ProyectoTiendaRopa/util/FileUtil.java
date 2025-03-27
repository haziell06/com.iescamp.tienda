package com.iescamp.tienda.util;

import com.iescamp.tienda.model.articulo.Catalogo;
import com.iescamp.tienda.model.pedido.Ventas;
import com.iescamp.tienda.model.usuario.cliente.Clientela;
import com.iescamp.tienda.model.usuario.empleado.Plantilla;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


public class FileUtil {
    // serializar en binario
    public static void serializarCatalogo(Catalogo catalogo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("catalogo.dat"))) {
            oos.writeObject(catalogo);
            System.out.println("Objeto serializado");
        } catch (IOException e) {
            System.out.println("Error al serializar el objeto");
            e.printStackTrace();
        }
    }
    public static void serializarClientela(Clientela clientela) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientela.dat"))) {
            oos.writeObject(clientela);
            System.out.println("Objeto serializado");
        } catch (IOException e) {
            System.out.println("Error al serializar el objeto");
            e.printStackTrace();
        }
    }
    public static void serializarPlantilla(Plantilla plantilla) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("plantilla.dat"))) {
            oos.writeObject(plantilla);
            System.out.println("Objeto serializado");
        } catch (IOException e) {
            System.out.println("Error al serializar el objeto");
            e.printStackTrace();
        }
    }
    public static void serializarVentas(Ventas ventas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ventas.dat"))) {
            oos.writeObject(ventas);
            System.out.println("Objeto serializado");
        } catch (IOException e) {
            System.out.println("Error al serializar el objeto");
            e.printStackTrace();
        }
    }
    // deserializar en binario
    public static void deserializarCatalogo(Catalogo catalogo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalogo.dat"))) {
            catalogo = (Catalogo) ois.readObject();
            System.out.println("Objeto deserializado: " + catalogo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el objeto");
            e.printStackTrace();
        }
    }

    public static void deserializarClientela(Clientela clientela) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalogo.dat"))) {
            clientela = (Clientela) ois.readObject();
            System.out.println("Objeto deserializado: " + clientela);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el objeto");
            e.printStackTrace();
        }
    }

    public static void deserializarPlantilla(Plantilla plantilla) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalogo.dat"))) {
            plantilla = (Plantilla) ois.readObject();
            System.out.println("Objeto deserializado: " + plantilla);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el objeto");
            e.printStackTrace();
        }
    }

    public static void deserializarVentas(Ventas ventas) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalogo.dat"))) {
            ventas = (Ventas) ois.readObject();
            System.out.println("Objeto deserializado: " + ventas);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el objeto");
            e.printStackTrace();
        }
    }





    // API Jackson

    public static <T> void guardarEnJson(List<T> objetos, String tipo, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), objetos);
            System.out.println(tipo + " guardado en JSON: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON para " + tipo);
            e.printStackTrace();
        }
    }

    public static <T> List<T> leerDesdeJson(String filePath, Class<T[]> clase, String tipo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<T> lista = List.of(objectMapper.readValue(new File(filePath), clase));
            System.out.println(tipo + " cargado desde JSON: " + filePath);
            return lista;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON para " + tipo);
            e.printStackTrace();
            return List.of();
        }
    }
}
    // API Opencsv
