package es.codeurjc.restspring;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;


public class Usuarios {

	private long id;

	private String nombre;

	private String password;
	
	private String correo;

	private List<String> roles;

	private List<Localizaciones> reservas;

	private List<Animal> mascotas;

	private List<Productos> listaCompra;

	public Usuarios() {
	};
	
	public Usuarios(String n, String p) {
		super();
		this.nombre = n;
		this.password = p;
		List<Localizaciones> l = null;
		this.reservas = l;
		List<Animal> a = null;
		this.mascotas = a;
		List<Productos> c = null;
		this.listaCompra = c;
	}


	public Usuarios(String nombre, String password, String... roles) {
		super();
		this.nombre = nombre;
		this.password = password;
		//this.roles = List.of(roles);
		List<Localizaciones> l = null;
		this.reservas = l;
		List<Animal> a = null;
		this.mascotas = a;
		List<Productos> c = null;
		this.listaCompra = c;
	}
	


	public Usuarios(String nombre, String password, List<String> roles) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.roles = roles;
		List<Localizaciones> l = null;
		this.reservas = l;
		List<Animal> a = null;
		this.mascotas = a;
		List<Productos> c = null;
		this.listaCompra = c;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<Productos> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Productos> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public List<Localizaciones> getReservas() {
		return reservas;
	}

	public void setReservas(List<Localizaciones> reservas) {
		this.reservas = reservas;
	}

	public List<Animal> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Animal> mascotas) {
		this.mascotas = mascotas;
	}

	public void addMascotas(Animal m) {
		this.mascotas.add(m);
	}

	public void addReserva(Localizaciones l) {
		this.reservas.add(l);
	}

	public void addProducto(Productos p) {
		this.listaCompra.add(p);
	}

	public long getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasword() {
		return password;
	}

	public void setPasword(String pasword) {
		this.password = pasword;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", pasword=" + password + "]";
	}

}
