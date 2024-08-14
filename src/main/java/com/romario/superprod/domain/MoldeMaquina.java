package com.romario.superprod.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MoldeMaquina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	public MoldeMaquinaPK id = new MoldeMaquinaPK();
	private Boolean status = Boolean.TRUE;
	
	
	

	public MoldeMaquinaPK getId() {
		return id;
	}

	public void setId(MoldeMaquinaPK id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public MoldeMaquina(MoldeMaquinaPK id) {
		this.id = id;
	}

	public MoldeMaquina() {
		super();
	}
	
	
	


}
