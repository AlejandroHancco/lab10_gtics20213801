package com.example.lab10.Controller;

import com.example.lab10.Entity.Tablero;
import com.example.lab10.Entity.TableroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TableroController {

    private final TableroService tableroService;

    public TableroController(TableroService tableroService) {
        this.tableroService = tableroService;
    }

    @GetMapping("/minijuego")
    public String mostrarTablero(Model model) {
        try {

            String rutaArchivo = "src/main/resources/static/mapa_del_juego.txt";
            Tablero tablero = tableroService.leerArchivo(rutaArchivo);
            model.addAttribute("celdas", tablero.getCeldas());
            model.addAttribute("recursos", tablero.getImagen());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al leer el archivo.");
        }
        return "tablero";
    }
}
