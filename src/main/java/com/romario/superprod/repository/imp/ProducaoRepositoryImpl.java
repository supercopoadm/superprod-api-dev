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

import com.romario.superprod.domain.Producao;
import com.romario.superprod.domain.Tenant;
import com.romario.superprod.repository.filter.ProducaoFilter;
import com.romario.superprod.repository.query.ProducaoRepositoryQuery;
import com.romario.superprod.service.util.Tenantuser;

public class ProducaoRepositoryImpl implements ProducaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Tenantuser tenantUsuario;

	@Override
	public Page<Producao> filtrar(ProducaoFilter producaoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Producao> criteria = builder.createQuery(Producao.class);
		Root<Producao> root = criteria.from(Producao.class);
		From<?, ?> logJoin = root.join("logs", JoinType.LEFT);
		From<?, ?> operadorJoin = root.join("operador", JoinType.INNER);
		From<?, ?> maquinaJoin = root.join("maquina", JoinType.INNER);
		From<?, ?> produtoJoin = root.join("produto", JoinType.INNER);
		criteria.distinct(true);
		List<Order> orderList = new ArrayList<>();
		orderList.add(builder.desc(root.get("id")));
		criteria.orderBy(orderList);

		Predicate[] predicates = criarRestricoes(producaoFilter, builder, root, logJoin, operadorJoin, maquinaJoin,produtoJoin);
		criteria.where(predicates);

		TypedQuery<Producao> query = manager.createQuery(criteria);
		List<Producao> listacarga = new ArrayList<>();
		listacarga = query.getResultList();
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, listacarga.size());

	}


		
		

	private Predicate[] criarRestricoes(ProducaoFilter producaoFilter, CriteriaBuilder builder, Root<Producao> root,
			From<?, ?> logJoin, From<?, ?> operadorJoin, From<?, ?> maquinaJoin, From<?, ?> produtoJoin) {
		List<Predicate> predicates = new ArrayList<>();
		Tenant t = tenantUsuario.buscarOuFalhar();
		predicates.add(builder.equal(builder.lower(root.get("tenant")), t));
		
		
		if (producaoFilter.getId() != null) {
			
			try {
				Integer valor = Integer.parseInt(producaoFilter.getId());
				predicates.add(builder.equal(builder.lower(root.get("id")), valor));
			} catch (Exception e) {
				predicates.add(builder.equal(builder.lower(root.get("id")), 0));
			}
			
		}
		
		
		if(producaoFilter.getNome() != null) {
			predicates.add(
					builder.like(builder.lower(operadorJoin.get("nome")), "%" + producaoFilter.getNome() + "%"));
		}
		

		
//		if (producaoFilter.getNome() != null) {
//			predicates.add(
//					builder.like(builder.lower(produtoJoin.get("nome")), "%" + producaoFilter.getNome() + "%"));
//		}

		
		if (producaoFilter.getDataprevisaode() != null) {
//			Instant instant = atendimentofilter.getDatanascde().toInstant();
//			ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
//			OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataprevisao"), producaoFilter.getDataprevisaode()));
		}
		if (producaoFilter.getDataprevisaoate() != null) {
//			Instant instant = atendimentofilter.getDatanascate().toInstant();
//			ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
//			OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
			predicates.add(builder.lessThanOrEqualTo(root.get("dataprevisao"), producaoFilter.getDataprevisaoate()));
		}
		
		if (producaoFilter.getDataproducaode() != null) {
//			Instant instant = atendimentofilter.getDatanascde().toInstant();
//			ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
//			OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataproducao"), producaoFilter.getDataproducaode()));
		}
		if (producaoFilter.getDataproducaoate() != null) {
//			Instant instant = atendimentofilter.getDatanascate().toInstant();
//			ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
//			OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
			predicates.add(builder.lessThanOrEqualTo(root.get("dataproducao"), producaoFilter.getDataproducaoate()));
		}
		
		if (producaoFilter.getLoginusuario() != null) {
			predicates.add(builder.like(builder.lower(logJoin.get("loginusuario")),
					"%" + producaoFilter.getLoginusuario() + "%"));
		}
		
		if (producaoFilter.getStatus().equals("Ativos")) {
			predicates.add(builder.equal(builder.lower(root.get("status")), false));
			System.out.println(producaoFilter.getStatus() + " " + Boolean.getBoolean(producaoFilter.getStatus()));
		} else {
			predicates.add(builder.equal(builder.lower(root.get("status")), true));
			System.out.println(producaoFilter.getStatus()  + " " + Boolean.getBoolean(producaoFilter.getStatus()));
		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}





	private void adicionarRestricoesDePaginacao(TypedQuery<Producao> query, Pageable pageable) {
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
