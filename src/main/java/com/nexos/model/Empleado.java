package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empleado_id_seq")
	@Column(name = "empleado_id")
	private Long empleado_id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "id_cargo")
	private Long id_cargo;
	
	@Column(name = "fecha_ingreso_empresa")
	private String fecha_ingreso_empresa;
	
	public Empleado () {}
	
	public Empleado (Long empleado_id) {
		this.empleado_id = empleado_id;
	}
	
	public Empleado(Long empleado_id, String nombre, String apellido, int edad, Long id_cargo, String fecha_ingreso_empresa) {
		super();
		this.empleado_id = empleado_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id_cargo = id_cargo;
		this.fecha_ingreso_empresa = fecha_ingreso_empresa;
	}

	@Override
	public String toString() {
		return "Empleado [empleado_id=" + empleado_id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", id_Cargo="
				+ id_cargo + ", fecha_ingreso_empresa=" + fecha_ingreso_empresa + "]";
	}
	
}