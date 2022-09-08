package com.nexos.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.HistorialMercanciaDTO;
import com.nexos.model.HistorialMercancia;
import com.nexos.service.HistorialMercanciaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/HistorialMercancia/")
public class HistorialMercanciaRest {
	
	@Autowired
	private HistorialMercanciaService historialMercanciaService;

	
	@PostMapping("/CrearHistorialMercancia")
	private ResponseEntity<HistorialMercancia> saveHistorialMercancia (@RequestBody HistorialMercanciaDTO historialMercancia, @PathVariable Long id_empleado,@PathVariable Long id_mercancia, String operacion ) {
		
		try {
			HistorialMercancia historialMercanciaGuardada = historialMercanciaService.save(castDTOEntity(historialMercancia), id_empleado, id_mercancia, operacion);
			historialMercanciaGuardada.setFecha_modificacion(historialMercanciaGuardada.setFecha_modificacion(operacion));	 
			return ResponseEntity.created(new URI ("/HistorialMercancia/" + historialMercanciaGuardada.getId())).body(historialMercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	private HistorialMercancia castDTOEntity(HistorialMercanciaDTO dto) {
		HistorialMercancia obj = new HistorialMercancia();
		obj.setId_mercancia(dto.getId_mercancia());
		obj.setId_empleado(dto.getId_empleado());
		obj.setFecha_modificacion(dto.getFecha_modificacion());
		return obj;
	}
}
