package com.alquilercoches.servicios;

import com.alquilercoches.model.Alquiler;
import com.alquilercoches.model.Coche;
import com.alquilercoches.repositorio.AlquilerRepository;
import com.alquilercoches.repositorio.CocheRepository;
import com.alquilercoches.repositorio.PagoRepository;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    private final CocheRepository cocheRepository;
    private final AlquilerRepository alquilerRepository;
    private final PagoRepository pagoRepository;

    public CocheService(CocheRepository cocheRepository, AlquilerRepository alquilerRepository, PagoRepository pagoRepository) {
        this.cocheRepository = cocheRepository;
		this.alquilerRepository = alquilerRepository;
		this.pagoRepository = pagoRepository;
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

    @Transactional
    public void delete(Long id) {
        // 1) eliminar todos los pagos de todos los alquileres de este coche
        List<Alquiler> alquileres = alquilerRepository.findByCocheId(id);
        for (Alquiler alq : alquileres) {
            pagoRepository.deleteByAlquilerId(alq.getId());
        }
        // 2) eliminar los propios alquileres
        alquilerRepository.deleteByCocheId(id);
        // 3) finalmente borrar el coche
        cocheRepository.deleteById(id);
    }
}

