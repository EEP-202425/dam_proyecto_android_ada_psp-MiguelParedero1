package com.alquilercoches.servicios;

import com.alquilercoches.model.Coche;
import com.alquilercoches.repositorio.CocheRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public Page<Coche> findAll(int numPagina, String marca) {
    	int size = 4;
    	final PageRequest pageable = PageRequest.ofSize(size);
    	final Page<Coche> pagina;
    	if(marca == null) {
    		pagina = cocheRepository.findAll(pageable.withPage(numPagina));
    	} else {
    		pagina = cocheRepository.findAllByMarca(marca, pageable.withPage(numPagina));
    	}
        return pagina;
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
