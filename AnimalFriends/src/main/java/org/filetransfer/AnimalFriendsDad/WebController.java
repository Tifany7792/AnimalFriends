package org.filetransfer.AnimalFriendsDad;

import javax.servlet.http.HttpSession;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ModelAndView registrar(Model model, @RequestParam String nombre, @RequestParam String psw,
			@RequestParam String pswRepeat, HttpSession session) {
		if (psw.equals(pswRepeat)) {
			boolean result = userService.registrar(nombre, psw);
			if (result) {
				session.setAttribute("nombre", nombre);
				session.setAttribute("logged", "yes");
				model.addAttribute("sesion", true);
				return new ModelAndView("principal");
			} else {
				model.addAttribute("nombreUsado", true);
				return new ModelAndView("registerWeb");
			}
		} else {
			model.addAttribute("contrasenaIncorrecta", true);
			return new ModelAndView("registerWeb");
		}
	}

	@GetMapping("/logout")
	public ModelAndView logout(Model model, HttpSession session) {
		userService.logout();
		session.setAttribute("logged", "no");
		model.addAttribute("sesion", false);
		return new ModelAndView("redirect:/");
	}
	
	
	/*@RequestMapping(value = "/registrarAnimal")
	public ModelAndView registrarAnimal(@RequestParam String tipo) {
		
		Usuarios miUsuario = userService.getMiUsuario();
		
		if (miUsuario.getAnimal().getTipo().equals(tipo)) {
			boolean result = animalService.registrarAnimal(tipo,miUsuario.getNombre());
			if (result) {
				return new ModelAndView("redirect:/");
			} else {
				return new ModelAndView("redirect:/registrarAnimal");
			}
		} else {
			return new ModelAndView("redirect:/registrarAnimal");
		}
	}*/

}