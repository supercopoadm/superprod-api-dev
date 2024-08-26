package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.LogSistema;
import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.MoldeMaquina;
import com.romario.superprod.domain.MoldeMaquinaPK;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.MaquinaFlatMolde;
import com.romario.superprod.domain.dto.flat.MaquinaFlatUpdate;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaFlatUpdate;
import com.romario.superprod.repository.LogSistemaRepository;
import com.romario.superprod.repository.MaquinaRepository;
import com.romario.superprod.repository.MoldeMaquinaRepository;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.service.execption.DataIntegrityException;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class MaquinaService {

	@Autowired
	private MaquinaRepository repo;

	@Autowired
	private LogSistemaService log;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private MoldeMaquinaRepository repoMoldeMaquina;

	@Autowired
	private MoldeRepository molderepo;

	public MaquinaFlatInsert find(Integer id) {

		Maquina obj = repo.findPorId(id);

		MaquinaFlatInsert mf = new MaquinaFlatInsert(obj);

		return mf;
	}

	public List<MaquinaFlatInsert> findAllSQL() {
		List<Maquina> exames = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
		List<MaquinaFlatInsert> examesflat = new ArrayList<>();
		for (Maquina obj : exames) {
			MaquinaFlatInsert exameflat = new MaquinaFlatInsert(obj);
			examesflat.add(exameflat);
		}
		return examesflat;

	}

	public List<MaquinaFlatInsert> findAllSqlInativo() {
		List<Maquina> exames = repo.findAllSqlInativo();
		List<MaquinaFlatInsert> examesflat = new ArrayList<>();
		for (Maquina obj : exames) {
			MaquinaFlatInsert exameflat = new MaquinaFlatInsert(obj);
			examesflat.add(exameflat);
		}
		return examesflat;
	}
	
	public List<MaquinaFlatInsert> findAllSqlAtivo() {
		List<Maquina> exames = repo.findAllSqlAtivo();
		List<MaquinaFlatInsert> examesflat = new ArrayList<>();
		for (Maquina obj : exames) {
			MaquinaFlatInsert exameflat = new MaquinaFlatInsert(obj);
			examesflat.add(exameflat);
		}
		return examesflat;
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			Maquina ex = new Maquina();
			ex.setId(id);
			logMaquina(ex, "excluir");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Exame");
		}
	}

	private void logMaquina(Maquina obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setMaquina(obj);
		repolog.save(logsistema);
	}

    @Transactional
	public Maquina insert(MaquinaFlatInsert novoFlat, Maquina obj) {
		novoFlat.setId(null);
		Maquina maquina = new Maquina(novoFlat);
		maquina.setStatus(true);
		maquina.setNome(obj.getNome());
		maquina.setPeso(obj.getPeso());
		maquina.setNumero(obj.getNumero());
		maquina.setTenant(tenantUsuario.buscarOuFalhar());
		repo.save(maquina);
		for (MoldeMaquinaFlatUpdate ipp : novoFlat.getMoldeMaquina()) {
			MoldeMaquinaPK maquinachave = new MoldeMaquinaPK();
			maquinachave.setMaquina(maquina);
			maquinachave.setMolde(molderepo.findByCodigo(ipp.getIdmolde()));
			MoldeMaquina moldemaquina = new MoldeMaquina();
			moldemaquina.setStatus(true);
			moldemaquina.setId(maquinachave);
			System.out.println("molde e  a maquina " + moldemaquina.getId().getMolde());
			repoMoldeMaquina.save(moldemaquina);
			
		}
		logMaquina(maquina, "inserir");
		return obj;
	}

	@Transactional
	public MaquinaFlatUpdate from(MaquinaFlatUpdate novoobj) {
		Maquina maquina = new Maquina();
		maquina.setId(novoobj.getId());
		maquina.setStatus(novoobj.getStatus());
		maquina.setNome(novoobj.getNome());
		maquina.setNumero(novoobj.getNumero());
		maquina.setPeso(novoobj.getPeso());
		maquina.setTenant(tenantUsuario.buscarOuFalhar());
		repoMoldeMaquina.deleteByIdMaquina(maquina.getId());
		for (MoldeMaquinaFlatUpdate ipp : novoobj.getMoldeMaquina()) {
			MoldeMaquinaPK maquinachave = new MoldeMaquinaPK();
			maquinachave.setMaquina(maquina);
			
			Molde molde = molderepo.findByCodigo(ipp.getIdmolde());
			System.out.println("Id Molde = " + molde);
			maquinachave.setMolde(molderepo.findByCodigo(ipp.getIdmolde()));
			
			
			MoldeMaquina moldemaquina = new MoldeMaquina();
			moldemaquina.setStatus(true);
			moldemaquina.setId(maquinachave);
			repoMoldeMaquina.save(moldemaquina);
			maquina.addItem(moldemaquina);
		}
		repo.save(maquina);
		logMaquina(maquina, "alterar");
		return novoobj;
	}

	@Transactional
	public void status(Boolean obj, int id) {
		Maquina maquina = buscarOuFalhar(id);
		maquina.setStatus(obj);
		logMaquina(maquina, "status");

	}

	public Maquina buscarOuFalhar(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Exame não encontrada", id)));
	}

	public List<MaquinaFlatInsert> findPorMolde(int idmolde) {
		List<Maquina> maquinas = repo.findAllPorMolde(idmolde);
		List<MaquinaFlatInsert> maquinaFlat = new ArrayList<>();
		for (Maquina obj : maquinas) {
			MaquinaFlatInsert exameflat = new MaquinaFlatInsert(obj);
			maquinaFlat.add(exameflat);
		}
		return maquinaFlat;
	}

	public List<MoldeMaquinaFlatInsert> findAllSQL(Integer idmolde) {
		List<MoldeMaquinaFlatInsert> moldesFlat = new ArrayList<MoldeMaquinaFlatInsert>();
		Maquina maquinas = repo.findByCodigo( idmolde);
		for (MoldeMaquina maq :maquinas.getMoldeMaquina()) {
			MoldeMaquinaFlatInsert maqFlat = new MoldeMaquinaFlatInsert(maq);  
			moldesFlat.add(maqFlat);
		}
		return moldesFlat;

	}


}
