package vista;

import datos.*;
import excepciones.AccesoDatosEx;
import java.util.Scanner;
import servicio.*;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) throws AccesoDatosEx {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        // Utilizamos bajo acomplamiento para que esta capa conecte con los datos directamente y no la de negocios
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImple();
        IAccesoDatos datos = new AccesoDatosImple();
        
        while(opcion != 0){
            System.out.println("Elegi una opcion: \n"
               + "1. Iniciar catalogo peliculas\n" 
               + "2. Agregar pelicula\n"
               + "3. Listar peliculas\n"
               + "4. Buscar pelicula\n"
               + "5. Borrar pelicula\n"
               + "0. Salir\n");
            System.out.println("Opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogo();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese una pelicula a buscar: ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del archivo: ");
                    var archivo = scanner.nextLine();
                    datos.borrar(archivo);
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        }
    }
}
