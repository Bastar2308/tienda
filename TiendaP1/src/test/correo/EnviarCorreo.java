package test.correo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import auxiliares.MailTools;
import java.util.Properties;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Fernando
 */
public class EnviarCorreo {

    public static void main(String[] args) {
        /*Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("correo_prueba456@hotmail.com", "Contrasena");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo_prueba456@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("aaronlr160399@hotmail.com"));
            message.setSubject("Correo enviado desde STCBB");
            message.setText("Funciona");

            Transport.send(message);
            System.out.println("Enviado con éxito");

        } catch (MessagingException e) {
            System.out.println("Error en el envío");
            throw new RuntimeException(e);
        }*/
        MailTools.getInstance().enviarCorreo(MailTools.getInstance().iniciarSesion("correo_prueba456@hotmail.com", "Contrasena"),
                "aaronlr160399@hotmail.com", "Funciona", "Mensaje enviado desde STCBB",
                new FileDataSource("C:/Users/aaron/Desktop/0001.jpg"));
    }
}
