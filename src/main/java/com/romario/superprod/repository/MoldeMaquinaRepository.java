package com.romario.superprod.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.MoldeMaquina;
import com.romario.superprod.domain.MoldeMaquinaPK;

@Repository
public interface MoldeMaquinaRepository extends JpaRepository<MoldeMaquina, MoldeMaquinaPK>{
	
	
	@Modifying
	@Transactional	
	@Query(value= "delete from molde_maquina where maquina_id = ?", nativeQuery = true)
	void deleteByIdMaquina(Integer id);
	
	
	@Query(value = "select * from molde_maquina where molde_id =? and maquina_id =?", nativeQuery = true)
	MoldeMaquina buscarProdOpe(Long prodId, Long operadorId);

	@Query(value= "SELECT * FROM molde_maquina where maquina_id = ? and molde_id = ?", nativeQuery = true)
	MoldeMaquina buscarMoldeMaquina(int idmaquina, int idmolde);

}
