package app;

import view.CadastroView;
import controller.CadastroController;
import javax.swing.SwingUtilities;

/**
 * Ponto de entrada da aplicacao de Cadastro.
 */
public class Main {

    /**
     * Inicia a interface no Event Dispatch Thread.
     * @param args argumentos da linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CadastroView view = new CadastroView();
                new CadastroController(view);
                view.setVisible(true);
            }
        });
    }
}
