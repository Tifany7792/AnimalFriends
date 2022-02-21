package org.filetransfer.AnimalFriendsDad;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocalizacionController {

	@Autowired
	private RepositorioLocalizaciones localizaciones;
	
	
	@PostConstruct
    public void init() {
		localizaciones.save(new Localizaciones("Hotel Perruno", "Hotel"));
		localizaciones.save(new Localizaciones("Piscinas PetFriends", "Ocio"));
    }
	
	
	@GetMapping("/localizaciones")
	public String verLocalizaciones(Model model) {
		
		model.addAttribute("local", localizaciones.findAll());
		
		return "list_localizaciones";
	}
	
	@GetMapping("/local/{id}")
	public String showLocalizacion(Model model, @PathVariable long id) {

		
		Localizaciones loc = localizaciones.getById(id);
		
		model.addAttribute("local", loc);

		return "show_localizacion";
	}
	
	@GetMapping("/local/{id}/delete")
	public String deleteLocalizacion(Model model, @PathVariable long id) {

		
		localizaciones.deleteById(id);
		

		return "deleted_localizacion";
	}
	
	@GetMapping("/newLocalizacion")
	public String deleteAnimal() {

		return "new_localizacion";
	}
	
	@PostMapping("/localizacion/new")
	public String newAnimal(Localizaciones loc) {

		localizaciones.save(loc);
		
		return "saved_localizacion";
	}
	
}