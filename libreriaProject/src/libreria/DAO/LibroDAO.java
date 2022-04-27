package libreria.DAO;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;

public class LibroDAO {

    static EntityManager em = Persistence
            .createEntityManagerFactory("libreriaProjectPU")
            .createEntityManager();

//////////////////////////////////////////////////////////////////// 
    public static void insertar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
            System.out.println("Libro insertado con exito");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void modificar(Libro libro) throws Exception {

        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al modificar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void eliminar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar");
        }
    }
////////////////////////////////////////////////////////////////////

    public Libro consultarPorCodigo(Integer isbn) throws Exception {
        try {
            Libro libro = em.find(Libro.class, isbn);
            return libro;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new Exception("No se encontro el codigo ingrsado");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new Exception("Error al buscar");
        }
    }
////////////////////////////////////////////////////////////////////

    public static List<Libro> consultarPorNombre(String ABuscar) throws Exception {
        try {
            List<Libro> libro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :varABuscar", Libro.class)
                    .setParameter("varABuscar", ABuscar).getResultList();

            return libro;
        } catch (NoResultException e) {
            em.getTransaction().rollback();

            throw new Exception("Error al buscar libro");
        }
    }
////////////////////////////////////////////////////////////////////

    public static Libro consultarPorAutor(String ABuscar) throws Exception {
        try {
            Libro libro = em.createQuery("SELECT l FROM Libro l WHERE l.autor LIKE :varABuscar", Libro.class)
                    .setParameter("varABuscar", ABuscar).getSingleResult();

            return libro;
        } catch (NoResultException e) {
            em.getTransaction().rollback();

            throw new Exception("Error al buscar libro");
        }
    }
////////////////////////////////////////////////////////////////////

    public static List<Libro> traerTodo() throws Exception {
        try {
            List<Libro> libro = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();

            return libro;
        } catch (NoResultException e) {
            em.getTransaction().rollback();

            throw new Exception("Error al traer todo");
        }
    }
////////////////////////////////////////////////////////////////////

    public static void actualizarAlta() throws Exception {
        try {
            List<Libro> todo = traerTodo();
            em.getTransaction().begin();
            for (Libro i : todo) {
                i.setAlta(false);
                i.setNroEjemplares(3);
                em.merge(i);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("error al actualizar");
        }
    }

    ////////////////////////////////////////////////////////////////////
    public static int sumarEjemplarATotal(Long nroIsbn,int nroNuevosEjemplares) throws Exception {
        try {
            List<Libro> todo = traerTodo();
            em.getTransaction().begin();
            int nuevoTotal = 0;
            for (Libro i : todo) {
                if (i.getIsbn()== nroIsbn) {//Objects.equals(i.getIsbn(), nroIsbn)
                    i.setNroEjemplares(i.getNroEjemplares() + nroNuevosEjemplares);
                    em.merge(i);
                    nuevoTotal = i.getNroEjemplares();
                    System.out.println(nuevoTotal);
                }
            }
            em.getTransaction().commit();
            return nuevoTotal;
        } catch (Exception e) {
            throw new Exception("error al sumar nuevo ejemplar");
        }
    }
    ////////////////////////////////////////////////////////////////////
    public static Integer consultarNroPestados(String nombreLibro,String nombreAutor) throws Exception {
        try {
            List<Libro> todo = traerTodo();
            em.getTransaction().begin();
            int nuevoTotalPrestados = 0;
            for (Libro i : todo) {
                if (i.getTitulo().equalsIgnoreCase(nombreLibro) && i.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                    i.setNroEjemplares(i.getNroEjemplares() + 1);
                    //nuevoTotal = i.getNroEjemplares();
                }
            }
            return nuevoTotalPrestados;
        } catch (Exception e) {
            throw new Exception("error al sumar nuevo ejemplar");
        }
    }
    ////////////////////////////////////////////////////////////////////
    public static void prestarUnLibro(Long isbn) throws Exception {
        try {
            List<Libro> todo = traerTodo();
            em.getTransaction().begin();
            int nuevoTotalPrestados = 0;
            for (Libro i : todo) {
                if (i.getTitulo().equalsIgnoreCase(nombreLibro) && i.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                    i.setNroEjemplares(i.getNroEjemplares() + 1);
                    nuevoTotal = i.getNroEjemplares();
                }
            }
            return nuevoTotalPrestados;
        } catch (Exception e) {
            throw new Exception("error al sumar nuevo ejemplar");
        }
    }
    ////////////////////////////////////////////////////////////////////

}
