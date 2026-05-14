package br.com.unesp.cartao.aplicacao;

import br.com.unesp.cartao.modelo.Aniversario;
import br.com.unesp.cartao.modelo.CartaoWeb;
import br.com.unesp.cartao.modelo.DiaDosNamorados;
import br.com.unesp.cartao.modelo.Natal;

/**
 * Classe de entrada do exercício de cartões virtuais.
 * <p>
 * Demonstra polimorfismo com {@link CartaoWeb}: cria um array de cartões
 * de tipos distintos e chama {@code showMessage()} para cada um.
 */
public class MainCartao {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        CartaoWeb[] cartoes = {
            new DiaDosNamorados("Ana"),
            new Natal("Carlos"),
            new Aniversario("Beatriz")
        };

        for (CartaoWeb cartao : cartoes) {
            cartao.showMessage();
        }
    }

}
