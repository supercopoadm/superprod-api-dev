package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.Produto;
import com.romario.superprod.domain.dto.flat.MoldeFlat;
import com.romario.superprod.domain.dto.flat.ProdutoFlat;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.repository.ProdutoRepository;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.execption.ObjectNotFoundException;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	@Autowired
	private LogSistemaService log;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private Tenantuser tenantUsuario;

	public List<ProdutoFlat> findAllSQL() {

		List<Produto> produtos = repo.findAllSQl(tenantUsuario.buscarOuFalharInt());
		List<ProdutoFlat> produtoFlat = new ArrayList<>();
		for (Produto obj : produtos) {
			ProdutoFlat prodFalt = new ProdutoFlat(obj);
			produtoFlat.add(prodFalt);
		}
		return produtoFlat;
	}
	
	public Produto buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produto não encontrada", id)));
	}
	
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public List<ProdutoFlat> findAllSqlInativo() {
		List<ProdutoFlat> prodFlat = new ArrayList<ProdutoFlat>();
		List<Produto> produto = repo.findAllSqlInativo(tenantUsuario.buscarOuFalharInt());
		for (Produto prod : produto) {
			ProdutoFlat molFlat = new ProdutoFlat(prod);
			prodFlat.add(molFlat);
		}
		return prodFlat;

	}

	@Transactional
	public Produto insert(Produto obj) {
		obj.setId(null);
		obj.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(obj);
		logProduto(obj, "inserir");
		return obj;
	}
	
	private void logProduto(Produto obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setProduto(obj);
		repolog.save(logsistema);
		
	}
	
	
	public Produto from(Produto atividadeNovo) {
		Produto atividadeAtual = buscarOuFalhar(atividadeNovo.getId());
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		
		BeanUtils.copyProperties(atividadeNovo, atividadeAtual, "id");
		atividadeAtual.setTenant(tenantUsuario.buscarOuFalhar());
		logProduto(atividadeAtual, "alterar");
	
		return repo.save(atividadeAtual);
	}
	
	@Transactional
	public void status(Boolean obj, int id) {
		Produto produto = buscarOuFalhar(id);
		produto.setStatus(obj);
		produto.setTenant(tenantUsuario.buscarOuFalhar());
		logProduto(produto, "status");

	}

}
