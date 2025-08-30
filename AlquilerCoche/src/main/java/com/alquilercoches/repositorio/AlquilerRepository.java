package com.alquilercoches.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alquilercoches.model.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
	  @Modifying
	  @Query("delete from Alquiler a where a.coche.id = :cocheId")
	  void deleteByCocheId(@Param("cocheId") Long cocheId);
	  
	  List<Alquiler> findByCocheId(Long cocheId);

}

