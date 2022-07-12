package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

@Component
public class TranslateEmpleadoDTO implements Translator<Empleado, EmpleadoDTO> {

	@Override
	public EmpleadoDTO translate(Empleado empleados) {
		
		EmpleadoDTO imput = new EmpleadoDTO();
		imput.setId(empleados.getEdad());
		imput.setNombre(empleados.getNombre());
		imput.setApellido(empleados.getApellido());
		imput.setEdad(empleados.getEdad());
		imput.setFechaIngresoEmpresa(empleados.getFechaIngresoEmpresa());
		imput.setId_Cargo(empleados.getId_Cargo());
		return imput;
	}
}
