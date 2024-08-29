package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Atributo;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Integer>{
	
	@Query(value = "select * from atributo", nativeQuery = true)
	List<Atributo> findAllSql();

	@Query(value = "select * from atributo where status = 1 and tenant_id = ? ", nativeQuery = true)
	List<Atributo> findAllSqlAtivo(Integer buscarOuFalharInt);
	
	@Query(value = "select * from atributo where id = ? ", nativeQuery = true)
	Atributo findByPorId(Integer id);

	@Query(value = "select * from atributo where status = 0 and tenant_id = ? ", nativeQuery = true)
	List<Atributo> findAllSqlInativo(Integer buscarOuFalharInt);

}
