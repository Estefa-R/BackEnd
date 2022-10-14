package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.AuditoriaSitioWeb;

@Repository
public interface AuditoriaSitioWebRepository extends JpaRepository<AuditoriaSitioWeb, Long> {
	
	@Query(value = "SELECT a.id, a.nombre_empleado, a.fecha_modificacion, a.operacion, a.modulo"
			+ "FROM AuditoriaSitioWeb a"
			+ "JOIN empleado e"
			+ "ON a.empleado = a.empleado ", nativeQuery=true)
	List<AuditoriaSitioWebDTO> getAllHistorialMercancia();
}