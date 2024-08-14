package com.romario.superprod.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	@Query(value= "select * from usuario where status=1 and login = ?", nativeQuery = true)
	Usuario findPorEmail(String login);
	
	@Query(value= "select * from usuario where id = ?", nativeQuery = true)
	Usuario findPorId(int id);
	
	
	@Query(value = "select * from usuario", nativeQuery = true)
	List<Usuario> findAllSql();	
	

	@Query(value = "select * from usuario where status=0 and id !=3 and id !=1 and tenant_id = ?", nativeQuery = true)
	List<Usuario> findAllSqlInativo(int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE usuario SET senha = ? WHERE id = ?;", nativeQuery = true)
	void saveSenha(String senha, int id);
	
	@Query(value = "Select * from usuario WHERE login = ?;", nativeQuery = true)
	Usuario buscarUsuario(String login);
	
	@Query(value = "Select * from usuario WHERE id = ?;", nativeQuery = true)
	Usuario buscarUsuarioId(int id);
	
	@Query(value = "Select * from usuario WHERE id !=3 and id !=1 and tenant_id = ?", nativeQuery = true)
	List<Usuario> findAllList(Integer tenant);

	
	@Query(value= "select tenantativo from usuario where login=?", nativeQuery = true) 
	Integer buscarTenant(String login);

	@Query(value= "select gtenant_id from usuario where login=?", nativeQuery = true) 
	Integer buscarGTenant(String login);

	@Query(value= "select gtenant_id from usuario where login=?", nativeQuery = true) 
	Integer buscarGTenantId(String login);
	
	@Query(value= "select gtenant_id from usuario where login=?", nativeQuery = true) 
	Integer findPorGtwenantPeloEmail(String login);

	@Modifying
	@Transactional
	@Query(value = "UPDATE usuario SET tenantativo = ? WHERE id = ?", nativeQuery = true)
	void settenantAtivo(Integer tenanttenantativo, Integer idusuario);



	@Modifying
	@Transactional
	@Query(value = "UPDATE usuario SET gtenantativo = ? WHERE id = ?", nativeQuery = true)
	void setGtenantAtivo(Integer gtenant, Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE usuario SET tenantativo = tenant_id WHERE login = ?", nativeQuery = true)
	void voltartenant(String buscarLoginUsuToken);
	
	@Query(value= "select * from usuario where telefone=?", nativeQuery = true) 
	Usuario findPorTelefone(String telefone);

	Optional<Usuario> findByLogin(String login);


	

}
