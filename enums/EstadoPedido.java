package com.iescamp.enums;

public enum EstadoPedido {
    EN_PROCESO("En proceso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado");

    // es final porque descripcion no se cambiará despues
    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // es estática
    public static EstadoPedido desdeString(String texto){
        for (EstadoPedido estado : EstadoPedido.values()) { //el .values() te saca todos los elementos del enum
            if (estado.getDescripcion().equalsIgnoreCase(texto)){ //ignorecase es para que de igual que esté en mayuscula o minuscula
                return estado;
            }
        }
        return null;
    }
}