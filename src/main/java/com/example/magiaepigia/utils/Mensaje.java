package com.example.magiaepigia.utils;

public enum Mensaje {
    

    ERROR_DE_NOMBRE(" Error en el nombre ingresado, revisa por favor");

    private final String texto;

    private Mensaje(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

   
}
