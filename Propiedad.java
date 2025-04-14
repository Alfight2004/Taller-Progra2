public class Propiedad {
    String nombre;
    int precio;
    int alquiler;
    Jugador propietario;

    public Propiedad(String nombre, int precio, int alquiler) {
        this.nombre = nombre;
        this.precio = precio;
        this.alquiler = alquiler;
        this.propietario = null;
    }
}
