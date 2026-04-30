package br.com.unesp.restaurante.modelo;

import java.util.ArrayList;

/**
 * Classe que representa uma Mesa do restaurante FCTrante.
 * Gerencia os pedidos realizados na mesa, o total a pagar e o status de atividade.
 */
public class Mesa {

    /** Número identificador da mesa */
    private int numero;

    /** Quantidade de clientes sentados na mesa */
    private int quantidadeClientes;

    /** Lista de pedidos realizados na mesa */
    private ArrayList<Pedido> listaDePedidos;

    /** Total acumulado a pagar pela mesa em reais */
    private double totalAPagar;

    /** Indica se a mesa está ativa (atendendo clientes) ou livre */
    private boolean mesaAtiva;

    /**
     * Construtor que inicializa uma nova Mesa com seu número e quantidade de clientes.
     * A mesa começa ativa ao ser criada.
     *
     * @param numero             Número identificador da mesa
     * @param quantidadeClientes Quantidade de clientes sentados na mesa
     */
    public Mesa(int numero, int quantidadeClientes) {
        this.numero = numero;
        this.quantidadeClientes = quantidadeClientes;
        this.listaDePedidos = new ArrayList<>();
        this.totalAPagar = 0;
        this.mesaAtiva = true;
    }

    /**
     * Obtém o número da mesa.
     *
     * @return Número da mesa
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número da mesa.
     *
     * @param numero Número a ser atribuído
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém a quantidade de clientes na mesa.
     *
     * @return Quantidade de clientes
     */
    public int getQuantidadeClientes() {
        return quantidadeClientes;
    }

    /**
     * Define a quantidade de clientes na mesa.
     *
     * @param quantidadeClientes Quantidade de clientes a ser atribuída
     */
    public void setQuantidadeClientes(int quantidadeClientes) {
        this.quantidadeClientes = quantidadeClientes;
    }

    /**
     * Obtém o total acumulado a pagar pela mesa.
     *
     * @return Total a pagar em reais
     */
    public double getTotalAPagar() {
        return totalAPagar;
    }

    /**
     * Verifica se a mesa está ativa.
     *
     * @return {@code true} se a mesa está ativa, {@code false} se está livre
     */
    public boolean isMesaAtiva() {
        return mesaAtiva;
    }

    /**
     * Adiciona um pedido à mesa e atualiza o total a pagar.
     * Só é possível adicionar pedidos em mesas ativas.
     *
     * @param pedido Pedido a ser adicionado à mesa
     */
    public void adicionarPedido(Pedido pedido) {
        if(this.mesaAtiva) {
            this.listaDePedidos.add(pedido);
            this.totalAPagar = this.totalAPagar + pedido.getPreco();
            System.out.println("Pedido adicionado à Mesa " + this.numero);
        } if(!this.mesaAtiva) {
            System.out.println("Mesa " + this.numero + " está fechada. Não é possível adicionar pedidos.");
        }
    }

    /**
     * Calcula e exibe o total a pagar pela mesa com base nos pedidos realizados.
     */
    public void calcularTotal() {
        double total = 0;

        for(Pedido p : this.listaDePedidos) {
            total = total + p.getPreco();
        }

        this.totalAPagar = total;
        System.out.println("Total a pagar da Mesa " + this.numero + ": R$ " + this.totalAPagar);
    }

    /**
     * Verifica se a mesa possui pedidos pendentes.
     *
     * @return {@code true} se há pedidos na mesa, {@code false} caso contrário
     */
    public boolean temPedidosPendentes() {
        if(this.listaDePedidos.size() > 0) {
            return true;
        } if(this.listaDePedidos.size() == 0) {
            return false;
        }
        return false;
    }

    /**
     * Finaliza o atendimento da mesa, liberando-a para novos clientes.
     * Só finaliza se não houver pedidos pendentes ou se o pagamento foi realizado.
     */
    public void finalizarMesa() {
        this.mesaAtiva = false;
        this.listaDePedidos.clear();
        this.totalAPagar = 0;
        System.out.println("Mesa " + this.numero + " finalizada e liberada para novos clientes.");
    }

    /**
     * Exibe todas as informações da mesa no console, incluindo pedidos e total a pagar.
     */
    public void exibir() {
        System.out.println("=== Mesa " + this.numero + " | Clientes: " + this.quantidadeClientes +
                " | Situação: " + (this.mesaAtiva ? "Ativa" : "Finalizada") + " ===");

        if(this.listaDePedidos.size() > 0) {
            for(Pedido p : this.listaDePedidos) {
                p.exibir();
            }
            System.out.println("Total a pagar: R$ " + this.totalAPagar);
        } if(this.listaDePedidos.size() == 0) {
            System.out.println("  Nenhum pedido registrado.");
        }
    }

}
