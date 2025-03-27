package com.iescamp.tienda.util;

import com.iescamp.tienda.enums.TipoAccesorio;
import com.iescamp.tienda.model.articulo.Material;
import com.iescamp.tienda.model.articulo.accesorio.Bolso;
import com.iescamp.tienda.model.articulo.accesorio.Zapato;
import com.iescamp.tienda.model.articulo.ropa.Camisa;
import com.iescamp.tienda.model.articulo.ropa.Chaqueta;
import com.iescamp.tienda.model.articulo.ropa.Pantalon;

import java.math.BigDecimal;

import static com.iescamp.tienda.ConsoleReader.*;

public class ConsoleUtil {
    public static Zapato crearZapato(Material material) {
        System.out.println("Creando un Zapato...");
        int cod_art = readInt("Código del artículo: ");
        String nombre = readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(readDouble("Precio: "));
        String marca = readString("Marca: ");
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        String color = readString("Color: ");
        String estilo = readString("Estilo: ");
        boolean activo = readBoolean("¿Es activo? ");
        boolean personalizado = readBoolean("¿Es personalizado? ");
        String tipoSuela = readString("Tipo de suela: ");
        int tallaZapato = readInt("Talla del zapato: ");

        return new Zapato(cod_art, nombre, precio, marca, descripcion, true, imagen, color, material, estilo, activo, personalizado, TipoAccesorio.ZAPATOS, tipoSuela, tallaZapato);
    }

    public static Chaqueta crearChaqueta(Material material){
        System.out.println("Creando una Chaqueta...");
        int cod_art = readInt("Código del artículo: ");
        String nombre = readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(readDouble("Precio: "));
        String marca = readString("Marca: ");
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        boolean activo = readBoolean("¿Es activo? ");
        String talla = readString("Talla: ");
        String tipoCierre = readString("Tipo cierre: ");
        boolean impermeable = readBoolean("¿Es impermeable? ");

        return new Chaqueta(talla, nombre, precio, marca, descripcion, imagen, activo, cod_art, tipoCierre, impermeable);
    }

    public static Bolso crearBolso(Material material) {
        System.out.println("Creando un Bolso...");
        int cod_art = readInt("Código del artículo: ");
        String nombre = readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(readDouble("Precio: "));
        String marca = readString("Marca: ");
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        boolean activo = readBoolean("¿Es activo? ");
        String estilo = readString("Estilo: ");
        boolean personalizado = readBoolean("¿Es personalizado? ");
        String tipoCierre = readString("Tipo de cierre: ");
        int capacidad = readInt("Capacidad en litros: ");

        return new Bolso(cod_art, nombre, precio, marca, descripcion, imagen, activo, estilo, personalizado, tipoCierre, capacidad);
    }

    public static Camisa crearCamisa(Material material) {
        System.out.println("Creando una Camisa...");
        int cod_art = readInt("Código del artículo: ");
        String nombre = readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(readDouble("Precio: "));
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        boolean activo = readBoolean("¿Es activo? ");
        String marca = readString("Marca: ");
        String talla = readString("Talla: ");
        String color = readString("Color: ");
        String tipoCierre = readString("Tipo cierre: ");
        String tipoManga = readString("Tipo Manga:  ");
        boolean esEstampada = readBoolean("¿Tiene Estampado? ");

        return new Camisa(cod_art, nombre, precio, descripcion, imagen, activo, marca, talla, color, tipoCierre, tipoManga, esEstampada);
    }
    public static Pantalon crearPantalon(Material material) {
        System.out.println("Creando un Pantalon...");
        int cod_art = readInt("Código del artículo: ");
        String nombre = readString("Nombre: ");
        BigDecimal precio = BigDecimal.valueOf(readDouble("Precio: "));
        String descripcion = readString("Descripción: ");
        String imagen = readString("Imagen: ");
        boolean activo = readBoolean("¿Es activo? ");
        String marca = readString("Marca: ");
        String talla = readString("Talla: ");
        String color = readString("Color: ");
        String tipoCierre = readString("Tipo cierre: ");
        String tipoPantalon = readString("Tipo Pantalon:  ");
        boolean tieneBolsillos = readBoolean("¿Tiene Bolsillos? ");

        return new Pantalon(cod_art, nombre, precio, descripcion, imagen, activo, marca, talla, color, tipoCierre, tipoPantalon, tieneBolsillos);
    }
}
