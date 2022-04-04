package org.filetransfer.AnimalFriendsDad;

import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalController {
	@Autowired
	private RepositorioAnimales animales;

	@Autowired
	private AnimalService animalService;

	@Autowired
	private UserService userService;


	@PostConstruct
	public void init() {
		animales.save(new Animal("Mono",
				"mono pequeño, en peligro de extinción, que come bichos y pequeños mamiferos"));
		animales.save(
				new Animal("erizo", "mamifero de la familia de los topos, con el cuerpo cubierto de puas"));

	}

	@GetMapping("/animales/new")
	public String createAnimal(Model model, HttpServletRequest request) {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		return "new_animal";
	}
	
	/*@RequestMapping("/animales/new")
	public String añadirMascota(Model model, @RequestParam String tipo) {
		
		if(!animalService.existeAnimal(tipo)) {
			Animal mascota=new Animal(tipo,animalService.getAnimal(tipo).getDescripcion());
			animalService.guardarAnimal(mascota);
					
		}else {
			List<Animal> mascotas = animalService.getAllAnimals();
			model.addAttribute("mascotas",mascotas);
			return "show_usuario";
		}
		
		List<Animal> mascotas = animalService.getAllAnimals();
		model.addAttribute("mascotas",mascotas);
		
		return "show_usuario";
	}*/

	@RequestMapping("/animales/{id}/añadir")
	public String tenerMascota(Model model, HttpServletRequest request, @PathVariable long id) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails uloggeado = (UserDetails) principal;
		Usuarios userIniciado = userService.getUsuario(uloggeado.getUsername());
		String nombre = userIniciado.getNombre();
		
		if (nombre != "") {
			Animal ani = animales.getById(id);
			userIniciado.addMascotas(ani);
			animalService.guardarAnimal(ani);
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
	

	@PostMapping("/animales/new/created")
	public String newAnimal(@RequestParam String tipo, @RequestParam String descripcion, HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails uloggeado = (UserDetails) principal;
		Usuarios userIniciado = userService.getUsuario(uloggeado.getUsername());
		Animal a = animales.save(new Animal(tipo, userIniciado, descripcion));
		if (userIniciado.getRoles().contains("ADMIN")) {
			userIniciado.addMascotas(a);
		}
		return "saved_animal";
	}

	@GetMapping("/animales")
	public String verAnimales(Model model, HttpServletRequest request) {
		model.addAttribute("animales", animales.findAll());
		model.addAttribute("permiso", permiso(request));
		return "list_animals";
	}

	private boolean permiso(HttpServletRequest request) {
		if (request.getUserPrincipal() == null) {
			return false;
		}

		return request.isUserInRole("ADMIN");
	}

	@GetMapping("/animales/{id}")
	public String showAnimal(Model model, @PathVariable long id) {
		Animal ani = animales.getById(id);

		model.addAttribute("animal", ani);

		return "show_animal";
	}

	@GetMapping("/animales/{id}/delete")
	public String deleteAnimal(Model model, @PathVariable long id) {
		animales.deleteById(id);

		return "deleted_animal";
	}

	/*@GetMapping("/animales/{id}/añadir")
	public String tenerMascota(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Animal a = animales.getById(id);
		userService.getUsuario(nombre).addMascotas(a);
		model.addAttribute("usuario", userService.getUsuario(nombre));
		model.addAttribute("mascotas", userService.getUsuario(nombre).getMascotas());
		model.addAttribute("reservas", userService.getUsuario(nombre).getReservas());
		model.addAttribute("compra", userService.getUsuario(nombre).getListaCompra());
		return "show_usuario";

	}*/

}