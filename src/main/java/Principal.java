import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        String jsonRecibido = GestorPeticionesAPI.realizaPeticion("https://random.dog/woof.json");
        System.out.println(jsonRecibido);
        BufferedImage imagenDescargada = GestorFTP.descargaImagen(jsonRecibido);


    }
}
