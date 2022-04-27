package libreria.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {

   static EntityManager em = Persistence
            .createEntityManagerFactory("libreriaProjectPU")
            .createEntityManager();

//////////////////////////////////////////////////////////////////// 
    public static Autor insertar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(autor);
            
            em.getTransaction().commit();
            System.out.println("Autor insertado con exito");
            return autor;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void modificar(Autor autor) throws Exception {

        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void eliminar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar");
        }
    }
////////////////////////////////////////////////////////////////////

    public static Autor consultarPorCodigo(Integer codigo) throws Exception {
        try {
            Autor autor = em.find(Autor.class, codigo);
            
            return autor;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new Exception("No se encontro el codigo ingrsado"); 
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new Exception("Error al buscar");
        }
    }
////////////////////////////////////////////////////////////////////

    public static List<Autor> consultarPorNombre(String ABuscar) throws Exception {
        try {
            List<Autor> autor=em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :varABuscar",Autor.class)
                    .setParameter("varABuscar", ABuscar).getResultList();
            
            return autor;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            
            throw new Exception("Error al buscar autor");
        }
    }
////////////////////////////////////////////////////////////////////
}
