import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {

        try {

            String contenido = Files.readString(Path.of("peliculas.csv")); // Lectura del fichero completo

            System.out.println(contenido); // Lo mostramos por consola para comprobar que funciona

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

    }
}