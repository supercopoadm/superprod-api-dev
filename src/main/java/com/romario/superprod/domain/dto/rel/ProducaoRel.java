package com.romario.superprod.domain.dto.rel;

import java.time.OffsetDateTime;
import java.util.Date;

import com.romario.superprod.domain.Producao;

public class ProducaoRel {

	private Integer id;
	private String obs;
	private Date dataprevisao;
	private OffsetDateTime dataproducao;
	private Integer quantidade;
	private String piguimento;
	private String cor;
	private Integer perda;
	private Integer tempomaquina;
	private String horainicio;
	private String horafinal;
	private String turno;
	private String status;
	private Integer numero;
	private String nome;
	private Integer maquina_id;
	private Integer produto_id;
	private Integer operador_id;
	private Integer tenant_id;

	public ProducaoRel() {
	}

	public ProducaoRel(Integer id, String obs, Date dataprevisao, OffsetDateTime dataproducao, Integer quantidade,
			String piguimento, String cor, Integer perda, Integer tempomaquina, String horainicio, String horafinal,
			String turno, String status, Integer numero, String nome, Integer maquina_id, Integer produto_id,
			Integer operador_id, Integer tenant_id) {
		this.id = id;
		this.obs = obs;
		this.dataprevisao = dataprevisao;
		this.dataproducao = dataproducao;
		this.quantidade = quantidade;
		this.piguimento = piguimento;
		this.cor = cor;
		this.perda = perda;
		this.tempomaquina = tempomaquina;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.turno = turno;
		this.status = status;
		this.numero = numero;
		this.nome = nome;
		this.maquina_id = maquina_id;
		this.produto_id = produto_id;
		this.operador_id = operador_id;
		this.tenant_id = tenant_id;
	}

	public ProducaoRel(Producao obj) {
		this.id = obj.getId();
		this.obs = obj.getObs();
		this.cor = obj.getCor();
		this.quantidade = obj.getQuantidade();
		this.dataprevisao = obj.getDataprevisao();
		this.dataproducao = obj.getDataproducao();
		this.perda = obj.getPerda();
		this.tempomaquina = obj.getTempomaquina();
		this.horainicio = obj.getHorainicio();
		this.horafinal = obj.getHorafinal();
		this.turno = obj.getTurno();
		this.numero = obj.getMaquina().getNumero();
		this.nome = obj.getProduto().getNome();
		this.maquina_id = obj.getMaquina().getId();
		this.produto_id = obj.getProduto().getId();
		this.operador_id = obj.getOperador().getId();
		Boolean status = obj.getStatus();
		if (status) {
			this.status = "Ativo";
		} else {
			this.status = "Inativo";
		}

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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OffsetDateTime getDataproducao() {
		return dataproducao;
	}

	public void setDataproducao(OffsetDateTime dataproducao) {
		this.dataproducao = dataproducao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPiguimento() {
		return piguimento;
	}

	public void setPiguimento(String piguimento) {
		this.piguimento = piguimento;
	}

	public Integer getMaquina_id() {
		return maquina_id;
	}

	public void setMaquina_id(Integer maquina_id) {
		this.maquina_id = maquina_id;
	}

	public Integer getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}

	public Integer getOperador_id() {
		return operador_id;
	}

	public void setOperador_id(Integer operador_id) {
		this.operador_id = operador_id;
	}

	public Integer getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id) {
		this.tenant_id = tenant_id;
	}

}
