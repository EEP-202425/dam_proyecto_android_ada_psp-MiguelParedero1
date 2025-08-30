package com.alquilercoches.controller;

import com.alquilercoches.model.Pago;
import com.alquilercoches.servicios.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.getAllPagos();
    }

    @PostMapping
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoService.crearPago(pago);
    }

    @GetMapping("/{id}")
    public Pago obtenerPago(@PathVariable Long id) {
        return pagoService.getPagoById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
    }
}
