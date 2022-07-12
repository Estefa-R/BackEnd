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

import com.nexos.model.Empleado;
import com.nexos.service.EmpleadoService;

@RestController
@RequestMapping("/Empleado/")
public class EmpleadoRest {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping(value = "{Id}")
	private ResponseEntity<List<Empleado>> getAllEmpleados() {
		return ResponseEntity.ok(empleadoService.findAll());
	}

	@PostMapping
	private ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado Empleado) {
		try {
			Empleado empleadoGuardado = empleadoService.create(Empleado);
			return ResponseEntity.created(new URI("/Empleado/" + empleadoGuardado.getId())).body(empleadoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}