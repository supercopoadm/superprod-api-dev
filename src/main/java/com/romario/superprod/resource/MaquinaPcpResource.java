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

import com.romario.superprod.domain.MaquinaPcp;
import com.romario.superprod.domain.dto.MaquinaPcpDTO;
import com.romario.superprod.domain.dto.flat.MaquinaPcpFlat;
import com.romario.superprod.domain.dto.flat.ProducaoPcpFlat;
import com.romario.superprod.repository.MaquinaPcpRepository;
import com.romario.superprod.service.MaquinaPcpService;
import com.romario.superprod.service.util.Tenantuser;

@RestController
@RequestMapping(value = "/pcp")
public class MaquinaPcpResource {
    
    @Autowired
    private MaquinaPcpService service;

    @Autowired
    private MaquinaPcpRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Tenantuser tenantUsuario;

    @RequestMapping(value = "/produto/{maquina}", method = RequestMethod.GET)
    public ResponseEntity<MaquinaPcpFlat> find(@PathVariable Integer maquina) {
        MaquinaPcpFlat obj = service.findByMaquina(maquina);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/produto/{maquina}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@Valid @RequestBody MaquinaPcpDTO obj, @PathVariable Integer maquina) {
        MaquinaPcpFlat existingObj = service.findByMaquina(maquina);
        if (existingObj == null) {
            return ResponseEntity.notFound().build();
        }
        
        obj.setId(existingObj.getId());
        obj.setMaquina(maquina);
        MaquinaPcp objNovo = new MaquinaPcp(obj);
        MaquinaPcp atividadeAtualizado = service.from(objNovo);
        
        MaquinaPcpFlat updatedFlat = new MaquinaPcpFlat(atividadeAtualizado);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(maquina).toUri();
        return ResponseEntity.ok().location(uri).body(updatedFlat);
    }

    @RequestMapping(value = "/maquinas", method = RequestMethod.GET)
    public ResponseEntity<List<MaquinaPcpFlat>> listAllMachines() {
        List<MaquinaPcpFlat> machines = service.findAll();
        return ResponseEntity.ok().body(machines);
    }
}
