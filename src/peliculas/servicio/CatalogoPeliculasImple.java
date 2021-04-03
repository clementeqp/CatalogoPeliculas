/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.servicio;

import peliculas.datos.*;
import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;

/**
 *
 * @author Clemen
 */
public class CatalogoPeliculasImple implements ICatalogoPeliculas{

    private final IAccesoDatos datos;

    public CatalogoPeliculasImple() {
        this.datos = new AccesoDatosImple();
        
        
    }
    
    
    
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de ACceso a Datos ");
            ex.printStackTrace(System.out);
        }
    }
    
    

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("Pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar el catalogo de Peliculas");
            ex.printStackTrace(System.out);
        }
    }
    
    
    
    
}
