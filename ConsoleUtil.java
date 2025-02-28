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
        boolean personalizado = readBoolean("¿Es personalizado? ");
        String tipoSuela = readString("Tipo de suela: ");
        int tallaZapato = readInt("Talla del zapato: ");

        return new Zapatos(cod_art, nombre, precio, marca, descripcion, true, imagen, color, material, estilo, personalizado, TipoAccesorio.ZAPATOS, tipoSuela, tallaZapato);
    }

}
