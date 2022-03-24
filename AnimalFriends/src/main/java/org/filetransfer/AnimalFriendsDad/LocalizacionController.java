package org.filetransfer.AnimalFriendsDad;


import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
	
	@PostMapping("/localizaciones/new")
	public ResponseEntity<Localizaciones> createAnimal(@RequestBody Localizaciones loc) {
		 localizaciones.save(loc);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/created").buildAndExpand(loc.getId()).toUri();
		 return ResponseEntity.created(location).body(loc);
		}

	
	@GetMapping("/localizaciones/{id}")
	public String showLocalizacion(Model model, @PathVariable long id) {

		Localizaciones loc = localizaciones.getById(id);
		
		model.addAttribute("local", loc);

		return "show_localizacion";
	}
	
	@GetMapping("/localizaciones/{id}/delete")
	public String deleteLocalizacion(Model model, @PathVariable long id) {

		
		localizaciones.deleteById(id);
		

		return "deleted_localizacion";
	}
	
//	@GetMapping("/localizaciones/new")
//	public String añadirLocalizacion(Model model, HttpServletRequest request) {
//		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//		if (token != null) {
//			model.addAttribute("token", token.getToken());
//		}
//		return "new_localizacion";
//	}
	
	@PostMapping("/localizacion/new/created")
	public String newLocalizacion(Localizaciones loc) {

		localizaciones.save(loc);
		
		return "saved_localizacion";
	}
	
}