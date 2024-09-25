package com.romario.superprod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.superprod.domain.MaquinaPcp;
import com.romario.superprod.domain.ProducaoPcp;
import com.romario.superprod.domain.dto.flat.MaquinaPcpFlat;
import com.romario.superprod.domain.dto.flat.ProducaoPcpFlat;
import com.romario.superprod.repository.MaquinaPcpRepository;
import com.romario.superprod.service.execption.EntidadeNaoEncontradaExcepition;
import com.romario.superprod.service.util.Tenantuser;

@Service
public class MaquinaPcpService {

    @Autowired
    private MaquinaPcpRepository repo;

    @Autowired
    private Tenantuser tenantUsuario;

    public MaquinaPcpFlat find(Integer id) {
        MaquinaPcp obj = repo.findPorId(id);
        MaquinaPcpFlat pdf = new MaquinaPcpFlat(obj);
        return pdf;
    }

    public MaquinaPcpFlat findByMaquina(Integer maquina) {
		MaquinaPcp convs = repo.findByMaquina(maquina, tenantUsuario.buscarOuFalharInt());
		return new MaquinaPcpFlat(convs);
	}

    public MaquinaPcp from(MaquinaPcp novoObj) {
        MaquinaPcp objAtual = buscarOuFalhar(novoObj.getId());
        objAtual.setTenant(tenantUsuario.buscarOuFalhar());
        BeanUtils.copyProperties(novoObj, objAtual, "id");
        objAtual.setTenant(tenantUsuario.buscarOuFalhar());
    
        return repo.save(objAtual);
    }

    public MaquinaPcp buscarOuFalhar(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produção não encontrada", id)));
    }

    public List<MaquinaPcpFlat> findAll() {
        List<MaquinaPcpFlat> convsFlat = new ArrayList<MaquinaPcpFlat>();
        List<MaquinaPcp> convs = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
        for (MaquinaPcp prod : convs) {
            MaquinaPcpFlat convFlat = new MaquinaPcpFlat(prod);
            convsFlat.add(convFlat);
        }
        return convsFlat;
    }

    
}
