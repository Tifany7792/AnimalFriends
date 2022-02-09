package org.filetransfer.AnimalFriendsDad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	private Logger log = LoggerFactory.getLogger(WebController.class);	
	
	@GetMapping("/")
	public String page(Model model) {
		
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
		
		return "web_template";
	}
	
	@RequestMapping("/greeting")
	public String greeting(Model model, @RequestParam String userName, @RequestParam String re, @RequestParam String body) {
		
		model.addAttribute("name", userName);
		model.addAttribute("asunto", re);
		model.addAttribute("cuerpo", body);
		
		return "tablon";
	}
	
}