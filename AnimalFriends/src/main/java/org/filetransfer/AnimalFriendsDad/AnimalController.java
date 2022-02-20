package org.filetransfer.AnimalFriendsDad;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

///

@Controller
public class AnimalController {

	@Autowired
	private RepositorioAnimales animales;
	
	
	@PostConstruct
    public void init() {
		animales.save(new Animal(null, "Mono"));
		animales.save(new Animal(null, "Erizo"));
    }
	
	@RequestMapping("/animales/nuevoAnimal")
	public void nuevoAnimal() {
		
		
		//return "animal_nuevo"
	}
	
	@GetMapping("/animales")
	public String verAnimales(Model model) {
		
		model.addAttribute("animales", animales.findAll());
		
		return "list_animals";
	}
	
	@GetMapping("/animal/{id}")
	public String showAnimal(Model model, @PathVariable long id) {

		
		Animal ani = animales.getById(id);
		
		model.addAttribute("animal", ani);

		return "show_animal";
	}
	
	
	
	@GetMapping("/animal/{id}/delete")
	public String deleteAnimal(Model model, @PathVariable long id) {

		
		animales.deleteById(id);
		

		return "deleted_animal";
	}
	
}