package libreria.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.DAO.EditorialDAO;
import libreria.DAO.LibroDAO;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import static libreria.servicios.ValidacionesServicios.ingresarAnioValido;
import static libreria.servicios.ValidacionesServicios.ingresarEnteroPositivo;

public class LibroServicios {

    static Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public static void agregarNuevo() throws Exception {
        System.out.println("Agregando nuevo libro:");
        System.out.println("Ingrese datos:\n");

        int nroTotales;
        int nroPrestados = 0;
        int nroRestantes = 0;
        boolean alta = true;

        System.out.print("ISBN: ");
        Long nroIsbn = ingresarEnteroPositivo();
        System.out.print("Titulo: ");
        String nombreLibro = entrada.next();
        System.out.print("Autor: ");
        String nombreAutor = entrada.next();
        System.out.print("Nombre de editorial:");
        String nombreEditorial = entrada.next();
        System.out.print("Anio de publicacion: ");
        int anio = ingresarEnteroPositivo().intValue();
        System.out.print("Nro. de ejemplares a ingresar: ");
        int nroNuevosEjemplares = ingresarEnteroPositivo().intValue();

        if (LibroServicios.consultarPorNombre(nombreLibro).isEmpty() && AutorServicios.consultarPorNombre(nombreAutor).isEmpty()) {
            System.out.println("Aun no se han ingresado ejemplares con ese titulo");
            
        } else if (!LibroServicios.consultarPorNombre(nombreLibro).isEmpty() && AutorServicios.consultarPorNombre(nombreAutor).isEmpty()) {
            System.out.println("Existen ejemplares con el mismo titulo pero con otro autor");
            
        }
        nroTotales = LibroDAO.sumarEjemplarATotal(nroIsbn,nroNuevosEjemplares);

        

        System.out.println("llegoaca2");
        
        if (AutorServicios.consultarPorNombre(nombreAutor).isEmpty()) {
            System.out.println("Aun no se han ingresado ejemplares con ese autor, nuevo autor generado con Alta=false");
            //AutorDAO.insertar(new Autor(null, nombreAutor, true));
        }
        //Integer idAutor = AutorServicios.consultarPorNombre(nombreAutor).get(AutorServicios.consultarPorNombre(nombreAutor).size() - 1).getId();
//pide un id ambiguo, corregir
        if (EditorialServicios.consultarPorNombre(nombreEditorial).isEmpty()) {
            System.out.println("No existe la editorial ingresada, nueva editorial generada con Alta=false");
            //EditorialDAO.insertar(new Editorial(null, nombreEditorial, true));
        }
        //Integer idEditorial = EditorialServicios.consultarPorNombre(nombreEditorial).get(EditorialServicios.consultarPorNombre(nombreEditorial).size() - 1).getId();
//pide un id ambiguo, corregir
        
//probar

        LibroDAO.insertar(new Libro(
                nroIsbn,
                nombreLibro,
                anio,
                nroTotales,
                nroPrestados,
                nroRestantes,
                alta,
                AutorDAO.insertar(new Autor(null,nombreAutor,true)),
                EditorialDAO.insertar(new Editorial(null, nombreEditorial, true))));
    }

    public static List<Libro> consultarPorNombre(String aBuscar) throws Exception {
        //servicios
        List<Libro> libro = LibroDAO.consultarPorNombre(aBuscar);
        return libro;

    }

    public static Libro consultarPorAutor(String aBuscar) throws Exception {
        //servicios
        Libro libro = LibroDAO.consultarPorAutor(aBuscar);
        return libro;

    }

}
