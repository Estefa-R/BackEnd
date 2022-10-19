package com.nexos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexos.model.AuditoriaSitioWeb;

@Repository
public interface AuditoriaSitioWebRepository extends JpaRepository<AuditoriaSitioWeb, Long> {
	
	@Query(value = "SELECT a.id, a.nombre_empleado as nombre_empleado, a.fecha_modificacion, a.operacion, a.nombre_mercancia "
			+ "FROM AuditoriaSitioWeb a "
			+ "JOIN empleado e "
			+ "ON e.nombre = a.nombre_empleado "
			+ "JOIN mercancia m "
			+ "ON m.nombre = a.nombre_mercancia ", nativeQuery=true)
	List<AuditoriaSitioWeb> getAllHistorialMercancia();
}