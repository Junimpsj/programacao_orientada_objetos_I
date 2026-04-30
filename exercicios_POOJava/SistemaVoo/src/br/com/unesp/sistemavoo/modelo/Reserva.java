package br.com.unesp.sistemavoo.modelo;

/**
 * Classe que representa uma Reserva realizada no sistema de voos.
 * Armazena os dados do passageiro, assento, classe e código do voo.
 */
public class Reserva {

    /** Passageiro que realizou a reserva */
    private Passageiro passageiro;

    /** Número do assento reservado */
    private int assento;

    /** Classe do assento reservado (Primeira Classe ou Econômica) */
    private String classe;

    /** Código do voo da reserva */
    private String codigoVoo;

    /**
     * Construtor que inicializa uma nova Reserva com todos os dados.
     *
     * @param passageiro Passageiro que realizou a reserva
     * @param assento    Número do assento reservado
     * @param classe     Classe do assento reservado
     * @param codigoVoo  Código do voo
     */
    public Reserva(Passageiro passageiro, int assento, String classe, String codigoVoo) {
        this.passageiro = passageiro;
        this.assento = assento;
        this.classe = classe;
        this.codigoVoo = codigoVoo;
    }

    /**
     * Obtém o passageiro da reserva.
     *
     * @return Passageiro da reserva
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Obtém o número do assento reservado.
     *
     * @return Número do assento
     */
    public int getAssento() {
        return assento;
    }

    /**
     * Define o número do assento reservado.
     *
     * @param assento Número do assento a ser atribuído
     */
    public void setAssento(int assento) {
        this.assento = assento;
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
     * Define a classe do assento reservado.
     *
     * @param classe Classe a ser atribuída
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }

    /**
     * Obtém o código do voo da reserva.
     *
     * @return Código do voo
     */
    public String getCodigoVoo() {
        return codigoVoo;
    }

    /**
     * Exibe as informações da reserva no console.
     */
    public void exibir() {
        System.out.println("Voo: " + this.codigoVoo + " | Passageiro: " + this.passageiro.getNome() +
                " | RG: " + this.passageiro.getRg() + " | Assento: " + this.assento + " | Classe: " + this.classe);
    }

}
