package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HistorialMercancia")
public class HistorialMercancia implements Serializable {
	
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "historialMercancia_id_seq")
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "id_mercancia")
	private Long id_mercancia;
	
	@Column(name = "id_empleado")
	private Long id_empleado;
	
	@Column(name = "fecha_modificacion")
	private String fecha_modificacion;
	
	@Column(name = "operacion")
	private String operacion;
}
