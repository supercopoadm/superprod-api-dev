package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.Atributo;

public class AtributoFlat {

	private Integer id;
	private String nome;
	@JsonIgnore
	private String atributo;
	private Boolean status = Boolean.TRUE;
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public AtributoFlat() {
	}

	public AtributoFlat(Integer id, String nome, String atributo, Boolean status, OffsetDateTime datagravacao,
			String loginusuario) {
		this.id = id;
		this.nome = nome;
		this.atributo = atributo;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public AtributoFlat(Atributo obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.status = obj.getStatus();
		this.datagravacao = obj.getLogs().getDatagravacao();
		this.loginusuario = obj.getLogs().getLoginusuario();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public OffsetDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(OffsetDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

}
