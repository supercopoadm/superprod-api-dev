package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;
import java.util.Date;

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Produto;

public class ProducaoFlat {

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
	private String turno;
	private Operador operador;
	private Integer idoperador;
	private String nomeOperador;
	private Maquina maquina;
	private Integer idmaquina;
	private Integer nomeMaquina;
	private Produto produto;
	private Integer idprouto;
	private String nomeProduto;
	private Funcionario funcionario;
	private Integer idfuncionario;
	private String nomefuncionario;
	private Boolean status = Boolean.TRUE;

	private OffsetDateTime datagravacao;
	private String loginusuario;

	public ProducaoFlat() {
	}

	public ProducaoFlat(Integer id, String obs, Date dataprevisao, Integer quantidade, String cor,
			Integer perda, Integer tempomaquina, OffsetDateTime dataproducao, String horainicio, String horafinal,
			String turno, Operador operador, Integer idoperador, String nomeOperador, Maquina maquina,
			Integer idmaquina, Integer nomeMaquina, Produto produto, Integer idprouto, String nomeProduto,
			Boolean status, OffsetDateTime datagravacao, String loginusuario,Funcionario funcionario,
			Integer idfuncionario, String nomefuncionario) {
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
		this.turno = turno;
		this.operador = operador;
		this.idoperador = idoperador;
		this.nomeOperador = nomeOperador;
		this.maquina = maquina;
		this.idmaquina = idmaquina;
		this.nomeMaquina = nomeMaquina;
		this.produto = produto;
		this.idprouto = idprouto;
		this.nomeProduto = nomeProduto;
		this.status = status;
		this.datagravacao = datagravacao;
		this.loginusuario = loginusuario;
		this.funcionario = funcionario;
		this.idfuncionario = idfuncionario;
		this.nomefuncionario = nomefuncionario;
	}

	public ProducaoFlat(Producao obj) {
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
		this.turno = obj.getTurno();
		this.operador = obj.getOperador();
		this.nomeOperador = obj.getOperador().getNome();
		this.nomeProduto = obj.getProduto().getNome();
		this.nomeMaquina = obj.getMaquina().getNumero();
		this.nomefuncionario = obj.getFuncionario().getNome();
		this.maquina = obj.getMaquina();
		this.produto = obj.getProduto();
		this.datagravacao = obj.getLogs().getDatagravacao();
		this.loginusuario = obj.getLogs().getLoginusuario();

		this.idmaquina = obj.getMaquina().getId();
		this.idoperador = obj.getOperador().getId();
		this.idprouto = obj.getProduto().getId();
		
		this.funcionario = obj.getFuncionario();
		this.idfuncionario = obj.getFuncionario().getId();
		this.nomefuncionario = obj.getFuncionario().getNome();

	}

	public ProducaoFlat(Producao obj, String string) {
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
		this.turno = obj.getTurno();
		// this.operadorID = obj.getOperador();
		this.nomeOperador = obj.getOperador().getNome();
		this.nomeProduto = obj.getProduto().getNome();
		this.nomeMaquina = obj.getMaquina().getNumero();
		this.nomefuncionario = obj.getFuncionario().getNome();
		// this.maquinaID = obj.getMaquina();
		// this.produtoID = obj.getProduto();
		this.datagravacao = obj.getLogs().getDatagravacao();
		this.loginusuario = obj.getLogs().getLoginusuario();
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
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

	public String getNomeOperador() {
		return nomeOperador;
	}

	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}

	public Integer getNomeMaquina() {
		return nomeMaquina;
	}

	public void setNomeMaquina(Integer nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getIdoperador() {
		return idoperador;
	}

	public void setIdoperador(Integer idoperador) {
		this.idoperador = idoperador;
	}

	public Integer getIdmaquina() {
		return idmaquina;
	}

	public void setIdmaquina(Integer idmaquina) {
		this.idmaquina = idmaquina;
	}

	public Integer getIdprouto() {
		return idprouto;
	}

	public void setIdprouto(Integer idprouto) {
		this.idprouto = idprouto;
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

}
