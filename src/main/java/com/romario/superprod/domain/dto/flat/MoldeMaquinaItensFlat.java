package com.romario.superprod.domain.dto.flat;

import com.romario.superprod.domain.MoldeMaquina;

public class MoldeMaquinaItensFlat {

	private Boolean status;
	private Integer idmolde;
	private String descricaomolde;
	private Integer idmaquina;
	private Integer numeromaquina;

	public MoldeMaquinaItensFlat() {
	}

	public MoldeMaquinaItensFlat(Boolean status, Integer idmolde, String descricaomolde, Integer idmaquina,
			Integer numeromaquina) {
		super();
		this.status = status;
		this.idmolde = idmolde;
		this.descricaomolde = descricaomolde;
		this.idmaquina = idmaquina;
		this.numeromaquina = numeromaquina;
	}

	public MoldeMaquinaItensFlat(MoldeMaquina obj) {
		this.idmolde = obj.getId().getMolde().getId();
		this.descricaomolde = obj.getId().getMolde().getNome();
		this.idmaquina = obj.getId().getMaquina().getId();
		this.numeromaquina = obj.getId().getMaquina().getNumero();
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public Integer getIdmaquina() {
		return idmaquina;
	}

	public void setIdmaquina(Integer idmaquina) {
		this.idmaquina = idmaquina;
	}

	public Integer getNumeromaquina() {
		return numeromaquina;
	}

	public void setNumeromaquina(Integer numeromaquina) {
		this.numeromaquina = numeromaquina;
	}

}
