package com.nexos.PruebaBackend.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nexos.model.Mercancia;
import com.nexos.repository.MercanciaRepository;




@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MercanciaTests {
	
	@Autowired
	private MercanciaRepository repository;
	
	@Test
	@Rollback(false)
	public void saveMercanciaTest() {
		Mercancia mercancia = new Mercancia ();
		Mercancia mercanciaSaveTest = repository.save(mercancia);
		
		assertNotNull(mercanciaSaveTest);
	}
	
	@Test
	public void listMercanciaTest (){
		List<Mercancia> id = (List<Mercancia>) repository.findAll();
		
		for (Mercancia mercancia : id) {
			System.out.println(mercancia);
		}
		assertThat(id).size().isGreaterThan(0);
	}
	
	
	@Test
	public void buscarMercanciaTest() {
		long id = 7;
		Optional<Mercancia> mercancia = repository.findById(id);
	     assertThat(mercancia.get());
	}
	
	@Test
	public void buscarMercanciaNoExisteTest() {
		long id = 17;
		Optional<Mercancia> mercancia = repository.findById(id);
	     assertNull(mercancia);
	}
	
	@Test
	public void updateMercanciaTest() {
		long id = 16;
		Mercancia mercancia = new Mercancia (id);
		mercancia.setId(id);
		
		repository.save(mercancia);
		Optional<Mercancia> updateMercancia = repository.findById(id);
		assertThat(updateMercancia.get().equals(id));
	}
	
	@Test
	@Rollback(false)
	public void deleteMercanciaTest() {
		long id = 15;
		boolean existeAntesDeEliminar = repository.findById(id).isPresent();
		repository.deleteById(id);
		boolean noExisteDespuesDeEliminar = repository.findById(id).isPresent();
		
		assertTrue(existeAntesDeEliminar);
		assertFalse(noExisteDespuesDeEliminar);
	}

}
