package com.alquilercoches.repositorio;

import com.alquilercoches.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}