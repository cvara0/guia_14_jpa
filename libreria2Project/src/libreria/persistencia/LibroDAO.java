
package libreria.persistencia;


public class LibroDAO extends DAO{

    public LibroDAO() {
    }
    

    
   /* public List<Libro> traerTodosLibro() throws Exception {
        try {

            em.getTransaction().begin();
            List<Libro> listaLibro = em.createQuery("SELECT l FROM Libro l").getResultList();
            em.getTransaction().commit();
            System.out.println("Se trajeron todos los libros");
            if (listaLibro.isEmpty()) {
                System.out.println("Tabla libro vacia");
            }
            return listaLibro;
        } catch (Exception e) {
            throw new Exception("Error al consultar libro");
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public List<Libro> traerAutoresPorNombre(String aBuscar) throws Exception {
        try { 
            em.getTransaction().begin();
            List<Libro> listaLibro = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :a_buscar",Libro.class).setParameter("a_buscar", aBuscar).getResultList();
            em.getTransaction().commit();
            System.out.println("Se trajo el libro ingresado");
            if(listaLibro.isEmpty()){
                System.out.println("Tabla libro vacia");
            }
            return listaLibro;
        } catch (Exception e) {
           
            throw new Exception("Error al consultar libro");
        }
    }
    ///////////////////////////////////////////////////////////////////////*/
}
