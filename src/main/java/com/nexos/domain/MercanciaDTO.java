package com.nexos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MercanciaDTO {
	
	private int Id;
	private String nombre;
	private int cantidad;
	private String fechaIngreso;
	private String fechaModificacion;
	private int idEmpleado;
	private int idCreadoPor;

}
