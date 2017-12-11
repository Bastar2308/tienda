package auxiliares;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Fernando
 */
public class MailTools {    
    
    private MailTools() {
    }
    
    public static MailTools getInstance() {
        return LogToolsHolder.INSTANCE;
    }
    
    private static class LogToolsHolder {

        private static final MailTools INSTANCE = new MailTools();
    }
    
    /**
     * Inicia sesión en una cuenta de correo existente
     * @param correo
     * @param password
     */
    public Session iniciarSesion(final String correo, final String password){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(correo, password);
                    }
                });
        return session;
    }
    
    /**
     * Envía un correo desde una sesión iniciada
     *
     * @param session
     * @param destinatario
     * @param asunto
     * @param mensaje
     * 
     */
    
    public boolean enviarCorreo(Session session, String destinatario, String asunto, String mensaje){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo_prueba456@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("aaronlr160399@hotmail.com"));
            message.setSubject("Correo enviado desde STCBB");
            message.setText("Funciona");

            Transport.send(message);
            System.out.println("Enviado con éxito");
            return true;

        } catch (MessagingException e) {
            System.out.println("Error en el envío "+e);
            return false;
        }
    }
    
    /**
     * Envía un correo desde una sesión iniciada adjuntando un archivo
     *
     * @param session
     * @param destinatario
     * @param asunto
     * @param mensaje
     * @param archivo
     * 
     */
    public boolean enviarCorreo(Session session, String destinatario, String asunto, String mensaje, FileDataSource archivo){
        try {
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(archivo));
            adjunto.setFileName("imagen.png");
            
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correo_prueba456@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("aaronlr160399@hotmail.com"));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport.send(message);
            System.out.println("Enviado con éxito");
            return true;

        } catch (MessagingException e) {
            System.out.println("Error en el envío "+e);
            return false;
        }
    }
    /**
     * Crea un registro de error
     *
     * @param mensaje
     * @param e
     */
    
}
