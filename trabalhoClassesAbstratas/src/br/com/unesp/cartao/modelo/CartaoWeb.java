package br.com.unesp.cartao.modelo;

/**
 * Classe abstrata que representa um cartão virtual (web).
 * <p>
 * Subclasses definem a mensagem específica exibida para o destinatário.
 */
public abstract class CartaoWeb {

    /** Nome do destinatário do cartão. */
    protected String destinatario;

    /**
     * Cria um cartão endereçado ao destinatário informado.
     *
     * @param destinatario nome de quem receberá o cartão
     */
    public CartaoWeb(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Exibe a mensagem do cartão no console.
     * Cada subclasse implementa sua própria mensagem.
     */
    public abstract void showMessage();

}
