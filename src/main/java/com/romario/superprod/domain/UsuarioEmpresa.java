package com.romario.superprod.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UsuarioEmpresa {

	@EmbeddedId
	public UsuarioEmpresaPK id = new UsuarioEmpresaPK();
	public Boolean empresapadrao;
	public Integer tenantId;

	public UsuarioEmpresa() {
	}

	public UsuarioEmpresa(UsuarioEmpresaPK id) {
		this.id = id;
	}

	public UsuarioEmpresaPK getId() {
		return id;
	}

	public void setId(UsuarioEmpresaPK id) {
		this.id = id;
	}

	public Boolean getEmpresapadrao() {
		return empresapadrao;
	}

	public void setEmpresapadrao(Boolean empresapadrao) {
		this.empresapadrao = empresapadrao;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	
	

}
