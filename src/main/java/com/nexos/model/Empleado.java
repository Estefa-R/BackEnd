package com.nexos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "edad")
	private int edad;
	@Column(name = "id_Cargo")
	private int id_Cargo;
	@Column(name = "fechaIngresoEmpresa")
	private String fechaIngresoEmpresa;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
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
	public int getId_Cargo() {
		return id_Cargo;
	}
	public void setId_Cargo(int id_Cargo) {
		this.id_Cargo = id_Cargo;
	}
	public String getFechaIngresoEmpresa() {
		return fechaIngresoEmpresa;
	}
	public void setFechaIngresoEmpresa(String fechaIngresoEmpresa) {
		this.fechaIngresoEmpresa = fechaIngresoEmpresa;
	}

	public Empleado(int id, String nombre, String apellido, int edad, int id_Cargo, String fechaIngresoEmpresa) {
		super();
		Id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id_Cargo = id_Cargo;
		this.fechaIngresoEmpresa = fechaIngresoEmpresa;
	}
	public Empleado() {
		super();
	}	
		
}