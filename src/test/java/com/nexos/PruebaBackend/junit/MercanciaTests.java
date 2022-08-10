package com.nexos.PruebaBackend.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
