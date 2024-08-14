package com.romario.superprod.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.romario.superprod.domain.Usuario;
import com.romario.superprod.repository.UsuarioRepository;

@Component
public class DaringSecurity {
	
	@Autowired
	private UsuarioRepository usurepo;
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public String getUsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();		
		return nome;
	}
	public Integer getIdUsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario idusuario = usurepo.buscarUsuario(nome);
		return idusuario.getId();
	}
	
	public String getEmailsuario() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario idusuario = usurepo.buscarUsuario(nome);
		return idusuario.getLogin();
	}
	
	public Usuario getUsu() {
		String nome = (String) getAuthentication().getPrincipal().toString();
		Usuario usuario = usurepo.buscarUsuario(nome);
		return usuario;
	}
	
	
}
