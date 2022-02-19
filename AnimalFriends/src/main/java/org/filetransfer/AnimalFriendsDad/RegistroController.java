/*package org.filetransfer.AnimalFriendsDad;

import javax.annotation.PostConstruct;

import org.filetransfer.AnimalFriendsDad.Entidades.Usuarios;
import org.filetransfer.AnimalFriendsDad.Repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistroController {
	@Autowired
	private RepositorioUsuarios usuario;
	
	@PostConstruct
	public void init() {
		
	}
	
	@GetMapping("/registrado")
	public String creandoAlmacer(Model model,
			@RequestParam String nombre, @RequestParam String pasword) {
		
		String mensaje = "";
		
		if(nombre == "") {
			mensaje ="El nombre de usuario tiene que tener almenos un caracter";
			model.addAttribute("mensaje", mensaje);
			return "registro";
		}
		
		if(pasword == "") {
			mensaje ="La contraseña tiene que tener almenos un caracter";
			model.addAttribute("mensaje", mensaje);
			return "registro";
		}
		
		if(pasword.length()<7) {
			mensaje = "La contraseña debe tener almenos 7 carácteres";
			model.addAttribute("mensaje", mensaje);
			return "registro";
		}
		
		//Usuarios usu = new Usuarios("Pepe","123");
		Usuarios usu = usuario.findByNombre(nombre);
		
		if(usu != null) {
			mensaje = "Usuario ya está registrado";
			model.addAttribute("mensaje", mensaje);
			return "registrado";
		}
		
		Usuarios usu2 = new Usuarios(nombre,pasword);
		usuario.save(usu2);
		
		mensaje="Usuario registrado correctamente";
		model.addAttribute("mensaje", mensaje);
		return "index";
				
	}
}*/
