package com.nexos.service;

import java.util.List;

import com.nexos.domain.AuditoriaSitioWebDTO;
public interface AuditoriaSitioWebService {
	
	void save(String nombre_empleado, String operacion, String modulo);
	public List<AuditoriaSitioWebDTO> getAllHistorialMercancia();
}