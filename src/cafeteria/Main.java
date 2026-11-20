package cafeteria;

import cafeteria.descuento.CalculadoraDescuento;
import cafeteria.descuento.ReglasCafeteria;
import cafeteria.vista.VentanaDescuento;

import javax.swing.SwingUtilities;

/** Punto de entrada. Aquí se crean los objetos y se conectan entre sí. */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraDescuento calculadora =
                    new CalculadoraDescuento(ReglasCafeteria.QUINCE_POR_CIENTO_SOBRE_10);

            VentanaDescuento ventana = new VentanaDescuento(calculadora);
            ventana.setVisible(true);
        });
    }
}
