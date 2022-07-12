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

	private int Id;
	private String nombre;
	private String apellido;
	private int edad;
	private int id_Cargo;
	private String fechaIngresoEmpresa;

}

