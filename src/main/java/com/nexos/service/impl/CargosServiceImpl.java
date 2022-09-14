package com.nexos.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;
import com.nexos.repository.CargosRepository;
import com.nexos.service.CargosService;

@Service
@Transactional
public class CargosServiceImpl implements CargosService{
	
	@Autowired
	private CargosRepository cargosRepository;
	
	@Override
	public List<Cargos> getAllCargos() {
		return cargosRepository.findAll();
	}
	
	@Override
	public Optional<Cargos> findById(Long id) {
		return cargosRepository.findById(id);
	}
	
	@Override
	public Cargos create (Cargos cargos) {
		return cargosRepository.save(cargos);
	}

	@Override
	public Cargos save(Cargos cargos) {
		return cargosRepository.save(cargos);
	}

	@Override
	public Cargos save(CargosDTO cargos) {
		return null;
	}

}
