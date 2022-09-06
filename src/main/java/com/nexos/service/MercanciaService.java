package com.nexos.service;

import java.util.List;
import java.util.Optional;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

public interface MercanciaService {

	public Mercancia create (Mercancia mercancia);
	public List<Mercancia> findAll();
	public List<Mercancia> getAllMercancia();
	public Mercancia save(Mercancia mercancia, String nombre);
	public Boolean deleteById(Long id);
	public void delete(Mercancia entity);
	public void deleteById(long id, Long idEmpleado);
	void updateMercancia(MercanciaDTO mercancia, Long id, Long idEmpleado);
	public Optional<Mercancia> findById(Long id);
	
	
}

