package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.validation.funcionario.FuncionarioInsert;

@FuncionarioInsert
public class FuncionarioFlat {

	private Integer id;
	private String nome;
	private String funcao;
	private String funcionario;
	private Boolean status = Boolean.TRUE;
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public FuncionarioFlat() {
		super();
	}

	public FuncionarioFlat(Integer id, String nome, String funcao, Boolean status, OffsetDateTime datagravacao,
			String loginusuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public FuncionarioFlat(Funcionario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.funcao = obj.getFuncao();
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

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

}
