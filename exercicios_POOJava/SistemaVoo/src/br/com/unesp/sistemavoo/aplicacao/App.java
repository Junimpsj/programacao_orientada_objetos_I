package br.com.unesp.sistemavoo.aplicacao;

import br.com.unesp.sistemavoo.controle.SistemaReserva;
import br.com.unesp.sistemavoo.modelo.Voo;

/**
 * Classe principal que executa o sistema de reservas de assentos da companhia aérea.
 * Inicializa o voo e inicia o sistema de reservas interativo.
 */
public class App {

    /**
     * Método principal que executa o programa.
     * Cria o voo e inicia o sistema de reservas para interação com o usuário.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Voo voo = new Voo("LA3042");

        SistemaReserva sistema = new SistemaReserva(voo);
        sistema.iniciar();

    }

}
