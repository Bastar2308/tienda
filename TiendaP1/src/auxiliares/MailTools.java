package auxiliares;

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

public class MailTools {

    String sender = "cafeteriakpbaltico@hotmail.com";
    String pass = "R4quel_1";

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
     *
     * @param correo
     * @param password
     */
    public Session iniciarSesion(final String correo, final String password) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.live.com");
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
     * @param destinatario
     * @param asunto
     * @param mensaje
     * @param titulo
     *
     */
    public boolean enviarCorreo(String destinatario, String asunto, String mensaje, String titulo) {
        try {
            BodyPart texto = new MimeBodyPart();
            texto.setContent("<html><head></head>" + generaEncabezado(titulo) + mensaje + "</html>", "text/html; charset=utf-8");
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            Message message = new MimeMessage(iniciarSesion(sender, pass));
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport.send(message);
            System.out.println("Enviado con éxito a:" + destinatario);
            return true;

        } catch (MessagingException e) {
            System.out.println("Error en el envío " + e);
            return false;
        }
    }

    public String generaEncabezado(String titulo) {
        String encabezado = "<b>" + Prefs.get(Prefs.ESCUELA) + "</b>"
                + "<br>Cafetería: <b>" + Prefs.get(Prefs.NEGOCIO) + "</b><br>"
                + "Encargado: <b>" + Prefs.get(Prefs.ENCARGADO) + "</b><br>"
                + "Cualquier duda o aclaración con gusto le atendemos al teléfono: <b>" + Prefs.get(Prefs.TELEFONO) + "</b><br>"
                + "<div width='100%' style='background-color:#000000'><p>línea</p></div><br>"
                + "<h1><center>" + titulo + "</center></h1><br>";
        return encabezado;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
    }

    /**
     * Envía un correo desde una sesión iniciada adjuntando un archivo
     *
     * @param destinatario
     * @param asunto
     * @param mensaje
     * @param archivo
     *
     */
    public boolean enviarCorreo(String destinatario, String asunto, String mensaje, FileDataSource archivo) {
        try {
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(archivo));
            adjunto.setFileName("credencial.png");

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            Message message = new MimeMessage(iniciarSesion(sender, pass));
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport.send(message);
            System.out.println("Enviado con éxito a:" + destinatario);
            return true;

        } catch (MessagingException e) {
            System.out.println("Error en el envío " + e);
            return false;
        }
    }
}
