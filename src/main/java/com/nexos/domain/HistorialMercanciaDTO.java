package com.nexos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialMercanciaDTO {
	
	private Long id; 
	private Long id_mercancia;
	private Long id_empleado;
	private String operacion; // creacion, modificacion, borrado
	private String fecha_modificacion;

}
