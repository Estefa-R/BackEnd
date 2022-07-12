package com.nexos.service;

import java.util.List;

import com.nexos.model.Cargos;

public interface CargosService {
	
	public Cargos create (Cargos cargos);
	public List<Cargos> findAll();

}
