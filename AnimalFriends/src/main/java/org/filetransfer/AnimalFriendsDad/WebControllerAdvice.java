package org.filetransfer.AnimalFriendsDad;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class WebControllerAdvice {
	@ModelAttribute("userName")
	public String userName() {
	return "Jose";
	}
}
