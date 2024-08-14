package com.romario.superprod.domain.dto.flat;

import com.romario.superprod.domain.MoldeMaquina;

public class MoldeMaquinaFlatInsert {

	private Integer idmolde;
	private String descricaomolde;
	

	public MoldeMaquinaFlatInsert() {
	}

	public MoldeMaquinaFlatInsert(Integer idmolde, String descricaomolde) {
		this.idmolde = idmolde;
		this.descricaomolde = descricaomolde;
	}


	public MoldeMaquinaFlatInsert(MoldeMaquina obj) {
		this.idmolde = obj.getId().getMolde().getId();
		this.descricaomolde = obj.getId().getMolde().getNome();
		
	}

	public Integer getIdmolde() {
		return idmolde;
	}

	public void setIdmolde(Integer idmolde) {
		this.idmolde = idmolde;
	}

	public String getDescricaomolde() {
		return descricaomolde;
	}

	public void setDescricaomolde(String descricaomolde) {
		this.descricaomolde = descricaomolde;
	}
	
	

}
