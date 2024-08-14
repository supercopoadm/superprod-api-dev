package com.romario.superprod.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.Tenant;
import com.romario.superprod.domain.Usuario;
import com.romario.superprod.repository.TenantRepository;
import com.romario.superprod.repository.UsuarioRepository;
import com.romario.superprod.security.DaringSecurity;



@Service
public class Tenantuser {
	@Autowired
	private DaringSecurity daringSecurity;
	@Autowired
	private UsuarioRepository repoUsu;
	@Autowired
	private TenantRepository repotenant;

	public Tenant buscarOuFalhar() {
		String email = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarTenant(email);
		Tenant t = repotenant.findPorId(codigo);		
		return t;
	}
	public String buscarEmailUsuToken() {
		String email = daringSecurity.getUsuario();			
		return email;
	}
	public Integer buscarOuFalharGtenant() {
		String email = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarGTenant(email);
		
		return codigo;
	}
	public Integer buscarOuFalharGtenantID() {
		String email = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarGTenantId(email);		
		return codigo;
	}
	
	
	public Integer buscarOuFalharInt() {
		String email = daringSecurity.getUsuario();
		Integer codigo = repoUsu.buscarTenant(email);
		Tenant t = new Tenant();
		t.setId(codigo);
		return codigo;
	}
	
	public Usuario buscarUsuario() {
		String email = daringSecurity.getUsuario();
		Usuario usu = repoUsu.findPorEmail(email);	
		return usu;
	}
	
	public String tenantOuGtenant() {
		String retorno = "tenant_id";
		String email = daringSecurity.getUsuario();
		Usuario usu = repoUsu.findPorEmail(email);
		if(usu.getGtenantativo() == 0 ) {
			retorno = "tenant_id";
		}else {
			retorno = "gtenant_id";
		}
		return retorno;
	}
	public Integer buscarGtenantdoCadastrodeUsu() {
		String email = daringSecurity.getUsuario();
		Integer gtenant = repoUsu.findPorGtwenantPeloEmail(email);
		return gtenant;
	}

}
