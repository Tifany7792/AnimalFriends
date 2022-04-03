package org.filetransfer.AnimalFriendsDad.Entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String nombre;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String correo;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private List<Localizaciones> reservas;

	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private List<Animal> mascotas;

	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private List<Productos> listaCompra;

	public Usuarios() {
	};

	public Usuarios(String n, String p) {
		super();
		this.nombre = n;
		this.password = p;
		String r = "USER";
		this.roles = List.of(r);
		this.listaCompra = new ArrayList<Productos>();
		this.mascotas = new ArrayList<Animal>();
		this.reservas = new ArrayList<Localizaciones>();
		this.correo = "estefaniadominguez7792@hotmail.com";
	}

	public Usuarios(String nombre, String password, String... roles) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.roles = List.of(roles);
		this.listaCompra = new ArrayList<Productos>();
		this.mascotas = new ArrayList<Animal>();
		this.reservas = new ArrayList<Localizaciones>();
		this.correo = "estefaniadominguez7792@hotmail.com";
	}

	public Usuarios(String nombre, String password, List<String> roles) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.roles = roles;
		this.listaCompra = new ArrayList<Productos>();
		this.mascotas = new ArrayList<Animal>();
		this.reservas = new ArrayList<Localizaciones>();
		this.correo = "estefaniadominguez7792@hotmail.com";
	}

	public Usuarios(String nombre, String password, List<String> roles, String email) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.roles = roles;
		this.listaCompra = new ArrayList<Productos>();
		this.mascotas = new ArrayList<Animal>();
		this.reservas = new ArrayList<Localizaciones>();
		this.correo = email;
	}

	public List<Localizaciones> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Localizaciones> reservas) {
		this.reservas = reservas;
	}

	public List<Animal> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Animal> mascotas) {
		this.mascotas = mascotas;
	}

	public List<Productos> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Productos> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public void addMascotas(Animal m) {
		if (!mascotas.contains(m)) {
			this.mascotas.add(m);
		}
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void addReserva(Localizaciones l) {
		if (!reservas.contains(l)) {
			this.reservas.add(l);
		}
	}

	public void addProducto(Productos p) {
		if (!listaCompra.contains(p)) {
			this.listaCompra.add(p);
		}
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

	public boolean RegistrarMascota(Animal m) {
		boolean insertado = false;
		for (Animal a : getMascotas()) {
			if (mascotas.equals(m))
				return insertado;
		}
		insertado = mascotas.add(m);
		return insertado;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + "]";
	}

}
