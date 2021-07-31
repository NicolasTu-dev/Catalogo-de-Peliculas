package datos;

import excepciones.*;
import java.util.List;
import domain.Peliculas;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Peliculas pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
