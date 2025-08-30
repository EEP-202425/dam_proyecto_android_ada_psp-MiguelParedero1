package com.alquilercoches.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alquilercoches.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
	@Modifying
	  @Query("delete from Pago p where p.alquiler.id = :alqId")
	  void deleteByAlquilerId(@Param("alqId") Long alquilerId);
}