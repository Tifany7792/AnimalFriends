package es.codeurjc.restspring;

import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

@Component
public class Correo {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarPedido(Usuarios u) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("animalfriendsdad@gmail.com");
        message.setTo(u.getCorreo()); 
        message.setSubject("Su pedido"); 
        message.setText("¡AnimalFriends!\n"+"Gracias por confiar en nosotros. Copia del pedido: \n" + u.getListaCompra().toString());
        emailSender.send(message);
        System.out.println("Enviado");
    }
    
    public void enviarReserva(Usuarios u) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("animalfriendsdad@gmail.com");
        message.setTo(u.getCorreo()); 
        message.setSubject("Su reserva"); 
        message.setText("¡AnimalFriends!\n"+"Gracias por confiar en nosotros. Copia del pedido: \n" + u.getReservas().toString());
        emailSender.send(message);
        System.out.println("Enviado");
    }
}
