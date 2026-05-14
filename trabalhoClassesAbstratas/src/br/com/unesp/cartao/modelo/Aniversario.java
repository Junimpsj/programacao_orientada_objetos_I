package br.com.unesp.cartao.modelo;

/**
 * Cartão virtual de felicitações de aniversário.
 */
public class Aniversario extends CartaoWeb {

    /**
     * Cria cartão de aniversário para o destinatário informado.
     *
     * @param destinatario nome de quem receberá o cartão
     */
    public Aniversario(String destinatario) {
        super(destinatario);
    }

    /**
     * Exibe mensagem de feliz aniversário no console.
     */
    @Override
    public void showMessage() {
        System.out.println("Feliz Aniversario, " + destinatario + "! E as namoradinhas?");
    }

}
