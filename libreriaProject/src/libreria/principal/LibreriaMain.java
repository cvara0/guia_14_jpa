package libreria.principal;

import java.util.Locale;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import libreria.DAO.LibroDAO;
import libreria.servicios.AutorServicios;
import libreria.servicios.EditorialServicios;
import libreria.servicios.LibroServicios;

public class LibreriaMain {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        byte opcionA = 0;
        byte opcionB = 0;

        do {
            try {
                System.out.println("------------------------------------------");
                System.out.println("Seleccione operacion:\n");
                System.out.println("1. Agregar");
                System.out.println("2. Modificar");
                System.out.println("3. Consultar");
                System.out.println("4. Eliminar");
                System.out.println("5. Salir\n");
                System.out.print("Seleccion: ");
                opcionA = entrada.nextByte();
                System.out.println("------------------------------------------");
                switch (opcionA) {
                    case 1:
                        do {
                            try {
                                System.out.println("------------------------------------------");
                                System.out.println("Que desea agregar?");
                                System.out.println("1. Autor");
                                System.out.println("2. Editorial");
                                System.out.println("3. Libro");
                                System.out.println("4. Volver al menu principal\n");
                                System.out.print("Seleccion: ");
                                opcionB = entrada.nextByte();
                                System.out.println("------------------------------------------");
                                switch (opcionB) {
                                    case 1:

                                        AutorServicios.agregarNuevo();

                                        break;
                                    case 2:
                                        EditorialServicios.agregarNuevo();

                                        break;
                                    case 3:
                                        //validar que exista editorial sino crear una
                                        //validar que exista autor sino crear uno
                                        LibroServicios.agregarNuevo();
                                        break;

                                    case 4:
                                        System.out.println("Volviendo");
                                        break;
                                }
                            } catch (Exception e) {
                                entrada.next();
                                System.out.println("ERROR. Ingrese caracteres validos");
                            }

                        } while (opcionB != 4);
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("------------------------------------------");
                                System.out.println("Que desea modificar?");
                                System.out.println("1. Autor");
                                System.out.println("2. Editorial");
                                System.out.println("3. Libro");
                                System.out.println("4. Volver al menu principal\n");
                                System.out.print("Seleccion: ");
                                opcionB = entrada.nextByte();
                                System.out.println("------------------------------------------");
                                switch (opcionB) {
                                    case 1:
                                        //LibroDAO.actualizarTotalEjemplares();
                                                                               
//AutorServicios.modificar();
                                        break;
                                    case 2:
                                        
                    
                                        ///EditorialServicios.modificar();
                                        break;
                                    case 3:
                                        //LibroServicios.modificar();
                                        break;
                                    case 4:
                                        System.out.println("Volviendo");
                                        break;
                                }
                            } catch (Exception e) {
                                entrada.next();
                                System.out.println("ERROR. Ingrese caracteres validos");
                            }
                        } while (opcionB != 4);
                        break;
                    case 3:
                        do {
                            try {

                                System.out.println("------------------------------------------");
                                System.out.println("Consultar:");
                                System.out.println("1. Autor");
                                System.out.println("2. Editorial");
                                System.out.println("3. Libro");
                                System.out.println("4. Volver al menu principal\n");
                                System.out.print("Seleccion: ");
                                opcionB = entrada.nextByte();
                                System.out.println("------------------------------------------");
                                switch (opcionB) {
                                    case 1:
                                        // AutorServicios.consultar();
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 5:
                                        System.out.println("Volviendo");
                                        break;
                                }
                            } catch (Exception e) {
                                entrada.next();
                                System.out.println("ERROR. Ingrese caracteres validos");
                            }
                        } while (opcionB != 5);
                        break;
                    case 4:
                        do {
                            try {
                                System.out.println("------------------------------------------");
                                System.out.println("Que desea eliminar?");
                                System.out.println("1. Autor");
                                System.out.println("2. Editorial");
                                System.out.println("3. Libro");
                                System.out.println("4. Volver al menu principal\n");
                                System.out.print("Seleccion: ");
                                opcionB = entrada.nextByte();
                                System.out.println("------------------------------------------");
                                switch (opcionB) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        System.out.println("Volviendo");
                                        break;
                                }
                            } catch (Exception e) {
                                entrada.next();
                                System.out.println("ERROR. Ingrese caracteres validos");
                            }
                        } while (opcionB != 4);
                        break;
                    case 5:
                        do {
                            try {
                                System.out.println("------------------------------------------");
                                System.out.println("Otras operaciones");
                                System.out.println("1. Autor");
                                System.out.println("2. Editorial");
                                System.out.println("3. Libro");
                                System.out.println("4. Volver al menu principal\n");
                                System.out.print("Seleccion: ");
                                opcionB = entrada.nextByte();
                                System.out.println("------------------------------------------");
                                switch (opcionB) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        System.out.println("Volviendo");
                                        break;
                                }
                            } catch (Exception e) {
                                entrada.next();
                                System.out.println("ERROR. Ingrese caracteres validos");
                            }
                        } while (opcionB != 5);
                        break;
                    case 6:
                        System.out.println("------------------------------------------");
                        System.out.println("Fin");
                        break;

                }
            } catch (Exception e) {
                entrada.next();
                System.out.println("ERROR. Ingrese caracteres validos");

            }

        } while (opcionA != 5);

    }

}

/*

d) Main
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para interactuar con el usuario. En esta clase se muestra el menú de opciones con las
operaciones disponibles que podrá realizar el usuario.
e) Tareas a Realizar
Al alumno le toca desarrollar, las siguientes funcionalidades:
1) Crear base de datos Librería
2) Crear unidad de persistencia

3) Crear entidades previamente mencionadas ( excepto Préstamo )
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.

 */
