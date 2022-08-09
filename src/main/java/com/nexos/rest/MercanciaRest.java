package com.nexos.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.service.MercanciaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Mercancia/")
public class MercanciaRest {

	@Autowired
	private MercanciaService mercanciaService;

	@GetMapping("/Listar")
	private ResponseEntity<List<Mercancia>> listarMercancia(){
		return ResponseEntity.ok(mercanciaService.getAllMercancia());
	}

	@PostMapping("/CrearMercancia")
	private ResponseEntity<Mercancia> saveMercancia(@RequestBody MercanciaDTO mercancia) {
		try {
			Mercancia mercanciaGuardada = mercanciaService.save(castDTOEntity(mercancia));
			
			mercanciaGuardada.setFechaIngreso(mercancia.getFechaIngreso());
			return ResponseEntity.created(new URI("/Mercancia/" + mercanciaGuardada.getId())).body(mercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	private Mercancia castDTOEntity (MercanciaDTO dto) {
		Mercancia obj = new Mercancia();
		obj.setNombre(dto.getNombre());
		obj.setCantidad(dto.getCantidad());
		obj.setFechaIngreso(dto.getFechaIngreso()); 
		obj.setFechaModificacion(dto.getFechaModificacion());
		obj.setIdEmpleado(dto.getIdEmpleado());
		return obj;
	}
	
	@DeleteMapping(value = "/Eliminar/{id}/{idEmpleado}")
	public ResponseEntity<?> deleteMercancia(@PathVariable(value = "id") Long id, @PathVariable(value = "idEmpleado") Long idEmpleado ) {
		mercanciaService.deleteById(id, idEmpleado);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping(value = "/Editar/{id}/{idEmpleado}")
	public ResponseEntity<Object> updateMercancia(@RequestBody MercanciaDTO Mercancia, @PathVariable Long id, @PathVariable(value = "idEmpleado") Long idEmpleado) {
		this.mercanciaService.updateMercancia(Mercancia, id, idEmpleado);
		return ResponseEntity.ok(Boolean.TRUE);
	
	}
}