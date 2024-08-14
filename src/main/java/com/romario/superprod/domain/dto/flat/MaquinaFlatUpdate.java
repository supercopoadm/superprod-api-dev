package com.romario.superprod.domain.dto.flat;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.MoldeMaquina;

public class MaquinaFlatUpdate {

	private Integer id;
	private String nome;
	private String peso;
	private Integer numero;
	private Boolean status;
	private Set<MoldeMaquinaFlatUpdate> moldeMaquina = new HashSet<>();

	public MaquinaFlatUpdate() {
	}

	public MaquinaFlatUpdate(Integer id, String nome, String peso, Integer numero, Boolean status,
			Set<MoldeMaquinaFlatUpdate> moldeMaquina) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.numero = numero;
		this.status = status;
		this.moldeMaquina = moldeMaquina;
	}

	public MaquinaFlatUpdate(Maquina obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.numero = obj.getNumero();
		this.peso = obj.getPeso();
		this.status = obj.getStatus();
		maquinaMolde(obj);
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

	@Override
	public int hashCode() {
		return Objects.hash(id, moldeMaquina, nome, numero, peso, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaquinaFlatUpdate other = (MaquinaFlatUpdate) obj;
		return Objects.equals(id, other.id) && Objects.equals(moldeMaquina, other.moldeMaquina)
				&& Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero)
				&& Objects.equals(peso, other.peso) && Objects.equals(status, other.status);
	}

	private void maquinaMolde(Maquina obj) {
		for (MoldeMaquina conveniosExames : obj.getMoldeMaquina()) {
			MoldeMaquinaFlatUpdate convenioExames = new MoldeMaquinaFlatUpdate(conveniosExames);
			moldeMaquina.add(convenioExames);
		}
	}

}
