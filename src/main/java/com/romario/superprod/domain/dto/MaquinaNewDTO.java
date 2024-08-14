package com.romario.superprod.domain.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.romario.superprod.domain.MoldeMaquina;

public class MaquinaNewDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String peso;
	private Integer numero;
	private Boolean status = Boolean.TRUE;

	@OneToMany(mappedBy = "id.molde")
	private Set<MoldeMaquina> moldeMaquina = new HashSet<>();

	public MaquinaNewDTO() {
	}


	public MaquinaNewDTO(Integer id, String nome, String peso, Integer numero, Boolean status,
			Set<MoldeMaquina> moldeMaquina) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.numero = numero;
		this.status = status;
		this.moldeMaquina = moldeMaquina;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<MoldeMaquina> getMoldeMaquina() {
		return moldeMaquina;
	}

	public void setMoldeMaquina(Set<MoldeMaquina> moldeMaquina) {
		this.moldeMaquina = moldeMaquina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaquinaNewDTO other = (MaquinaNewDTO) obj;
		return Objects.equals(id, other.id);
	}

}
