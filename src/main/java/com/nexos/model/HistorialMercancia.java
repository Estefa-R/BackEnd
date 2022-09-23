package com.nexos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "HISTORIALMERCANCIA")
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
	
	public HistorialMercancia() {
	}

	public HistorialMercancia( Long id_mercancia,Long id_empleado, String operacion) {
		super();

		this.id_mercancia = id_mercancia;
		this.id_empleado = id_empleado;
		this.operacion = operacion;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	    LocalDateTime now = LocalDateTime.now();
		this.fecha_modificacion = dtf.format(now);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_mercancia() {
		return id_mercancia;
	}

	public void setId_mercancia(Long id_mercancia) {
		this.id_mercancia = id_mercancia;
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public String setFecha_modificacion(String fecha_modificacion) {
		return fecha_modificacion;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	@Override
	public String toString() {
		return "HistorialMercancia [id=" + id + ", id_mercancia=" + id_mercancia + ", id_empleado=" + id_empleado
				+ ", fecha_modificacion=" + fecha_modificacion + ", operacion=" + operacion + "]";
	}
	
}
