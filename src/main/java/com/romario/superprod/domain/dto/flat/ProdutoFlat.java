package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;

import com.romario.superprod.domain.Produto;

public class ProdutoFlat {

	private Integer id;
	private String nome;
	private String sku;
	private Boolean status = Boolean.TRUE;
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public ProdutoFlat() {
	}

	public ProdutoFlat(Integer id, String nome, String sku, Boolean status, OffsetDateTime datagravacao,
			String loginusuario) {
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
	}

	public ProdutoFlat(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sku = obj.getSku();
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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
