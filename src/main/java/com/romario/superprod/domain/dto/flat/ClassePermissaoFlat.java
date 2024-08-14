package com.romario.superprod.domain.dto.flat;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.romario.superprod.domain.Classepermissao;
import com.romario.superprod.domain.Permissao;

public class ClassePermissaoFlat implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	private Boolean read =  Boolean.FALSE;
	private Boolean create=  Boolean.FALSE;
	private Boolean update=  Boolean.FALSE;
	private Boolean delete=  Boolean.FALSE;
	private Boolean status=  Boolean.FALSE;
	@OneToMany(mappedBy = "classepermissao")
	private PermissoesFlat permission;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public PermissoesFlat getPermission() {
		return permission;
	}
	public void setPermission(PermissoesFlat permission) {
		this.permission = permission;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassePermissaoFlat other = (ClassePermissaoFlat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public ClassePermissaoFlat(Integer id, String nome, PermissoesFlat permission) {
		this.id = id;
		this.nome = nome;
		this.permission = permission;
	}
	public ClassePermissaoFlat() {
	}

	public ClassePermissaoFlat(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		this.id = objPorCategoria.getId();
		this.nome = objPorCategoria.getNome();
		
		switch(objPorCategoria.getNome()) {
	         case "Molde": classePermissaoFlatMolde(objPorCategoria, permissoes); break;
	         case "Maquina": classePermissaoFlatMaquina(objPorCategoria, permissoes); break;
	         case "Operador": classePermissaoFlatOperador(objPorCategoria, permissoes); break;
	         case "Produto": classePermissaoFlatProduto(objPorCategoria, permissoes); break;
	         case "Usuario": classePermissaoFlatUsuario(objPorCategoria, permissoes); break;
	         case "Relatorio": classePermissaoFlatRelatorio(objPorCategoria, permissoes); break;
	         case "Empresa": classePermissaoFlatEmpresa(objPorCategoria, permissoes); break;
	         case "Producao": classePermissaoFlatProducao(objPorCategoria, permissoes); break;
	         
	       }
		 
	}
	private void classePermissaoFlatMolde(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_MOL": create =Boolean.TRUE ; break;
	         case "U_MOL": update =Boolean.TRUE ; break;
	         case "D_MOL": delete =Boolean.TRUE ; break;
	         case "R_MOL": read =Boolean.TRUE ; break;
	         case "S_MOL": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();	
		
	}
	private void classePermissaoFlatEmpresa(Classepermissao objPorCategoria, List<Permissao> permissoes) {
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_EMP": create =Boolean.TRUE ; break;
	         case "U_EMP": update =Boolean.TRUE ; break;
	         case "D_EMP": delete =Boolean.TRUE ; break;
	         case "R_EMP": read =Boolean.TRUE ; break;
	         case "S_EMP": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void classePermissaoFlatMaquina(Classepermissao objPorCategoria, List<Permissao> permissoes) {	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_MAQ": create =Boolean.TRUE ; break;
	         case "U_MAQ": update =Boolean.TRUE ; break;
	         case "D_MAQ": delete =Boolean.TRUE ; break;
	         case "R_MAQ": read =Boolean.TRUE ; break;
	         case "S_MAQ": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void voltarStatusAtributos() {
		create =Boolean.FALSE;
		update =Boolean.FALSE;
		delete =Boolean.FALSE;
		read =Boolean.FALSE;
		status =Boolean.FALSE;
	}
	private void classePermissaoFlatOperador(Classepermissao objPorCategoria, List<Permissao> permissoes) {	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_OPE": create =Boolean.TRUE ; break;
	         case "U_OPE": update =Boolean.TRUE ; break;
	         case "D_OPE": delete =Boolean.TRUE ; break;
	         case "R_OPE": read =Boolean.TRUE ; break;
	         case "S_OPE": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void classePermissaoFlatProduto(Classepermissao objPorCategoria, List<Permissao> permissoes) {	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_PROD": create =Boolean.TRUE ; break;
	         case "U_PROD": update =Boolean.TRUE ; break;
	         case "D_PROD": delete =Boolean.TRUE ; break;
	         case "R_PROD": read =Boolean.TRUE ; break;
	         case "S_PROD": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void classePermissaoFlatProducao(Classepermissao objPorCategoria, List<Permissao> permissoes){	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_PRODU": create =Boolean.TRUE ; break;
	         case "U_PRODU": update =Boolean.TRUE ; break;
	         case "D_PRODU": delete =Boolean.TRUE ; break;
	         case "R_PRODU": read =Boolean.TRUE ; break;
	         case "S_PRODU": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void classePermissaoFlatUsuario(Classepermissao objPorCategoria, List<Permissao> permissoes) {	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {
			 case "C_USU": create =Boolean.TRUE ; break;
	         case "U_USU": update =Boolean.TRUE ; break;
	         case "D_USU": delete =Boolean.TRUE ; break;
	         case "R_USU": read =Boolean.TRUE ; break;
	         case "S_USU": status =Boolean.TRUE ; break;	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(create, update, delete, read, status);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	private void classePermissaoFlatRelatorio(Classepermissao objPorCategoria, List<Permissao> permissoes) {	
		for (Permissao permissao : permissoes) {
			switch(permissao.getDescricao()) {

	         case "R_REL": read =Boolean.TRUE ; break;
	         
			}
		}			
			PermissoesFlat classepermissaoFlat = new PermissoesFlat(read);
			setPermission(classepermissaoFlat);
			voltarStatusAtributos();			
	      
	}
	

}
