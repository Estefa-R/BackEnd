package com.nexos.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.EmpleadoDTO;
import com.nexos.model.Empleado;
import com.nexos.service.EmpleadoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Empleado/")
public class EmpleadoRest {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/Listar")
	private ResponseEntity<List<Empleado>> listarEmpleados() {
		return ResponseEntity.ok(empleadoService.getAllEmpleados());
	}
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<Empleado>> buscarEmpleadoById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(empleadoService.findById(id));
	}
	
	@GetMapping("/BuscarPorApellido/{apellido}")
	private ResponseEntity<List<Empleado>> buscarEmpleadoByApellido(@PathVariable String apellido){
		return ResponseEntity.ok(empleadoService.findByApellido(apellido));
	}

	@PostMapping("/CrearEmpleado")
	private ResponseEntity<Empleado> saveEmpleado(@RequestBody EmpleadoDTO empleado) {
		try {
			Empleado empleadoGuardado = empleadoService.save(castDTOEmpleadoEntity(empleado));
			empleadoGuardado.setFecha_ingreso_empresa(empleado.getFecha_ingreso_empresa());
			return ResponseEntity.created(new URI("/Empleado/" + empleadoGuardado.getId())).body(empleadoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	private Empleado castDTOEmpleadoEntity (EmpleadoDTO dto) {
		Empleado obj = new Empleado();
		
		obj.setNombre(dto.getNombre());
		obj.setApellido(dto.getApellido());
		obj.setEdad(dto.getEdad());
		obj.setId_cargo(dto.getId_cargo());
		obj.setFecha_ingreso_empresa(dto.getFecha_ingreso_empresa());
		return obj;
	}
}