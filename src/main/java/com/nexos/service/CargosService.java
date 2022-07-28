package com.nexos.service;

import java.util.List;

import com.nexos.model.Cargos;

public interface CargosService {
	
	public List<Cargos> getAllCargos ();
	public Cargos create (Cargos cargos);
	
}
