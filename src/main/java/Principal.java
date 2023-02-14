import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        String jsonRecibido = GestorPeticionesAPI.realizaPeticion("https://random.dog/woof.json");

        File imagenDescargada = GestorPeticionesAPI.descargaArchivo(jsonRecibido);

        GestorFTP.subirArchivo(imagenDescargada);




    }
}
