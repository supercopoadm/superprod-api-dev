package com.romario.superprod.domain.dto;

import java.time.OffsetDateTime;
import java.util.Date;

public class ProducaoNewDTO {

	private Integer id;
	private String obs;
	private Date dataprevicao;
	private Integer quantidade;
	private String cor;
	private Integer perda;
	private Integer tempomaquina;
	private OffsetDateTime dataproducao;
	private String horainicio;
	private String horafinal;
	private String lote;
	private Boolean status = Boolean.TRUE;
	private Integer operadorID;
	private Integer maquinaID;
	private Integer produtoID;
	private Integer funcionarioID;

	public ProducaoNewDTO() {
	}

	public ProducaoNewDTO(Integer id, String obs, Date dataprevicao, Integer quantidade, String cor, Integer perda,
			Integer tempomaquina, OffsetDateTime dataproducao, String horainicio, String horafinal, String lote,
			Boolean status, Integer operadorID, Integer maquinaID, Integer produtoID, Integer funfuncionarioID) {
		this.id = id;
		this.obs = obs;
		this.dataprevicao = dataprevicao;
		this.quantidade = quantidade;
		this.cor = cor;
		this.perda = perda;
		this.tempomaquina = tempomaquina;
		this.dataproducao = dataproducao;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.lote = lote;
		this.status = status;
		this.operadorID = operadorID;
		this.maquinaID = maquinaID;
		this.produtoID = produtoID;
		this.funcionarioID = funfuncionarioID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getPerda() {
		return perda;
	}

	public void setPerda(Integer perda) {
		this.perda = perda;
	}

	public Integer getTempomaquina() {
		return tempomaquina;
	}

	public void setTempomaquina(Integer tempomaquina) {
		this.tempomaquina = tempomaquina;
	}

	public OffsetDateTime getDataproducao() {
		return dataproducao;
	}

	public void setDataproducao(OffsetDateTime dataproducao) {
		this.dataproducao = dataproducao;
	}

	public String getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public String getHorafinal() {
		return horafinal;
	}

	public void setHorafinal(String horafinal) {
		this.horafinal = horafinal;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Integer getOperadorID() {
		return operadorID;
	}

	public void setOperadorID(Integer operadorID) {
		this.operadorID = operadorID;
	}

	public Integer getMaquinaID() {
		return maquinaID;
	}

	public void setMaquinaID(Integer maquinaID) {
		this.maquinaID = maquinaID;
	}

	public Integer getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDataprevicao() {
		return dataprevicao;
	}

	public void setDataprevicao(Date dataprevicao) {
		this.dataprevicao = dataprevicao;
	}

	public Integer getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(Integer funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

}
