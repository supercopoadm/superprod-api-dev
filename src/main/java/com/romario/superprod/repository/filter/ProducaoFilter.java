package com.romario.superprod.repository.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProducaoFilter {

	private String id;
	private String obs;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataprevisaode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataprevisaoate;
	private String motivoperda;
	private String quantidade;
	private String perda;
	private String tempomaquina;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataproducaode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataproducaoate;
	private String horainicio;
	private String horafinal;
	private String lote;
	private String status;
	private String operador;
	private String maquina;
	private String produto;
	private String nome;
	private String numero;
	private String loginusuario;
	private String atributo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPerda() {
		return perda;
	}

	public void setPerda(String perda) {
		this.perda = perda;
	}

	public String getTempomaquina() {
		return tempomaquina;
	}

	public void setTempomaquina(String tempomaquina) {
		this.tempomaquina = tempomaquina;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataprevisaode() {
		return dataprevisaode;
	}

	public void setDataprevisaode(Date dataprevisaode) {
		this.dataprevisaode = dataprevisaode;
	}

	public Date getDataprevisaoate() {
		return dataprevisaoate;
	}

	public void setDataprevisaoate(Date dataprevisaoate) {
		this.dataprevisaoate = dataprevisaoate;
	}
	
	public String getMotivoperda() {
		return motivoperda;
	}

	public void setMotivoperda(String motivoperda) {
		this.motivoperda = motivoperda;
	}

	public Date getDataproducaode() {
		return dataproducaode;
	}

	public void setDataproducaode(Date dataproducaode) {
		this.dataproducaode = dataproducaode;
	}

	public Date getDataproducaoate() {
		return dataproducaoate;
	}

	public void setDataproducaoate(Date dataproducaoate) {
		this.dataproducaoate = dataproducaoate;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}
	
	
	

}
