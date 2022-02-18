package es.codeurjc.AnimalFriendsDad.entidades;

import jakarta.persistence.*;

@Entity
public class Localizaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombreSitio;
	@Column
	private String tipo;
	
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


	public long getId() {
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
