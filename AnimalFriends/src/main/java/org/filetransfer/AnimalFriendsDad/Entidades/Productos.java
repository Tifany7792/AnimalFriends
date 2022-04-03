package org.filetransfer.AnimalFriendsDad.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Productos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombre;
	@Column
	private String tipo;
	@Column
	private String user;
	
	@ManyToOne
	private Usuarios usuario;
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Productos(String nombre, String tipo, String user) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.user = user;
	}
	
	public Productos(String nombre,Usuarios user, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.usuario = user;
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
	public String getUser() {
		return this.user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	

}
