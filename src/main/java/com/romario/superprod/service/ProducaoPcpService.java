package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.ProducaoPcp;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.dto.flat.ProducaoPcpFlat;
import com.romario.superprod.domain.dto.flat.ProducaoFlat;
import com.romario.superprod.repository.ProducaoPcpRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class ProducaoPcpService {
	
	@Autowired
	private ProducaoPcpRepository repo;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	public ProducaoPcpFlat find(Integer id) {
		ProducaoPcp obj = repo.findPorId(id);
		ProducaoPcpFlat pdf = new ProducaoPcpFlat(obj);
		return pdf;
	}
	
	public List<ProducaoPcpFlat> findByMaquina(Integer maquina) {
		List<ProducaoPcpFlat> convsFlat = new ArrayList<ProducaoPcpFlat>();
		List<ProducaoPcp> convs = repo.findByMaquina(maquina, tenantUsuario.buscarOuFalharInt());
		for (ProducaoPcp maq : convs) {
			ProducaoPcpFlat convFlat = new ProducaoPcpFlat(maq);
			convsFlat.add(convFlat);
		}
		return convsFlat;
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		ProducaoPcp conv = new ProducaoPcp();
		conv.setId(id);
	}
	
	@Transactional
	public ProducaoPcpFlat insert(ProducaoPcpFlat novoObj) {
		ProducaoPcp maquina1 = new ProducaoPcp();
		maquina1.setId(null);
		maquina1.setMaquina(novoObj.getMaquina());
		maquina1.setQuantidade(novoObj.getQuantidade());
		maquina1.setOrdem(novoObj.getOrdem());
		maquina1.setStatus(novoObj.getStatus());
		maquina1.setAtributo(novoObj.getAtributo());
		maquina1.setTenant(tenantUsuario.buscarOuFalhar());
		novoObj.setIdatributo(maquina1.getAtributo().getId());
		repo.save(maquina1);
		return novoObj;
	}
	
	public ProducaoPcp from(ProducaoPcp novoObj) {
		ProducaoPcp objAtual = buscarOuFalhar(novoObj.getId());
		objAtual.setTenant(tenantUsuario.buscarOuFalhar());
		BeanUtils.copyProperties(novoObj, objAtual, "id");
		objAtual.setTenant(tenantUsuario.buscarOuFalhar());
		return repo.save(objAtual);
	}
	
	
	public ProducaoPcp buscarOuFalhar(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produção não encontrada", id)));
	}
	
	
//	@Transactional
//	public void status(Boolean obj, Integer id) {
//		Maquina1 prd = buscarOuFalhar(id);
//		prd.setStatus(obj);
//		prd.setTenant(tenantUsuario.buscarOuFalhar());
//
//	}

	public Page<ProducaoPcpFlat> mudarMaquina1ParaFlat(Page<ProducaoPcp> pacs) {
		List<ProducaoPcpFlat> cFlats = new ArrayList<ProducaoPcpFlat>();

		for (ProducaoPcp p : pacs.getContent()) {
			ProducaoPcpFlat cFlat = new ProducaoPcpFlat(p, "control");
			cFlats.add(cFlat);

		}
		Page<ProducaoPcpFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
				pacs.getTotalElements());

		return page;
	}
	
	public List<ProducaoPcpFlat> findAllProduzindo() {
		List<ProducaoPcpFlat> producaoFlat = new ArrayList<>();
		List<ProducaoPcp> producao = repo.findAllProduzindo(tenantUsuario.buscarOuFalharInt());
		for (ProducaoPcp prod : producao) {
			ProducaoPcpFlat flat = new ProducaoPcpFlat(prod);
			producaoFlat.add(flat);
		}
		return producaoFlat;
	}
}