package libreria.servicio;

import java.util.List;
import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;
import libreria.validacion.Validacion;

public class LibroServicio {

    LibroDAO libroDAO = new LibroDAO();
    AutorDAO autorDAO = new AutorDAO();
    EditorialDAO editorialDAO = new EditorialDAO();

//
    public void agregarUnNuevoLibro() throws Exception {
        System.out.println("Agregando nuevo libro:");
        System.out.print("ISBN: ");
        Long isbn = Validacion.ingresarLongPositivo();
        System.out.print("Titulo: ");
        String titulo = Validacion.ingresarString();
        System.out.print("Anio: ");
        Short anio = Validacion.ingresarAnioValido();
        System.out.print("Cantidad: ");
        Integer cantidadTotal = Validacion.ingresarLongPositivo().intValue();
        Integer cantidadPrestados = 0;
        Integer cantidadRestantes = cantidadTotal;
        System.out.print("Seleccionar autor: ");
        AutorServicio autor = new AutorServicio();
        autor.mostrarTodosLosAutores();
        Autor autorSeleccionado = autor.mostrarAutorPorID();
        System.out.print("Seleccionar editorial: ");
        EditorialServicio editorial = new EditorialServicio();
        editorial.mostrarTodoEditorial();
        Editorial editorialSeleccionado = editorial.mostrarEditorialPorID();
        libroDAO.insertar(new Libro(null, isbn, titulo, anio, cantidadTotal, cantidadPrestados, cantidadRestantes, true, autorSeleccionado, editorialSeleccionado));
    }
//

    public void eliminarUnLibroPorId() throws Exception {
        System.out.println("Se muestran todos los libros:");
        mostrarTodoLibro();
        System.out.println("Eliminando libro por id:");
        System.out.print("Ingrese id:");
        Integer id = Validacion.ingresarLongPositivo().intValue();
        Editorial aEliminar = new Editorial();
        aEliminar = (Editorial) editorialDAO.consultaPorID(id, aEliminar.getClass(), id.getClass());

        if (aEliminar.getId() == null) {
            System.out.println("No se encontro la editorial ingresado");
        } else {
            System.out.println("Eliminando a " + aEliminar.getNombre() + " , ID: " + aEliminar.getId());
            editorialDAO.eliminar(aEliminar);
            System.out.println("Editorial Eliminado");
        }
    }
///*

    public void mostrarTodoLibro() throws Exception {//modificar el otro
        System.out.println("Mostrando todos los libros:");
        List<Object> todosLosLibros = libroDAO.consultarTodo(Libro.class);
        System.out.println("ID  Nombre  Alta");
        for (Object i : todosLosLibros) {
            Libro libroCast = (Libro) i;
            System.out.println(libroCast.getId() + "  "
                    + libroCast.getTitulo() + "      "
                    + libroCast.getAutor().getNombre() + "   "
                    + libroCast.getEditorial().getNombre() + "   "
                    + libroCast.getAnio());
        }
    }

//
    public void mostrarLibroPorID() throws Exception {

        System.out.println("Consultando libro por ID:");
        System.out.print("ID:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Libro libroAMostrar = new Libro();//continuar aca
        libroAMostrar = (Libro) libroDAO.consultaPorID(id, libroAMostrar.getClass(), id.getClass());
        System.out.println("Resultados:");
        System.out.println("ID: " + libroAMostrar.getId());
        System.out.println("Titulo: " + libroAMostrar.getTitulo());
        System.out.println("Autor: " + libroAMostrar.getAutor().getNombre());
        System.out.println("Editorial: " + libroAMostrar.getEditorial().getNombre());
        System.out.println("Anio: " + libroAMostrar.getAnio());
        System.out.println("Alta: " + libroAMostrar.getAlta());

    }
//

    public List<Object> mostrarLibroPorNombre() throws Exception {

        System.out.println("Consultando libros por titulo:");
        System.out.print("Nombre: ");
        String nombreAbuscar = Validacion.ingresarString();
        List<Object> todosLosLibros = libroDAO.consultaPorNombre(nombreAbuscar, Libro.class);
        System.out.println("ID Nombre Autor Editorial Anio  Alta");
        for (Object i : todosLosLibros) {
            Libro libroCast = (Libro) i;
            System.out.println(libroCast.getId() + "  "
                    + libroCast.getTitulo() + "    "
                    + libroCast.getAutor().getNombre() + "   "
                    + libroCast.getEditorial().getNombre() + "        "
                    + libroCast.getAnio() + "   "
                    + libroCast.getAlta());
        }
        return todosLosLibros;
    }
    //

    public void modificarTodosLibros() throws Exception {

        System.out.println("Modificando libros por titulo:");
        List<Object> aModificar = mostrarLibroPorNombre();

        if (aModificar.isEmpty()) {
            System.out.println("No se encontro el titulo ingresado");
        } else {
            String nuevoNombre;
            boolean nuevoAlta;
            byte opcion = 0;
            do {
                try {
                    System.out.println("------------------------------------------");
                    System.out.println("Que desea modificar?");
                    System.out.println("1. Titulo");
                    System.out.println("2. Autor");
                    System.out.println("3. Editorial");
                    System.out.println("4. Anio");
                    System.out.println("5. Alta");
                    System.out.println("6. Volver atras\n");
                    System.out.print("Seleccion: ");//seguir aca
                    opcion = Validacion.ingresarBytePositivo();
                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo nombre de titulo:");
                            nuevoNombre = Validacion.ingresarString();
                            for (Object i : aModificar) {
                                Libro libroCast = (Libro) i;
                                libroCast.setTitulo(nuevoNombre);
                                libroDAO.modificar(libroCast);
                            }
                            System.out.println("Titulos actualizados");

                            break;
                        case 2:
                            
                            break;
                        case 3:
                            System.out.print("Cambiando autor:");
                            System.out.print("Seleccionar autor: ");
                            AutorServicio autor = new AutorServicio();
                            autor.mostrarTodosLosAutores();
                            Autor autorSeleccionado = autor.mostrarAutorPorID();

                            for (Object i : aModificar) {
                                Libro libroCast = (Libro) i;
                                libroCast.setAutor(autorSeleccionado);
                                libroDAO.modificar(libroCast);
                            }
                            System.out.println("Autores actualizadas");
                            opcion = 4;
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.print("Alta? (s/n): ");
                            nuevoAlta = Validacion.ingresarSoN();
                            for (Object i : aModificar) {
                                Libro libroCast = (Libro) i;
                                libroCast.setAlta(nuevoAlta);
                                libroDAO.modificar(libroCast);
                            }
                            System.out.println("Altas actualizadas");
                            break;
                        case 6:
                            System.out.println("Volviendo");
                            break;
                    }

                } catch (Exception e) {
                    Validacion.entradaNext();
                    System.out.println("ERROR. Ingrese caracteres validos");
                }

            } while (opcion != 6);

        }
    }
    //*/
}
