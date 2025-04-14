public class Tablero {
    Propiedad[] casillas;

    public Tablero() {
        casillas = new Propiedad[10];
        casillas[1] = new Propiedad("Multicines", 100, 10);
        casillas[3] = new Propiedad("Scala", 150, 15);
        casillas[5] = new Propiedad("Udla", 200, 20);
    }

    public Propiedad obtenerCasilla(int posicion) {
        return casillas[posicion];
    }

    public int totalCasillas() {
        return casillas.length;
    }
}
