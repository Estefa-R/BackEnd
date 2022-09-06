package com.nexos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexos.model.HistorialMercancia;

@Repository
public interface HistorialMercanciaRepository extends JpaRepository<HistorialMercancia, Long> {

}
