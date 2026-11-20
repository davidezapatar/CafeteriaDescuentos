package cafeteria;

import cafeteria.descuento.CalculadoraDescuento;
import cafeteria.descuento.ReglasCafeteria;

/** Segunda versión: prueba la regla de descuento hecha con lambda. */
public class Main {

    public static void main(String[] args) {
        CalculadoraDescuento calculadora =
                new CalculadoraDescuento(ReglasCafeteria.QUINCE_POR_CIENTO_SOBRE_10);

        double[] montos = {25, 10, 8};
        for (double monto : montos) {
            System.out.printf("Monto: $%.2f | Descuento: $%.2f | Total: $%.2f%n",
                    monto, calculadora.calcularDescuento(monto), calculadora.calcularTotalFinal(monto));
        }
    }
}
