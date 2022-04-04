package org.filetransfer.AnimalFriendsDad;



import org.springframework.web.client.RestTemplate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String ventanaPrincipal(Model model, HttpServletRequest request) {
		
		model.addAttribute("sesion", null != request.getUserPrincipal());
		
		return "principal1";
	}

	@GetMapping("/login")
	public String goToLogin(Model model, HttpServletRequest request) {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		
		model.addAttribute("incorrecto", false);
		return "indexPrueba";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		model.addAttribute("sesion", null != request.getUserPrincipal());
		return "redirect:/home";
	}

	@GetMapping("/registrar")
	public String goToRegister(Model model, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		
		return "registerWeb";
	}
	
	@RequestMapping(value = "/registrar/usuario")
	public String registrar(Model model, @RequestParam String nombre, @RequestParam String psw,
			@RequestParam String pswRepeat, HttpSession session, HttpServletRequest request) {
		
		if (psw.equals(pswRepeat)) {
			
			boolean result = userService.registrar(nombre, passwordEncoder.encode(psw));
			if (result) {
				
				model.addAttribute("sesion", false);
				return "redirect:/home";
				
			} else {
				model.addAttribute("nombreUsado", true);

				CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
				if (token != null) {
					model.addAttribute("token", token.getToken());
				}
				
				return "registerWeb";
			}
		} else {
			
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			if (token != null) {
				model.addAttribute("token", token.getToken());
			}
			
			model.addAttribute("contrasenaIncorrecta", true);
			
			return "registerWeb";
		}
	}
		
	
	@GetMapping("/usuario")
	public String visualizarUsuario(Model model, HttpServletRequest request) {
		
		if(null != request.getUserPrincipal()) {
			
			mostrarDatos(model, request);
			return "show_usuario";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping ("/usuario/pedir")
	public String pedir(Model model, HttpServletRequest request) {
		
		
		Usuarios u = dameUsuario(request);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://127.0.0.1:8080/usuarios/pedir/completar", u, int.class);
		
		return "redirect:/gracias";
		
	}
	
	@GetMapping ("/usuario/reservar")
	public String reservar(Model model, HttpServletRequest request) {
		
		Usuarios u = dameUsuario(request);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://127.0.0.1:8080/usuarios/reservar/completar", u, int.class);
		
		return "redirect:/gracias";
		
	}
	
	@GetMapping ("gracias")
	public String gracias(Model model, HttpServletRequest request) {
		
		Usuarios u = dameUsuario(request);
		model.addAttribute("usuario", u);
		return "gracias";
		
	}
	
	
	private void mostrarDatos(Model model, HttpServletRequest request) {
		Usuarios u = dameUsuario(request);
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