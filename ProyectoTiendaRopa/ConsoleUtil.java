package com.iescamp.tienda;

import java.math.BigDecimal;

import static com.iescamp.tienda.ConsoleReader.*;

public class ConsoleUtil {
    public static Zapatos crearZapato(Material material) {
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

        return new Zapatos(cod_art, nombre, precio, marca, descripcion, true, imagen, color, material, estilo, activo, personalizado, TipoAccesorio.ZAPATOS, tipoSuela, tallaZapato);
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
        String tallaRopa = readString("Talla: ");
        String tipoCierre = readString("Tipo cierre: ");
        boolean impermeable = readBoolean("¿Es impermeable? ");

        return new Chaqueta(cod_art, nombre, precio, marca, descripcion, imagen, activo, tallaRopa, tipoCierre, impermeable);
    }

        public static Bolso crearBolso(){
        System.out.println("Creando un Bolso...");
        String estilo = readString("Estilo: ");
        String esPersonalizado = readString("¿Es personalizado? (Sí/No): ");
        String tipoCierre = readString("Tipo de cierre: ");
        int capacidad = readInt("Capacidad en litros: ");
        
        return new Bolso(estilo, esPersonalizado, tipoCierre, capacidad);



    
}
