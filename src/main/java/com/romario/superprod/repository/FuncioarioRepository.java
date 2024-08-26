package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Funcionario;

@Repository
public interface FuncioarioRepository extends JpaRepository<Funcionario, Integer>{
	
	@Query(value = "select * from funcionario", nativeQuery = true)
	List<Funcionario> findAllSql(Integer idtenant);
	
	
	@Query(value = "select * from funcionario where status = 1", nativeQuery = true)
	List<Funcionario> findAllSqlAtivo();


	@Query(value = "select * from funcionario where id = ?", nativeQuery = true)
	Funcionario findByPorId(Integer id);


	@Query(value = "select * from funcionario where status = 0", nativeQuery = true)
	List<Funcionario> findAllSqlInativo();


	Funcionario findByNome(String nome);
	
	
	
	
}
