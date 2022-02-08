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
	
	public Animal(String tipo) {
		this.Id = 0;
		this.tipo = tipo;
		this.descripcion = " ";
	}
	
	public long getId() {
		return this.Id;
	}
	
	public void setId(int i) {
		this.Id = i;
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

	@Override
	public String toString() {
		return "Animal [tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
	

}
