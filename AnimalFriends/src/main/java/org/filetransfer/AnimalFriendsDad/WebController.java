package org.filetransfer.AnimalFriendsDad;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
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
	private UserService userService;
	
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
	
	@GetMapping("/new_usuario")
	public String newUsuario(Model model) {

		return "new_usuario";
	}
	
	@PostMapping("/animal/new")
	public String newAnimal(Model model, Animal animal) {

		animalService.save(animal);
		
		userSession.setUser(animal.getUser());
		userSession.incNumAnimals();
		
		model.addAttribute("numPosts", userSession.getNumAnimals());

		return "saved_animal";
	}
	
	@PostMapping("/usuario/new")
	public String newUsu(Model model, Usuarios usu) {

		if (userService.existeUsuario(usu.getNombre())) {
			return "/new_usuario";
		}
		userService.save(usu);
		
		userSession.setUser(usu.getNombre());
		
		model.addAttribute("numAni", userSession.getNumAnimals());

		return "saved_user";
	}

	@GetMapping("/usu/{id}")
	public String showUsu(Model model, @PathVariable long id) {

		Usuarios usu = userService.findById(id);
		
		model.addAttribute("nombre", usu);

		return "show_usuario";
	}
	
	@GetMapping("/animal/{id}/delete")
	public String deleteAnimal(Model model, @PathVariable long id) {

		animalService.deleteById(id);

		return "deleted_animal";
	}
	
}