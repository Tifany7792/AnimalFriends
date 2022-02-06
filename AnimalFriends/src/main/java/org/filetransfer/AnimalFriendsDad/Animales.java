package org.filetransfer.AnimalFriendsDad;

public class Animales {
	
	String tipo;
	int Id;
	String descripcion;
	
	public Animales(String tipo) {
		this.Id = 0;
		this.tipo = tipo;
		this.descripcion = " ";
	}
	
	public int getId() {
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

}
