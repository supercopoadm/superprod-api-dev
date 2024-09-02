package com.romario.superprod.repository.filter;

public class MoldeFilter {

	private String id;
	private String nome;
	private String sku;
	private Integer cavidades;
	private String status;
	private String produto_id;
	private String loginusuario;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public Integer getCavidades() {
		return cavidades;
	}

	public void setCavidades(Integer cavidades) {
		this.cavidades = cavidades;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(String produto_id) {
		this.produto_id = produto_id;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

}
