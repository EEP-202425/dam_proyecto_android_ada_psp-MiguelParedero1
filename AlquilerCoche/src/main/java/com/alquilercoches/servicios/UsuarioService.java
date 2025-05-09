package com.alquilercoches.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alquilercoches.model.Usuario;
import com.alquilercoches.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getAllUusarios(){
		return usuarioRepository.findAll();
	}
	
	

}
