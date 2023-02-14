import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        String jsonRecibido = GestorPeticionesAPI.realizaPeticion("https://random.dog/woof.json");

        File imagenDescargada = GestorPeticionesAPI.descargaImagen(jsonRecibido);




    }
}
