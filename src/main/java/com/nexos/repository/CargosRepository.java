package com.nexos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nexos.model.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Long>{

}