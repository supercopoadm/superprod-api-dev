package com.romario.superprod.domain.dto;

import com.romario.superprod.domain.Produto;

public class MaquinaPcpDTO {

    private Integer id;
    private Integer maquina;
    private Produto produto;
    private Integer idproduto;
    private String nomeProduto;

    public MaquinaPcpDTO() {
    }

    public MaquinaPcpDTO(Integer id, Integer maquina, Produto produto, Integer idproduto, String nomeProduto) {
        super();
        this.id = id;
        this.maquina = maquina;
        this.produto = produto;
        this.idproduto = idproduto;
        this.nomeProduto = nomeProduto;
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

    public Integer getIdproduto() {
        return idproduto;
    }
    

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }   

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public MaquinaPcpDTO(MaquinaPcpDTO obj) {
        this.id = obj.getId();
        this.maquina = obj.getMaquina();

        this.produto = obj.getProduto();
        this.idproduto = obj.produto.getId();
        this.nomeProduto = obj.produto.getNome();
    }


}


