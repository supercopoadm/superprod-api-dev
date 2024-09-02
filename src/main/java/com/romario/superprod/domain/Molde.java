package com.romario.superprod.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.dto.MoldeDTO;
import com.romario.superprod.domain.dto.flat.MoldeFlat;

@Entity
public class Molde {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sku;
	private Integer cavidades;
	@ManyToOne
	private Tenant tenant;
	
	private Integer produto_id;

	private Boolean status = Boolean.TRUE;

	@JsonIgnore
	@OneToMany(mappedBy = "molde")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Molde() {
	}


	public Molde(Integer id, String nome, String sku, Integer cavidades, Tenant tenant, Integer produto_id, Boolean status,
			List<LogSistema> logs) {
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.cavidades = cavidades;
		this.tenant = tenant;
		this.produto_id = produto_id;
		this.status = status;
		this.logs = logs;
	}


	public Molde(@Valid MoldeDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sku = obj.getSku();
		this.cavidades = obj.getCavidades();
		this.status = obj.getStatus();
	}

	public Molde(@Valid MoldeFlat obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sku = obj.getSku();
		this.cavidades = obj.getCavidades();
		this.status = obj.getStatus();
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}


	public Integer getProduto_id() {
		return produto_id;
	}


	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}


	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void addLogs(LogSistema log) {
		logs.add(log);
	}
	
	

	public LogSistema getLogs() {
		Integer codigo = 0;
		Integer indice = -1;
		LogSistema ultimo = new LogSistema();
		for (int i = 0; i < logs.size(); i++) {
			if (codigo < logs.get(i).getId()) {
				codigo = logs.get(i).getId();
				indice = i;
			}
		}
		if (indice == -1) {
			return ultimo;
		} else {
			return ultimo = logs.get(indice);
		}

	}

	public void setLogs(List<LogSistema> logs) {
		this.logs = logs;
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
		Molde other = (Molde) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
