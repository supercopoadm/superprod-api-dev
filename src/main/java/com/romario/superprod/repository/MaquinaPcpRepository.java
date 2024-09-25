package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.MaquinaPcp;


@Repository
public interface MaquinaPcpRepository extends JpaRepository<MaquinaPcp, Integer>{
	
    @Query(value= "select * from maquina_pcp where tenant_id = ?", nativeQuery = true)
	List<MaquinaPcp> findAllSql(Integer tenant_id);

    @Query(value= "select * from maquina_pcp where maquina = ? and tenant_id = ?", nativeQuery = true)
	MaquinaPcp findByMaquina(Integer maquina, Integer buscarOuFalharInt);
	
	@Query(value= "select * from maquina_pcp where  id = ?", nativeQuery = true)
	MaquinaPcp findPorId(Integer id);
}


