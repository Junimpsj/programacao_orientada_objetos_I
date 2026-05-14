package br.com.unesp.cartao.modelo;

/**
 * Cartão virtual de Dia dos Namorados.
 */
public class DiaDosNamorados extends CartaoWeb {

    /**
     * Cria cartão de Dia dos Namorados para o destinatário informado.
     *
     * @param destinatario nome de quem receberá o cartão
     */
    public DiaDosNamorados(String destinatario) {
        super(destinatario);
    }

    /**
     * Exibe mensagem de Dia dos Namorados no console.
     */
    @Override
    public void showMessage() {
        System.out.println("Feliz Dia dos Namorados, " + destinatario + "! Que nosso amor seja brilhante como a careca do Lex Luthor.");
    }

}
