package org.filetransfer.AnimalFriendsDad;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductosController {

	@Autowired
	private RepositorioProductos productos;
	
	
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
	
	@GetMapping("/prod/{id}")
	public String showProducto(Model model, @PathVariable long id) {

		
		Productos prod = productos.getById(id);
		
		model.addAttribute("prod", prod);

		return "show_producto";
	}
	
	@GetMapping("/prod/{id}/delete")
	public String deleteProducto(Model model, @PathVariable long id) {

		
		productos.deleteById(id);
		

		return "deleted_producto";
	}
	
	@GetMapping("/newProducto")
	public String añadirProducto(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		return "new_producto";
	}
	
	@PostMapping("/producto/new")
	public String newProducto(Productos prod) {

		productos.save(prod);
		
		return "saved_producto";
	}
	
}