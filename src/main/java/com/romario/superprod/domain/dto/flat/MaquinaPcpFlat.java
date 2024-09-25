package com.romario.superprod.domain.dto.flat;

import com.romario.superprod.domain.MaquinaPcp;
import com.romario.superprod.domain.Produto;

public class MaquinaPcpFlat {

    private Integer id;
    private Integer maquina;
    private Produto produto;
	private Integer idproduto;
	private String nomeProduto;

    public MaquinaPcpFlat() {
    }

    public MaquinaPcpFlat(Integer id, Integer maquina, Produto produto, Integer idproduto, String nomeProduto) {
        this.id = id;
        this.maquina = maquina;
        this.produto = produto;
        this.idproduto = idproduto;
        this.nomeProduto = nomeProduto;
    }

    public MaquinaPcpFlat(MaquinaPcp obj) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();
        
        this.produto = obj.getProduto();
        this.idproduto = obj.getProduto().getId();
        this.nomeProduto = obj.getProduto().getNome();
    }

    public MaquinaPcpFlat(MaquinaPcp obj, String string) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();
        this.produto = obj.getProduto();
        this.idproduto = obj.getProduto().getId();
        this.nomeProduto = obj.getProduto().getNome();
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }   
    
    
}

