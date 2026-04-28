package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.aplicacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo.Compromisso;
import trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo.Data;
import trabalhoPraticoAgenda.src.br.com.unesp.agendapp.util.ValidaData;

/**
 * Classe principal da aplicação. Gerencia o menu e as interações com o usuário.
 */
public class Agenda {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Compromisso> compromissos = new ArrayList<>();

    /**
     * Ponto de entrada da aplicação. Exibe o menu principal e direciona as ações do usuário.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        System.out.println("--- AgendApp ---");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Calcular data futura");
            System.out.println("2 - Cadastrar compromisso");
            System.out.println("3 - Listar todos os compromissos");
            System.out.println("4 - Listar compromissos por data");
            System.out.println("5 - Dias faltando para um compromisso");
            System.out.println("6 - Comparar duas datas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    calcularDataFutura();
                    break;
                case 2:
                    cadastrarCompromisso();
                    break;
                case 3:
                    listarTodos();
                    break;
                case 4:
                    listarPorData();
                    break;
                case 5:
                    diasFaltando();
                    break;
                case 6:
                    compararDatas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    /**
     * Solicita ao usuário os campos de uma data e retorna um objeto {@link Data} validado.
     * Repete a entrada enquanto a data informada for inválida.
     *
     * @param mensagem texto exibido antes da leitura dos campos
     * @return objeto {@link Data} válido
     */
    private static Data lerData(String mensagem) {

        System.out.println(mensagem);
        Data data = null;
        boolean valida = false;

        while (!valida) {
            try {
                System.out.print("Dia: ");
                int dia = Integer.parseInt(scanner.nextLine());

                System.out.print("Mês: ");
                int mes = Integer.parseInt(scanner.nextLine());

                System.out.print("Ano: ");
                int ano = Integer.parseInt(scanner.nextLine());

                data = new Data(dia, mes, ano);

                if (!ValidaData.validar(data)) {
                    System.out.println("Erro: data inválida! Tente novamente.\n");
                    continue;
                }

                valida = true;

            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
            }
        }

        return data;

    }

    /**
     * Lê uma data inicial e uma quantidade de dias, exibe a data resultante após a adição.
     */
    private static void calcularDataFutura() {

        Data dataInicial = lerData("\nDigite a data inicial:");

        int dias = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Quantidade de dias a adicionar: ");
                dias = Integer.parseInt(scanner.nextLine());

                if (dias < 0) {
                    System.out.println("Erro: a quantidade deve ser positiva!\n");
                    continue;
                }

                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
            }
        }

        System.out.print("\nData inicial: ");
        dataInicial.exibirData();
        System.out.println();

        Data novaData = dataInicial.adicionarDias(dias);
        System.out.print("Nova data: ");
        novaData.exibirData();
        System.out.println();

    }

    /**
     * Lê descrição e data do usuário e cadastra um novo compromisso na lista.
     */
    private static void cadastrarCompromisso() {

        System.out.print("\nDescrição do compromisso: ");
        String descricao = scanner.nextLine();

        Data data = lerData("Data do compromisso:");

        compromissos.add(new Compromisso(descricao, data));
        System.out.println("Compromisso cadastrado com sucesso!");

    }

    /**
     * Lista todos os compromissos cadastrados.
     */
    private static void listarTodos() {

        if (compromissos.isEmpty()) {
            System.out.println("\nNenhum compromisso cadastrado.");
            return;
        }

        System.out.println("\n--- Todos os compromissos ---");
        for (Compromisso c : compromissos) {
            c.exibir();
        }

    }

    /**
     * Filtra e exibe os compromissos de uma data específica informada pelo usuário.
     */
    private static void listarPorData() {

        if (compromissos.isEmpty()) {
            System.out.println("\nNenhum compromisso cadastrado.");
            return;
        }

        Data dataFiltro = lerData("\nDigite a data para filtrar:");

        System.out.print("\n--- Compromissos em ");
        dataFiltro.exibirData();
        System.out.println(" ---");

        boolean encontrou = false;
        for (Compromisso c : compromissos) {
            if (c.getData().compararCom(dataFiltro) == 0) {
                c.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum compromisso nessa data.");
        }

    }

    /**
     * Exibe quantos dias faltam (ou já passaram) para um compromisso escolhido pelo usuário.
     * Usa a data atual do sistema como referência.
     */
    private static void diasFaltando() {

        if (compromissos.isEmpty()) {
            System.out.println("\nNenhum compromisso cadastrado.");
            return;
        }

        System.out.println("\n--- Compromissos cadastrados ---");
        for (int i = 0; i < compromissos.size(); i++) {
            System.out.print((i + 1) + " - ");
            compromissos.get(i).exibir();
        }

        int indice = -1;
        while (indice < 1 || indice > compromissos.size()) {
            try {
                System.out.print("Escolha o número do compromisso: ");
                indice = Integer.parseInt(scanner.nextLine());

                if (indice < 1 || indice > compromissos.size()) {
                    System.out.println("Número inválido!\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
            }
        }

        //pega a data de hoje usando Calendar
        Calendar cal = Calendar.getInstance();
        Data hoje = new Data(
            cal.get(Calendar.DAY_OF_MONTH),
            cal.get(Calendar.MONTH) + 1,
            cal.get(Calendar.YEAR)
        );

        Compromisso c = compromissos.get(indice - 1);
        int diff = hoje.diferencaDias(c.getData());

        System.out.print("\nCompromisso: " + c.getDescricao() + " | Data: ");
        c.getData().exibirData();
        System.out.println();

        int comparacao = c.getData().compararCom(hoje);

        if (comparacao < 0) {
            System.out.println("Esse compromisso já passou há " + diff + " dia(s).");
        } else if (comparacao == 0) {
            System.out.println("Esse compromisso é HOJE!");
        } else {
            System.out.println("Faltam " + diff + " dia(s) para esse compromisso.");
        }

    }

    /**
     * Lê duas datas e exibe qual delas é mais recente, ou se são iguais.
     */
    private static void compararDatas() {

        Data data1 = lerData("\nDigite a primeira data:");
        Data data2 = lerData("Digite a segunda data:");

        System.out.print("\nData 1: ");
        data1.exibirData();
        System.out.print("\nData 2: ");
        data2.exibirData();
        System.out.println();

        int resultado = data1.compararCom(data2);

        if (resultado == 0) {
            System.out.println("As duas datas são iguais.");
        } else if (resultado > 0) {
            System.out.println("Data 1 é mais recente que Data 2.");
        } else {
            System.out.println("Data 2 é mais recente que Data 1.");
        }

    }

}
