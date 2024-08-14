package com.romario.superprod.domain;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LogSistema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comando;
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss:SSS")
	@Column(columnDefinition = "datetime")
	private OffsetDateTime datagravacao;
	private String loginusuario;
	private Boolean status;
	@JsonIgnore
	@ManyToOne
	private Tenant tenant;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "molde_id")
	private Molde molde;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "operador_id")
	private Operador operador;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "producao_id")
	private Producao producao;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "chamado_id")
	private Chamado chamado;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	public LogSistema() {
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String loginusuario, Boolean status) {
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
		this.status = true;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Usuario usuario) {
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.usuario = usuario;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Empresa empresa) {
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.empresa = empresa;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Molde molde) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.molde = molde;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Produto produto) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.produto = produto;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Maquina maquina) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.maquina = maquina;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado,
			Operador operador) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.operador = operador;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado,
			Producao producao) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.producao = producao;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado, Chamado chamado) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.chamado = chamado;
	}

	public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String usuariologado,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.comando = comando;
		this.datagravacao = datagravacao;
		this.loginusuario = usuariologado;
		this.status = true;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Molde getMolde() {
		return molde;
	}

	public void setMolde(Molde molde) {
		this.molde = molde;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
