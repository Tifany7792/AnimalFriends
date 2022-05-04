package org.filetransfer.AnimalFriendsDad;

import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

//import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
//import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class LocalizacionController {

	@Autowired
	private RepositorioLocalizaciones localizaciones;
	
	@Autowired
	private RepositorioUsuarios repusu;
	

	@PostConstruct
	public void init() {
		localizaciones.save(new Localizaciones("Hotel Perruno", "Hotel"));
		localizaciones.save(new Localizaciones("Piscinas PetFriends", "Ocio"));
	}

	@GetMapping("/localizaciones")
	public String verLocalizaciones(Model model, HttpServletRequest request) {

		model.addAttribute("local", localizaciones.findAll());
		model.addAttribute("permiso", permiso(request));
		return "list_localizaciones";
	}


	@GetMapping("/localizaciones/{id}")
	public String showLocalizacion(Model model, HttpServletRequest request, @PathVariable long id) {

		Localizaciones loc = localizaciones.getById(id);

		model.addAttribute("local", loc);
		model.addAttribute("permiso", permiso(request));

		return "show_localizacion";
	}

	@GetMapping("/localizaciones/{id}/delete")
	public String deleteLocalizacion(Model model, @PathVariable long id) {

		localizaciones.deleteById(id);

		return "deleted_localizacion";
	}
	
	private boolean permiso(HttpServletRequest request) {
		if (request.getUserPrincipal() == null) {
			return false;
		}
		return request.isUserInRole("ADMIN");

	}
	
	@GetMapping("/localizaciones/new")
	public String añadirLocalizacion(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		return "new_localizacion";
	}

	@PostMapping("/localizacion/new/created")
	public String newLocalizacion(Localizaciones loc, HttpServletRequest request) {

		localizaciones.save(loc);
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = repusu.findByNombre(nombre).get();
		if (permiso(request)) {
			u.addReserva(loc);
		}
		
		return "saved_localizacion";
	}
	
	@RequestMapping("/localizacion/{id}/añadir")
	public String hacerReserva(Model model, HttpServletRequest request, @PathVariable long id) {
		
		String nombre = request.getUserPrincipal().getName();
		Usuarios userIniciado = repusu.findByNombre(nombre).get();
		
		if (nombre != "") {
			Localizaciones l = localizaciones.getById(id);
			userIniciado.addReserva(l);
			localizaciones.save(l);
		}
		return "redirect:/usuario";
	}
	
	
}