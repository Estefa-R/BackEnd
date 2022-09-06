package com.nexos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.model.Mercancia;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long> {

	@Query(value = "select m from Mercancia m where m.nombre = ?1")
	Mercancia findByNombre(String nombre);

	
}