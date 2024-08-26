package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.dto.flat.FuncionarioFlat;
import com.romario.superprod.repository.FuncioarioRepository;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class FuncionarioService {

	@Autowired
	private FuncioarioRepository funRepository;
	
	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private LogSistemaService log;
	
	
	public List<FuncionarioFlat> findAllSql() {
		List<Funcionario> funcionarios = funRepository.findAllSql(tenantUsuario.buscarOuFalharInt());
		List<FuncionarioFlat> funcionarioFlat = new ArrayList<>();
		for (Funcionario obj : funcionarios) {
			FuncionarioFlat funFlat = new FuncionarioFlat(obj);
			funcionarioFlat.add(funFlat);
		}
		return funcionarioFlat;
	}
	
	public FuncionarioFlat find(Integer id) {
		Funcionario obj = funRepository.findByPorId(id);
		
		FuncionarioFlat funFlat = new FuncionarioFlat(obj);
		return funFlat;
	}
	
	public List<FuncionarioFlat> findAllSqlInativo() {
		List<FuncionarioFlat> funcionarioFlat = new ArrayList<FuncionarioFlat>();
		List<Funcionario> funcionarios = funRepository.findAllSqlInativo();
		for (Funcionario fun : funcionarios) {
			FuncionarioFlat funFlat = new FuncionarioFlat(fun);
			funcionarioFlat.add(funFlat);
		}
		return funcionarioFlat;
	}
	
	public List<FuncionarioFlat> findAllSqlAtivo() {
		List<FuncionarioFlat> funcionarioFlat = new ArrayList<FuncionarioFlat>();
		List<Funcionario> funcionarios = funRepository.findAllSqlAtivo();
		for (Funcionario fun : funcionarios) {
			FuncionarioFlat funFlat = new FuncionarioFlat(fun);
			funcionarioFlat.add(funFlat);
		}
		return funcionarioFlat;
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			funRepository.deleteById(id);
			Funcionario funcionario = new Funcionario();
			funcionario.setId(id);
			logFuncionario(funcionario, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Funcionario");
		}

	}
	
	private void logFuncionario(Funcionario obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setFuncionario(obj);
		repolog.save(logsistema);

	}
	
	public Funcionario insert(Funcionario novoobj) {
		novoobj.setId(null);
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(novoobj.getNome());
		funcionario.setFuncao(novoobj.getFuncao());
		funcionario.setStatus(true);
		funcionario.setTenant(tenantUsuario.buscarOuFalhar());
		
		novoobj.setTenant(tenantUsuario.buscarOuFalhar());
		funRepository.save(novoobj);
		logFuncionario(novoobj, "inserir");
		return novoobj;
	}
	
	public Funcionario from(Funcionario novoobj) {
		Funcionario atividadeAtual = buscarOuFalhar(novoobj.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(novoobj, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logFuncionario(atividadeAtual, "alterar");
	
		return funRepository.save(atividadeAtual);
	}
	
	public Funcionario buscarOuFalhar(int id) {
		return funRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Funcionario não encontrada", id)));
	}
	
	@Transactional
	public void status(Boolean obj, int id) {
		Funcionario funcionario = buscarOuFalhar(id);
		funcionario.setStatus(obj);
		funcionario.setTenant(tenantUsuario.buscarOuFalhar());
		logFuncionario(funcionario, "status");

	}
	
	
}
