package com.romario.superprod.resource;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.dto.ProducaoDTO;
import com.romario.superprod.domain.dto.flat.ProducaoFlat;
import com.romario.superprod.repository.ProducaoRepository;
import com.romario.superprod.repository.filter.ProducaoFilter;
import com.romario.superprod.service.ProducaoService;
import com.romario.superprod.service.rels.RelProducao;
import com.romario.superprod.service.util.Tenantuser;

@RestController
@RequestMapping(value = "/producoes")
public class ProducaoResource {

	@Autowired
	private ProducaoService service;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProducaoRepository repo;
	
	@Autowired
	private RelProducao relservice;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ProducaoFlat obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<ProducaoFlat>> findAll() {
//	//	List<ConvenioDTO> list = service.findAll();
//		List<ProducaoFlat> list = service.findAllSQL();
//		return ResponseEntity.ok().body(list);
//	}
	
//	@RequestMapping(value = "/conv/{id}",method = RequestMethod.GET)
//	public ResponseEntity<List<Producao>> findAllConv(@PathVariable Integer id) {
//	//	List<ConvenioDTO> list = service.findAll();
//		List<Producao> list = service.findAllProd(id);
//		return ResponseEntity.ok().body(list);
//	}
	
	@RequestMapping(value = "/inativos", method = RequestMethod.GET)
	public ResponseEntity<List<ProducaoFlat>> findAllInativo() {
		List<ProducaoFlat> list = service.findAllSqlInativo();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/ativos", method = RequestMethod.GET)
	public ResponseEntity<List<ProducaoFlat>> findAllAtivo() {
		List<ProducaoFlat> list = service.findAllSqlAtivo();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/relatorios/maquina", method = RequestMethod.GET)
	public ResponseEntity<byte[]> maquina() throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		System.out.println("passando aqui " + tenant);
		byte[] relatorio = relservice.maquina(tenant);		
				
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	@RequestMapping(value = "/relatorios/molde", method = RequestMethod.GET)
	public ResponseEntity<byte[]> molde() throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		System.out.println("passando aqui " + tenant);
		byte[] relatorio = relservice.molde(tenant);		
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	@RequestMapping(value = "/relatorios/produto", method = RequestMethod.GET)
	public ResponseEntity<byte[]> produto() throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		System.out.println("passando aqui " + tenant);
		byte[] relatorio = relservice.produto(tenant);		
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	@RequestMapping(value = "/relatorios/usuario", method = RequestMethod.GET)
	public ResponseEntity<byte[]> usuario() throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		System.out.println("passando aqui " + tenant);
		byte[] relatorio = relservice.usuario(tenant);		
				
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Producao> insert(@Valid @RequestBody ProducaoFlat obj) {
//		
//		 modelMapper.createTypeMap(ProducaoFlat.class, Producao.class)
//         .addMapping(src -> src.getOperadorID().getTenant().getId(), Producao::setTenant);
//		Producao novoobj = modelMapper.map(obj, Producao.class);
//		Producao objNovo = service.insert(obj ,novoobj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
//				path("/{id}").buildAndExpand(objNovo.getId()).toUri();
//		return ResponseEntity.created(uri).body(objNovo);
//		
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProducaoFlat> insert(@Valid @RequestBody ProducaoFlat obj) {

	    ProducaoFlat objNovo = service.insert(obj);

	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}").buildAndExpand(objNovo.getId()).toUri();

	    return ResponseEntity.created(uri).body(objNovo);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ProducaoDTO obj, @PathVariable Integer id) {
		obj.setId(id);
		Producao novoobj = new Producao(obj);
		Producao atividadeAtualizado = service.from(novoobj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(atividadeAtualizado.getId()).toUri();
		return ResponseEntity.created(uri).body(atividadeAtualizado);
		
	}
	
	
	@RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
		service.status(obj,id);
		

	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProducaoFlat> findAllPag(ProducaoFilter producaoFilter, Pageable pageable) {
		Page<Producao> pacs = repo.filtrar(producaoFilter, pageable);
		Page<ProducaoFlat> atedflat = service.mudarPacienteParaFlat(pacs);
		return atedflat;
	}

	
	@RequestMapping(value = "/relatorios/producaoFiltro", method = RequestMethod.GET)
	public ResponseEntity<byte[]> producaofiltro(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) throws Exception {
		Integer tenant = tenantUsuario.buscarOuFalharInt();
		System.out.println("passando aqui " + tenant);
		byte[] relatorio = relservice.relatorioproducao(inicio, fim, tenant);		
				
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}
	
	
}
