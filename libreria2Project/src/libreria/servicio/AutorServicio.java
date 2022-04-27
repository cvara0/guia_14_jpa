package libreria.servicio;

import java.util.ArrayList;
import java.util.List;

import libreria.entidad.Autor;
import libreria.persistencia.AutorDAO;
import libreria.validacion.Validacion;

public class AutorServicio {

    AutorDAO autorDAO = new AutorDAO();
//

    public void agregarUnAutor() throws Exception {
        System.out.println("Agregando nuevo autor:");
        System.out.print("Nombre:");
        String nombre = Validacion.ingresarString();
        autorDAO.insertar(new Autor(null, nombre, true));
    }
//

    public void eliminarUnAutorPorId() throws Exception {
        mostrarAutorPorNombre();
        System.out.println("Eliminando autor por id:");
        System.out.print("Ingrese id:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Autor aEliminar = new Autor();
        aEliminar = (Autor) autorDAO.consultaPorID(id, aEliminar.getClass(), id.getClass());

        if (aEliminar.getId() == null) {
            System.out.println("No se encontro el autor ingresado");
        } else {
            System.out.println("Eliminando a " + aEliminar.getNombre() + " , ID: " + aEliminar.getId());
            autorDAO.eliminar(aEliminar);
            System.out.println("Autor Eliminado");
        }
    }
//

    public void mostrarTodosLosAutores() throws Exception {
        System.out.println("Mostrando todos los autores:");
        List<Object> todosLosAutores = autorDAO.consultarTodo(Autor.class);
        System.out.println("ID  Nombre  Alta");
        for (Object i : todosLosAutores) {
            Autor autorCast = (Autor) i;
            System.out.println(autorCast.getId() + "  " + autorCast.getNombre() + "      " + autorCast.getAlta());
        }
    }

//
    public Autor mostrarAutorPorID() throws Exception {

        System.out.println("Consultando autor por ID:");
        System.out.print("ID:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Autor autorAMostrar = new Autor();
        autorAMostrar = (Autor) autorDAO.consultaPorID(id, autorAMostrar.getClass(), id.getClass());
        System.out.println("Resultados:");
        System.out.println("ID: " + autorAMostrar.getId());
        System.out.println("Nombre: " + autorAMostrar.getNombre());
        System.out.println("Alta: " + autorAMostrar.getAlta());
        return autorAMostrar;

    }
//

    public void mostrarAutorPorNombre() throws Exception {

        System.out.println("Consultando autores por nombre:");
        System.out.print("Nombre: ");
        String nombreAbuscar = Validacion.ingresarString();
        List<Object> autoresPorNombre = autorDAO.consultaPorNombre(nombreAbuscar, Autor.class);
        System.out.println("ID  Nombre Alta");
        for (Object i : autoresPorNombre) {
            Autor autorCast = (Autor) i;
            System.out.println(autorCast.getId() + "  " + autorCast.getNombre() + "      " + autorCast.getAlta());
        }
    }
    //

    public void modificarUnAutor() throws Exception {

        System.out.println("Se muestran todos los autores:");
        mostrarTodosLosAutores();
        System.out.println("Modificando autor por id:");
        System.out.print("Ingrese id:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Autor aModificar = new Autor();
        aModificar = (Autor) autorDAO.consultaPorID(id, aModificar.getClass(), id.getClass());

        if (aModificar.getId() == null) {
            System.out.println("No se encontro el autor ingresado");
        } else {
            String nuevoNombre;
            boolean nuevoAlta;
            byte opcion = 0;
            do {
                try {
                    System.out.println("------------------------------------------");
                    System.out.println("Que desea modificar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Alta");
                    System.out.println("3. Nombre y alta");
                    System.out.println("4. Volver atras\n");
                    System.out.print("Seleccion: ");
                    opcion = Validacion.ingresarBytePositivo();
                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo nombre:");
                            nuevoNombre = Validacion.ingresarString();
                            aModificar.setNombre(nuevoNombre);
                            opcion = 4;
                            break;
                        case 2:
                            System.out.print("Alta? (s/n): ");
                            nuevoAlta = Validacion.ingresarSoN();
                            aModificar.setAlta(nuevoAlta);
                            opcion = 4;
                            break;
                        case 3:
                            System.out.print("Nuevo nombre:");
                            nuevoNombre = Validacion.ingresarString();
                            System.out.print("Alta? (s/n): ");
                            nuevoAlta = Validacion.ingresarSoN();
                            aModificar.setNombre(nuevoNombre);
                            aModificar.setAlta(nuevoAlta);
                            opcion = 4;
                            break;
                        case 4:
                            System.out.println("Volviendo");
                            break;
                    }

                } catch (Exception e) {
                    Validacion.entradaNext();
                    System.out.println("ERROR. Ingrese caracteres validos");
                }

            } while (opcion != 4);

            autorDAO.modificar(aModificar);
            System.out.println("Nuevo nombre: " + aModificar.getNombre() + " , Alta: " + aModificar.getAlta());

        }
    }
    //

}
