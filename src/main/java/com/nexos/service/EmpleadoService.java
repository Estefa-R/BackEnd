package com.nexos.service;

import java.util.List;

import com.nexos.model.Empleado;

public interface EmpleadoService {

	public Empleado create (Empleado Empleados);
	public List<Empleado> findAll();

}