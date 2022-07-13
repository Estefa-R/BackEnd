package com.nexos.rest;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;

import com.nexos.model.Mercancia;
import com.nexos.service.MercanciaService;

@RestController
@RequestMapping("/Mercancia1/")
public class MercanciaRest {

	@Autowired
	private MercanciaService mercanciaService;

	@GetMapping(value = "{Id}")
	private ResponseEntity<List<Mercancia>> Listar (@RequestBody Mercancia mercancia){
		Mercancia mercancia1 = new Mercancia();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		mercancia1.getNombre();
		mercancia1.getFechaIngreso();
		mercancia1.getIdCreadoPor();
		return ResponseEntity.ok(mercanciaService.getAllMercancia());
	}

	@PostMapping
	private ResponseEntity<Mercancia> saveMercancia(@RequestBody Mercancia Mercancia) {
		try {
			Mercancia mercanciaGuardada = mercanciaService.save(Mercancia);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			mercanciaGuardada.setFechaModificacion(dtf.format(now));
			return ResponseEntity.created(new URI("/Mercancia/" + mercanciaGuardada.getMercanciaId())).body(mercanciaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteMercancia(@PathVariable(value = "mercanciaId") int mercanciaId, @PathVariable(value = "idEmpleado") int idEmpleado ) {
		mercanciaService.deleteById(mercanciaId, idEmpleado);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<Mercancia> actualizarMercancia(@PathVariable int id, @RequestBody Mercancia Mercancia) {
		Mercancia mercancia = new Mercancia();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		mercancia.setNombre(Mercancia.getNombre());
		mercancia.setCantidad(Mercancia.getCantidad());
		mercancia.setFechaModificacion(dtf.format(now));

		com.nexos.model.Mercancia mercanciaActualizado = new Mercancia();
		return ResponseEntity.ok(mercanciaActualizado);
	}

}