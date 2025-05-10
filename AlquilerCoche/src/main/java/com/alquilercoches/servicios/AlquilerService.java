package com.alquilercoches.servicios;

import com.alquilercoches.model.Alquiler;
import com.alquilercoches.model.Coche;
import com.alquilercoches.repositorio.AlquilerRepository;
import com.alquilercoches.repositorio.CocheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService {

    private final AlquilerRepository alquilerRepository;
    private final CocheRepository cocheRepository;

    public AlquilerService(AlquilerRepository alquilerRepository, CocheRepository cocheRepository) {
        this.alquilerRepository = alquilerRepository;
        this.cocheRepository = cocheRepository;
    }

    public List<Alquiler> getAllAlquileres() {
        return alquilerRepository.findAll();
    }

    public Optional<Alquiler> getAlquilerById(Long id) {
        return alquilerRepository.findById(id);
    }

    public Alquiler crearAlquiler(Alquiler alquiler) {
        Coche coche = alquiler.getCoche();
        coche.setDisponible(false); // Marcar el coche como alquilado
        cocheRepository.save(coche);
        return alquilerRepository.save(alquiler);
    }

    public void eliminarAlquiler(Long id) {
        alquilerRepository.deleteById(id);
    }

    public Alquiler marcarComoDevuelto(Long id) {
        Alquiler alquiler = alquilerRepository.findById(id).orElseThrow();
        Coche coche = alquiler.getCoche();
        coche.setDisponible(true); // Liberar coche
        cocheRepository.save(coche);
        return alquiler;
    }
}

