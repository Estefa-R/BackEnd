package com.nexos.service.impl;

import java.util.List;
import java.util.Optional;

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
	public void save(Long id_mercancia, Long id_empleado, String operacion) {
	    HistorialMercancia historialMercancia = new HistorialMercancia(id_mercancia, id_empleado, operacion);
	    historialMercanciaRepository.save(historialMercancia);
	}


	@Override
	public Optional<HistorialMercancia> findById(Long id) {
		return historialMercanciaRepository.findById(id);
	}
}
