package com.romario.superprod.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.MaquinaFlatUpdate;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaFlatInsert;
import com.romario.superprod.service.MaquinaService;
import com.romario.superprod.service.rels.RelProducao;

@RestController
@RequestMapping(value = "/maquinas")
public class MaquinaResource {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MaquinaService service;
	
	@Autowired
	private RelProducao relservice;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		MaquinaFlatInsert obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<MaquinaFlatInsert> list = service.findAllSQL();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<MaquinaFlatInsert>> findAllInativo() {
		List<MaquinaFlatInsert> list = service.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Maquina> insert(@Valid @RequestBody MaquinaFlatInsert obj) {
		Maquina novoobj = modelMapper.map(obj, Maquina.class);
		Maquina objNovo = service.insert(obj, novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody MaquinaFlatUpdate obj, @PathVariable Integer id) {
		obj.setId(id);
		service.from(obj);
		List<MaquinaFlatInsert> list = service.findAllSQL();
		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativar(@RequestBody Boolean obj, @PathVariable int id) {
		service.status(obj, id);

	}
	
	
	@RequestMapping(value = "/molde/{idmolde}", method = RequestMethod.GET)
	public ResponseEntity<List<MoldeMaquinaFlatInsert>> findAll(@PathVariable Integer idmolde) {
		List<MoldeMaquinaFlatInsert> list = service.findAllSQL(idmolde);
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/relatorios/maquina", method = RequestMethod.GET)
	public ResponseEntity<byte[]> maquina(
			@RequestParam Integer tenant) throws Exception {
		System.out.println("id " +  tenant);
		byte[] relatorio = relservice.maquina(tenant);		
				
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	

}
