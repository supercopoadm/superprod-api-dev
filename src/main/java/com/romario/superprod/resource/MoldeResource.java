package com.romario.superprod.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.dto.MoldeDTO;
import com.romario.superprod.domain.dto.flat.MoldeFlat;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.UsuarioFlat;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.repository.filter.MoldeFilter;
import com.romario.superprod.service.MoldeService;

@RestController
@RequestMapping(value = "/moldes")
public class MoldeResource {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MoldeService service;
	
	@Autowired
	private MoldeRepository repo;
//	
//	@Autowired
//	private RelAtendimento relservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MoldeFlat>> findAll() {
		List<MoldeFlat> list = service.findAllSql();
		return ResponseEntity.ok().body(list);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public Page<MoldeFlat> findAllPag(MoldeFilter moldeFilter, Pageable pageable) {
//		Page<Molde> pacs = repo.filtrar(moldeFilter, pageable);
//		Page<MoldeFlat> atedflat = service.mudarPacienteParaFlat(pacs);
//		return atedflat;
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Molde obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/molde/{idmolde}", method = RequestMethod.GET)
	public ResponseEntity<List<MoldeMaquinaFlatInsert>> findAll(@PathVariable Integer idmolde) {
		List<MoldeMaquinaFlatInsert> list = service.findAllSQL(idmolde);
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<MoldeFlat>> findAllInativo() {
		List<MoldeFlat> list = service.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/ativos", method = RequestMethod.GET)
	public ResponseEntity<List<MoldeFlat>> findAllAtivo() {
		List<MoldeFlat> list = service.findAllSqlAtivo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/maq/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Molde>> findAllConv(@PathVariable Integer id) {
	//	List<ConvenioDTO> list = service.findAll();
		List<Molde> list = service.findAllMaq(id);
		return ResponseEntity.ok().body(list);
	}
	
	
//	@RequestMapping(value = "/relatorios/molde", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> convenio(
//			@RequestParam Integer tenant) throws Exception {
//		byte[] relatorio = relservice.convenio(tenant);		
//				
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
//				.body(relatorio);
//	}
//	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Molde> insert(@Valid @RequestBody MoldeFlat obj) {
		Molde novoobj = modelMapper.map(obj, Molde.class);
		Molde objNovo = service.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
		return ResponseEntity.created(uri).body(objNovo);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Molde> update(@Valid @RequestBody MoldeDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Molde novoobj = new Molde(obj);
		Molde atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	@RequestMapping(value = "/sql", method = RequestMethod.GET)
	public ResponseEntity<List<MoldeFlat>> findAllSql() {
		List<MoldeFlat> list = service.findAllSQL();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
		service.status(obj,id);
		

	}
	
	
	
}
