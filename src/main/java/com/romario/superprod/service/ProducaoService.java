package com.romario.superprod.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Produto;
import com.romario.superprod.domain.dto.flat.ProducaoFlat;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.repository.ProducaoRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.execption.ObjectNotFoundException;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository repo;

	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaService log;
	
	@Autowired
	private LogSistemaRepository repolog;


	public ProducaoFlat find(Integer id) {
		Producao obj = repo.findPorId(id);
		ProducaoFlat pdf = new ProducaoFlat(obj);
		return pdf;
	}

	public List<ProducaoFlat> findAllSQL() {
		List<ProducaoFlat> convsFlat = new ArrayList<ProducaoFlat>();
		List<Producao> convs = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
		for (Producao prod : convs) {
			ProducaoFlat convFlat = new ProducaoFlat(prod);
			convsFlat.add(convFlat);
		}
		return convsFlat;

	}

//	public List<Producao> findAllProd(int id) {
//		return repo.findAllSqlProd(id);
//		
//	}

	public List<ProducaoFlat> findAllSqlInativo() {
		List<ProducaoFlat> prodFlat = new ArrayList<ProducaoFlat>();
		List<Producao> prods = repo.findAllSqlInativo(tenantUsuario.buscarOuFalharInt());
		for (Producao prod : prods) {
			ProducaoFlat convFlat = new ProducaoFlat(prod);
			prodFlat.add(convFlat);
		}
		return prodFlat;

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			Producao conv = new Producao();
			conv.setId(id);
			logProducao(conv, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir producao");
		}
	}

	private void logProducao(Producao obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setProducao(obj);
		repolog.save(logsistema);

	}
	
	private void logMaquina(Maquina obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setMaquina(obj);
		repolog.save(logsistema);

	}
	
	@Transactional
	public ProducaoFlat insert(ProducaoFlat novoObj) {
		Producao producao = new Producao();
		producao.setId(null);
		producao.setMaquina(novoObj.getMaquina());
		producao.setOperador(novoObj.getOperador());
		producao.setProduto(novoObj.getProduto());
		producao.setFuncionario(novoObj.getFuncionario());
		producao.setTenant(tenantUsuario.buscarOuFalhar());
		
		novoObj.setIdmaquina(producao.getMaquina().getId());
		novoObj.setIdoperador(producao.getOperador().getId());
		novoObj.setIdprouto(producao.getProduto().getId());
		novoObj.setIdfuncionario(producao.getFuncionario().getId());
		
		producao.setCor(novoObj.getCor());
		producao.setDataprevisao(novoObj.getDataprevisao());
		producao.setDataproducao(novoObj.getDataproducao());
		producao.setHorainicio(novoObj.getHorainicio());
		producao.setHorafinal(novoObj.getHorafinal());
		producao.setObs(novoObj.getObs());
		producao.setPerda(novoObj.getPerda());
		producao.setQuantidade(novoObj.getQuantidade());
		producao.setStatus(true);
		producao.setTempomaquina(novoObj.getTempomaquina());
		producao.setTurno(novoObj.getTurno());
		repo.save(producao);
		logProducao(producao, "inserir");
		return novoObj;
	}
	
	public Producao from(Producao novoObj) {
		Producao objAtual = buscarOuFalhar(novoObj.getId());
		objAtual.setTenant(tenantUsuario.buscarOuFalhar());
		BeanUtils.copyProperties(novoObj, objAtual, "id");
		objAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logProducao(objAtual, "alterar");
	
		return repo.save(objAtual);
	}
	
	
	public Producao buscarOuFalhar(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Producao não encontrada", id)));
	}
	
	
	@Transactional
	public void status(Boolean obj, Integer id) {
		Producao prd = buscarOuFalhar(id);
		prd.setStatus(obj);
		prd.setTenant(tenantUsuario.buscarOuFalhar());
		logProducao(prd, "status");

	}

	public Page<ProducaoFlat> mudarPacienteParaFlat(Page<Producao> pacs) {
		List<ProducaoFlat> cFlats = new ArrayList<ProducaoFlat>();

		for (Producao p : pacs.getContent()) {
			ProducaoFlat cFlat = new ProducaoFlat(p, "control");
			cFlats.add(cFlat);

		}
		Page<ProducaoFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
				pacs.getTotalElements());

		return page;
	}

}
