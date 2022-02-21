package org.filetransfer.AnimalFriendsDad.Entidades;


import java.util.List;
import java.util.Optional;

import javax.persistence.*;



@Entity
public class Usuarios {
	
	//public static final String T_USUARIOS = "Usuarios";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public static final String C_USUARIO = "nombre";
	@Column(name = C_USUARIO, unique = true)
	private String nombre;
	
	public static final String C_CONTRASEÑA = "contraseña";
	@Column(name = C_CONTRASEÑA,nullable = false)
	private String password;
	
	@OneToMany
	private List<Localizaciones> reservas;
	
	@OneToMany
	private List<Animal> mascotas;
	
	@ManyToMany
	private List<Productos> listaCompra;
	

	public static int nUsuarios;
	
	
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
	
	
	public static int getnUsuarios() {
		return nUsuarios;
	}

	public static void setnUsuarios(int nUsuarios) {
		Usuarios.nUsuarios = nUsuarios;
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
