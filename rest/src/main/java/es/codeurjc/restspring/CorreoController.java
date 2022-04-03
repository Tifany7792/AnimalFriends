package es.codeurjc.restspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> sendPedido(@RequestBody(required=true) Usuarios user) {
		System.out.println("enviando");
		try {
			correo.enviarPedido(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return  ResponseEntity.ok("Correo notificación pedido realizado");
	}
	
	@PostMapping("/usuarios/reservar/completar")
	public ResponseEntity<String> sendReserva(@RequestBody(required=true) Usuarios user) {
		System.out.println("enviando");
		try {
			correo.enviarReserva(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return  ResponseEntity.ok("Correo notificación reserva realizada");
	}
	
	
}
