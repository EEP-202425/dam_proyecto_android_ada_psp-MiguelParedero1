package com.alquilercoches.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import com.alquilercoches.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
