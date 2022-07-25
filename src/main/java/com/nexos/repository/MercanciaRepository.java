package com.nexos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexos.model.Mercancia;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long> {
	
}