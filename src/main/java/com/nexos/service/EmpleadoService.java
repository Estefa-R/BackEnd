package com.nexos.service;

import java.util.List;

import com.nexos.model.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> getAllEmpleados();
	public Empleado create (Empleado Empleados);
	

}