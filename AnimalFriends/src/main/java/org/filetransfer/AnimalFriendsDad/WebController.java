package org.filetransfer.AnimalFriendsDad;



import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Animal;
import org.springframework.beans.factory.annotation.Autowired;
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
	private UserService userService;

	@GetMapping("/")
	public String ventanaPrincipal(Model model, HttpSession session) {

		if (session.getAttribute("logged") == "yes") {
			model.addAttribute("Usuarios", true);
		}
		return "principal";
	}

	@GetMapping("/login")
	public String goToLogin(Model model) {
		model.addAttribute("incorrecto", false);
		return "loginWeb";
	}

	@GetMapping("/registrar")
	public String goToRegister() {
		return "registerWeb";
	}

	@RequestMapping(value = "/loginUsuario")
	public String login(Model model, @RequestParam String nombre, @RequestParam String psw, HttpSession session) {
		boolean result = userService.login(nombre, psw);
		if (result) {
			session.setAttribute("nombre", nombre);
			session.setAttribute("logged", "yes");
			model.addAttribute("sesion", true);
			return "principal";
		} else {
			model.addAttribute("incorrecto", true);
			return "loginWeb";
		}
	}

	@RequestMapping(value = "/registrarUsuario")
	public String registrar(Model model, @RequestParam String nombre, @RequestParam String psw,
			@RequestParam String pswRepeat, HttpSession session) {
		if (psw.equals(pswRepeat)) {
			boolean result = userService.registrar(nombre, psw);
			if (result) {
				session.setAttribute("nombre", nombre);
				session.setAttribute("logged", "yes");
				model.addAttribute("sesion", true);
				return "principal";
			} else {
				model.addAttribute("nombreUsado", true);
				return "registerWeb";
			}
		} else {
			model.addAttribute("contrasenaIncorrecta", true);
			return "registerWeb";
		}
	}

	@GetMapping("/logout")
	public ModelAndView logout(Model model, HttpSession session) {
		
		session.setAttribute("logged", "no");
		model.addAttribute("sesion", false);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/verUsuario")
	public String visualizarUsuario(Model model, String nombre) {

		model.addAttribute("usuario", userService.getUsuario(nombre));
		return "show_usuario";
	}
	
	@GetMapping("/editarUsuario")
	public String editarUsuario(Model model) {

		return "edit_usuario";
	}
	
	@PostMapping("/aniadirMascota")
	public ModelAndView añadirMascota(Model model, String masc, String nombre) {
		userService.registrarMascota(nombre, masc);
		model.addAttribute("usuario", userService.getUsuario(nombre));
		return new ModelAndView("show_usuario");
		
	}
	
	

}