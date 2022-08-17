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
	public Optional<Mercancia> findById(Long id) {
		return mercanciaRepository.findById(id);
	}

	@Override
	public Boolean deleteById(Long id) {
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
	public Mercancia save(Mercancia mercancia) {
		return mercanciaRepository.save(mercancia);
	}

	@Override
	public Mercancia save(MercanciaDTO mercancia) {
		return null;
	}

	@Override
	public void deleteById(long id, Long id_empleado) {
		Optional<Mercancia> mercancia = mercanciaRepository.findById(id);
		if(mercancia.get().getId_empleado() == id_empleado ){
		System.out.print("El usuario tiene permisos para borrar este objeto");
		mercanciaRepository.deleteById(id);
		}else{
		System.out.print("El usuario NO tiene permisos para borrar este objeto");
		
		}	
	}

	@Override
	public void updateMercancia(MercanciaDTO Mercancia, Long id, Long id_empleado) {
	Optional<Mercancia> mercancia = this.mercanciaRepository.findById(id);
		Mercancia mercancia1 = mercancia.get();
			if(mercancia.get().getId_empleado() == id_empleado ){
				mercancia1.setId_empleado(Mercancia.getId_empleado());
				System.out.print("El usuario tiene permisos para editar este objeto");
				mercancia1.setNombre_producto(Mercancia.getNombre_producto());
				mercancia1.setCantidad(Mercancia.getCantidad());
				mercancia1.setFecha_modificacion(Mercancia.getFecha_modificacion());
		
			}else{
				System.out.print("El usuario NO tiene permisos para editar este objeto");
		
		}	
	}
}