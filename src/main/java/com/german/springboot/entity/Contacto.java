package com.german.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contactos")
@Entity
public class Contacto {

	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String telefono;
	private String ciudad;
	private String estatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Contacto(int id, String nombre, String apellidoMaterno, String apellidoPaterno, String telefono, String ciudad, String estatus) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.estatus = estatus;
	}

	public Contacto() {
	}

	@Override
	public String toString() {
		return "Contactos [id=" + id + ", nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", telefono=" + telefono + ", ciudad=" + ciudad + ", estatus=" + estatus + "]";
	}

}
