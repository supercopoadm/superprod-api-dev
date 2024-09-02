package com.romario.superprod.domain.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.romario.superprod.validation.molde.MoldeInsert;

@MoldeInsert
public class MoldeNewDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String sku;
	private Integer cavidades;
	private Boolean status = Boolean.TRUE;
	public MoldeNewDTO() {
	}
	public MoldeNewDTO(Integer id, String nome, String sku, Integer cavidades, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.cavidades = cavidades;
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
	public Integer getCavidades() {
		return cavidades;
	}
	public void setCavidades(Integer cavidades) {
		this.cavidades = cavidades;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	

}
