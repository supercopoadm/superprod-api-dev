package com.romario.superprod.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.Chamado;
import com.romario.superprod.domain.Empresa;
import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Produto;
import com.romario.superprod.domain.Usuario;
import com.romario.superprod.security.DaringSecurity;
@Service
public class LogSistemaService {
    @Autowired
	private DaringSecurity daringSecurity;

	public LogSistema insert(Molde obj, String acao) {
        String usuarioLogado = daringSecurity.getUsuario();
        
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;		
	}
	public LogSistema insert(Maquina obj, String acao) {
        String usuarioLogado = daringSecurity.getUsuario();        
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;		
	}
	
	public LogSistema insert(Operador obj, String acao) {
        String usuarioLogado = daringSecurity.getUsuario();
        
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;		
	}
	public LogSistema insert(Produto obj, String acao) {
        String usuarioLogado = daringSecurity.getUsuario();        
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;		
	}
	
	public LogSistema insert(Producao obj, String acao) {
        String usuarioLogado = daringSecurity.getUsuario();        
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;		
	}

	public LogSistema insert(Usuario obj, String string) {
        String usuarioLogado = daringSecurity.getUsuario();
        
	    String comando = (string + "  " + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;	
	}
	public LogSistema insert(Empresa obj, String acao) {
		String usuarioLogado = daringSecurity.getUsuario();
	    String comando = (acao + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;
	}
	
	public LogSistema insert(Chamado obj, String acao) {
		String usuarioLogado = daringSecurity.getUsuario();
		String comando = (acao + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;
	}
	
	public LogSistema insert(Funcionario obj, String acao) {
		String usuarioLogado = daringSecurity.getUsuario();
		String comando = (acao + obj.toString());
		LogSistema log = new LogSistema(null, comando, OffsetDateTime.now(), usuarioLogado, obj);
		return log;
	}

}
