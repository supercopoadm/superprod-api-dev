package com.romario.superprod.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.dto.OperadorDTO;
import com.romario.superprod.domain.dto.flat.OperadorFlat;
import com.romario.superprod.service.OperadorService;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorResource {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OperadorService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<OperadorFlat> list = service.findAllSql();
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		OperadorFlat obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<OperadorFlat>> findAllInativo() {
		List<OperadorFlat> list = service.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Operador> insert(@Valid @RequestBody OperadorFlat obj) {
		Operador novoobj = modelMapper.map(obj, Operador.class);
		Operador objNovo = service.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
		return ResponseEntity.created(uri).body(objNovo);
		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Operador> update(@Valid @RequestBody OperadorDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Operador novoobj = new Operador(obj);
		Operador atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	@RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
		service.status(obj,id);
	}
	

}
