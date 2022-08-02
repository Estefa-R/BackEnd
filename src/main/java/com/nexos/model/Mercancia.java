package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MERCANCIA")
public class Mercancia implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "mercancia_id_seq")
	@Column(name = "mercancia_id")
	private Long mercanciaId;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cantidad")
	private String cantidad;
	
	@Column(name = "fecha_ingreso")
	private String fechaIngreso;
	
	@Column(name = "fecha_modificacion")
	private String fechaModificacion;
	
	@Column(name = "id_empleado")
	private Long idEmpleado;
	
	@Column(name = "id_creado_por")
	private Long idCreadoPor;

	public Mercancia() {}
	
	public Mercancia(Long mercanciaId ) {
		this.mercanciaId = mercanciaId;		
	}
	
	public Mercancia(Long mercanciaId, String nombre, String cantidad, String fechaIngreso,
		String fechaModificacion, Long idEmpleado, Long idCreadoPor) {
		super();
		this.mercanciaId = mercanciaId;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaModificacion = fechaModificacion;
		this.idEmpleado = idEmpleado;
		this.idCreadoPor = idCreadoPor;
	}

	public Long getMercanciaId() {
		return mercanciaId;
	}

	public void setMercanciaId(Long mercanciaId) {
		this.mercanciaId = mercanciaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdCreadoPor() {
		return idCreadoPor;
	}

	public void setIdCreadoPor(Long idCreadoPor) {
		this.idCreadoPor = idCreadoPor;
	}

	@Override
	public String toString() {
		return "Mercancia [mercanciaId=" + mercanciaId + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", fechaIngreso=" + fechaIngreso + ", fechaModificacion=" + fechaModificacion + ", idEmpleado="
				+ idEmpleado + ", idCreadoPor=" + idCreadoPor + "]";
	}
}