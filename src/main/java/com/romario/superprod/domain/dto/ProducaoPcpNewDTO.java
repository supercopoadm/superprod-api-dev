package com.romario.superprod.domain.dto;

public class ProducaoPcpNewDTO {
	
	private Integer id;
	private Integer maquina;
	private Integer quantidade;
	private Integer ordem;
	private String status;
	
	public ProducaoPcpNewDTO() {
	}
	
	public ProducaoPcpNewDTO(Integer id, Integer maquina, Integer quantidade, Integer ordem, String status) {
		this.id = id;
		this.maquina = maquina;
		this.quantidade = quantidade;
		this.ordem = ordem;
		this.status = status;
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