package com.alquilercoches.controller;

import com.alquilercoches.model.Coche;
import com.alquilercoches.servicios.CocheService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coches")
@CrossOrigin(origins = "*")
public class CocheController {

    private final CocheService cocheService;

    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @GetMapping
    public Page<Coche> getAllCoches(@RequestParam int numPagina, @RequestParam (required = false) String marca) {
        return cocheService.findAll(numPagina, marca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCocheById(@PathVariable Long id) {
        return cocheService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coche createCoche(@RequestBody Coche coche) {
        return cocheService.save(coche);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> updateCoche(@PathVariable Long id, @RequestBody Coche cocheDetails) {
        return cocheService.findById(id)
                .map(coche -> {
                    coche.setMarca(cocheDetails.getMarca());
                    coche.setModelo(cocheDetails.getModelo());
                    coche.setMatricula(cocheDetails.getMatricula());
                    coche.setDisponible(cocheDetails.isDisponible());
                    return ResponseEntity.ok(cocheService.save(coche));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoche(@PathVariable Long id) {
        cocheService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
