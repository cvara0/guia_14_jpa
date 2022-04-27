
package libreria.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import libreria.DAO.EditorialDAO;
import libreria.entidades.Editorial;

public class EditorialServicios {
    static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    
    public static void agregarNuevo() throws Exception {
        System.out.println("Agregando nueva editorial:");
        System.out.print("Ingrese nombre: ");
        String nombre = entrada.next();
        if (EditorialServicios.consultarPorNombre(nombre).isEmpty()) {
        System.out.print("Alta? (s/n): ");
        boolean altaEditorial = ValidacionesServicios.ingresarSoN();
        EditorialDAO.insertar(new Editorial(null, nombre, altaEditorial));}
        else{
            System.out.println("Ya existe una editorial con ese nombre");
        }
    }
    
    public static List<Editorial> consultarPorNombre(String aBuscar) throws Exception {
        //servicios
        List<Editorial> editorial = EditorialDAO.consultarPorNombre(aBuscar);
        return editorial;
    }
}
