package com.nexos.service;

import java.util.List;

import com.nexos.model.Mercancia;

public interface MercanciaService {

	public Mercancia create (Mercancia mercancia);
	public List<Mercancia> findAll();
	public List<Mercancia> getAllMercancia();
	public <S extends Mercancia> S save(S entity);
	public Boolean deleteById(int Id);
	public void delete(Mercancia entity);
	public void deleteById(int mercanciaId, int idEmpleado);
	
}

