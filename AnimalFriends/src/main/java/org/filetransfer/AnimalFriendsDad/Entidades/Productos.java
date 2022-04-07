package org.filetransfer.AnimalFriendsDad.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

@Entity
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombre;
	@Column
	private String tipo;
	


	public void setId(long id) {
		this.id = id;
	}

	public Productos(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public Productos() {
		
	}
	
	public long getId() {
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
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	

}
