package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class DAO implements DAOInterface {

    static EntityManager em = Persistence.createEntityManagerFactory("libreria2ProjectPU").createEntityManager();

    @Override
    public void insertar(Object tipo) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(tipo);
            em.getTransaction().commit();
            System.out.println("Objeto insertado");
        } catch (Exception e) {
            throw new Exception("Error al insertar");
        }
    }

    @Override
    public void eliminar(Object tipo) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(tipo);
            em.getTransaction().commit();
            System.out.println("Objeto eliminado");
        } catch (Exception e) {
            throw new Exception("Error al eliminar");
        }
    }

    @Override
    public void modificar(Object tipo) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(tipo);
            em.getTransaction().commit();
            System.out.println("Objeto modificado");
        } catch (Exception e) {
            throw new Exception("Error al modificar");
        }
    }

    @Override
    public Object consultaPorID(Object id,Class clase,Class claseDelId) throws Exception {
        try {
            em.getTransaction().begin();
            id=claseDelId.cast(id);
            Object resultado = em.find(clase, id);
            System.out.println("Consulta realizada");
            em.getTransaction().commit();
            return resultado;
        } catch (Exception e) {
            throw new Exception("Error al consultar por ID");
        }
    }

    @Override
    public List<Object> consultaPorNombre(String nombre,Class clase) throws Exception {
        try {//falta poner condicion  WHERE i.nombre LIKE :nom   .setParameter("nom", nombre)
            System.out.println("Consultando por nombre:");
            System.out.println(clase.getSimpleName());
            String query="SELECT i FROM "+clase.getSimpleName()+" i WHERE i.nombre LIKE :nom";
            List<Object> resultado=em.createQuery(query,clase).setParameter("nom", nombre).getResultList();
            System.out.println("resultado");
                     
            return resultado;
        } catch (Exception e) {
            throw new Exception("Error al consultar por nombre");
        }   
    }
    
    @Override
    public List<Object> consultarTodo(Class clase) throws Exception {
        try {
  
            String query="SELECT i FROM "+clase.getSimpleName()+" i";
            List<Object> resultado=em.createQuery(query,clase).getResultList();
            return resultado;
        } catch (Exception e) {
            throw new Exception("Error al consultar todo");
        }   
    }

}
