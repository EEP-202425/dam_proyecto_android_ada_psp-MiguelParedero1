package com.alquilercoches.controller;

import com.alquilercoches.model.Alquiler;
import com.alquilercoches.servicios.AlquilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alquileres")
@CrossOrigin
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping
    public List<Alquiler> listarAlquileres() {
        return alquilerService.getAllAlquileres();
    }

    @PostMapping
    public Alquiler crearAlquiler(@RequestBody Alquiler alquiler) {
        return alquilerService.crearAlquiler(alquiler);
    }

    @PutMapping("/{id}/devolver")
    public Alquiler devolverAlquiler(@PathVariable Long id) {
        return alquilerService.marcarComoDevuelto(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        alquilerService.eliminarAlquiler(id);
    }
}

