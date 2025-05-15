package com.alquilercoches.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alquilercoches.dtos.RegistroDto;
import com.alquilercoches.model.Usuario;
import com.alquilercoches.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
	
	public static final String USUARIO_CREADO = "Usuario Creado";
	public static final String LOGIN_OK = "Log In exitoso";
	public static final String LOGIN_NO = "Log In no realizado";

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getAllUusarios(){
		return usuarioRepository.findAll();
	}

	public String crearUsuario(Usuario usuario) {
		if(usuario.getEmail()  == null || usuario.getEmail().trim().isEmpty()) {
			return "El email es obligatorio";
		} 
		if(usuario.getUsuario()  == null || usuario.getUsuario().isBlank()) {
			return "El usuario es obligatorio";
		}
		if(usuario.getPassword()  == null || usuario.getPassword().isBlank()) {
			return "La contraseña es obligatoria";
		}
		Usuario usuarioExistente = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(usuarioExistente != null) {
			return "El usuario ya existe";
		} 
		usuarioRepository.save(usuario);
		
		return USUARIO_CREADO;
	}
	
	public String login(Usuario usuario) { 
		if(usuario.getUsuario()  == null || usuario.getUsuario().isBlank()) {
			return "El usuario es obligatorio";
		}
		if(usuario.getPassword()  == null || usuario.getPassword().isBlank()) {
			return "La contraseña es obligatoria";
		}
		Usuario usuarioExistente = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(usuarioExistente == null) {
			return LOGIN_NO;
		} 
		if(usuario.getPassword().equals(usuarioExistente.getPassword())) {
			return LOGIN_OK;
		}
		return LOGIN_NO;
	}
	
	
	
	

}
