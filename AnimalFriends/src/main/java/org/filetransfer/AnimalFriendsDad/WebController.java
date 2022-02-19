package org.filetransfer.AnimalFriendsDad;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController{

	@RequestMapping("/")
	public String ventanaPrincipal(Model model, HttpServletRequest request) {
		//model.addAttribute("login",!request.isUserInRole("ADMIN") && !request.isUserInRole("USUARIO"));
		model.addAttribute("index");
		return "principal";
	}
	
}