package org.filetransfer.AnimalFriendsDad;

import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
//import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
//import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioLocalizaciones;
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
	private UserService userService;
	
	@Autowired
	private LocalizacionService locaService;

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
		Usuarios u = userService.getUsuario(nombre);
		if (permiso(request)) {
			u.addReserva(loc);
		}
		
		return "saved_localizacion";
	}
	
	/*@GetMapping("/localizacion/{id}/añadir")
	public String hacerReserva(Model model, HttpServletRequest request, @PathVariable long id) {
		Usuarios u = dameUsuario (request);
		Localizaciones loc = localizaciones.getById(id);
		userService.añadirReserva(u, loc);
		mostrarDatos(model, request);
		return "show_usuario";
		
	}*/
	
	@RequestMapping("/localizacion/{id}/añadir")
	public String hacerReserva(Model model, HttpServletRequest request, @PathVariable long id) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails uloggeado = (UserDetails) principal;
		Usuarios userIniciado = userService.getUsuario(uloggeado.getUsername());
		String nombre = userIniciado.getNombre();
		
		if (nombre != "") {
			Localizaciones l = localizaciones.getById(id);
			userIniciado.addReserva(l);
			locaService.guardarLocalizacion(l);
		}
		mostrarDatos(model, request);
		return "show_usuario";
	}
	
	private void mostrarDatos(Model model, HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails uloggeado = (UserDetails) principal;
		Usuarios u = userService.getUsuario(uloggeado.getUsername());
		
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas", u.getMascotas());
		model.addAttribute("reservas", u.getReservas());
		model.addAttribute("compra", u.getListaCompra());
	}
	
	private Usuarios dameUsuario(HttpServletRequest request) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		return u;
	}
	
}