package org.filetransfer.AnimalFriendsDad;

import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
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
	
	@Autowired
	private UserService userService;

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

	@PostMapping("/localizaciones/new")
	public ResponseEntity<Localizaciones> createLocalizacion(@RequestBody Localizaciones loc) {
		localizaciones.save(loc);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/created").buildAndExpand(loc.getId())
				.toUri();
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
	
	
	
	private boolean permiso(HttpServletRequest request) {
		if (request.getUserPrincipal() == null) {
			return false;
		} else {
			request.isUserInRole("ADMIN");
		}
		return false;
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
	
	@GetMapping("/localizacion/{id}/añadir")
	public String hacerReserva(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		Localizaciones loc = localizaciones.getById(id);
		userService.añadirReserva(u, loc);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return "redirect:/usuario";
		
	}

}