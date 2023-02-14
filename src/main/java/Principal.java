import Gestores.GestorEmail;
import Gestores.GestorFTP;
import Gestores.GestorPeticionesAPI;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, MessagingException {

        String jsonRecibido = GestorPeticionesAPI.realizaPeticion("https://random.dog/woof.json");

        File imagenDescargada = GestorPeticionesAPI.descargaArchivo(jsonRecibido);

        GestorFTP.subirArchivo(imagenDescargada);

        GestorEmail gestorEmail = new GestorEmail();

        gestorEmail.enviarMensajeConAdjunto("imalara353@g.educaand.es","ismaelma1996@gmail.com","Prueba de envío de email","Esto es una prueba desde intellij",imagenDescargada);






    }
}
