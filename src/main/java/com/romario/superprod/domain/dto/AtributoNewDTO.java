package com.romario.superprod.domain.dto;

public class AtributoNewDTO {

	private Integer id;
	private String nome;
	private Boolean status = Boolean.TRUE;

	public AtributoNewDTO() {
	}

	public AtributoNewDTO(Integer id, String nome, Boolean status) {
		this.id = id;
		this.nome = nome;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
