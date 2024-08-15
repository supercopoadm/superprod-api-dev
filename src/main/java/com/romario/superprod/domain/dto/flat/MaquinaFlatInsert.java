package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.MoldeMaquina;
import com.romario.superprod.validation.maquina.MaquinaInsert;

@MaquinaInsert
public class MaquinaFlatInsert {

	private Integer id;
	private String nome;
	private String peso;
	private Integer numero;
	private Boolean status;
	private Set<MoldeMaquinaFlatUpdate> moldeMaquina = new HashSet<>();
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public MaquinaFlatInsert() {
	}

	public MaquinaFlatInsert(Integer id, String nome, String peso, Integer numero, Boolean status,
			Set<MoldeMaquinaFlatUpdate> moldeMaquina, OffsetDateTime datagravacao, String loginusuario) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.numero = numero;
		this.status = status;
		this.moldeMaquina = moldeMaquina;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
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

	

	public Set<MoldeMaquinaFlatUpdate> getMoldeMaquina() {
		return moldeMaquina;
	}

	public void setMoldeMaquina(Set<MoldeMaquinaFlatUpdate> moldeMaquina) {
		this.moldeMaquina = moldeMaquina;
	}

	public OffsetDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(OffsetDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

	public MaquinaFlatInsert(Maquina obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
		this.peso = obj.getPeso();
		this.status = obj.getStatus();
		this.datagravacao = obj.getLogs().getDatagravacao();
		this.loginusuario = obj.getLogs().getLoginusuario();
		 maquinaMolde(obj);
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
		MaquinaFlatInsert other = (MaquinaFlatInsert) obj;
		return Objects.equals(id, other.id);
	}

	private void maquinaMolde(Maquina obj) {
		for (MoldeMaquina moldemaquinas : obj.getMoldeMaquina()) {
			MoldeMaquinaFlatUpdate moldemaquinaflat = new MoldeMaquinaFlatUpdate(moldemaquinas);
			moldeMaquina.add(moldemaquinaflat);
		}
	}

}
