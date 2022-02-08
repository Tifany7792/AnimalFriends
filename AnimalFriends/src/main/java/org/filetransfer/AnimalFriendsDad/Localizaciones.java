package org.filetransfer.AnimalFriendsDad;

public class Localizaciones {
	
	String nombreSitio;
	int id;
	String tipo;
	
	
	public Localizaciones(String nombreSitio, int id, String tipo) {
		super();
		this.nombreSitio = nombreSitio;
		this.id = id;
		this.tipo = tipo;
	}


	public String getNombreSitio() {
		return nombreSitio;
	}


	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Localizaciones [nombreSitio=" + nombreSitio + ", tipo=" + tipo + "]";
	}
	
	
	

}
