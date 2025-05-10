package com.alquilercoches.servicios;

import com.alquilercoches.model.Coche;
import com.alquilercoches.repositorio.CocheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public List<Coche> findAll() {
        return cocheRepository.findAll();
    }

    public Optional<Coche> findById(Long id) {
        return cocheRepository.findById(id);
    }

    public Coche save(Coche coche) {
        return cocheRepository.save(coche);
    }

    public void delete(Long id) {
        cocheRepository.deleteById(id);
    }
}
