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

import com.nexos.model.Cargos;
import com.nexos.service.CargosService;

@RestController
@RequestMapping ("/Cargos/")
public class CargosRest {

	@Autowired
	private CargosService cargosService;
	
	@GetMapping
	private ResponseEntity<List<Cargos>> getAllCargo (){
		return ResponseEntity.ok(cargosService.findAll());
	}	
	
	@PostMapping
	private ResponseEntity<Cargos> saveCargos(@RequestBody Cargos cargos) {
		try {
			Cargos cargosGuardado = cargosService.create(cargos);
			return ResponseEntity.created(new URI("/Cargos/" + cargosGuardado.getId())).body(cargosGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
