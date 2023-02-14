package Gestores;

import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;


public class GestorFTP {

    private static final String SERVIDOR = "192.168.1.50";
    private static final int PUERTO = 21;
    private static final String USUARIO = "ismael";

    private static final String PASSWORD = "A123456a";

    public static void subirArchivo(File archivo){

        String remotePath = "/";

        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        try {
            ftpClient.connect(SERVIDOR, PUERTO);
            ftpClient.login(USUARIO, PASSWORD);
            ftpClient.enterLocalPassiveMode();


            fis = new FileInputStream(archivo);

            String remoteFile = remotePath + "/" + archivo.getName();
            boolean uploaded = ftpClient.storeFile(remoteFile, fis);
            if (uploaded) {
                System.out.println("Archivo subido correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al subir archivo al servidor FTP: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                System.out.println("Error al cerrar conexión FTP: " + e.getMessage());
            }
        }
    }


}
