package com.romario.superprod.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.romario.superprod.domain.MoldeMaquina;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;
import com.romario.superprod.domain.dto.flat.MoldeMaquinaItensFlat;
import com.romario.superprod.repository.MoldeMaquinaRepository;
import com.romario.superprod.service.MaquinaService;

@RestController
@RequestMapping(value = "/moldemaq")
public class MoldeMaquinaResource {

	@Autowired
	private MoldeMaquinaRepository repo;
	
	@Autowired
	private MaquinaService service;
	
	
	@RequestMapping(value = "/{idmaquina}/{idmolde}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer idmaquina, @PathVariable Integer idmolde ) {
		MoldeMaquina obj = repo.buscarMoldeMaquina(idmaquina, idmolde );
		MoldeMaquinaItensFlat obj1 = new MoldeMaquinaItensFlat(obj);
		return ResponseEntity.ok().body(obj1);
	}
	
	@RequestMapping(value = "/{idmolde}", method = RequestMethod.GET)
	public ResponseEntity<List<MaquinaFlatInsert>> find(@PathVariable int idmolde ) {
		List<MaquinaFlatInsert> obj = service.findPorMolde(idmolde);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
