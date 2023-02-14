package Gestores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    public static File descargaArchivo(String json) throws IOException, URISyntaxException {

        File imagen = null;
        Gson gson = new Gson();

        JsonObject jsonRecibido = gson.fromJson(json, JsonObject.class);
        String urlImagen = jsonRecibido.get("url").toString();
        String urlImagenFixed = urlImagen.replaceAll("\"", "");
        String sufijo = urlImagenFixed.substring(urlImagenFixed.lastIndexOf(".") + 1);
        System.out.println(urlImagenFixed);

        imagen = new File("src/main/java/imagen_descargada/descarga." + sufijo);
        FileUtils.copyURLToFile(new URL(urlImagenFixed), imagen);
        return imagen;

    }
}
