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
import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.MoldeMaquina;
import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Produto;
import com.romario.superprod.domain.dto.flat.MoldeFlat;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.OperadorFlat;
import com.romario.superprod.domain.dto.flat.ProducaoFlat;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.repository.MaquinaRepository;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.repository.ProdutoRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.execption.ObjectNotFoundException;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class MoldeService {

	@Autowired
	private MoldeRepository repo;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	private MaquinaRepository maquinarepo;
	
	@Autowired
	private LogSistemaService log;
	
	
	@Autowired
	private LogSistemaRepository repolog;
	
	@Autowired
	private ProdutoRepository repoPrduto;
	
	
	public Molde buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Molde não encontrada", id)));
	}
	
	
	public List<MoldeFlat> findAllSql() {
	    List<Molde> moldes = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
	    List<MoldeFlat> moldeFlat = new ArrayList<>();
	    for (Molde obj : moldes) {
	        // Verifique o valor da data antes da conversão
	        System.out.println("Data original: " + obj.getLogs().getDatagravacao());
	        
	        MoldeFlat opeFlat = new MoldeFlat(obj);
	        
	        // Verifique o valor da data após a conversão
	        System.out.println("Data convertida: " + opeFlat.getDatagravacao());
	        
	        moldeFlat.add(opeFlat);
	    }
	    return moldeFlat;
	}


	public Molde find(Integer id) {
		Optional<Molde> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Molde.class.getName()));
	}


	public List<MoldeFlat> findAllSqlInativo() {
		List<MoldeFlat> moldeFlat = new ArrayList<MoldeFlat>();
		List<Molde> moldes = repo.findAllSqlInativo(tenantUsuario.buscarOuFalharInt());
		for (Molde mol : moldes ) {
			MoldeFlat molFlat = new MoldeFlat(mol);  
			moldeFlat.add(molFlat);
		}
		return moldeFlat;

	}
	
	public List<MoldeMaquinaFlatInsert> findAllSQL(Integer idmolde) {
		List<MoldeMaquinaFlatInsert> moldesFlat = new ArrayList<MoldeMaquinaFlatInsert>();
		Maquina maquinas = maquinarepo.findByCodigo( idmolde);
		for (MoldeMaquina maq :maquinas.getMoldeMaquina()) {
			MoldeMaquinaFlatInsert maqFlat = new MoldeMaquinaFlatInsert(maq);  
			moldesFlat.add(maqFlat);
		}
		return moldesFlat;

	}
	
	public List<Molde> findAllMaq(int id) {
		return repo.findAllSqlMol(id);

	}
	
	
	public void delete(Integer id) {	
		find(id);
		try {			
			repo.deleteById(id);
			Molde conv = new Molde();
			conv.setId(id);
			logMolde(conv, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Molde");
		}
	}
	
	
	private void logMolde(Molde obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setMolde(obj);
		repolog.save(logsistema);
		
	}
	
	
	private void logProduto(Produto obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setProduto(obj);
		repolog.save(logsistema);
		
	}
	
	@Transactional
	public Molde insert(Molde novoObj) {
		novoObj.setId(null);
		Integer produto = repo.produtoMaisUm();
		Produto p = new Produto();
		p.setId(produto);
		p.setNome(novoObj.getNome());
		p.setSku(novoObj.getSku());
		p.setTenant(tenantUsuario.buscarOuFalhar());
		salvarProduto(p);
		novoObj.setProduto_id(p.getId());
		novoObj.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(novoObj);
		logMolde(novoObj, "inserir");
		logProduto(p, "inserir");
		return novoObj;
	}
	
	
	private void salvarProduto(Produto p) {		
		repoPrduto.save(p);
	}
	
	public Molde from(Molde atividadeNovo) {
		Molde atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logMolde(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	public List<MoldeFlat> findAllSQL() {
		List<MoldeFlat> moldesFlat = new ArrayList<MoldeFlat>();
		List<Molde> moldes = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
		for (Molde mol :moldes ) {
			MoldeFlat convFlat = new MoldeFlat(mol);  
			moldesFlat.add(convFlat);
		}
		return moldesFlat;
		
	}
	
	
	@Transactional
	public void status(Boolean obj, int id) {
		Molde molde = buscarOuFalhar(id);
		molde.setStatus(obj);
		molde.setTenant(tenantUsuario.buscarOuFalhar());
		logMolde(molde, "status");

	}
	
	public Page<MoldeFlat> mudarPacienteParaFlat(Page<Molde> pacs) {
		List<MoldeFlat> cFlats = new ArrayList<MoldeFlat>();

		for (Molde p : pacs.getContent()) {
			MoldeFlat cFlat = new MoldeFlat(p, "control");
			cFlats.add(cFlat);

		}
		Page<MoldeFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
				pacs.getTotalElements());

		return page;
	}

	

}
