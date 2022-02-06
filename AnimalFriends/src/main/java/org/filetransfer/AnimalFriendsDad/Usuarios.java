package org.filetransfer.AnimalFriendsDad;

public class Usuarios {
	
	String nombre;
	String pasword;
	int id;
	
	public Usuarios(String n, String p) {
		this.nombre = n;
		this.pasword = p;
		this.id = 0;
	}
	
	public int getId() {
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

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
