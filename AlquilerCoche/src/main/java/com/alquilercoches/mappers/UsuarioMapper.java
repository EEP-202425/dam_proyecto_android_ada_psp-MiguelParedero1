package com.alquilercoches.mappers;

import java.util.ArrayList;
import java.util.List;

import com.alquilercoches.dtos.LoginDto;
import com.alquilercoches.dtos.RegistroDto;
import com.alquilercoches.dtos.UsuarioDto;
import com.alquilercoches.model.Usuario;

public class UsuarioMapper {
	
	public UsuarioDto toDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setTelefono(usuario.getTelefono());
		usuarioDto.setUsuario(usuario.getUsuario());
		return usuarioDto;
		
	}
	
	public List<UsuarioDto> toDtos(List<Usuario> usuarios){
		
		List<UsuarioDto> usuarioDtos = new ArrayList<UsuarioDto>();
		for(Usuario usuario : usuarios) {
			usuarioDtos.add(toDto(usuario));
		}
		return usuarioDtos ;
		
	}
	
	public Usuario toEntity(RegistroDto registroDto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(registroDto.getEmail());
		usuario.setNombre(registroDto.getNombre());
		usuario.setPassword(registroDto.getPassword());
		usuario.setTelefono(registroDto.getTelefono());
		usuario.setUsuario(registroDto.getUsuario());
		return usuario;
		
	}
	
	public Usuario toEntity(LoginDto loginDto) {
		Usuario usuario = new Usuario();
		usuario.setPassword(loginDto.getPassword());
		usuario.setUsuario(loginDto.getUsuario());
		return usuario;
		
	}


}
