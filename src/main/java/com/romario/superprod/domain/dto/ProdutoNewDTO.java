package com.romario.superprod.domain.dto;

public class ProdutoNewDTO {

	private Integer id;
	private String nome;
	private String sku;
	private Float peso;
	private Boolean status = Boolean.TRUE;

	public ProdutoNewDTO() {
	}

	public ProdutoNewDTO(Integer id, String nome, String sku, Float peso, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.peso = peso;
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
	
	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
