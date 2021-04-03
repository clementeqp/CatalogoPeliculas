/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.presentacion;

import java.util.Scanner;
import peliculas.servicio.*;

/**
 *
 * @author Clemente Quintana
 */
public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImple();
        
        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo de peliculas\n"
                + "2. Agregar Pelicula\n"
                + "3. Listar Pelicula\n"
                + "4. Buscar Pelicula\n"
                + "0. Salir");
                opcion =Integer.parseInt(scanner.nextLine());
                
                switch(opcion){
                    case 1:
                        catalogo.iniciarCatalogoPeliculas();
                        break;
                    case 2:
                        System.out.println("Introduce el nombre de la Pelicula ");
                        var nombrePelicula = scanner.nextLine(); 
                        catalogo.agregarPelicula(nombrePelicula);
                        break;
                    case 3:
                        catalogo.listarPeliculas();
                        break;
                    case 4:
                        System.out.println("Introduce una pelicula a buscar");
                        var buscar = scanner.nextLine();
                        catalogo.buscarPelicula(buscar);
                        break;
                    case 0:
                        System.out.println("Hasta pronto");
                        break;
                    default:
                        System.out.println("Opcion desconocida");
                        
                }
        }
    }
}
