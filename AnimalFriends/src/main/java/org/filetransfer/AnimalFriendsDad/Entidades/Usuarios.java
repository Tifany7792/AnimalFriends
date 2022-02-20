package org.filetransfer.AnimalFriendsDad.Entidades;


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
	
	
	//public static final String C_HABILITADO = "habilitado";
	//@Column(name = C_HABILITADO)
	
	//private boolean enabled = true;
	
	///@OneToOne
	//private Animal animal;
	

	public static int nUsuarios;
	
	
	public Usuarios() {};
	
	public Usuarios(String n, String p) {
		this.nombre = n;
		this.password = p;
	}
	
	
	/*
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}*/

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
