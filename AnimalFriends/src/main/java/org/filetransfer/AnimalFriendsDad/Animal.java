package org.filetransfer.AnimalFriendsDad;

import javax.persistence.*;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	
	private String user;
	
	public Animal(String user, String tipo) {
		this.Id = 0;
		this.tipo = tipo;
		this.descripcion = " ";
		this.user = user;
	}
	
	public long getId() {
		return this.Id;
	}
	
	public void setId(long id2) {
		this.Id = id2;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String t) {
		this.tipo = t;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}

	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Animal [tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
	

}
