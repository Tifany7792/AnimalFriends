package es.codeurjc.restspring;

import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

@Service
public class Correo {
	
	private JavaMailSender javaMailSender;
	
	public void enviarCorreo (Usuarios user) {
		
		SimpleMailMessage correo = new SimpleMailMessage();
		correo.setTo(user.getCorreo());
		correo.setSubject("Tu pedido");
		String cuerpo = "Hola " + user.getNombre() +",\n"+ "Gracias por realizar tu pedido. "
				+ "A continuación te enviamos una copia de los productos que has solicitado:\n"
				+ user.getListaCompra().toString() + "\n" + "Esperamos verle de nuevo," +
				"AnimalFriends";
		correo.setText(cuerpo);
		
		javaMailSender.send(correo);
	}
}
