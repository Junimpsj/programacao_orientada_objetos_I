package app;

import view.LojaView;
import controller.LojaController;
import javax.swing.SwingUtilities;

/**
 * Ponto de entrada da aplicacao Loja Teste.
 */
public class Main {

    /**
     * Inicia a interface no Event Dispatch Thread.
     * @param args argumentos da linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LojaView view = new LojaView();
                new LojaController(view);
                view.setVisible(true);
            }
        });
    }
}