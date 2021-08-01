package servicio;

public interface ICatalogoPeliculas {

    String NOMBRE_ARCHIVO = "Peliculas.txt";

    // Esto es mas orientado al usuario, el IAccesoDatos es mas orientada al manejo de datos
    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPelicula(String buscar);

    void iniciarCatalogo();
}
