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

	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "cantidad")
	private String cantidad;
	
	@Column(name = "fecha_ingreso")
	private String fecha_ingreso;
	
	@Column(name = "fecha_modificacion")
	private String fecha_modificacion;
	
	@Column(name = "id_empleado")
	private Long id_empleado;
	
	@Column(name = "id_creado_por")
	private Long id_creado_por;

	public Mercancia() {}
	
	public Mercancia(Long Id ) {
		this.Id = Id;		
	}
	
	public Mercancia(Long Id, String nombre_producto, String cantidad, String fecha_ingreso,
		String fecha_modificacion, Long id_empleado, Long id_creado_por) {
		super();
		this.Id = Id;
		this.nombre_producto = nombre_producto;
		this.cantidad = cantidad;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_modificacion = fecha_modificacion;
		this.id_empleado = id_empleado;
		this.id_creado_por = id_creado_por;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	
	public Long getId_creado_por() {
		return id_creado_por;
	}

	public void setId_creado_por(Long id_creado_por) {
		this.id_creado_por = id_creado_por;
	}

	@Override
	public String toString() {
		return "Mercancia [Id=" + Id + ", nombre_producto=" + nombre_producto + ", cantidad=" + cantidad + ", fecha_ingreso="
				+ fecha_ingreso + ", fecha_modificacion=" + fecha_modificacion + ", id_empleado=" + id_empleado
				+ ", id_creado_por=" + id_creado_por + "]";
	}
}