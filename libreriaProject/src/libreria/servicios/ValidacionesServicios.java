
package libreria.servicios;

import java.util.Locale;
import java.util.Scanner;


public class ValidacionesServicios {
    private static final Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    ///////////////////////////////////////////////////////////////////////////
    public static int ingresarAnioValido() throws Exception {
       
        boolean error;
        int anio;
        do {
            error = false;
            try {
                anio = entrada.nextInt();
            } catch (NumberFormatException e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese un anio valido");
            }
        } while (error);
        return anio;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static Long ingresarEnteroPositivo() throws Exception {
        boolean error;
        Long cantidad;
        do {
            error = false;
            try {
                cantidad = entrada.nextLong();
            } catch (NumberFormatException e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese una cantidad valida");
            }
        } while (error || cantidad < 0);
        return cantidad;
    }
    ///////////////////////////////////////////////////////////////////////////

    public static boolean ingresarSoN() throws Exception {
        boolean error;
        String disponible;
        do {
            error = false;
            try {
                disponible = entrada.next();
                if (!disponible.equalsIgnoreCase("s") && !disponible.equalsIgnoreCase("n")) {
                    System.out.println("Error. Ingrese solo letras 's' o 'n'");
                }
            } catch (Exception e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese caracteres validos");
            }
        } while ((!disponible.equalsIgnoreCase("s") && !disponible.equalsIgnoreCase("n")) || error);
        return disponible.equalsIgnoreCase("s");
    }
    
}
