package com.romario.superprod.domain.dto.rel;

import com.romario.superprod.domain.Usuario;

public class UsuRel {

	private String nome;
	private String login;
	private String status;

	public UsuRel() {
	}

	public UsuRel(String nome, String login, String status) {
		this.nome = nome;
		this.login = login;
		this.status = status;
	}

	public UsuRel(Usuario obj) {
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		Boolean status = obj.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
