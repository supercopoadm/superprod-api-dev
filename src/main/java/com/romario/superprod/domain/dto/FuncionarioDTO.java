package com.romario.superprod.domain.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.romario.superprod.validation.funcionario.FuncionarioUpdate;

@FuncionarioUpdate
public class FuncionarioDTO {

	private Integer id;
	private String nome;
	private String funcao;
	private Boolean status = Boolean.TRUE;

	public FuncionarioDTO() {
		super();
	}

	public FuncionarioDTO(Integer id, String nome, String funcao, Boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
