package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	@Query(value = "select * from produto", nativeQuery = true)
	List<Produto> findAllSQl();
	
	@Query(value = "select * from produto where status=0 and tenant_id = ?", nativeQuery = true)
	List<Produto> findAllSqlInativo(int id);
	
	@Query(value = "select * from produto where status=1 and tenant_id = ? ", nativeQuery = true)
	List<Produto> findAllSqlAtivo(Integer idproduto);
	
	@Query(value= "select * from produto where tenant_id = ?", nativeQuery = true)
	List<Produto> produto(Integer tenant);

}
