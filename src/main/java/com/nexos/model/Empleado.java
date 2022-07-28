package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empleado_id_seq")
	@Column(name = "empleado_id")
	private Long Id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "id_cargo")
	private Long id_Cargo;
	
	@Column(name = "fecha_ingreso_empresa")
	private String fechaIngresoEmpresa;
	
	public Empleado () {}
	
	public Empleado (Long Id) {
		this.Id = Id;
	}
	
	public Empleado(Long id, String nombre, String apellido, int edad, Long id_Cargo, String fechaIngresoEmpresa) {
		super();
		Id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id_Cargo = id_Cargo;
		this.fechaIngresoEmpresa = fechaIngresoEmpresa;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Long getId_Cargo() {
		return id_Cargo;
	}
	public void setId_Cargo(Long id_Cargo) {
		this.id_Cargo = id_Cargo;
	}
	public String getFechaIngresoEmpresa() {
		return fechaIngresoEmpresa;
	}
	public void setFechaIngresoEmpresa(String fechaIngresoEmpresa) {
		this.fechaIngresoEmpresa = fechaIngresoEmpresa;
	}

	@Override
	public String toString() {
		return "Empleado [Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", id_Cargo="
				+ id_Cargo + ", fechaIngresoEmpresa=" + fechaIngresoEmpresa + "]";
	}
	
}