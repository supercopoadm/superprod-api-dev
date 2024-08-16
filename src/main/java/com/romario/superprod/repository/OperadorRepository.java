package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import com.romario.superprod.domain.Operador;

@RestController
public interface OperadorRepository extends JpaRepository<Operador, Integer>{
	
	@Query(value = "select * from operador", nativeQuery = true)
	List<Operador> findAllSql();
	
	@Query(value = "select * from operador where status=0 and tenant_id = ?", nativeQuery = true)
	List<Operador> findAllSqlInativo(Integer buscarOuFalharInt);
	
	Operador findByNumero(Integer numero);
	
	
	@Query(value = "select * from operador where status = 1 and tenant_id = ?", nativeQuery = true)
	List<Operador> findAllSql(Integer idtenant);
	
	@Query(value = "select * from operador where id = ?", nativeQuery = true)
	Operador findByPorId(Integer id);

}
