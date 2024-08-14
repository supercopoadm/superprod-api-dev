package com.romario.superprod.domain.dto.flat;

import java.time.OffsetDateTime;

import com.romario.superprod.domain.MoldeMaquina;

public class MaquinaFlatMolde {

	private Integer idMolde;
	private String nomeMolde;
	private OffsetDateTime datagravacao;
	private String loginusuario;

	public MaquinaFlatMolde() {
	}

	public MaquinaFlatMolde(Integer idMolde, String nomeMolde) {
		this.idMolde = idMolde;
		this.nomeMolde = nomeMolde;
		
	}

	public MaquinaFlatMolde(MoldeMaquina obj) {
		this.idMolde = obj.getId().getMolde().getId();
		this.nomeMolde = obj.getId().getMolde().getNome();

	}

	public Integer getIdMolde() {
		return idMolde;
	}

	public void setIdMolde(Integer idMolde) {
		this.idMolde = idMolde;
	}

	public String getNomeMolde() {
		return nomeMolde;
	}

	public void setNomeMolde(String nomeMolde) {
		this.nomeMolde = nomeMolde;
	}

	public OffsetDateTime getDatagravacao() {
		return datagravacao;
	}

	public void setDatagravacao(OffsetDateTime datagravacao) {
		this.datagravacao = datagravacao;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	public void setLoginusuario(String loginusuario) {
		this.loginusuario = loginusuario;
	}

}
