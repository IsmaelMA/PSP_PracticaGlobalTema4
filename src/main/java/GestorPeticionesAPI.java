import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GestorPeticionesAPI {
    public static String realizaPeticion(String url) throws IOException, InterruptedException {
        String respuesta = null;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            System.out.println("No ha sido posible realizar la petición");
        }

        assert response != null;
        respuesta = response.body();


        return respuesta;
    }
}
