package com.romario.superprod.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class MoldeMaquinaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "molde_id")
	private Molde molde;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;


	public Molde getMolde() {
		return molde;
	}

	public void setMolde(Molde molde) {
		this.molde = molde;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public MoldeMaquinaPK(Molde molde, Maquina maquina) {
		super();
		this.molde = molde;
		this.maquina = maquina;
	}

	public MoldeMaquinaPK() {
		super();
	}
	
	

}
