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

import com.romario.superprod.domain.Atributo;
import com.romario.superprod.domain.dto.AtributoDTO;
import com.romario.superprod.domain.dto.flat.AtributoFlat;
import com.romario.superprod.service.AtributoService;

@RestController
@RequestMapping("/atributos")
public class AtributoResource {
	
	@Autowired
	private AtributoService atributoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<AtributoFlat> list = atributoService.findAllSql();
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AtributoFlat obj = atributoService.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<AtributoFlat>> findAllInativo() {
		List<AtributoFlat> list = atributoService.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/ativos", method = RequestMethod.GET)
	public ResponseEntity<List<AtributoFlat>> findAllSqlAtivo() {
		List<AtributoFlat> list = atributoService.findAllSqlAtivo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		atributoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Atributo> insert(@Valid @RequestBody AtributoFlat obj) {
		Atributo novoobj = modelMapper.map(obj, Atributo.class);
		Atributo objNovo = atributoService.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Atributo> update(@Valid @RequestBody AtributoDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Atributo novoobj = new Atributo(obj);
		Atributo atividadeAtualizado = atributoService.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
	}
	
	@RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
		atributoService.status(obj,id);
	}
	
}
