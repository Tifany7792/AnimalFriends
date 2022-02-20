package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

//import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserService {

	@Autowired
	private RepositorioUsuarios usuarios;

	private Usuarios miUsuario;
	
	//private List<Animal> animales;

	@PostConstruct
	private void addAdmin() {
		Usuarios aux = new Usuarios("admin", "admin");
		Optional<Usuarios> u = usuarios.findByNombre(aux.getNombre());

		if (!u.isPresent()) {
			usuarios.save(aux);
		}
	}

	public boolean login(String nombre, String password) {
		Optional<Usuarios> u = usuarios.findByNombre(nombre);

		if (u.isPresent()) {
			if (u.get().getPasword().equals(password)) {
				miUsuario = u.get();
				return true;
			} else {
				miUsuario = null;
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registrar(String nombre, String password) {
		Optional<Usuarios> u = usuarios.findByNombre(nombre);

		if (!u.isPresent()) {
			miUsuario = new Usuarios(nombre, password);
			usuarios.save(miUsuario);
			return true;
		} else {
			miUsuario = null;
			return false;
		}
	}

	public void logout() {
		miUsuario = null;
	}

	public List<Usuarios> getAllUsers() {
		return usuarios.findAll();
	}

	public Usuarios getMiUsuario() {
		return miUsuario;
	}
	
	/*public List<Animal> getMisAnimales() {
		return animales;
	}*/

	public Usuarios getUsuario(long id) {
		Optional<Usuarios> usu = usuarios.findById(id);
		if (usu.isPresent())
			return usu.get();
		else
			return null;
	}

}
