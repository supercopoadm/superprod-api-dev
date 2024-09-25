package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.ProducaoPcp;

@Repository
public interface ProducaoPcpRepository extends JpaRepository<ProducaoPcp, Integer>{
	
	@Query(value= "select * from producao_pcp where maquina = ? and tenant_id = ?", nativeQuery = true)
	List<ProducaoPcp> findByMaquina(Integer maquina, Integer buscarOuFalharInt);
	
	@Query(value= "select * from producao_pcp where  id = ?", nativeQuery = true)
	ProducaoPcp findPorId(Integer id);
	
	@Query(value = "SELECT * FROM producao_pcp WHERE status = 'PRODUZINDO' AND tenant_id = ?", nativeQuery = true)
	List<ProducaoPcp> findAllProduzindo(Integer tenantId);
	
}