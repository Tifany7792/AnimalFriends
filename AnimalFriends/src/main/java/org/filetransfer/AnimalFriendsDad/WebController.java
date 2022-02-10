package org.filetransfer.AnimalFriendsDad;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController{

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private UserSession userSession;
	
	
	
	@GetMapping("/")
	public String showAnimals(Model model, HttpSession session) {
		
		model.addAttribute("animales", animalService.findAll());
		model.addAttribute("welcome", session.isNew());
		
		return "index";
	}

	@GetMapping("/new_animal")
	public String newAnimal(Model model) {

		return "new_animal";
	}
	
	@PostMapping("/animal/new")
	public String newAnimal(Model model, Animal animal) {

		animalService.save(animal);
		
		userSession.setUser(animal.getUser());
		userSession.incNumAnimals();
		
		model.addAttribute("numPosts", userSession.getNumAnimals());

		return "saved_animal";
	}

	@GetMapping("/animal/{id}")
	public String showAnimal(Model model, @PathVariable long id) {

		Animal animal = animalService.findById(id);
		
		model.addAttribute("animal", animal);

		return "show_animal";
	}
	
	@GetMapping("/animal/{id}/delete")
	public String deleteAnimal(Model model, @PathVariable long id) {

		animalService.deleteById(id);

		return "deleted_animal";
	}
	
}