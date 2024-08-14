package com.romario.superprod.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.romario.superprod.domain.Producao;
import com.romario.superprod.repository.filter.ProducaoFilter;

public interface ProducaoRepositoryQuery {
	
	public Page<Producao> filtrar(ProducaoFilter producaoFilter, Pageable pageable);
	
}
