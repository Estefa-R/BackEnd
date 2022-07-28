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
	
	private Long mercanciaId;
	private String nombre;
	private String cantidad;
	private String fechaIngreso;
	private String fechaModificacion;
	private Long idEmpleado;
	private Long idCreadoPor;

}
