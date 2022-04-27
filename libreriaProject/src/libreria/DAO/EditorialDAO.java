
package libreria.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialDAO {
    static EntityManager em = Persistence
            .createEntityManagerFactory("libreriaProjectPU")
            .createEntityManager();

//////////////////////////////////////////////////////////////////// 
    public static Editorial insertar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
            System.out.println("Editorial insertada con exito");
            return editorial;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void modificar(Editorial editorial) throws Exception {

        try {
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al insertar");
        }
    }
////////////////////////////////////////////////////////////////////

    public void eliminar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al actualizar");
        }
    }
////////////////////////////////////////////////////////////////////

    public Editorial consultarPorCodigo(Integer codigo) throws Exception {
        try {
            Editorial editorial = em.find(Editorial.class, codigo);
            return editorial;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            throw new Exception("No se encontro el codigo ingrsado"); 
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new Exception("Error al buscar");
        }
    }
////////////////////////////////////////////////////////////////////

    public static List<Editorial> consultarPorNombre(String ABuscar) throws Exception {
        try {
            List<Editorial> editorial=em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :varABuscar",Editorial.class)
                    .setParameter("varABuscar", ABuscar).getResultList();
            
            return editorial;
        } catch (NoResultException e) {
            em.getTransaction().rollback();
            
            throw new Exception("Error al buscar editorial");
        }
    }
////////////////////////////////////////////////////////////////////
}
