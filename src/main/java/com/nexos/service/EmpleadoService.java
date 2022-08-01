package com.nexos.service;

import java.util.List;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> getAllEmpleados();
	public Empleado create (Empleado empleado);
	public Empleado save(Empleado empleado);
	public Empleado save(EmpleadoDTO empleado);

}