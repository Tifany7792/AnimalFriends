package es.codeurjc.restspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CorreoController {
	@Autowired
	private Correo correo;
	
	@PostMapping("/usuarios/pedir/completar")
	public int send(@RequestBody(required=true) Usuarios user) {

		try {
			correo.enviarCorreo(user);
		} catch (MailException mailException) {
			return 1;
		}
		return 0;
	}
	
}
