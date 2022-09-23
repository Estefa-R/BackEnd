package com.nexos.rest;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


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
import com.nexos.service.impl.HistorialMercanciaServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Mercancia/")
public class MercanciaRest {

	@Autowired
	private MercanciaService mercanciaService;

	@GetMapping("/listar")
	private ResponseEntity<List<Mercancia>> listarMercancia(){
		return ResponseEntity.ok(mercanciaService.getAllMercancia());
	}
	
	@GetMapping("/BuscarPorId/{id}")
	private ResponseEntity<Optional<Mercancia>> buscarMercanciaById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(mercanciaService.findById(id));
	}
	
	@GetMapping("/BuscarPorNombre/{nombre}")
	private ResponseEntity<List<Mercancia>> buscarMercanciaByNombre(@PathVariable String nombre){
		return ResponseEntity.ok(mercanciaService.findByNombre(nombre));
	}

	@PostMapping("/CrearMercancia")
	private ResponseEntity<Mercancia> saveMercancia (@RequestBody MercanciaDTO mercancia, String nombre) {
	
		try {
			Mercancia mercanciaGuardada = mercanciaService.save(castDTOEntity(mercancia), nombre);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		    LocalDateTime now = LocalDateTime.now();
		    
			mercanciaGuardada.setFecha_ingreso(dtf.format(now));
			
			new HistorialMercanciaServiceImpl().save(mercanciaGuardada.getId_empleado(), mercanciaGuardada.getId(), "Creado");
			return ResponseEntity.created(new URI("Mercancia/" + mercanciaGuardada.getId())).body(mercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	private Mercancia castDTOEntity (MercanciaDTO dto) {
		Mercancia obj = new Mercancia();
		obj.setNombre(dto.getNombre());
		obj.setCantidad(dto.getCantidad());
		obj.setFecha_ingreso(dto.getFecha_ingreso()); 
		obj.setId_empleado(dto.getId_empleado());
		return obj;
	}
	
	@PutMapping(value = "/updateMercancia")
	public ResponseEntity<Object> updateMercancia(@RequestBody MercanciaDTO Mercancia) {
		this.mercanciaService.updateMercancia(Mercancia);
		return ResponseEntity.ok(Boolean.TRUE);
	
	}
	
	@DeleteMapping(value = "/deleteMercancia/{id}/{id_empleado}")
	public ResponseEntity<?> deleteMercancia(@PathVariable(value = "id") Long id, @PathVariable(value = "id_empleado") Long id_empleado ) {
		mercanciaService.deleteById(id, id_empleado);
		return ResponseEntity.ok().build();
	}
}