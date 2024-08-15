package com.romario.superprod.domain.dto.flat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.romario.superprod.domain.Usuario;
import com.romario.superprod.domain.dto.EmpresaUsu;

public class UsuarioFlat {

	private Integer id;
	private Boolean status = Boolean.TRUE;
	private String nome;
	private String login;
	private String email;
	private String perfil;
	private String senha;
	private LocalDateTime datagravacao;
	private String loginusario;

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public UsuarioFlat() {
		super();
	}

	

	public LocalDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(LocalDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusario() {
		return loginusario;
	}

	public void setLoginusario(String loginusario) {
		this.loginusario = loginusario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	private List<PermissaoFront> permissoes;
	private List<EmpresaUsu> empresas;

	public List<EmpresaUsu> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaUsu> empresas) {
		this.empresas = empresas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PermissaoFront> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoFront> permissoes) {
		this.permissoes = permissoes;
	}

	public UsuarioFlat(Integer id, Boolean status, String nome, String login, String email, String senha,
			LocalDateTime dataGravacao, String loginusario, List<PermissaoFront> permissoes) {
		super();
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.datagravacao = dataGravacao;
		this.loginusario = loginusario;
		this.permissoes = permissoes;
	}

	public UsuarioFlat(Usuario usu) {
		this.id = usu.getId();
		this.status = usu.getStatus();
		this.nome = usu.getNome();
		this.login = usu.getLogin();
		// this.senha = senha;
		this.datagravacao = usu.getLogs().getDatagravacao();
		this.loginusario = usu.getLogs().getLoginusuario();
		// this.permissoes = permissoes;
	}

	@Override
	public String toString() {
		return "UsuarioFlat [id=" + id + ", status=" + status + ", nome=" + nome + ", login=" + login + ", email="
				+ email + ", perfil=" + perfil + ", senha=" + senha + ", datagravacao=" + datagravacao
				+ ", loginusario=" + loginusario + ", permissoes=" + permissoes + ", empresas=" + empresas + "]";
	}


}
