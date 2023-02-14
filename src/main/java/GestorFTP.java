import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GestorFTP {

    public static BufferedImage descargaImagen(String json) throws IOException {

        Gson gson = new Gson();

        //JsonObject json = new JsonObject("{'url': 'https://ejemplo.com/imagen.jpg'}");
        //String urlImagen = json.getString("imagen");

        JsonObject jsonRecibido = gson.fromJson(json, JsonObject.class);
        String urlImagen = jsonRecibido.get("url").toString();


        System.out.println(urlImagen);
        URL url = new URL(urlImagen);
        BufferedImage imagen = ImageIO.read(url);

        return imagen;

    }
}
