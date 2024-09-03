package com.romario.superprod.domain.dto.rel;

import com.romario.superprod.domain.Produto;

public class ProdutoRel {

	private Integer id;
	private String nome;
	private String sku;
	private Float peso;
	private String status;
	
	
	public ProdutoRel() {
	}
	
	public ProdutoRel(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sku = obj.getSku();
		this.peso = obj.getPeso();
		Boolean status = obj.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}
		
	}
	public ProdutoRel(Integer id, String nome, String sku, Float peso, String status) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
