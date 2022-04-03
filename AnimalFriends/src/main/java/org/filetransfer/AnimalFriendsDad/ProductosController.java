package org.filetransfer.AnimalFriendsDad;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Localizaciones;
import org.filetransfer.AnimalFriendsDad.Entidades.Productos;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioProductos;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
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

@Controller
public class ProductosController {

	@Autowired
	private RepositorioProductos productos;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private RepositorioUsuarios usuarios;
	
	@PostConstruct
    public void init() {
		
		productos.save(new Productos("Pelota de goma","Juguete","admin"));
		productos.save(new Productos("Comida gato", "Comida","admin"));
    }
	
	
	@GetMapping("/productos")
	public String verProductos(Model model, HttpServletRequest request) {
		
		model.addAttribute("prod", productos.findAll());
		model.addAttribute("permiso", permiso(request));
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
	
	
	@PostMapping("/productos/new/created")
	public String newProducto(Productos prod, HttpServletRequest request) {

		productos.save(prod);
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		if (permiso(request)) {
			u.addProducto(prod);
		}
		
		return "saved_producto";
	}
	
	public boolean añadirProducto(Usuarios u, Productos p) {
		u.addProducto(p);
		return true;
	}
	
	
	/*@GetMapping("/productos/{id}/añadir")
	public String comprarProducto(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = usuarios.findByNombre(nombre).get();
		Productos prod = productos.getById(id);
		usuarios.findByNombre(nombre).get().addProducto(prod);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return "show_usuario";
		
	}*/
	
	@RequestMapping("/productos/{id}/añadir")
	public String comprarProducto(Model model, HttpServletRequest request, @PathVariable long id) {
			
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails uloggeado = (UserDetails) principal;
		Usuarios userIniciado = userService.getUsuario(uloggeado.getUsername());
		String nombre = userIniciado.getNombre();
		if (nombre != "") {
			Productos p = productos.getById(id);
			userIniciado.addProducto(p);
			prodService.guardarProducto(p);
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
	
	
	/*@GetMapping("/productos/{id}/añadir")
	public String comprarProducto(Model model, HttpServletRequest request, @PathVariable long id) {
		String nombre = request.getUserPrincipal().getName();
		Usuarios u = userService.getUsuario(nombre);
		Productos prod = productos.getById(id);
		userService.añadirProducto(u, prod);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return "show_usuario";
		
	}*/
	
	private boolean permiso(HttpServletRequest request) {
		if (request.getUserPrincipal() == null) {
			return false;
		} 
		return request.isUserInRole("ADMIN");
	}
}