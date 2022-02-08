package org.filetransfer.AnimalFriendsDad;

import javax.persistence.*;

@Entity
public class Usuarios {
	
	@Column
	private String nombre;
	@Column
	private String pasword;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public Usuarios(String n, String p) {
		this.nombre = n;
		this.pasword = p;
	}
	
	public long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", pasword=" + pasword + "]";
	}
	
	
	
	
	

}
