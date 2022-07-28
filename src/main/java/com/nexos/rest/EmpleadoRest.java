package com.nexos.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;
import com.nexos.service.EmpleadoService;

@RestController
@RequestMapping("/EMPLEADO/")
public class EmpleadoRest {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/Listar")
	private ResponseEntity<List<Empleado>> listarEmpleados() {
		System.out.print("Entro al metodo listar de empleados");
		return ResponseEntity.ok(empleadoService.getAllEmpleados());
	}

	@PostMapping("/CrearEmpleado")
	private ResponseEntity<Empleado> saveEmpleado(@RequestBody EmpleadoDTO Empleado) {
		
		System.out.print("Entro al metodo**");
		try {
			Empleado empleadoGuardado = empleadoService.create(castDTOEntity(Empleado));
			
			empleadoGuardado.setFechaIngresoEmpresa(Empleado.getFechaIngresoEmpresa());
			return ResponseEntity.created(new URI("/Empleado/" + empleadoGuardado.getId())).body(empleadoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	private Empleado castDTOEntity (EmpleadoDTO dto) {
		Empleado obj = new Empleado();
		
		obj.setNombre(dto.getNombre());
		obj.setApellido(dto.getApellido());
		obj.setEdad(dto.getEdad());
		obj.setId_Cargo(dto.getId());
		obj.setFechaIngresoEmpresa(dto.getFechaIngresoEmpresa());
		return obj;
	}
}