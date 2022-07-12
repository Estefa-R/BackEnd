package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;

@Component
public class TranslateEmpleadoDTO implements Translator<Empleado, EmpleadoDTO> {

	@Override
	public EmpleadoDTO translate(Empleado empleado) {
		
		EmpleadoDTO imput = new EmpleadoDTO();
		imput.setId(empleado.getId());
		imput.setNombre(empleado.getNombre());
		imput.setApellido(empleado.getApellido());
		imput.setEdad(empleado.getEdad());
		imput.setFechaIngresoEmpresa(empleado.getFechaIngresoEmpresa());
		imput.setId_Cargo(empleado.getId_Cargo());
		return imput;
	}
}
