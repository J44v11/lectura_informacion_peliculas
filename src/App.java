import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import net.salesianos.pelicula.Pelicula;

public class App {
    public static void main(String[] args) throws Exception {

        List<Pelicula> listaPeliculas = new ArrayList<>();

        try {
            // Lee el fichero peliculas.csv linea a linea
            List<String> lineas = Files.readAllLines(Path.of("./peliculas.csv"));

            // Ignora la primera linea
            // Verificamos que la lista no este vacia por seguridad, y eliminamos la
            // posicion 0
            if (!lineas.isEmpty()) {
                String cabecera = lineas.remove(0);
                System.out.println("Hemos ignorado esta cabecera: " + cabecera);
            }

            for (String linea : lineas) {
                // Separamos el texto de la línea por las comas
                String[] datos = linea.split(",");

                // Extraemos cada dato
                String tituloPelicula = datos[0];
                String generoPelicula = datos[1];
                // la duración la parseamos a int ya que es de tipo String ahora mismo
                int duracionPelicula = Integer.parseInt(datos[2]);

                // Instanciamos el objeto Pelicula con esos datos que extraimos
                Pelicula pelicula = new Pelicula(tituloPelicula, generoPelicula, duracionPelicula);

                // Lo imprimo por consola para ver que peliculas se han añadido en memoria
                System.out.println("Pelicula creada en memoria: " + pelicula.getTitulo());

                listaPeliculas.add(pelicula);
            }

            System.out.println("Peliculas añadidas al ArrayList: ");
            for (Pelicula pelicula : listaPeliculas) {

                System.out.println(pelicula);

            }

            System.out.println("Numero total de peliculas: " + listaPeliculas.size() + " peliculas");

            int duracionTotal = 0;

            for (Pelicula pelicula : listaPeliculas) {
                int duracion = pelicula.getDuracionMinutos();

                duracionTotal = duracionTotal + duracion;

            }

            System.out.println("Duracion total de las peliculas: " + duracionTotal + " minutos");

            System.out
                    .println("Duracion media de las peliculas: " + duracionTotal / listaPeliculas.size() + " minutos");

            int peliculaMasLarga = 0;

            for (Pelicula pelicula : listaPeliculas) {

                if (pelicula.getDuracionMinutos() > peliculaMasLarga) {
                    peliculaMasLarga = pelicula.getDuracionMinutos();
                }

            }

            System.out.println("Pelicula mas larga: " + peliculaMasLarga + " minutos");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

    }
}