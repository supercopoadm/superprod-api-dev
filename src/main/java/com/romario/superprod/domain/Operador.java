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
import com.romario.superprod.domain.dto.OperadorDTO;
import com.romario.superprod.domain.dto.flat.OperadorFlat;

@Entity
public class Operador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer numero;
	private Boolean status = Boolean.TRUE;
	@ManyToOne
	private Tenant tenant;

	@JsonIgnore
	@OneToMany(mappedBy = "operador")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Operador() {
	}


	public Operador(Integer id, String nome, Integer numero, Boolean status, Tenant tenant, List<LogSistema> logs) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.status = status;
		this.tenant = tenant;
		this.logs = logs;
	}


	public Operador(@Valid OperadorDTO obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
		this.status = obj.getStatus();
	}


	public Operador(@Valid OperadorFlat obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public void addLogs(LogSistema log) {
		logs.add(log);
	}
	
	

	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
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
		Operador other = (Operador) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
