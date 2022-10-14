package com.nexos.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.AuditoriaSitioWeb;
import com.nexos.repository.AuditoriaSitioWebRepository;
import com.nexos.service.AuditoriaSitioWebService;

@Service
@Transactional
public class AuditoriaSitioWebServiceImpl implements AuditoriaSitioWebService {
	
	@Autowired
	private AuditoriaSitioWebRepository AuditoriaSitioWebRepository;
	
	@Override
	public void save(String nombre_empleado, String operacion, String modulo) {
		AuditoriaSitioWebRepository.save(AuditoriaSitioWeb.builder()
				.nombre_empleado(nombre_empleado)
				.operacion(operacion).modulo(modulo)
				.fecha_modificacion(LocalDate.now()).build());
	}


	@Override
	public List<AuditoriaSitioWebDTO> getAllHistorialMercancia() {
		List<AuditoriaSitioWebDTO> AuditoriaSitioWeb = AuditoriaSitioWebRepository.getAllHistorialMercancia();
		return AuditoriaSitioWeb;
	}
	
}
