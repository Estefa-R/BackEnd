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

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;
import com.nexos.service.CargosService;

@RestController
@RequestMapping ("/Cargos/")
public class CargosRest {

	@Autowired
	private CargosService cargosService;
	
	@GetMapping("/Listar")
	private ResponseEntity<List<Cargos>> listarCargos (){
		return ResponseEntity.ok(cargosService.getAllCargos());
	}	
	
	@PostMapping("/CrearCargos")
	private ResponseEntity<Cargos> saveCargos(@RequestBody CargosDTO cargos) {;
		try {
			Cargos cargosGuardado = cargosService.save(castDTOCargosEntity(cargos));
			return ResponseEntity.created(new URI("/Cargos/" + cargosGuardado.getCargos_id())).body(cargosGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	private Cargos castDTOCargosEntity (CargosDTO cargos) {
		Cargos obj = new Cargos();
		
		obj.setNombre_cargo(cargos.getNombre_cargo());
		return obj;
	}
}
