package br.com.unesp.restaurante.modelo;

import java.util.ArrayList;

/**
 * Classe que representa um Pedido realizado em uma mesa do restaurante FCTrante.
 * Armazena os itens do pedido e calcula o preço total.
 */
public class Pedido {

    /** Lista de itens do pedido */
    private ArrayList<Item> itens;

    /** Preço total calculado dos itens do pedido */
    private double preco;

    /**
     * Construtor que inicializa um novo Pedido vazio.
     * O preço é calculado a partir dos itens adicionados.
     */
    public Pedido() {
        this.itens = new ArrayList<>();
        this.preco = 0;
    }

    /**
     * Obtém a lista de itens do pedido.
     *
     * @return Lista de itens do pedido
     */
    public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     * Obtém o preço total do pedido.
     *
     * @return Preço total em reais
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Adiciona um item ao pedido e recalcula o preço total.
     *
     * @param item Item a ser adicionado ao pedido
     */
    public void adicionarItem(Item item) {
        this.itens.add(item);
        this.preco = this.preco + item.calcularSubtotal();
    }

    /**
     * Exibe todos os itens do pedido e o total no console.
     */
    public void exibir() {
        System.out.println("  Pedido:");
        for(Item i : this.itens) {
            i.exibir();
        }
        System.out.println("  Total do pedido: R$ " + this.preco);
    }

}
