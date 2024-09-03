package com.romario.superprod.domain.dto;

import java.time.OffsetDateTime;
import java.util.Date;

import com.romario.superprod.domain.Atributo;
import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Produto;

public class ProducaoDTO {

	private Integer id;
	private String obs;
	private Date dataprevisao;
	private String motivoperda;
	private Integer quantidade;
	private Float perda;
	private Float tempomaquina;
	private OffsetDateTime dataproducao;
	private String horainicio;
	private String horafinal;
	private String lote;
	private Boolean status = Boolean.TRUE;
	private Operador operador;
	private Integer idoperador;
	private String nomeoperador;
	private Maquina maquina;
	private Integer idmaquina;
	private Integer nomemaquina;
	private Produto produto;
	private Integer idproduto;
	private String nomeproduto;
	private Funcionario funcionario;
	private Integer idfuncionario;
	private String nomefuncionario;
	private Atributo atributo;
	private Integer idatributo;
	private String nomeatributo;

	public ProducaoDTO() {
	}

	public ProducaoDTO(Integer id, String obs, Date dataprevisao, String motivoperda, Integer quantidade, Float perda,
			Float tempomaquina, OffsetDateTime dataproducao, String horainicio, String horafinal, String lote,
			Boolean status, Operador operador, Integer idoperador, String nomeoperador, Maquina maquina,
			Integer idmaquina, Integer nomemaquina, Produto produto, Integer idproduto, String nomeproduto,
			Funcionario funcionario, Integer idfuncionario, String nomefuncionario, Atributo atributo,
			Integer idatributo, String nomeatributo) {
		super();
		this.id = id;
		this.obs = obs;
		this.dataprevisao = dataprevisao;
		this.motivoperda = motivoperda;
		this.quantidade = quantidade;
		this.perda = perda;
		this.tempomaquina = tempomaquina;
		this.dataproducao = dataproducao;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.lote = lote;
		this.status = status;
		this.operador = operador;
		this.idoperador = idoperador;
		this.nomeoperador = nomeoperador;
		this.maquina = maquina;
		this.idmaquina = idmaquina;
		this.nomemaquina = nomemaquina;
		this.produto = produto;
		this.idproduto = idproduto;
		this.nomeproduto = nomeproduto;
		this.funcionario = funcionario;
		this.idfuncionario = idfuncionario;
		this.nomefuncionario = nomefuncionario;
		this.atributo = atributo;
		this.idatributo = idatributo;
		this.nomeatributo = nomeatributo;
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

	public Date getDataprevisao() {
		return dataprevisao;
	}

	public void setDataprevisao(Date dataprevisao) {
		this.dataprevisao = dataprevisao;
	}
	
	public String getMotivoperda() {
		return motivoperda;
	}

	public void setMotivoperda(String motivoperda) {
		this.motivoperda = motivoperda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPerda() {
		return perda;
	}

	public void setPerda(Float perda) {
		this.perda = perda;
	}

	public Float getTempomaquina() {
		return tempomaquina;
	}

	public void setTempomaquina(Float tempomaquina) {
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getIdoperador() {
		return idoperador;
	}

	public void setIdoperador(Integer idoperador) {
		this.idoperador = idoperador;
	}

	public String getNomeoperador() {
		return nomeoperador;
	}

	public void setNomeoperador(String nomeoperador) {
		this.nomeoperador = nomeoperador;
	}

	public Integer getIdmaquina() {
		return idmaquina;
	}

	public void setIdmaquina(Integer idmaquina) {
		this.idmaquina = idmaquina;
	}

	public Integer getNomemaquina() {
		return nomemaquina;
	}

	public void setNomemaquina(Integer nomemaquina) {
		this.nomemaquina = nomemaquina;
	}

	public Integer getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public ProducaoDTO(ProducaoDTO obj) {
		this.id = obj.getId();
		this.obs = obj.getObs();
		this.dataprevisao = obj.getDataprevisao();
		this.motivoperda = obj.getMotivoperda();
		this.quantidade = obj.getQuantidade();
		this.perda = obj.getPerda();
		this.tempomaquina = obj.getTempomaquina();
		this.dataproducao = obj.getDataproducao();
		this.horainicio = obj.getHorainicio();
		this.horafinal = obj.getHorafinal();
		this.lote = obj.getLote();
		this.status = obj.getStatus();
		this.maquina = obj.getMaquina();
		this.idmaquina = obj.maquina.getId();
		this.nomemaquina = obj.maquina.getNumero();
		this.operador = obj.getOperador();
		this.idoperador = obj.getOperador().getId();
		this.nomeoperador = obj.getOperador().getNome();
		this.produto = obj.getProduto();
		this.idproduto = obj.produto.getId();
		this.nomeproduto = obj.produto.getNome();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(Integer idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNomefuncionario() {
		return nomefuncionario;
	}

	public void setNomefuncionario(String nomefuncionario) {
		this.nomefuncionario = nomefuncionario;
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

}
