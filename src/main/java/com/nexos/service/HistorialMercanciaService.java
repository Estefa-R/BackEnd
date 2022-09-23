package com.nexos.service;

import java.util.List;
import java.util.Optional;

import com.nexos.model.HistorialMercancia;

public interface HistorialMercanciaService {
	
	public List<HistorialMercancia> getAllHistorialMercancia();
	void save(Long id_mercancia, Long id_empleado, String operacion);
	public Optional<HistorialMercancia> findById(Long id);
}