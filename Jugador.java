import java.util.ArrayList;

public class Jugador {
    String nombre;
    int dinero = 500;
    int posicion = 0;
    ArrayList<Propiedad> propiedades = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void mover(int pasos, int totalCasillas) {
        int nuevaPosicion = posicion + pasos;
        if (nuevaPosicion >= totalCasillas) {
            dinero += 200;
            System.out.println(nombre + " pasó por GO y recibe $200.");
        }
        posicion = nuevaPosicion % totalCasillas;
    }

    public void comprarPropiedad(Propiedad propiedad) {
        if (propiedad.propietario == null && dinero >= propiedad.precio) {
            dinero -= propiedad.precio;
            propiedad.propietario = this;
            propiedades.add(propiedad);
            System.out.println(nombre + " compró " + propiedad.nombre);
        }
    }

    public void pagarAlquiler(Propiedad propiedad) {
        if (propiedad.propietario != null && propiedad.propietario != this) {
            dinero -= propiedad.alquiler;
            propiedad.propietario.dinero += propiedad.alquiler;
            System.out.println(nombre + " pagó $" + propiedad.alquiler + " a " + propiedad.propietario.nombre);
        }
    }

    public void mostrarInformacion() {
        System.out.println("Jugador: " + nombre);
        System.out.println("Dinero: $" + dinero);
        System.out.println("Posición: " + posicion);
        System.out.print("Propiedades: ");
        if (propiedades.isEmpty()) {
            System.out.println("Ninguna");
        } else {
            for (Propiedad p : propiedades) {
                System.out.print(p.nombre + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
