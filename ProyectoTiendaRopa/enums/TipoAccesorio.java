package com.iescamp.tienda.enums;

public enum TipoAccesorio {
    ZAPATOS("Zapatos"),
    BOLSO("Bolso");

    // es final porque descripcion no se cambiará despues
    private final String descripcion;

    TipoAccesorio(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoAccesorio desdeString(String texto){
        for (TipoAccesorio estado : TipoAccesorio.values()) { //el .values() te saca todos los elementos del enum
            if (estado.getDescripcion().equalsIgnoreCase(texto)){ //ignorecase es para que de igual que esté en mayuscula o minuscula
                return estado;
            }
        }
        return null;
    }
}
