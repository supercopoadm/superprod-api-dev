package com.romario.superprod.domain.dto;

import com.romario.superprod.domain.Atributo;


public class ProducaoPcpDTO {
	
	private Integer id;
	private Integer maquina;
	private Atributo atributo;
	private Integer idatributo;
	private String nomeatributo;
	private Integer quantidade;
	private Integer ordem;
	private String status;
	
	public ProducaoPcpDTO() {
	}
	
	public ProducaoPcpDTO(Integer id, Integer maquina, Atributo atributo, Integer idatributo, String nomeatributo, Integer quantidade, Integer ordem, String status) {
		super();
		this.id = id;
		this.maquina = maquina;

		this.atributo = atributo;
		this.idatributo = idatributo;
		this.nomeatributo = nomeatributo;

		this.quantidade = quantidade;
		this.ordem = ordem;
		this.status = status;
	}
	
	public ProducaoPcpDTO(ProducaoPcpDTO obj) {
		this.id = obj.getId();
		this.maquina = obj.getMaquina();

		this.atributo = obj.getAtributo();
		this.idatributo = obj.atributo.getId();
		this.nomeatributo = obj.atributo.getNome();
		
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

	public Integer getIdatributo() {
		return idatributo;
	}

	public void setIdatributo(Integer idatributo) {
		this.idatributo = idatributo;
	}

	public String getNomeatributo() {
		return nomeatributo;
	}

	public void setNomeatributo(String nomeatributo) {
		this.nomeatributo = nomeatributo;
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
}