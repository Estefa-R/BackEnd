package com.nexos.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.model.HistorialMercancia;
import com.nexos.repository.HistorialMercanciaRepository;
import com.nexos.service.HistorialMercanciaService;


@Service
@Transactional
public class HistorialMercanciaServiceImpl implements HistorialMercanciaService {
	
	@Autowired
	private HistorialMercanciaRepository historialMercanciaRepository;
	
	@Override
	public HistorialMercancia save (HistorialMercancia historialMercancia, Long id_empleado, Long id_mercancia, String operacion ) {
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		    LocalDateTime now = LocalDateTime.now();
		return historialMercanciaRepository.save(historialMercancia);
		
		// Obtenemos la fecha actual
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	    //LocalDateTime now = LocalDateTime.now(); // Convertimos la fecha a un string
		//mercancia1.setFecha_modificacion(dtf.format(now));
	}

}
