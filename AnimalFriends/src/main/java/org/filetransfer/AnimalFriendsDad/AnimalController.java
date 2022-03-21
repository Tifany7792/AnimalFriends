package org.filetransfer.AnimalFriendsDad;

import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {
	@Autowired
	private RepositorioAnimales animales;

	@PostConstruct
	public void init() {
		animales.save(new Animal("Mono",""));
		animales.save(new Animal("Erizo",""));
	}

	@GetMapping("/newAnimal")
	public String creeateAnimal(Model model, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		return "new_animal";
	}

	@PostMapping("/animal/new")
	public String newAnimal(Animal animal) {
		animales.save(animal);
		return "saved_animal";
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