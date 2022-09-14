package com.nexos.service;

import java.util.List;
import java.util.Optional;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> getAllEmpleados();
	public Empleado create (Empleado empleado);
	public Empleado save(Empleado empleado);
	public Empleado save(EmpleadoDTO empleado);
	public Optional<Empleado> findById(Long id);
}