package com.romario.superprod.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.romario.superprod.domain.ProducaoPcp;
import com.romario.superprod.domain.dto.ProducaoPcpDTO;
import com.romario.superprod.domain.dto.flat.ProducaoPcpFlat;
import com.romario.superprod.repository.ProducaoPcpRepository;
import com.romario.superprod.service.ProducaoPcpService;
import com.romario.superprod.service.util.Tenantuser;

@RestController
@RequestMapping(value = "/pcp")
public class ProducaoPcpResource {
	
	@Autowired
	private ProducaoPcpService service;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ProducaoPcpRepository repo;
	
	@RequestMapping(value = "/{maquina}", method = RequestMethod.GET)
	public ResponseEntity<List<ProducaoPcpFlat>> find(@PathVariable Integer maquina) {
		List<ProducaoPcpFlat> list = service.findByMaquina(maquina);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProducaoPcpFlat> insert(@Valid @RequestBody ProducaoPcpFlat obj) {

	    ProducaoPcpFlat objNovo = service.insert(obj);

	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}").buildAndExpand(objNovo.getId()).toUri();

	    return ResponseEntity.created(uri).body(objNovo);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ProducaoPcpDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		ProducaoPcp novoobj = new ProducaoPcp(obj);
		ProducaoPcp atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	@RequestMapping(value = "/produzindo", method = RequestMethod.GET)
	public ResponseEntity<List<ProducaoPcpFlat>> findAllProduzindo() {
		List<ProducaoPcpFlat> list = service.findAllProduzindo();
		return ResponseEntity.ok().body(list);
	}
	
	
}