package com.romario.superprod.domain.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.romario.superprod.validation.operador.OperadorInsert;

@OperadorInsert
public class OperadorNewDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer numero;
	private Boolean status = Boolean.TRUE;

	public OperadorNewDTO() {
	}

	public OperadorNewDTO(Integer id, String nome, Integer numero, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.status = status;
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

}
