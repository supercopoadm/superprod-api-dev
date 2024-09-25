package com.romario.superprod.domain.dto;

public class MaquinaPcpNewDTO {

    private Integer id;
    private Integer maquina;
    

    public MaquinaPcpNewDTO() {
    }

    public MaquinaPcpNewDTO(Integer id, Integer maquina ) {
        this.id = id;
        this.maquina = maquina;
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

}
