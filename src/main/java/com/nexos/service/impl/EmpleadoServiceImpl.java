package com.nexos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;
import com.nexos.repository.EmpleadoRepository;
import com.nexos.service.EmpleadoService;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}
	
	@Override
	public Empleado create (Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Override
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Override
	public Empleado save(EmpleadoDTO empleado) {
		return null;
	}

}
