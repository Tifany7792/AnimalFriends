package org.filetransfer.AnimalFriendsDad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

	private List<Animal> animales = new ArrayList<>();
	
	public WebController() {
		
		animales.add(new Animal("Perro"));
		animales.add(new Animal("Gato"));
		
	}
	
	@GetMapping("/")
	public String showAnimals(Model model) {
		
		model.addAttribute("animales", animales);
		
		return "index";
	}

	@GetMapping("/new_animal")
	public String newAnimal(Model model) {

		return "new_animal";
	}
	
	@PostMapping("/animal/new")
	public String newAnimal(Model model, Animal animal) {

		animales.add(animal);

		return "saved_animal";
	}

	@GetMapping("/animal/{numAnimal}")
	public String showAnimal(Model model, @PathVariable int numAnimal) {

		Animal animal = animales.get(numAnimal - 1);
		
		model.addAttribute("animal", animal);
		model.addAttribute("numAnimal", numAnimal);

		return "show_animal";
	}
	
	@GetMapping("/animal/{numAnimal}/delete")
	public String deleteAnimal(Model model, @PathVariable int numAnimal) {

		animales.remove(numAnimal - 1);

		return "deleted_animal";
	}
	
}