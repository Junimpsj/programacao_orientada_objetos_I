package app;

import view.CalculadoraView;
import controller.CalculadoraController;
import javax.swing.SwingUtilities;

/**
 * Ponto de entrada da aplicacao Calculadora.
 */
public class Main {

    /**
     * Inicia a interface no Event Dispatch Thread.
     * @param args argumentos da linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraView view = new CalculadoraView();
                new CalculadoraController(view);
                view.setVisible(true);
            }
        });
    }
}
