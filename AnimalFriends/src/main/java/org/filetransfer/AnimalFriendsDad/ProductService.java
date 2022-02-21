package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

	@Autowired
	private RepositorioProductos productos;

	private Productos miProducto;


	public boolean login(String tipo, String usuario) {
		Optional<Productos> a = productos.findByTipo(tipo);

		if (a.isPresent()) {
			if (a.get().getUser().equals(usuario)) {
				miProducto = a.get();
				return true;
			} else {
				miProducto = null;
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registrarProducto(String tipo, String nombre) {
		Optional<Productos> a = productos.findByTipo(nombre);

		if (!a.isPresent()) {
			miProducto = new Productos(nombre, tipo);
			productos.save(miProducto);
			return true;
		} else {
			miProducto = null;
			return false;
		}
	}

	public void logout() {
		miProducto = null;
	}

	public List<Productos> getAllProducts() {
		return productos.findAll();
	}

	public Productos getMiProducto() {
		return miProducto;
	}

	public Productos getProducto(long id) {
		Optional<Productos> aux = productos.findById(id);
		if (aux.isPresent())
			return aux.get();
		else
			return null;
	}

}
