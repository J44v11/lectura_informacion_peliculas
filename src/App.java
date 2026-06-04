import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            // Lee el fichero peliculas.csv línea a línea
            List<String> lineas = Files.readAllLines(Path.of("peliculas.csv"));
            
            // Ignora la primera línea
            // Verificamos que la lista no esté vacía por seguridad, y eliminamos la posición 0
            if (!lineas.isEmpty()) {
                String cabecera = lineas.remove(0);
                System.out.println("Hemos ignorado esta cabecera: " + cabecera);
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

    }
}