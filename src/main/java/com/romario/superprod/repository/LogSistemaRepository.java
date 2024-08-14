package com.romario.superprod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romario.superprod.domain.LogSistema;

@Repository
public interface LogSistemaRepository extends JpaRepository<LogSistema, Integer>{

}
