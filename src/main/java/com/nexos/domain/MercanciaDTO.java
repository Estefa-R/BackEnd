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
	
	private Long Id;
	private String nombre;
	private String cantidad;
	private String fecha_ingreso;
	private Long id_empleado;
	private String fecha_modificacion;

}
