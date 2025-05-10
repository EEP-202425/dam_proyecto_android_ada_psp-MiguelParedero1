package com.alquilercoches.repositorio;

import com.alquilercoches.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}

