package com.nexos.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.repository.MercanciaRepository;
import com.nexos.service.MercanciaService;

@Service
@Transactional
public class MercanciaServiceImpl implements MercanciaService {
	
	@Autowired
	private MercanciaRepository mercanciaRepository;
	
	@Override
	public Mercancia create (Mercancia mercancia) {
		return mercanciaRepository.save(mercancia);
	}
	
	@Override
	public List<Mercancia> findAll() {
		return mercanciaRepository.findAll();
	}
	
	@Override	
	public List<Mercancia> getAllMercancia() {
		return mercanciaRepository.findAll();
	}
	
	@Override
	public <S extends Mercancia> S save(S entity) {
		return mercanciaRepository.save(entity);
	}

	@Override
	public Boolean deleteById(int id) {
		if (mercanciaRepository.existsById(id)) {
			mercanciaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(Mercancia entity) {
		mercanciaRepository.delete(entity);
	}
	
	@Override
	public void deleteById(int mercanciaId, int idEmpleado)	{
		Optional<Mercancia> mercancia = mercanciaRepository.findById(mercanciaId);
		if(mercancia.get().getIdCreadoPor() == idEmpleado ){
		System.out.print("El usuario tiene permisos para borrar este objeto");
		}else{
		System.out.print("El usuario NO tiene permisos para borrar este objeto");
	
		}
	}

	@Override
	public <S extends Mercancia> S save(MercanciaDTO mercancia) {
		// TODO Auto-generated method stub
		return null;
	}
}
