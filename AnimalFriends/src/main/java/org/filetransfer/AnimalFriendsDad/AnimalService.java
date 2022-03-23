package org.filetransfer.AnimalFriendsDad;

import java.io.File;
import java.util.List;
import java.util.Optional;


import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class AnimalService {

	@Autowired
	private RepositorioAnimales animales;

	public boolean registrarAnimal(String tipo, String descripcion, File imagen) {
		Optional<Animal> a = animales.findByTipo(tipo);
		Animal miAnimal;
		if (!a.isPresent()) {
			miAnimal = new Animal(tipo, descripcion, imagen);
			animales.save(miAnimal);
			return true;
		} else {
			miAnimal = null;
			return false;
		}
	}


	public List<Animal> getAllAnimals() {
		return animales.findAll();
	}


	public Animal getAnimal(long id) {
		Optional<Animal> aux = animales.findById(id);
		if (aux.isPresent())
			return aux.get();
		else
			return null;
	}
	
	public Animal getAnimal(String name) {
		Optional<Animal> aux = animales.findByTipo(name);
		if (aux.isPresent())
			return aux.get();
		else
			return null;
	}

}
