package br.com.unesp.cartao.modelo;

/**
 * Cartão virtual de Natal.
 */
public class Natal extends CartaoWeb {

    /**
     * Cria cartão de Natal para o destinatário informado.
     *
     * @param destinatario nome de quem receberá o cartão
     */
    public Natal(String destinatario) {
        super(destinatario);
    }

    /**
     * Exibe mensagem de Feliz Natal no console.
     */
    @Override
    public void showMessage() {
        System.out.println("Feliz Natal, " + destinatario + "! Que papai Noel te traga muita linguiça.");
    }

}
