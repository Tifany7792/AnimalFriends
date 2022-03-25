package es.codeurjc.restspring;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Animal {

	private long Id;

	private String tipo;

	private String descripcion;

	private String imageFile;

	public Animal() {

	}

	public Animal(String tipo, String descripcion, String imagen) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.imageFile = imagen;
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

	public String getImageFile() {
		return imageFile;
	}
	

	@Override
	public String toString() {
		return "Animal [tipo=" + tipo + ", descripcion=" + descripcion + "]" + "imagen=" + imageFile;
	}

}
