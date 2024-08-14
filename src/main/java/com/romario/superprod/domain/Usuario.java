package com.romario.superprod.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.romario.superprod.domain.dto.flat.PermissaoFront;
import com.romario.superprod.domain.dto.flat.UsuarioFlat;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	private Boolean status = Boolean.TRUE;

	private Integer tenantativo;
	private Integer gtenantativo;

	@ManyToOne
	private Tenant tenant;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private List<Permissao> permissoes = new ArrayList<Permissao>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<LogSistema> logs = new ArrayList<LogSistema>();

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String login, String senha, Boolean status, Integer tenantativo,
			Integer gtenantativo, Tenant tenant, List<Permissao> permissoes, List<LogSistema> logs) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.tenantativo = tenantativo;
		this.gtenantativo = gtenantativo;
		this.tenant = tenant;
		this.permissoes = permissoes;
		this.logs = logs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTenantativo() {
		return tenantativo;
	}

	public void setTenantativo(Integer tenantativo) {
		this.tenantativo = tenantativo;
	}

	public Integer getGtenantativo() {
		return gtenantativo;
	}

	public void setGtenantativo(Integer gtenantativo) {
		this.gtenantativo = gtenantativo;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public void addLogs(LogSistema log) {
		logs.add(log);
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", tenantativo="
				+ tenantativo + ", gtenantativo=" + gtenantativo + ", permissoes=" + permissoes + "]";
	}

	public Usuario(Usuario usuAtual, UsuarioFlat obj) {
		this.id = usuAtual.getId();
		this.status = obj.getStatus();
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.senha = usuAtual.getSenha();
		transformarPermisaoFlat(obj.getPermissoes());

	}

	public Usuario(Usuario usuAtual, UsuarioFlat obj, Tenant t) {
		this.id = usuAtual.getId();
		this.status = obj.getStatus();
		this.nome = obj.getNome();
		this.login = obj.getLogin();
		this.senha = usuAtual.getSenha();
		transformarPermisaoFlat(obj.getPermissoes());

	}

	private void transformarPermisaoFlat(List<PermissaoFront> permissoes2) {
		for (PermissaoFront pf : permissoes2) {
			switch (pf.getNome()) {
			case "Molde":
				classePermissaoFlatMolde(pf);
				break;
			case "Maquina":
				classePermissaoFlatMaquina(pf);
				break;
			case "Produto":
				classePermissaoFlatProduto(pf);
				break;
			case "Producao":
				classePermissaoFlatProducao(pf);
				break;
			case "Usuario":
				classePermissaoFlatUsuario(pf);
				break;
			case "Relatorio":
				classePermissaoFlatRelatorio(pf);
				break;
			case "Empresa":
				classePermissaoFlatEmpresa(pf);
				break;
			case "Operador":
				classePermissaoFlatOperador(pf);
				break;
			}

		}

	}

	private void classePermissaoFlatMolde(PermissaoFront pf) {
	    if (pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(1, "C_MOL");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(2, "U_MOL");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(3, "D_MOL");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(4, "R_MOL");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(5, "S_MOL");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatMaquina(PermissaoFront pf) {
	    if (pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(6, "C_MAQ");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(7, "U_MAQ");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(8, "D_MAQ");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(9, "R_MAQ");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(10, "S_MAQ");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatProduto(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(11, "C_PROD");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(12, "U_PROD");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(13, "D_PROD");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(14, "R_PROD");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(15, "S_PROD");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatProducao(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(16, "C_PRODU");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(17, "U_PRODU");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(18, "D_PRODU");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(19, "R_PRODU");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(20, "S_PRODU");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatUsuario(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(21, "C_USU");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(22, "U_USU");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(23, "D_USU");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(24, "R_USU");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(25, "S_USU");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatRelatorio(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(26, "R_REL");
	            this.permissoes.add(r);
	        }
	    }
	}

	private void classePermissaoFlatEmpresa(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(27, "C_EMP");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(28, "U_EMP");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(29, "D_EMP");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(30, "R_EMP");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(31, "S_EMP");
	            this.permissoes.add(s);
	        }
	    }
	}

	private void classePermissaoFlatOperador(PermissaoFront pf) {
	    if (pf != null && pf.getPermission() != null) {
	        if (Boolean.TRUE.equals(pf.getPermission().getCreate())) {
	            Permissao c = new Permissao(32, "C_OPE");
	            this.permissoes.add(c);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getUpdate())) {
	            Permissao u = new Permissao(33, "U_OPE");
	            this.permissoes.add(u);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getDelete())) {
	            Permissao d = new Permissao(34, "D_OPE");
	            this.permissoes.add(d);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getRead())) {
	            Permissao r = new Permissao(35, "R_OPE");
	            this.permissoes.add(r);
	        }

	        if (Boolean.TRUE.equals(pf.getPermission().getStatus())) {
	            Permissao s = new Permissao(36, "S_OPE");
	            this.permissoes.add(s);
	        }
	    }
	}

}
