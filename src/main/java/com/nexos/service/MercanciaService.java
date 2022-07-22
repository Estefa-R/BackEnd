package com.nexos.service;

import java.util.List;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

public interface MercanciaService {

	public Mercancia create (Mercancia mercancia);
	public List<Mercancia> findAll();
	public List<Mercancia> getAllMercancia();
	public <S extends Mercancia> S save(Mercancia entity);
	public Boolean deleteById(int Id);
	public void delete(Mercancia entity);
	public void deleteById(int mercanciaId, int idEmpleado);
}

