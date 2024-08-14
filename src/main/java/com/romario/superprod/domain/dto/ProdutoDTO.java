package com.romario.superprod.domain.dto;

public class ProdutoDTO {

	private Integer id;
	private String nome;
	private String sku;

	private Boolean status = Boolean.TRUE;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Integer id, String nome, String sku, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.sku = sku;
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

}
