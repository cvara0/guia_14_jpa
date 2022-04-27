package libreria.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.entidades.Autor;

public class AutorServicios {

    static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public static void agregarNuevo() throws Exception {
        System.out.println("Agregando nuevo autor:");
            System.out.print("Ingrese nombre: ");
            String nombre = entrada.next();
        if (AutorServicios.consultarPorNombre(nombre).isEmpty()) {
            
            System.out.print("Alta? (s/n): ");
            boolean altaAutor = ValidacionesServicios.ingresarSoN();
            AutorDAO.insertar(new Autor(null, nombre, altaAutor));
        } else {
            System.out.println("Ya existe un autor con ese nombre");
        }
    }

    public static List<Autor> consultarPorNombre(String aBuscar) throws Exception {
        //servicios
        List<Autor> autor = AutorDAO.consultarPorNombre(aBuscar);
        return autor;

    }
}
