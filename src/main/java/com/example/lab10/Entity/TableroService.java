package com.example.lab10.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class TableroService {

    public Tablero leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

        int filasTablero = 10;
        String[][] celdas = new String[filasTablero][filasTablero];
        Map<String, String> recursos = new HashMap<>();


        for (int i = 0; i < filasTablero; i++) {
            String linea = lineas.get(i);

            celdas[i] = linea.split("");
        }
        for (int i = filasTablero; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            if (linea.contains(":")) {
                String[] partes = linea.split(":");
                recursos.put(partes[0], partes[1].trim());
            }
        }

        return new Tablero(celdas, recursos);
    }

}
