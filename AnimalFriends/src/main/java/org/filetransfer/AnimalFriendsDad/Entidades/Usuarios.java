package org.filetransfer.AnimalFriendsDad.Entidades;


import java.util.List;

import javax.persistence.*;



@Entity
public class Usuarios {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String nombre;
	
	@Column(nullable = false)
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@OneToMany
	private List<Localizaciones> reservas;
	
	@OneToMany
	private List<Animal> mascotas;
	
	@ManyToMany
	private List<Productos> listaCompra;
	
	
	public Usuarios() {};
	
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

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", pasword=" + password + "]";
	}
	

}
