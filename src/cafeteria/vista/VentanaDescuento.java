package cafeteria.vista;

import cafeteria.descuento.CalculadoraDescuento;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Ventana de la aplicación. Solo muestra datos y recibe lo que escribe el usuario.
 * Los cálculos los hace la CalculadoraDescuento.
 */
public class VentanaDescuento extends JFrame {

    private static final long serialVersionUID = 1L;

    private final CalculadoraDescuento calculadora;

    private final JTextField campoMonto = new JTextField(10);
    private final JButton botonCalcular = new JButton("Calcular Descuento");
    private final JTextArea areaResultado = new JTextArea(16, 58);

    public VentanaDescuento(CalculadoraDescuento calculadora) {
        super("Cafetería - Calculadora de descuentos");
        this.calculadora = calculadora;
        armarVentana();
        areaResultado.append("Escriba el monto y presione Calcular Descuento.\n");
    }

    private void armarVentana() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEntrada.add(new JLabel("Monto total del pedido ($):"));
        panelEntrada.add(campoMonto);
        panelEntrada.add(botonCalcular);

        areaResultado.setEditable(false);
        areaResultado.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        setContentPane(panel);

        // El evento del botón: leer el monto, aplicar la lambda y mostrar el resultado
        botonCalcular.addActionListener(e -> calcular());
        // Enter en el campo de texto hace lo mismo que el botón
        campoMonto.addActionListener(e -> calcular());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void calcular() {
        String texto = campoMonto.getText().trim().replace(",", ".");
        try {
            double total = Double.parseDouble(texto);
            double descuento = calculadora.calcularDescuento(total);
            double totalFinal = calculadora.calcularTotalFinal(total);
            areaResultado.append(String.format(
                    "Monto: $%.2f | Descuento: $%.2f | Total a pagar: $%.2f%n",
                    total, descuento, totalFinal));
        } catch (NumberFormatException ex) {
            areaResultado.append("Escriba un número válido, por ejemplo 12.50\n");
        } catch (IllegalArgumentException ex) {
            areaResultado.append(ex.getMessage() + "\n");
        }
        campoMonto.selectAll();
        campoMonto.requestFocus();
    }
}
