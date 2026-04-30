package br.com.unesp.sistemavoo.modelo;

/**
 * Classe que representa um Passageiro do sistema de reservas de voo.
 * Armazena o nome e o número de RG do passageiro.
 */
public class Passageiro {

    /** Nome completo do passageiro */
    private String nome;

    /** Número do RG do passageiro */
    private String rg;

    /**
     * Construtor que inicializa um novo Passageiro com seus dados.
     *
     * @param nome Nome completo do passageiro
     * @param rg   Número do RG do passageiro
     */
    public Passageiro(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
    }

    /**
     * Obtém o nome do passageiro.
     *
     * @return Nome do passageiro
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do passageiro.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o número do RG do passageiro.
     *
     * @return Número do RG do passageiro
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o número do RG do passageiro.
     *
     * @param rg Número do RG a ser atribuído
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Exibe as informações do passageiro no console.
     */
    public void exibir() {
        System.out.println("Nome: " + this.nome + " | RG: " + this.rg);
    }

}
