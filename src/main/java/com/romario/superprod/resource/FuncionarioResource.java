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

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.dto.FuncionarioDTO;
import com.romario.superprod.domain.dto.flat.FuncionarioFlat;
import com.romario.superprod.repository.FuncioarioRepository;
import com.romario.superprod.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncioarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<FuncionarioFlat> list = funcionarioService.findAllSql();
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		FuncionarioFlat obj = funcionarioService.find(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioFlat>> findAllInativo() {
		List<FuncionarioFlat> list = funcionarioService.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Funcionario> insert(@Valid @RequestBody FuncionarioFlat obj) {
		Funcionario novoobj = modelMapper.map(obj, Funcionario.class);
		Funcionario objNovo = funcionarioService.insert(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
		return ResponseEntity.created(uri).body(objNovo);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Funcionario> update(@Valid @RequestBody FuncionarioDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Funcionario novoobj = new Funcionario(obj);
		Funcionario atividadeAtualizado = funcionarioService.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	@RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
		funcionarioService.status(obj,id);
		

	}
	
	
	
}
