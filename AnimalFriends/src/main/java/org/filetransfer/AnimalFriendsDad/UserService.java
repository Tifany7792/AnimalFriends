package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.io.File;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
//import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
//import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
//import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

@Component
@SessionScope
public class UserService {

	@Autowired
	private RepositorioUsuarios usuarios;
	@Autowired
	private RepositorioAnimales mascotas;
	@Autowired
	private RepositorioLocalizaciones reservas;
	@Autowired 
	private RepositorioProductos listaCompra;

	private Usuarios miUsuario;
	
	private Animal animal;
	
	
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
		return (List<Usuarios>) usuarios.findAll();
	}

	public Usuarios getMiUsuario() {
		return miUsuario;
	}
	

	public Usuarios getUsuario(long id) {
		Optional<Usuarios> usu = usuarios.findById(id);
		if (usu.isPresent())
			return usu.get();
		else
			return null;
	}
	
	public Usuarios getUsuario(String nombre) {
		Optional<Usuarios> usu = usuarios.findByNombre(nombre);
		if (usu.isPresent())
			return usu.get();
		else
			return null;
	}
	
	public List<Animal> getMascotas(long id){
		return usuarios.findByMascotasTipo(id);
	}
	
	public List<Localizaciones> getReservas(long id){
		return usuarios.findByReservasNombreSitio(id);
	}
	
	public List<Productos> getListaCompra(long id){
		return usuarios.findByListaCompraNombre(id);
	}

	
	public boolean registrarMascota(String user, String tipo, String descripcion,String imagen) {
		Optional<Animal> a = mascotas.findByTipo(tipo);
		Optional<Usuarios> u = usuarios.findByNombre(user);
		Animal animal;
		Usuarios usuario;
		if (!a.isPresent()) {
			animal = new Animal(tipo, descripcion,imagen);
			mascotas.save(animal);
		}else {
			animal = a.get();
		}
		if (!u.isPresent()) {
			usuario = new Usuarios(user,"0000");
		}else {
			usuario = u.get();
		}
		usuario.addMascotas(animal);
		usuarios.save(usuario);
		return true;
	}
	
	public boolean registrarProducto(String user, String producto) {
		Optional<Productos> p = listaCompra.findByNombre(producto);
		Optional<Usuarios> u = usuarios.findByNombre(user);
		Productos prod;
		Usuarios usuario;
		if (!p.isPresent()) {
			prod = new Productos(producto,"generico");
			listaCompra.save(prod);
		}else {
			prod = p.get();
		}
		if (!u.isPresent()) {
			usuario = new Usuarios(user,"0000");
		}else {
			usuario = u.get();
		}
		usuario.addProducto(prod);
		usuarios.save(usuario);
		return true;
	}
	
	public boolean registrarReserva(String user, String lugar) {
		Optional<Localizaciones> l = reservas.findByNombreSitio(lugar);
		Optional<Usuarios> u = usuarios.findByNombre(user);
		Localizaciones local;
		Usuarios usuario;
		if (!l.isPresent()) {
			local = new Localizaciones(lugar,"generico");
			reservas.save(local);
		}else {
			local = l.get();
		}
		if (!u.isPresent()) {
			usuario = new Usuarios(user,"0000");
		}else {
			usuario = u.get();
		}
		usuario.addReserva(local);
		usuarios.save(usuario);
		return true;
	}

}
