package com.nexos.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.model.HistorialMercancia;
import com.nexos.service.HistorialMercanciaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/HistorialMercancia/")
public class HistorialMercanciaRest<historialMercancia> {
	
	@Autowired
	private HistorialMercanciaService historialMercanciaService;
	
	@GetMapping("/Listar")
	private ResponseEntity<List<HistorialMercancia>> listarHistorialMercancia() {
		return ResponseEntity.ok(historialMercanciaService.getAllHistorialMercancia());
	}
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<HistorialMercancia>> buscarHistorialMercanciaById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(historialMercanciaService.findById(id));
	}
}
