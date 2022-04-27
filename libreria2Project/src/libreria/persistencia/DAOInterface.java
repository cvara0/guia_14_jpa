
package libreria.persistencia;

import java.util.List;


public interface DAOInterface <T>{
    <T> void insertar(T tipo) throws Exception;
    <T> void eliminar(T tipo) throws Exception;
    <T> void modificar(T tipo) throws Exception;
    <T> T consultaPorID(Object id,Class clase,Class claseEntrada) throws Exception;
    <T> List<T> consultaPorNombre(String nombre,Class clase) throws Exception;
    <T> List<T> consultarTodo(Class clase)throws Exception;
}
