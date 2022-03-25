package es.codeurjc.restspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CorreoController {
	@Autowired
	private Correo correo;
	
	@RequestMapping(method = RequestMethod.POST, value ="/usuarios/pedir/completar")
	public String send(@RequestBody Usuarios user) {

		try {
			correo.enviarCorreo(user);
		} catch (MailException mailException) {
			return "Error";
		}
		return "Tu pedido ha sido realizado con exito";
	}
	
}
