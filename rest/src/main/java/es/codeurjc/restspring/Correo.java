package es.codeurjc.restspring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

@Component
public class Correo {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarCorreo(Usuarios u) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo(u.getNombre()); 
        message.setSubject("Su pedido"); 
        message.setText("Gracias por confiar en nosotros. Copia del pedido: \n" + u.getListaCompra().toString());
        emailSender.send(message);
    }
}
