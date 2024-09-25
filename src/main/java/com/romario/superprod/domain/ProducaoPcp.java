package com.romario.superprod.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.romario.superprod.domain.dto.ProducaoPcpDTO;
import com.romario.superprod.domain.dto.ProducaoPcpNewDTO;
import com.romario.superprod.domain.dto.flat.ProducaoPcpFlat;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ProducaoPcp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer maquina;
	private Integer quantidade;
	private Integer ordem;
	private String status;
	
	@ManyToOne
	private Atributo atributo;
	
	@ManyToOne
	private Tenant tenant;
	
	public ProducaoPcp() {
	}
	
	public ProducaoPcp(Integer id, Integer maquina, Atributo atributo, Integer quantidade, Integer ordem, String status, Tenant tenant) {
		this.id = id;
		this.maquina = maquina;
		this.atributo = atributo;
		this.quantidade = quantidade;
		this.ordem = ordem;
		this.status = status;
		this.tenant = tenant;
	}
	
	public ProducaoPcp(@Valid ProducaoPcpNewDTO obj) {
		this.id = obj.getId();
		this.maquina = obj.getMaquina();
		this.quantidade = obj.getQuantidade();
		this.ordem = obj.getOrdem();
		this.status = obj.getStatus();
	}
	
	public ProducaoPcp(@Valid ProducaoPcpDTO obj) {
		this.id = obj.getId();
		this.maquina = obj.getMaquina();
		this.atributo = obj.getAtributo();
		this.quantidade = obj.getQuantidade();
		this.ordem = obj.getOrdem();
		this.status = obj.getStatus();
	}
	
	public ProducaoPcp(ProducaoPcpFlat obj) {
		this.id = obj.getId();
		this.maquina = obj.getMaquina();
		this.atributo = obj.getAtributo();
		this.quantidade = obj.getQuantidade();
		this.ordem = obj.getOrdem();
		this.status = obj.getStatus();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMaquina() {
		return maquina;
	}
	
	public void setMaquina(Integer maquina) {
		this.maquina = maquina;
	}
	
	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getOrdem() {
		return ordem;
	}
	
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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
		ProducaoPcp other = (ProducaoPcp) obj;
		return Objects.equals(id, other.id);
	}
}