package com.romario.superprod.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;

@Entity
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String peso;
	private Integer numero;
	private Boolean status = Boolean.TRUE;

	@ManyToOne
	private Tenant tenant;

	@OneToMany(mappedBy = "id.maquina")
	private Set<MoldeMaquina> moldeMaquina = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "maquina")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Maquina() {
	}

	public Maquina(Integer id, String nome, String peso, Integer numero, Boolean status, Tenant tenant,
			Set<MoldeMaquina> moldeMaquina, List<LogSistema> logs) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.numero = numero;
		this.status = status;
		this.tenant = tenant;
		this.moldeMaquina = moldeMaquina;
		this.logs = logs;
	}

	public Maquina(MaquinaFlatInsert novoFlat) {
		this.id = novoFlat.getId();
		this.nome = novoFlat.getNome();
		this.numero = novoFlat.getNumero();
		this.peso = novoFlat.getPeso();
		this.status = novoFlat.getStatus();

	}

	public void addItem(MoldeMaquina moldemaquina) {

		moldeMaquina.add(moldemaquina);
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Set<MoldeMaquina> getMoldeMaquina() {
		return moldeMaquina;
	}

	public void setMoldeMaquina(Set<MoldeMaquina> moldeMaquina) {
		this.moldeMaquina = moldeMaquina;
	}

	public void addLogs(LogSistema log) {
		logs.add(log);
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
		Maquina other = (Maquina) obj;
		return Objects.equals(id, other.id);
	}

}
