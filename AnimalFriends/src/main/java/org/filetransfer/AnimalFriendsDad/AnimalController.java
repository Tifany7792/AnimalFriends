package org.filetransfer.AnimalFriendsDad;

import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioAnimales;
//import org.hibernate.engine.jdbc.BlobProxy;

//import java.io.File;
//import java.io.IOException;
//import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
//import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class AnimalController {
	@Autowired
	private RepositorioAnimales animales;
	
	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {

		animales.save(new Animal("Mono", "mono pequeño, en peligro de extinción, que come bichos y pequeños mamiferos",
				"capuchilo.jpg"));
		animales.save(new Animal("erizo", "mamifero de la familia de los topos, con el cuerpo cubierto de puas",
				"erizo.jpg"));

	}

	/*
	 * @GetMapping("/animales/new") public String createAnimal(Model model,
	 * HttpServletRequest request) {
	 * 
	 * CsrfToken token = (CsrfToken) request.getAttribute("_csrf"); if (token !=
	 * null) { model.addAttribute("token", token.getToken()); } return "new_animal";
	 * }
	 */

	@PostMapping("/animales/new/created")
	public String newAnimal(@RequestParam String tipo, @RequestParam String descripcion,
			@RequestParam String imageFile) {
		animales.save(new Animal(tipo, descripcion, imageFile));
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
		} else {
			request.isUserInRole("ADMIN");
		}
		return false;
	}

	/*
	 * @PostMapping("/{id}/image") public ResponseEntity<Object>
	 * uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
	 * throws IOException { Animal animal = animales.findById(id).orElseThrow(); URI
	 * location = fromCurrentRequest().build().toUri();
	 * animal.setImage(location.toString());
	 * animal.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(),
	 * imageFile.getSize())); animales.save(animal); return
	 * ResponseEntity.created(location).build(); }
	 */

	@GetMapping("/animales/{id}")
	public String showAnimal(Model model, @PathVariable long id) {
		Animal ani = animales.getById(id);

		model.addAttribute("animal", ani);

		return "show_animal";
	}

//	@GetMapping("/animales/{id}")
//	public  ResponseEntity<Animal> getAnimal(@PathVariable long id) {
//		Animal ani = animales.getById(id);
//
//		if (ani != null) {
//			return ResponseEntity.ok(ani);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

	/*@PostMapping("/animales/new")
	public ResponseEntity<Animal> createLocalizacion(@RequestBody Animal ani) {
		animales.save(ani);
		URI animal = ServletUriComponentsBuilder.fromCurrentRequest().path("/created").buildAndExpand(ani.getId())
				.toUri();
		return ResponseEntity.created(animal).body(ani);
	}*/

	@GetMapping("/animales/{id}/delete")
	public String deleteAnimal(Model model, @PathVariable long id) {
		animales.deleteById(id);

		return "deleted_animal";
	}
	
	@GetMapping("/animales/{id}/añadir")
	public String hacerReserva(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		Animal a = animales.getById(id);
		userService.añadirMascota(u, a);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return "redirect:/usuario";
		
	}
	
	
	
}