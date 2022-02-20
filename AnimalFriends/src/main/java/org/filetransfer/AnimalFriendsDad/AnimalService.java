package org.filetransfer.AnimalFriendsDad;

import java.util.List;
import java.util.Optional;


import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
import org.springframework.beans.factory.annotation.Autowired;

public class AnimalService {

	@Autowired
	private RepositorioAnimales animales;

	private Animal miAnimal;


	public boolean login(String tipo, String usuario) {
		Optional<Animal> a = animales.findByTipo(tipo);

		if (a.isPresent()) {
			if (a.get().getUser().equals(usuario)) {
				miAnimal = a.get();
				return true;
			} else {
				miAnimal = null;
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registrarAnimal(String tipo, String usuario) {
		Optional<Animal> a = animales.findByTipo(tipo);

		if (!a.isPresent()) {
			miAnimal = new Animal(tipo, usuario);
			animales.save(miAnimal);
			return true;
		} else {
			miAnimal = null;
			return false;
		}
	}

	public void logout() {
		miAnimal = null;
	}

	public List<Animal> getAllAnimals() {
		return animales.findAll();
	}

	public Animal getMiAnimal() {
		return miAnimal;
	}

	public Animal getAnimal(long id) {
		Optional<Animal> aux = animales.findById(id);
		if (aux.isPresent())
			return aux.get();
		else
			return null;
	}

}
