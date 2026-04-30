package br.com.unesp.sistemavoo.modelo;

/**
 * Classe que representa um Cartão de Embarque gerado após a reserva de um assento.
 * Contém os dados do passageiro, número da poltrona, classe e código do voo.
 */
public class CartaoEmbarque {

    /** Passageiro titular do cartão de embarque */
    private Passageiro passageiro;

    /** Número da poltrona reservada */
    private int poltrona;

    /** Classe do assento (Primeira Classe ou Econômica) */
    private String classe;

    /** Código identificador do voo */
    private String codigoVoo;

    /**
     * Construtor que inicializa um novo Cartão de Embarque com todos os dados necessários.
     *
     * @param passageiro Passageiro titular do cartão
     * @param poltrona   Número da poltrona reservada
     * @param classe     Classe do assento (Primeira Classe ou Econômica)
     * @param codigoVoo  Código identificador do voo
     */
    public CartaoEmbarque(Passageiro passageiro, int poltrona, String classe, String codigoVoo) {
        this.passageiro = passageiro;
        this.poltrona = poltrona;
        this.classe = classe;
        this.codigoVoo = codigoVoo;
    }

    /**
     * Obtém o passageiro titular do cartão.
     *
     * @return Passageiro titular
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Obtém o número da poltrona reservada.
     *
     * @return Número da poltrona
     */
    public int getPoltrona() {
        return poltrona;
    }

    /**
     * Obtém a classe do assento reservado.
     *
     * @return Classe do assento
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Obtém o código do voo.
     *
     * @return Código do voo
     */
    public String getCodigoVoo() {
        return codigoVoo;
    }

    /**
     * Exibe o cartão de embarque com todas as informações no console.
     */
    public void exibir() {
        System.out.println("========================================");
        System.out.println("          CARTÃO DE EMBARQUE            ");
        System.out.println("========================================");
        System.out.println("Voo:        " + this.codigoVoo);
        System.out.println("Passageiro: " + this.passageiro.getNome());
        System.out.println("RG:         " + this.passageiro.getRg());
        System.out.println("Poltrona:   " + this.poltrona);
        System.out.println("Classe:     " + this.classe);
        System.out.println("========================================");
    }

}
