package libreria.servicio;

import java.util.List;
import libreria.entidad.Editorial;
import libreria.persistencia.EditorialDAO;
import libreria.validacion.Validacion;

public class EditorialServicio {

    EditorialDAO editorialDAO = new EditorialDAO();
//

    public void agregarUnEditorial() throws Exception {
        System.out.println("Agregando nueva editorial:");
        System.out.print("Nombre:");
        String nombre = Validacion.ingresarString();
        editorialDAO.insertar(new Editorial(null, nombre, true));
    }
//

    public void eliminarUnEditorialPorId() throws Exception {
        mostrarEditorialPorNombre();
        System.out.println("Eliminando editorial por id:");
        System.out.print("Ingrese id:");
        Integer id = Validacion.ingresarEnteroPositivo();
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
//

    public void mostrarTodoEditorial() throws Exception {//modificar el otro
        System.out.println("Mostrando todas las editoriales:");
        List<Object> todosLosEditoriales = editorialDAO.consultarTodo(Editorial.class);
        System.out.println("ID  Nombre  Alta");
        for (Object i : todosLosEditoriales) {
            Editorial editorialCast = (Editorial) i;
            System.out.println(editorialCast.getId() + "  " + editorialCast.getNombre() + "      " + editorialCast.getAlta());
        }
    }

//
    public Editorial mostrarEditorialPorID() throws Exception {

        System.out.println("Consultando editorial por ID:");
        System.out.print("ID:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Editorial editorialAMostrar = new Editorial();
        editorialAMostrar = (Editorial) editorialDAO.consultaPorID(id, editorialAMostrar.getClass(), id.getClass());
        System.out.println("Resultados:");
        System.out.println("ID: " + editorialAMostrar.getId());
        System.out.println("Nombre: " + editorialAMostrar.getNombre());
        System.out.println("Alta: " + editorialAMostrar.getAlta());
        return editorialAMostrar;

    }
//

    public void mostrarEditorialPorNombre() throws Exception {

        System.out.println("Consultando editoriales por nombre:");
        System.out.print("Nombre: ");
        String nombreAbuscar = Validacion.ingresarString();
        List<Object> editorialesPorNombre = editorialDAO.consultaPorNombre(nombreAbuscar, Editorial.class);
        System.out.println("ID  Nombre Alta");
        for (Object i : editorialesPorNombre) {
            Editorial editorialCast = (Editorial) i;
            System.out.println(editorialCast.getId() + "  " + editorialCast.getNombre() + "      " + editorialCast.getAlta());
        }
    }
    //

    public void modificarUnEditorial() throws Exception {

        System.out.println("Se muestran todos las editoriales:");
        mostrarTodoEditorial();
        System.out.println("Modificando editorial por id:");
        System.out.print("Ingrese id:");
        Integer id = Validacion.ingresarEnteroPositivo();
        Editorial aModificar = new Editorial();
        aModificar = (Editorial) editorialDAO.consultaPorID(id, aModificar.getClass(), id.getClass());

        if (aModificar.getId() == null) {
            System.out.println("No se encontro la editorial ingresado");
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

            editorialDAO.modificar(aModificar);
            System.out.println("Nuevo nombre: " + aModificar.getNombre() + " , Alta: " + aModificar.getAlta());

        }
    }
    //

}
