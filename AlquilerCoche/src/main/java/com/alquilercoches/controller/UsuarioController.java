package com.alquilercoches.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquilercoches.dtos.UsuarioDto;
import com.alquilercoches.mappers.UsuarioMapper;
import com.alquilercoches.model.Usuario;
import com.alquilercoches.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioDto> listarUsuarios(){
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		return usuarioMapper.toDtos(usuarioService.getAllUusarios());
	}
	
	

}
