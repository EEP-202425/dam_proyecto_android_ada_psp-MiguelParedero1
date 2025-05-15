package com.alquilercoches.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquilercoches.dtos.LoginDto;
import com.alquilercoches.dtos.RegistroDto;
import com.alquilercoches.dtos.UsuarioDto;
import com.alquilercoches.mappers.UsuarioMapper;
import com.alquilercoches.servicios.UsuarioService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
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
	
	@PostMapping
	public ResponseEntity<Map<String,String>> crearUsuario(@RequestBody RegistroDto registroDto) {
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		 String respuesta = usuarioService.crearUsuario(usuarioMapper.toEntity(registroDto));
		 Map<String,String> body = Collections.singletonMap("mensaje", respuesta);
		 if(respuesta.equals(UsuarioService.USUARIO_CREADO)) {
			 return ResponseEntity.ok(body);
		 }
		 return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> loginUsuario(@RequestBody LoginDto loginDto) {
		UsuarioMapper usuarioMapper = new UsuarioMapper();
		 String respuesta = usuarioService.login(usuarioMapper.toEntity(loginDto));
		 Map<String,String> body = Collections.singletonMap("mensaje", respuesta);
		 if(respuesta.equals(UsuarioService.LOGIN_OK)) {
			 return ResponseEntity.ok(body);
		 }
		 return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
		
	}

	

}
