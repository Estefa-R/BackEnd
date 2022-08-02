package com.nexos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARGOS")
public class Cargos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cargos_id_seq")
	@Column(name = "cargos_id")
	private Long cargos_id;
	
	@Column(name = "nombre_cargo")
	private String nombre_cargo;
	
	public Cargos() {}
	
	public Cargos(Long cargos_id) {
		this.cargos_id = cargos_id;
	}
	
	public Cargos(Long cargos_id, String nombre_cargo) {
		super();
		this.cargos_id = cargos_id;
		this.nombre_cargo = nombre_cargo;
	}

	
	public Long getCargos_id() {
		return cargos_id;
	}

	public void setCargos_id(Long cargos_id) {
		this.cargos_id = cargos_id;
	}

	public String getNombre_cargo() {
		return nombre_cargo;
	}

	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}

	@Override
	public String toString() {
		return "Cargos [cargos_id=" + cargos_id + ", nombre_cargo=" + nombre_cargo + "]";
	}
	
}