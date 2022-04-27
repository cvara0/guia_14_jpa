/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.principal;

import java.util.Locale;
import java.util.Scanner;
import libreria.servicio.AutorServicio;

/**
 *
 * @author cvara
 */
public class LibreriaMenu {
    
    Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        byte opcionA = 0;
        byte opcionB = 0;
        AutorServicio autorServicio=new AutorServicio();

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

                                        autorServicio.agregarUnAutor();

                                        break;
                                    case 2:
                                        

                                        break;
                                    case 3:
                                        //validar que exista editorial sino crear una
                                        //validar que exista autor sino crear uno
                                        
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
                                        autorServicio.modificarUnAutor();
                                                                               

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
                                        System.out.println("");
                                        
                                        autorServicio.mostrarTodosLosAutores();
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
                                        autorServicio.eliminarUnAutorPorId();
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

        } while (opcionA!=5);
    
}
