package com.romario.superprod.domain.dto.rel;

import com.romario.superprod.domain.Maquina;


public class MaquinaRel {

	private Integer id;
	private String nome;
	private String peso;
	private Integer numero;
	private String status;

	public MaquinaRel() {
		super();
	}

	public MaquinaRel(Integer id, String nome, String peso, Integer numero, String status) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.numero = numero;
		this.status = status;
	}

	public MaquinaRel(Maquina obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
		Boolean status = obj.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}

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

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
