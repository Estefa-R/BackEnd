package com.nexos.PruebaBackend.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nexos.model.Empleado;
import com.nexos.repository.EmpleadoRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmpleadoTests {
	
	@Autowired
	private EmpleadoRepository repository;
	
	@Test
	@Rollback(false)
	public void saveEmpleadoTest() {
		String nombre = "Prueba4";
		String apellido = "Madrid";
		int edad = 26;
		Long id_cargo = 7;
		String fecha_ingreso_empresa = "2016-03-07";
		
		Empleado empleadoSaveTest = repository.save(nombre, apellido, edad, id:cargo, 2016-03-07);
		
		assertNotNull(empleadoSaveTest);
	}

}
