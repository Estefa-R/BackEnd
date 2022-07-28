package com.nexos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

	private Long Id;
	private String nombre;
	private String apellido;
	private int edad;
	private Long id_Cargo;
	private String fechaIngresoEmpresa;

}

