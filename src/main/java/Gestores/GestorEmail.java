package Gestores;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class GestorEmail {

    private Properties propiedades;
    private Session sesion;

    private void setPropiedadesServidorSMTP() {
        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.starttls.enable", "true");
        sesion = Session.getInstance(propiedades, null);

    }

    private Transport conectarServidorSMTP() throws NoSuchProviderException, MessagingException {
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"), "imalara353@g.educaand.es", "ghltcwtvgtrgclni");
        return t;
    }

    private Message crearNucleMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException {
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        return mensaje;
    }

    private Message crearMensajeconAdjunto(String emisor, String destinatario, String asunto, String textoMensaje, File archivoAdjunto) throws MessagingException, AddressException, IOException {
        Message mensaje = crearNucleMensaje(emisor, destinatario, asunto);

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(textoMensaje);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(archivoAdjunto);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);

        mensaje.setContent(multipart);

        return mensaje;
    }

    public void enviarMensajeConAdjunto(String emisor, String destinatario, String asunto, String textoMensaje, File archivoAAdjuntar) throws AddressException, MessagingException, IOException {
        setPropiedadesServidorSMTP();
        Message mensaje = crearMensajeconAdjunto(emisor, destinatario, asunto, textoMensaje, archivoAAdjuntar);

        Transport t = conectarServidorSMTP();
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
        return;

    }
}
