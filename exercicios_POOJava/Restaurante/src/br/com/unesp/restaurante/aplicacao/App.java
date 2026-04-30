package br.com.unesp.restaurante.aplicacao;

import br.com.unesp.restaurante.modelo.Item;
import br.com.unesp.restaurante.modelo.Mesa;
import br.com.unesp.restaurante.modelo.Pedido;

/**
 * Classe principal que executa a aplicação do sistema de gerenciamento do restaurante FCTrante.
 * Demonstra o uso das classes Mesa, Pedido e Item realizando operações de pedido e controle de mesa.
 */
public class App {

    /**
     * Método principal que executa o programa.
     * Cria mesas com pedidos, calcula totais e demonstra o fluxo de atendimento
     * até a finalização das mesas, exibindo os resultados no console.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        // Criação das mesas
        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(2, 2);

        System.out.println("--- Situação Inicial das Mesas ---\n");

        mesa1.exibir();
        System.out.println();
        mesa2.exibir();

        System.out.println();
        System.out.println("--- Registrando Pedidos ---\n");

        // Pedidos da Mesa 1
        Pedido pedido1Mesa1 = new Pedido();
        pedido1Mesa1.adicionarItem(new Item("X-Burguer", 2, 25.90));
        pedido1Mesa1.adicionarItem(new Item("Suco de Laranja", 2, 8.50));
        pedido1Mesa1.adicionarItem(new Item("Batata Frita Grande", 1, 18.00));

        Pedido pedido2Mesa1 = new Pedido();
        pedido2Mesa1.adicionarItem(new Item("Pizza Calabresa", 1, 55.00));
        pedido2Mesa1.adicionarItem(new Item("Refrigerante 2L", 1, 12.00));

        mesa1.adicionarPedido(pedido1Mesa1);
        mesa1.adicionarPedido(pedido2Mesa1);

        // Pedidos da Mesa 2
        Pedido pedido1Mesa2 = new Pedido();
        pedido1Mesa2.adicionarItem(new Item("Prato Feito", 2, 22.00));
        pedido1Mesa2.adicionarItem(new Item("Água Mineral", 2, 5.00));

        Pedido pedido2Mesa2 = new Pedido();
        pedido2Mesa2.adicionarItem(new Item("Sobremesa do Dia", 2, 14.50));

        mesa2.adicionarPedido(pedido1Mesa2);
        mesa2.adicionarPedido(pedido2Mesa2);

        System.out.println();
        System.out.println("--- Situação das Mesas com Pedidos ---\n");

        mesa1.exibir();
        System.out.println();
        mesa2.exibir();

        System.out.println();
        System.out.println("--- Verificando Pedidos Pendentes ---\n");

        System.out.print("Mesa 1 tem pedidos pendentes? ");
        if(mesa1.temPedidosPendentes()) {
            System.out.println("Sim");
        } if(!mesa1.temPedidosPendentes()) {
            System.out.println("Não");
        }

        System.out.print("Mesa 2 tem pedidos pendentes? ");
        if(mesa2.temPedidosPendentes()) {
            System.out.println("Sim");
        } if(!mesa2.temPedidosPendentes()) {
            System.out.println("Não");
        }

        System.out.println();
        System.out.println("--- Calculando Totais ---\n");

        mesa1.calcularTotal();
        mesa2.calcularTotal();

        System.out.println();
        System.out.println("--- Finalizando Mesas ---\n");

        mesa1.finalizarMesa();
        mesa2.finalizarMesa();

        System.out.println();
        System.out.println("--- Situação Final das Mesas ---\n");

        mesa1.exibir();
        System.out.println();
        mesa2.exibir();

    }

}
