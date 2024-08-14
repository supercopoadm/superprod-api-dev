package com.romario.superprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.Tenant;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {

	@Query(value = "select * from maquina where id= ?", nativeQuery = true)
	Maquina findByCodigo(int idmaquina);

	@Query(value = "select * from maquina where id = ?", nativeQuery = true)
	Maquina findPorId(Integer id);

	@Query(value = "select * from maquina where status=1 and tenant_id = ?", nativeQuery = true)
	List<Maquina> findAllSql(Integer idtenant);

	@Query(value = "select * from maquina where status=0", nativeQuery = true)
	List<Maquina> findAllSqlInativo();
	
	
	@Query(value= "select * from maquina where status=1 and numero = ?", nativeQuery = true)
	Maquina findBynumero(Integer numero);
	
	
	
	
	
	Maquina findByNumeroAndTenant(Integer numero, Tenant buscarOuFalhar);
	
	@Query(value= "SELECT e.* FROM maquina e, molde_maquina c  where c.molde_id = ? and e.id = c.maquina_id and e.status = 1", nativeQuery = true)
	List<Maquina> findAllPorMolde(int idmolde);
	
	@Query(value= "select * from maquina where tenant_id = ?", nativeQuery = true)
	List<Maquina> maquina(Integer tenant);

}
