package org.filetransfer.AnimalFriendsDad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class WebController {
	
	private Logger log = LoggerFactory.getLogger(WebController.class);
<<<<<<< Updated upstream
	DataBaseUsage bbdd = new DataBaseUsage();
=======
	
>>>>>>> Stashed changes
	@GetMapping("/AnimalFriends")
	public String page(Model model) {
		
		


		
		bbdd.init();
		
		System.out.print(bbdd.toString());
		
		return "web_template";
	}
	
<<<<<<< HEAD
	/*
=======
<<<<<<< Updated upstream
>>>>>>> branch 'main' of git@github.com:Tifany7792/animalfriends.git
	@RequestMapping("/bbdd")
	public String nombre(Model model, @RequestParam long name) {
		model.addAttribute("name", bbdd.getItem(name));
		return "nombre";
	}*/
}

/*
@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(Model model) {

		model.addAttribute("name", "Mundo");

		return "greeting_template";
=======
	@RequestMapping("/Nombre")
	public String saludo(Model model, @RequestParam String name) {
		
		model.addAttribute("name", name);
		
		return "nombre";
>>>>>>> Stashed changes
	}
}