package org.filetransfer.AnimalFriendsDad;


import java.net.URI;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class ProductosController {

	@Autowired
	private RepositorioProductos productos;
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
    public void init() {
		productos.save(new Productos("Pelota de goma", "Juguete"));
		productos.save(new Productos("Comida gato", "Comida"));
    }
	
	
	@GetMapping("/productos")
	public String verProductos(Model model) {
		
		model.addAttribute("prod", productos.findAll());
		
		return "list_productos";
	}
	
	@GetMapping("/productos/{id}")
	public String showProducto(Model model, @PathVariable long id) {

		
		Productos prod = productos.getById(id);
		
		model.addAttribute("prod", prod);

		return "show_producto";
	}
	
	@GetMapping("/produsctos/{id}/delete")
	public String deleteProducto(Model model, @PathVariable long id) {

		
		productos.deleteById(id);
		

		return "deleted_producto";
	}
	
	@GetMapping("/productos/new")
	public String añadirProducto(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		return "new_producto";
	}
	
	/*@PostMapping("/productos/new")
	public ResponseEntity<Productos> createLocalizacion(@RequestBody Productos prod) {
		productos.save(prod);
		URI producto = ServletUriComponentsBuilder.fromCurrentRequest().path("/created").buildAndExpand(prod.getId())
				.toUri();
		return ResponseEntity.created(producto).body(prod);
	}*/
	
	@PostMapping("/productos/new/created")
	public String newProducto(Productos prod) {

		productos.save(prod);
		
		return "saved_producto";
	}
	
	
	@PostMapping("/productos/{id}/añadir")
	public ModelAndView comprarProducto(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		Productos prod = productos.getById(id);
		userService.añadirProducto(u, prod);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return new ModelAndView("show_usuario");
		
	}
	
}