package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Mercancia")
public class Mercancia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mercanciaId;
	@Column(name = "nombre")
	private String nombre;
	private int cantidad;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String fechaIngreso;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String fechaModificacion;
	@Column(name = "idEmpleado")
	private int idEmpleado;
	@Column(name = "idCreadoPor")
	private int idCreadoPor;
	

	public int getMercanciaId() {
		return mercanciaId;
	}
	public void setMercanciaId(int mercanciaId) {
		this.mercanciaId = mercanciaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
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
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdCreadoPor() {
		return idCreadoPor;
	}
	public void setIdCreadoPor(int idCreadoPor) {
		this.idCreadoPor = idCreadoPor;
	}
}