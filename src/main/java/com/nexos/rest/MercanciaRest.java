package com.nexos.rest;

import java.net.URI;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.service.MercanciaService;

@RestController
@RequestMapping("/Mercancia1/")
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
			System.out.print("Entro a la API de Crear***");

			Mercancia mercanciaGuardada = mercanciaService.save(castDTOEntity(mercancia));
			
			mercanciaGuardada.setFechaModificacion(new Timestamp(mercancia.getFechaModificacion().getTime()));
			return ResponseEntity.created(new URI("/Mercancia/" + mercanciaGuardada.getMercanciaId())).body(mercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	private Mercancia castDTOEntity (MercanciaDTO dto) {
		System.out.print("Entro al Casteo***" + dto.getFechaIngreso());

		Mercancia obj = new Mercancia();
		
		obj.setNombre(dto.getNombre());
		obj.setCantidad(dto.getCantidad());
		obj.setFechaIngreso(new Timestamp(dto.getFechaIngreso().getTime())); 
		obj.setFechaModificacion(new Timestamp(dto.getFechaModificacion().getTime()));
		obj.setIdEmpleado(dto.getIdEmpleado());
		obj.setIdCreadoPor(dto.getIdCreadoPor());
		return obj;
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteMercancia(@PathVariable(value = "mercanciaId") Long mercanciaId, @PathVariable(value = "idEmpleado") int idEmpleado ) {
		mercanciaService.deleteById(mercanciaId, idEmpleado);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<Mercancia> actualizarMercancia(@PathVariable int id, @RequestBody MercanciaDTO Mercancia) {
		Mercancia mercancia = new Mercancia();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		mercancia.setNombre(Mercancia.getNombre());
//		mercancia.setCantidad(Mercancia.getCantidad());
//		mercancia.setFechaModificacion(dtf.format(now));

		com.nexos.model.Mercancia mercanciaActualizado = new Mercancia();
		return ResponseEntity.ok(mercanciaActualizado);
	}

}