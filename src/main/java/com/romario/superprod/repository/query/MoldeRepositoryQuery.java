package com.romario.superprod.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.repository.filter.MoldeFilter;

public interface MoldeRepositoryQuery {

	public Page<Molde> filtrar(MoldeFilter moldeFilter, Pageable pageable);
	
}
