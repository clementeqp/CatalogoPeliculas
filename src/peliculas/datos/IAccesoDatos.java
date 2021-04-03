/*
 * Interface para acceder a los datos 
 * La I inicio en el nombre lo indica, es una buena practica

 */
package peliculas.datos;

import java.util.List;
import peliculas.domain.Pelicula;
import peliculas.excepciones.*;

/**
 *
 * @author Clemente Quintana Pozo
 */
public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
