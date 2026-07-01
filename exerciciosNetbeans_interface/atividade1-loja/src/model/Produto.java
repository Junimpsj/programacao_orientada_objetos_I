package model;

/**
 * Representa um produto disponivel na loja, com nome e valor unitario.
 */
public class Produto {

    private String nome;
    private double valor;

    /**
     * @param nome  nome do produto
     * @param valor preco unitario do produto
     */
    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    /**
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return preco unitario do produto
     */
    public double getValor() {
        return valor;
    }
}
