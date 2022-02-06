package org.filetransfer.AnimalFriendsDad;

public class Productos {
	
	int id;
	String nombre;
	String tipo;
	
	public Productos(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
