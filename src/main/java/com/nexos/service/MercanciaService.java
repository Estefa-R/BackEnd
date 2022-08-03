package com.nexos.service;

import java.util.List;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

public interface MercanciaService {

	public Mercancia create (Mercancia mercancia);
	public List<Mercancia> findAll();
	public List<Mercancia> getAllMercancia();
	public Mercancia save(Mercancia mercancia);
	public Boolean deleteById(Long Id);
	public void delete(Mercancia entity);
	public void deleteById(long mercanciaId, Long idEmpleado);
	public Mercancia save(MercanciaDTO mercancia);
	void actualizarMercancia(MercanciaDTO mercancia, Long mercanciaId, Long idEmpleado);
}

