package org.filetransfer.AnimalFriendsDad;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String ventanaPrincipal(Model model, HttpServletRequest request) {
		model.addAttribute("sesion", null != request.getUserPrincipal());
		return "principal";
	}

	@GetMapping("/login")
	public String goToLogin(Model model, HttpServletRequest request) {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		
		model.addAttribute("incorrecto", false);
		return "loginWeb";
	}

	@GetMapping("/registrar")
	public String goToRegister(Model model, HttpServletRequest request) {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			model.addAttribute("token", token.getToken());
		}
		
		return "registerWeb";
	}


	@RequestMapping(value = "/registrarUsuario")
	public String registrar(Model model, @RequestParam String nombre, @RequestParam String psw,
			@RequestParam String pswRepeat, HttpSession session, HttpServletRequest request) {
		if (psw.equals(pswRepeat)) {
			boolean result = userService.registrar(nombre, passwordEncoder.encode(psw));
			if (result) {
				return "/";
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
	
	@GetMapping("/editarUsuario")
	public String editarUsuario(Model model) {

		return "edit_usuario";
	}
	
	
	@PostMapping("/verUsuario")
	public String visualizarUsuario(Model model, String nombre) {

		model.addAttribute("usuario", userService.getUsuario(nombre));
		
		Usuarios u = userService.getUsuario(nombre);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return "show_usuario";
	}
	

	@PostMapping("/aniadirMascota")
	public ModelAndView aniadirMascota(Model model, String masc, String nombre) {
		userService.registrarMascota(nombre, masc);
		model.addAttribute("usuario", userService.getUsuario(nombre));
		Usuarios u = userService.getUsuario(nombre);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return new ModelAndView("show_usuario");
		
	}

	@PostMapping("/aniadirReserva")
	public ModelAndView aniadirReserva(Model model, String lugar, String nombre) {
		userService.registrarReserva(nombre, lugar);
		model.addAttribute("usuario", userService.getUsuario(nombre));
		Usuarios u = userService.getUsuario(nombre);
		model.addAttribute("usuario", u);;
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return new ModelAndView("show_usuario");
		
	}

	@PostMapping("/aniadirProducto")
	public ModelAndView aniadirProducto(Model model, String producto, String nombre) {
		userService.registrarProducto(nombre, producto);
		model.addAttribute("usuario", userService.getUsuario(nombre));
		Usuarios u = userService.getUsuario(nombre);
		model.addAttribute("usuario", u);
		model.addAttribute("mascotas",u.getMascotas());
		model.addAttribute("reservas",u.getReservas());
		model.addAttribute("compra",u.getListaCompra());
		return new ModelAndView("show_usuario");
		
	}
	
	

}