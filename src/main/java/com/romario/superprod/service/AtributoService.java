package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.Atributo;
import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.dto.flat.AtributoFlat;
import com.romario.superprod.repository.AtributoRepository;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class AtributoService {

	@Autowired
	private AtributoRepository atributoRepository; 
	
	
	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private LogSistemaService log;
	
	
	public List<AtributoFlat> findAllSql() {
		List<Atributo> atributos = atributoRepository.findAllSql();
		List<AtributoFlat> atributoFlat = new ArrayList<>();
		for (Atributo obj : atributos) {
			AtributoFlat atriFlat = new AtributoFlat(obj);
			atributoFlat.add(atriFlat);
		}
		return atributoFlat;
	}
	
	public AtributoFlat find(Integer id) {
		Atributo obj = atributoRepository.findByPorId(id);
		
		AtributoFlat atriFlat = new AtributoFlat(obj);
		return atriFlat;
	}
	
	public List<AtributoFlat> findAllSqlInativo() {
		List<AtributoFlat> atributoFlat = new ArrayList<AtributoFlat>();
		List<Atributo> atributos = atributoRepository.findAllSqlInativo(tenantUsuario.buscarOuFalharInt());
		for (Atributo atributo : atributos) {
			AtributoFlat atriFlat = new AtributoFlat(atributo);
			atributoFlat.add(atriFlat);
		}
		return atributoFlat;
	}
	
	public List<AtributoFlat> findAllSqlAtivo() {
		List<AtributoFlat> atributoFlat = new ArrayList<AtributoFlat>();
		List<Atributo> atributos = atributoRepository.findAllSqlAtivo(tenantUsuario.buscarOuFalharInt());
		for (Atributo atributo : atributos) {
			AtributoFlat atriFlat = new AtributoFlat(atributo);
			atributoFlat.add(atriFlat);
		}
		return atributoFlat;
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			atributoRepository.deleteById(id);
			Atributo atributo = new Atributo();
			atributo.setId(id);
			logAtributo(atributo, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Atributo");
		}

	}
	
	private void logAtributo(Atributo obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setAtributo(obj);
		repolog.save(logsistema);

	}
	
	public Atributo insert(Atributo novoobj) {
		novoobj.setId(null);
		Atributo atributo = new Atributo();
		
		atributo.setNome(novoobj.getNome());
		atributo.setStatus(true);
		atributo.setTenant(tenantUsuario.buscarOuFalhar());
		
		novoobj.setTenant(tenantUsuario.buscarOuFalhar());
		atributoRepository.save(novoobj);
		logAtributo(novoobj, "inserir");
		
		return novoobj;
	}
	
	public Atributo from(Atributo novoobj) {
		Atributo atividadeAtual = buscarOuFalhar(novoobj.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(novoobj, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logAtributo(atividadeAtual, "alterar");
	
		return atributoRepository.save(atividadeAtual);
	}
	
	public Atributo buscarOuFalhar(int id) {
		return atributoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Atributo não encontrada", id)));
	}
	
	@Transactional
	public void status(Boolean obj, int id) {
		Atributo atributo = buscarOuFalhar(id);
		atributo.setStatus(obj);
		atributo.setTenant(tenantUsuario.buscarOuFalhar());
		logAtributo(atributo, "status");

	}
	
}
