package com.iescamp.tienda.enums;

public enum TipoRopa {
    CHAQUETA("Chaqueta"),
    CAMISA("Camisa"),
    PANTALON("Pantalón");

    // es final porque descripcion no se cambiará despues
    private final String descripcion;

    TipoRopa(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipoRopa desdeString(String texto){
        for (TipoRopa estado : TipoRopa.values()) { //el .values() te saca todos los elementos del enum
            if (estado.getDescripcion().equalsIgnoreCase(texto)){ //ignorecase es para que de igual que esté en mayuscula o minuscula
                return estado;
            }
        }
        return null;
    }
}
