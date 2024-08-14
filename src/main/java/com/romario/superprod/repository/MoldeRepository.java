package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.repository.query.MoldeRepositoryQuery;

@Repository
public interface MoldeRepository extends JpaRepository<Molde, Integer>, MoldeRepositoryQuery {

	@Query(value = "select * from molde", nativeQuery = true)
	List<Molde> findAllSql();

	@Query(value = "select * from molde where status=0 and tenant_id = ?", nativeQuery = true)
	List<Molde> findAllSqlInativo(int id);

	@Query(value = "select c.* from molde m, molde_maquina e\r\n"
			+ "where m.id = e.molde_id and e.maquina_id = ?", nativeQuery = true)
	List<Molde> findAllSqlMol(int id);

	@Query(value = "select * from molde where status=1 and tenant_id = ? ", nativeQuery = true)
	List<Molde> findAllSql(int idtenant);

	
	@Query(value= "	select max(produto_id + 1) from molde", nativeQuery = true)
	Integer produtoMaisUm();
	
	@Query(value= "select * from molde where id = ?", nativeQuery = true)
	Molde findByCodigo(Integer idMolde);
	
	
	@Query(value= "select * from molde where id= ?", nativeQuery = true)
	Molde buscarcodigo(Integer id);
	
	@Query(value= "select * from molde where tenant_id = ?", nativeQuery = true)
	List<Molde> molde(Integer tenant);
	
	Molde findByNome(String nome);

}
