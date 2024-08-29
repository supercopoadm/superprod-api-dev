package com.romario.superprod.domain;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.dto.ProducaoDTO;
import com.romario.superprod.domain.dto.ProducaoNewDTO;
import com.romario.superprod.domain.dto.flat.ProducaoFlat;

@Entity
public class Producao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String obs;
	private Date dataprevisao;
	private Integer quantidade;
	private String cor;
	private Integer perda;
	private Integer tempomaquina;
	private OffsetDateTime dataproducao;
	private String horainicio;
	private String horafinal;
	private String lote;
	private Boolean status = Boolean.TRUE;
	@ManyToOne
	private Operador operador;

	@ManyToOne
	private Tenant tenant;

	@ManyToOne
	private Maquina maquina;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Atributo atributo;

	@JsonIgnore
	@OneToMany(mappedBy = "producao")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Producao() {
	}

	public Producao(Integer id, String obs, Date dataprevisao, Integer quantidade, String cor, Integer perda,
			Integer tempomaquina, OffsetDateTime dataproducao, String horainicio, String horafinal, String lote,
			Boolean status, Operador operador, Tenant tenant, Maquina maquina, Produto produto, List<LogSistema> logs, Funcionario funcionario,
			Atributo atributo) {
		this.id = id;
		this.obs = obs;
		this.dataprevisao = dataprevisao;
		this.quantidade = quantidade;
		this.cor = cor;
		this.perda = perda;
		this.tempomaquina = tempomaquina;
		this.dataproducao = dataproducao;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.lote = lote;
		this.status = status;
		this.operador = operador;
		this.tenant = tenant;
		this.maquina = maquina;
		this.produto = produto;
		this.logs = logs;
		this.funcionario = funcionario;
		this.atributo = atributo;
	}

	public Producao(@Valid ProducaoNewDTO obj) {
		this.id = obj.getId();
		this.obs = obj.getObs();
		this.dataprevisao = obj.getDataprevicao();
		this.quantidade = obj.getQuantidade();
		this.cor = obj.getCor();
		this.perda = obj.getPerda();
		this.tempomaquina = obj.getTempomaquina();
		this.dataproducao = obj.getDataproducao();
		this.horainicio = obj.getHorainicio();
		this.horafinal = obj.getHorafinal();
		this.lote = obj.getLote();
		this.status = obj.getStatus();
	}

	public Producao(@Valid ProducaoDTO obj) {
		this.id = obj.getId();
		this.obs = obj.getObs();
		this.dataprevisao = obj.getDataprevisao();
		this.quantidade = obj.getQuantidade();
		this.cor = obj.getCor();
		this.perda = obj.getPerda();
		this.tempomaquina = obj.getTempomaquina();
		this.dataproducao = obj.getDataproducao();
		this.horainicio = obj.getHorainicio();
		this.horafinal = obj.getHorafinal();
		this.lote = obj.getLote();
		this.status = obj.getStatus();
		this.maquina = obj.getMaquina();
		this.operador = obj.getOperador();
		this.produto = obj.getProduto();
		this.funcionario = obj.getFuncionario();
		this.atributo = obj.getAtributo();
	}

	public Producao(ProducaoFlat obj) {
		this.id = obj.getId();
		this.obs = obj.getObs();
		this.dataprevisao = obj.getDataprevisao();
		this.quantidade = obj.getQuantidade();
		this.cor = obj.getCor();
		this.perda = obj.getPerda();
		this.tempomaquina = obj.getTempomaquina();
		this.dataproducao = obj.getDataproducao();
		this.horainicio = obj.getHorainicio();
		this.horafinal = obj.getHorafinal();
		this.lote = obj.getLote();
		this.status = obj.getStatus();
		this.maquina = obj.getMaquina();
		this.operador = obj.getOperador();
		this.produto = obj.getProduto();
		this.funcionario = obj.getFuncionario();
		this.atributo = obj.getAtributo();
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

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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
		Producao other = (Producao) obj;
		return Objects.equals(id, other.id);
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}
	

}
