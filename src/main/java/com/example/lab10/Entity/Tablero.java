package com.example.lab10.Entity;

import java.util.Map;

public class Tablero {
    private String[][] celdas;
    private Map<String, String> imagen;

    public Tablero(String[][] celdas, Map<String, String> imagen) {
        this.celdas = celdas;
        this.imagen = imagen;
    }

    public String[][] getCeldas() {
        return celdas;
    }

    public Map<String, String> getImagen() {
        return imagen;
    }
}