import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Ana");
        Jugador jugador2 = new Jugador("Luis");

        for (int turno = 1; turno <= 5; turno++) {
            System.out.println("\n--- Turno " + turno + " ---");

            jugarTurno(jugador1, tablero, teclado);
            jugarTurno(jugador2, tablero, teclado);
        }

        teclado.close();
    }

    public static void jugarTurno(Jugador jugador, Tablero tablero, Scanner teclado) {
        System.out.println("\nTurno de " + jugador.nombre);
        System.out.print("Presiona Enter para lanzar el dado...");
        teclado.nextLine();
        int dado = (int) (Math.random() * 6 + 1);
        System.out.println("Salió: " + dado);

        jugador.mover(dado, tablero.totalCasillas());
        System.out.println(jugador.nombre + " se movió a la posición " + jugador.posicion);

        Propiedad casilla = tablero.obtenerCasilla(jugador.posicion);
        if (casilla != null) {
            if (casilla.propietario == null) {
                jugador.comprarPropiedad(casilla);
            } else {
                jugador.pagarAlquiler(casilla);
            }
        }

        jugador.mostrarInformacion();
    }
}

