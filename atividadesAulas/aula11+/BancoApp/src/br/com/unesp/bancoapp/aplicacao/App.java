package br.com.unesp.bancoapp.aplicacao;

import br.com.unesp.bancoapp.view.Principal;

/**
 * Ponto de entrada da aplicação BancoApp.
 * Inicializa e exibe a janela principal do sistema.
 */
public class App {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        new Principal().setVisible(true);
    }

}
