package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Producao;
import com.romario.superprod.repository.query.ProducaoRepositoryQuery;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Integer>, ProducaoRepositoryQuery{
	
	@Query(value= "select * from producao where status= 1 and tenant_id = ? ", nativeQuery = true)
	List<Producao> findAllSql(int id);
	
	
	 @Query(value= "select c.* from convenio c, exame_convenio e\r\n" + 
	    		"where c.id = e.convenio_id and e.exame_id = ?", nativeQuery = true)
	List<Producao> findAllSqlProd(int id);

	 @Query(value= "select * from producao where status = 0 and tenant_id = ?", nativeQuery = true)
	List<Producao> findAllSqlInativo(int id);

	 @Query(value= "select * from producao where  id = ?", nativeQuery = true)
	Producao findPorId(Integer id);

	
	@Query(value = "select p.id, p.dataprevisao, p.dataproducao, \r\n"
			+ "p.horainicio, p.horafinal, p.obs, p.piguimento, p.perda, p.tempomaquina, p.status,\r\n"
			+ "p.cor, p.quantidade, p.maquina_id, p.produto_id, p.operador_id, p.tenant_id, p.turno from producao p, maquina m, produto pr, operador o \r\n"
			+ "where m.id = p.maquina_id and pr.id = p.produto_id and o.id = p.operador_id and p.dataprevisao between ? and ? and p.tenant_id = ?", nativeQuery = true)
	List<Producao> porDatas(String ini, String fim, Integer tenant);

}
