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

        File capturaPantalla = new File("src/main/java/capturaPantallaFTP/carpetaFTP.png");

        gestorEmail.enviarMensajeConAdjunto("imalara353@g.educaand.es", "rvilbri995@g.educaand.es", "Prueba Global Tema 4 - Ismael Maldonado", jsonRecibido, capturaPantalla);


    }
}
