package datos;

import domain.Peliculas;
import excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImple implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Peliculas> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Peliculas(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion en el archivo" + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir sobre peliculas" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar sobre peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar sobre peliculas" + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creo el archivo correctamente");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo" + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo){
       var archivo = new File(nombreArchivo);
       if(archivo.exists()){
           archivo.delete();
           System.out.println("Se borro el archivo");
       }
    }
}
