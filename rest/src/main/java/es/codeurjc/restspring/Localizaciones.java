package es.codeurjc.restspring;

import javax.persistence.*;


public class Localizaciones {

	private long id;

	private String nombreSitio;

	private String tipo;
	
	public Localizaciones() {
		
	}

	public Localizaciones(String nombreSitio, String tipo) {
		super();
		this.nombreSitio = nombreSitio;
		this.tipo = tipo;
	}


	public String getNombreSitio() {
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Localizaciones [nombreSitio=" + nombreSitio + ", tipo=" + tipo + "]";
	}

}
