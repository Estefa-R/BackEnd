package com.nexos.service.impl;

import java.util.List;

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
	public List<HistorialMercancia> getAllHistorialMercancia() {
		return historialMercanciaRepository.findAll();
	}
	
	@Override
	public void save(Long id_empleado, Long id_mercancia, String operacion) {
	    HistorialMercancia historialMercancia = new HistorialMercancia(id_empleado, id_mercancia, operacion);
	    historialMercanciaRepository.save(historialMercancia);
	}


	@Override
	public List<HistorialMercancia> findById(int id) {
		List<HistorialMercancia> historialMercancia= historialMercanciaRepository.findByIdXEmpleado(Long.valueOf(id));
		return historialMercancia;
	}
	
}
