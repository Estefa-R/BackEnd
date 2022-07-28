package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cargos")
public class Cargos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cargos_id_seq")
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "nombre_cargo")
	private String nombre;
	
	public Cargos() {}
	
	public Cargos(Long Id) {
		this.id = Id;
	}
	
	public Cargos(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cargos [id=" + id + ", nombre=" + nombre + "]";
	}
	
}