package com.romario.superprod.domain.dto.flat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.romario.superprod.domain.Operador;
import com.romario.superprod.validation.operador.OperadorInsert;

@OperadorInsert
public class OperadorFlat {

	private Integer id;
	private String nome;
	private Integer numero;
	private String operador;
	private Boolean status = Boolean.TRUE;
	private LocalDateTime datagravacao;
	private String loginusuario;

	public OperadorFlat() {
	}

	public OperadorFlat(Integer id, String nome, Integer numero, Boolean status, LocalDateTime datagravacao,
			String loginusuario) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public OperadorFlat(Operador obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	

	public LocalDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(LocalDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

}
