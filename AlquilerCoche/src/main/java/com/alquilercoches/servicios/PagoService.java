package com.alquilercoches.servicios;

import com.alquilercoches.model.Pago;
import com.alquilercoches.repositorio.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}
