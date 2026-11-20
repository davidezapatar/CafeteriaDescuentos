package cafeteria;

import cafeteria.modelo.Bebida;
import cafeteria.modelo.Comida;
import cafeteria.modelo.Producto;

import java.util.List;

/** Primera versión: solo prueba las clases del modelo en la consola. */
public class Main {

    public static void main(String[] args) {
        List<Producto> productos = List.of(
                new Bebida("Café americano", 2.50, true),
                new Comida("Empanada de verduras", 2.00, true));

        for (Producto p : productos) {
            System.out.println(p.describir());
        }
    }
}
