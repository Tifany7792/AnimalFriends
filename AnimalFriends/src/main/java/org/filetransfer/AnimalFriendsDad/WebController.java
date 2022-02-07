package org.filetransfer.AnimalFriendsDad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class WebController {
	private Logger log = LoggerFactory.getLogger(WebController.class);
	@GetMapping("/AnimalFriends")
	public String page(Model model) {
		
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
		
		//prueba de asignacion de variables al html
		model.addAttribute("name", "Mundo");
		//prueba de asignacion de booleanos a html
		model.addAttribute("hello", true);
		
		//prueba de creacion de una lista de animales
		List<String> animales = Arrays.asList("Perro","Gato","Erizo");
		model.addAttribute("animales", animales);
		
		//prueba de una iteracion de objetos
		List<Animal> lAnimales = new ArrayList<>();
		lAnimales.add(new Animal("Perro"));
		lAnimales.add(new Animal("Gato"));
		lAnimales.add(new Animal("Erizo"));
		model.addAttribute("lAnimales", lAnimales);


		 
		return "web_template";
	}
}

/*
@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(Model model) {

		model.addAttribute("name", "Mundo");

		return "greeting_template";
	}

}
*/