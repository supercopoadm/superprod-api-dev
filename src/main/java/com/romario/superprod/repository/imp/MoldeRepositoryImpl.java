package com.romario.superprod.repository.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Tenant;
import com.romario.superprod.repository.filter.MoldeFilter;
import com.romario.superprod.repository.filter.ProducaoFilter;
import com.romario.superprod.repository.query.MoldeRepositoryQuery;
import com.romario.superprod.service.util.Tenantuser;

public class MoldeRepositoryImpl implements MoldeRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Tenantuser tenantUsuario;
	
	
	@Override
	public Page<Molde> filtrar(MoldeFilter moldeFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Molde> criteria = builder.createQuery(Molde.class);
		Root<Molde> root = criteria.from(Molde.class);
		
		From<?, ?> logJoin = root.join("logs", JoinType.LEFT);
		criteria.distinct(true);
		List<Order> orderList = new ArrayList<>();
		orderList.add(builder.desc(root.get("id")));
		criteria.orderBy(orderList);
		
		Predicate[] predicates = criarRestricoes(moldeFilter, builder, root, logJoin);
		criteria.where(predicates);

		
		TypedQuery<Molde> query = manager.createQuery(criteria);
		List<Molde> listacarga = new ArrayList<>();
		listacarga = query.getResultList();
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, listacarga.size());

	}
	
	
	private Predicate[] criarRestricoes(MoldeFilter moldeFilter, CriteriaBuilder builder, Root<Molde> root,
			From<?, ?> logJoin) {
		List<Predicate> predicates = new ArrayList<>();
		Tenant t = tenantUsuario.buscarOuFalhar();
		predicates.add(builder.equal(builder.lower(root.get("tenant")), t));
		
		
		if (moldeFilter.getId() != null) {
			
			try {
				Integer valor = Integer.parseInt(moldeFilter.getId());
				predicates.add(builder.equal(builder.lower(root.get("id")), valor));
			} catch (Exception e) {
				predicates.add(builder.equal(builder.lower(root.get("id")), 0));
			}
			
		}
		
		
		if(moldeFilter.getNome() != null) {
			predicates.add(
					builder.like(builder.lower(root.get("nome")), moldeFilter.getNome() + "%"));
		}
		
		
		if (moldeFilter.getLoginusuario() != null) {
			predicates.add(builder.like(builder.lower(logJoin.get("loginusuario")),
					"%" + moldeFilter.getLoginusuario() + "%"));
		}
		
//		if (moldeFilter.getStatus().equals("Ativos")) {
//			predicates.add(builder.equal(builder.lower(root.get("status")), false));
//			System.out.println(moldeFilter.getStatus() + " " + Boolean.getBoolean(moldeFilter.getStatus()));
//		} else {
//			predicates.add(builder.equal(builder.lower(root.get("status")), true));
//			System.out.println(moldeFilter.getStatus()  + " " + Boolean.getBoolean(moldeFilter.getStatus()));
//		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Molde> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();

		int totalRegistrosPorPagina = pageable.getPageSize();

		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);

	}
	
	private Long total(ProducaoFilter producaoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Producao> root = criteria.from(Producao.class);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
