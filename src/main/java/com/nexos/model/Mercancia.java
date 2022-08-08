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
	@Column(name = "id")
	private Long Id;

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

	public Mercancia() {}
	
	public Mercancia(Long Id ) {
		this.Id = Id;		
	}
	
	public Mercancia(Long Id, String nombre, String cantidad, String fechaIngreso,
		String fechaModificacion, Long idEmpleado) {
		super();
		this.Id = Id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaModificacion = fechaModificacion;
		this.idEmpleado = idEmpleado;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
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


	@Override
	public String toString() {
		return "Mercancia [Id=" + Id + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", fechaIngreso=" + fechaIngreso + ", fechaModificacion=" + fechaModificacion + ", idEmpleado="
				+ idEmpleado + "]";
	}
}