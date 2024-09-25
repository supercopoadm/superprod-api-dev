package com.romario.superprod.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.romario.superprod.domain.dto.MaquinaPcpDTO;
import com.romario.superprod.domain.dto.MaquinaPcpNewDTO;
import com.romario.superprod.domain.dto.flat.MaquinaPcpFlat;

@Entity
public class MaquinaPcp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer maquina;

    @ManyToOne
    private Produto produto;
    
    @ManyToOne
	private Tenant tenant;

    public MaquinaPcp() {
    }

    public MaquinaPcp(Integer id, Integer maquina, Produto produto, Tenant tenant) {
        this.id = id;
        this.maquina = maquina;
        this.produto = produto;
        this.tenant = tenant;
    }

    public MaquinaPcp(MaquinaPcpDTO obj) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();
        this.produto = obj.getProduto();
    }

    public MaquinaPcp(MaquinaPcpNewDTO obj) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();
    }

    public MaquinaPcp(MaquinaPcpFlat obj) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();
        this.produto = obj.getProduto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   

    public Integer getMaquina() {
        return maquina;
    }

    public void setMaquina(Integer maquina) {
        this.maquina = maquina;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

   
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaquinaPcp other = (MaquinaPcp) obj;
		return Objects.equals(id, other.id);
	}

}
