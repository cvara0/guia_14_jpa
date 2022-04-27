/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.validacion;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author cvara
 */
public class Validacion {

    private static final Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    ///////////////////////////////////////////////////////////////////////////
    public static short ingresarAnioValido() throws Exception {
        boolean error;
        short anio;
        do {
            error = false;
            try {
                anio = entrada.nextShort();
            } catch (NumberFormatException e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese un anio valido");
            }
        } while (error);
        return anio;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static Long ingresarLongPositivo() throws Exception {
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

    ///////////////////////////////////////////////////////////////////////////
    public static String ingresarString() throws Exception {
        return entrada.next();
    }

    ///////////////////////////////////////////////////////////////////////////
    public static byte ingresarBytePositivo() throws Exception {
        boolean error;
        byte cantidad;
        do {
            error = false;
            try {
                cantidad = entrada.nextByte();
            } catch (NumberFormatException e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese una cantidad valida");
            }
        } while (error || cantidad < 0);
        return cantidad;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void entradaNext() {
        entrada.next();
    }
    ///////////////////////////////////////////////////////////////////////////
    public static Integer ingresarEnteroPositivo() throws Exception {
        boolean error;
        Integer cantidad;
        do {
            error = false;
            try {
                cantidad = entrada.nextInt();
            } catch (NumberFormatException e) {
                entrada.next();
                error = true;
                throw new Exception("Error. Ingrese una cantidad valida");
            }
        } while (error || cantidad < 0);
        return cantidad;
    }
    ///////////////////////////////////////////////////////////////////////////
}
