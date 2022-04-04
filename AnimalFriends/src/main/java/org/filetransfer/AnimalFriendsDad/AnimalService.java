package org.filetransfer.AnimalFriendsDad;

//import java.io.File;
import java.util.List;
import java.util.Optional;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

	@Autowired
	private RepositorioAnimales animales;

	public boolean registrarAnimal(String tipo, String descripcion, String nombre) {
		Optional<Animal> a = animales.findByTipo(tipo);
		
		Animal miAnimal;
		if (!a.isPresent()) {
			miAnimal = new Animal(tipo,descripcion);
			animales.save(miAnimal);
			return true;
		} else {
			miAnimal = null;
			return false;
		}
	}
	
	public boolean existeAnimal(String tipo) {
		Optional<Animal> a = animales.findByTipo(tipo);
		if(a.isPresent()) {
			return true;
		}
		else
		{
			return false;
		}
	}

	public void guardarAnimal(Animal animal) {

		animales.save(animal);

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
