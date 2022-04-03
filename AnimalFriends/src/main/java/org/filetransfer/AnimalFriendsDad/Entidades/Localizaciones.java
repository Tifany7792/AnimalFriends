package org.filetransfer.AnimalFriendsDad.Entidades;

import javax.persistence.*;

@Entity
public class Localizaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String nombreSitio;
	@Column
	private String tipo;
	
	@ManyToOne
	private Usuarios usuario;
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Localizaciones() {
		
	}

	public Localizaciones(String nombreSitio, String tipo) {
		super();
		this.nombreSitio = nombreSitio;
		this.tipo = tipo;
	}
	
	public Localizaciones(String nombreSitio,Usuarios user, String tipo) {
		super();
		this.nombreSitio = nombreSitio;
		this.tipo = tipo;
		this.usuario = user;
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
