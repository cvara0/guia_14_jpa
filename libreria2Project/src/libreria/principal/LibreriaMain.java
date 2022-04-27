/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.principal;

import java.util.Locale;
import java.util.Scanner;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.DAO;
import libreria.servicio.AutorServicio;
import libreria.servicio.EditorialServicio;
import libreria.servicio.LibroServicio;

public class LibreriaMain {

    public static void main(String[] args) throws Exception {
        AutorServicio autor = new AutorServicio();
        EditorialServicio editorial = new EditorialServicio();
        LibroServicio libro = new LibroServicio();

        /*editorial.agregarUnAutor();
        editorial.agregarUnAutor();
        editorial.agregarUnAutor();*/
//autor.eliminarUnAutorPorId();
        //autor.agregarUnAutor();
        /* autor.agregarUnAutor();
        autor.agregarUnAutor();
        autor.agregarUnAutor();
        autor.agregarUnAutor();
        autor.agregarUnAutor();*/
        //autor.mostrarAutorPorID();
        //autor.mostrarTodosLosAutores();
        //autor.mostrarAutorPorNombre();
        //autor.modificarUnAutor();
        //editorial.modificarUnEditorial();
        //editorial.agregarUnEditorial();
        //editorial.agregarUnEditorial();
        //libro.agregarUnNuevoLibro();
        //libro.agregarUnNuevoLibro();
        //libro.agregarUnNuevoLibro();
        libro.modificarTodosLibros();
    }

}
/*


@OneToOne(fetch.LAZY,mappedBy="tabla padre")
se trabaja de forma bidireccional sin necesidad de genrar 2
llaves foranea

*/
