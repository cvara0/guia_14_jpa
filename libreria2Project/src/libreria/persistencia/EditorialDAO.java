
package libreria.persistencia;


public class EditorialDAO extends DAO{
    ///////////////////////////////////////////////////////////////////////

    public EditorialDAO() {
    }
    
    
    
    /*public List<Editorial> traerTodosEditorial() throws Exception {
        try {

            em.getTransaction().begin();
            List<Editorial> listaEditorial = em.createQuery("SELECT e FROM Editorial e").getResultList();
            em.getTransaction().commit();
            System.out.println("Se trajeron todos los autores");
            if (listaEditorial.isEmpty()) {
                System.out.println("Tabla editorial vacia");
            }
            return listaEditorial;
        } catch (Exception e) {
            throw new Exception("Error al consultar editorial");
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public static List<Editorial> traerAutoresPorNombre(String aBuscar) throws Exception {
        try { 
            em.getTransaction().begin();
            List<Editorial> listaEditorial = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :a_buscar",Editorial.class).setParameter("a_buscar", aBuscar).getResultList();
            em.getTransaction().commit();
            System.out.println("Se trajo la editorial ingresada");
            if(listaEditorial.isEmpty()){
                System.out.println("Tabla editorial vacia");
            }
            return listaEditorial;
        } catch (Exception e) {
            
            throw new Exception("Error al consultar editorial");
        }
    }
    ///////////////////////////////////////////////////////////////////////*/
}
