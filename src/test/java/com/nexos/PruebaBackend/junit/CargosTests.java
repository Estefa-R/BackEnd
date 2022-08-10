package com.nexos.PruebaBackend.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.nexos.model.Cargos;
import com.nexos.repository.CargosRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CargosTests {
	
	private static final Long String = null;
	@Autowired
	private CargosRepository repository;
	
	@Test
	public void saveCargosTest() {
		Cargos cargos = new Cargos (String, "Gerente de proyectos");
		Cargos cargosSaveTest = repository.save(cargos);
		
		assertNotNull(cargosSaveTest);
	}
	

}
