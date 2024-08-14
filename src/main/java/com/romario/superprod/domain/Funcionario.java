package com.romario.superprod.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.dto.FuncionarioDTO;
import com.romario.superprod.domain.dto.flat.FuncionarioFlat;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String funcao;
	private Boolean status = Boolean.TRUE;

	@ManyToOne
	private Tenant tenant;

	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String funcao, Boolean status, Tenant tenant, List<LogSistema> logs) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.status = status;
		this.tenant = tenant;
		this.logs = logs;
	}

	public Funcionario(@Valid FuncionarioFlat obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.funcao = obj.getFuncao();
		this.status = obj.getStatus();
	}

	public Funcionario(@Valid FuncionarioDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.funcao = obj.getFuncao();
		this.status = obj.getStatus();
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

	public LogSistema getLogs() {
		Integer codigo = 0;
		Integer indice = -1;
		LogSistema ultimo = new LogSistema();
		for (int i = 0; i < logs.size(); i++) {
			if (codigo < logs.get(i).getId()) {
				codigo = logs.get(i).getId();
				indice = i;
			}
		}
		if (indice == -1) {
			return ultimo;
		} else {
			return ultimo = logs.get(indice);
		}

	}

	public void setLogs(List<LogSistema> logs) {
		this.logs = logs;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

}
