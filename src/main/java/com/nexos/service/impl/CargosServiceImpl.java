package com.nexos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.model.Cargos;
import com.nexos.repository.CargosRepository;
import com.nexos.service.CargosService;

@Service
@Transactional
public class CargosServiceImpl implements CargosService{
	
	@Autowired
	private CargosRepository cargosRepository;
	
	@Override
	public Cargos create (Cargos cargos) {
		return cargosRepository.save(cargos);
	}
	
	@Override
	public List<Cargos> findAll() {
		return cargosRepository.findAll();
	}
}
