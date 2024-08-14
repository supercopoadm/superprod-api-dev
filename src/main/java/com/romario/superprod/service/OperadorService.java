package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.OperadorFlat;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.repository.OperadorRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.execption.ObjectNotFoundException;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class OperadorService {

	@Autowired
	private OperadorRepository repo;

	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private LogSistemaService log;

	public List<OperadorFlat> findAllSql() {
		List<Operador> operadores = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
		List<OperadorFlat> operadorFlat = new ArrayList<>();
		for (Operador obj : operadores) {
			OperadorFlat opeFlat = new OperadorFlat(obj);
			operadorFlat.add(opeFlat);
		}
		return operadorFlat;
	}

	public OperadorFlat find(Integer id) {
		Operador obj = repo.findByPorId(id);
		
		OperadorFlat op = new OperadorFlat(obj);
		return op;
	}

	public List<OperadorFlat> findAllSqlInativo() {
		List<OperadorFlat> operadorFlat = new ArrayList<OperadorFlat>();
		List<Operador> operadores = repo.findAllSqlInativo(tenantUsuario.buscarOuFalharInt());
		for (Operador ope : operadores) {
			OperadorFlat molFlat = new OperadorFlat(ope);
			operadorFlat.add(molFlat);
		}
		return operadorFlat;
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			Operador opera = new Operador();
			opera.setId(id);
			logOperador(opera, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Operador");
		}

	}

	private void logOperador(Operador obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setOperador(obj);
		repolog.save(logsistema);

	}

	public Operador insert(Operador novoobj) {
		novoobj.setId(null);
		Operador operador = new Operador();
		
		operador.setNome(novoobj.getNome());
		operador.setNumero(novoobj.getNumero());
		operador.setStatus(true);
		operador.setTenant(tenantUsuario.buscarOuFalhar());
		
		novoobj.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(novoobj);
		logOperador(novoobj, "inserir");
		
		return novoobj;
	}

	public Operador from(Operador novoobj) {
		Operador atividadeAtual = buscarOuFalhar(novoobj.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(novoobj, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logOperador(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	public Operador buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Molde não encontrada", id)));
	}
	
	@Transactional
	public void status(Boolean obj, int id) {
		Operador operador = buscarOuFalhar(id);
		operador.setStatus(obj);
		operador.setTenant(tenantUsuario.buscarOuFalhar());
		logOperador(operador, "status");

	}
	

}
