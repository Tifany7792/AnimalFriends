<<<<<<< HEAD:AnimalFriends/src/main/java/org/filetransfer/AnimalFriendsDad/Usuarios.java
package org.filetransfer.AnimalFriendsDad;
=======
package org.filetransfer.AnimalFriendsDad.Entidades;
<<<<<<< HEAD:AnimalFriends/src/main/java/org/filetransfer/AnimalFriendsDad/Usuarios.java
>>>>>>> parent of a90dad4 (Intento 1 html usuarios):AnimalFriends/src/main/java/org/filetransfer/AnimalFriendsDad/Entidades/Usuarios.java
=======
>>>>>>> parent of a90dad4 (Intento 1 html usuarios):AnimalFriends/src/main/java/org/filetransfer/AnimalFriendsDad/Entidades/Usuarios.java

import javax.persistence.*;

@Entity
public class Usuarios {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@Column
	private String nombre;
	//@Column
	private String pasword;
	
	@OneToOne
	private Animal animal;
	

	public static int nUsuarios;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public static int getnUsuarios() {
		return nUsuarios;
	}

	public static void setnUsuarios(int nUsuarios) {
		Usuarios.nUsuarios = nUsuarios;
	}

	protected Usuarios() {};
	
	public Usuarios(String n, String p) {
		this.nombre = n;
		this.pasword = p;
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
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", pasword=" + pasword + "]";
	}
	
	public int compareTo(Object o) {
        Usuarios u;
        u = (Usuarios) o;
        return getNombre().compareTo(u.getNombre());
    }
	
	
	
	

}
