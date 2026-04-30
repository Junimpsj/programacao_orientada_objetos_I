package br.com.unesp.restaurante.modelo;

/**
 * Classe que representa um Item de um pedido do restaurante FCTrante.
 * Armazena a descrição, quantidade e valor unitário do item.
 */
public class Item {

    /** Descrição do item (nome do prato ou bebida) */
    private String descricao;

    /** Quantidade solicitada do item */
    private int quantidade;

    /** Valor unitário do item em reais */
    private double valorUnitario;

    /**
     * Construtor que inicializa um novo Item com seus dados.
     *
     * @param descricao     Descrição do item
     * @param quantidade    Quantidade solicitada do item
     * @param valorUnitario Valor unitário do item em reais
     */
    public Item(String descricao, int quantidade, double valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    /**
     * Obtém a descrição do item.
     *
     * @return Descrição do item
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do item.
     *
     * @param descricao Descrição a ser atribuída
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a quantidade do item.
     *
     * @return Quantidade do item
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do item.
     *
     * @param quantidade Quantidade a ser atribuída
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Obtém o valor unitário do item.
     *
     * @return Valor unitário em reais
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Define o valor unitário do item.
     *
     * @param valorUnitario Valor unitário em reais a ser atribuído
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Calcula o subtotal do item (quantidade multiplicada pelo valor unitário).
     *
     * @return Subtotal do item em reais
     */
    public double calcularSubtotal() {
        double subtotal = this.quantidade * this.valorUnitario;
        return subtotal;
    }

    /**
     * Exibe as informações do item no console.
     */
    public void exibir() {
        System.out.println("  Item: " + this.descricao + " | Qtd: " + this.quantidade +
                " | Unitário: R$ " + this.valorUnitario + " | Subtotal: R$ " + this.calcularSubtotal());
    }

}
