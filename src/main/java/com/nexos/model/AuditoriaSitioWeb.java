package com.nexos.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity
@Table(name = "AuditoriaSitioWeb")
public class AuditoriaSitioWeb implements Serializable {
	
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "AuditoriaSitioWeb_id_seq")
	@Column(name = "id")
	private Long id; 
		
	@Column(name = "nombre_empleado")
	private String nombre_empleado;
	
	@Column(name = "fecha_modificacion")
	private LocalDate fecha_modificacion;
	
	@Column(name = "operacion")
	private String operacion;
	
	@Column(name = "modulo")
	private String modulo;
}
