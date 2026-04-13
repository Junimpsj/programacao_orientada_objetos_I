package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.aplicacao;

import java.util.Scanner;
import trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo.Data;

public class Agenda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Data dataInicial = null;
        int dia, mes, ano, diasAdicionar;
        boolean dataValida = false;

        System.out.println("--- Agenda - Calculadora de Datas ---\n");

        while (!dataValida) {
            try {
                System.out.print("Digite o dia: ");
                dia = Integer.parseInt(scanner.nextLine());

                if (dia < 1 || dia > 31) {
                    System.out.println("Erro: Dia deve estar entre 1 e 31!\n");
                    continue;
                }

                System.out.print("Digite o mês: ");
                mes = Integer.parseInt(scanner.nextLine());

                if (mes < 1 || mes > 12) {
                    System.out.println("Erro: Mês deve estar entre 1 e 12!\n");
                    continue;
                }

                System.out.print("Digite o ano: ");
                ano = Integer.parseInt(scanner.nextLine());

                if (ano <= 0) {
                    System.out.println("Erro: Ano deve ser um valor positivo!\n");
                    continue;
                }

                //validando adicionalmente os dias do mês para casos mais "especificos"
                if ((mes == 2 && dia > 29) || ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)) {
                    System.out.println("Erro: Data inválida para o mês escolhido!\n");
                    continue;
                }

                dataInicial = new Data(dia, mes, ano);
                dataValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
            } catch (Exception e) {
                System.out.println("Erro na entrada: " + e.getMessage() + "\n");
            }
        }

        boolean diasValidos = false;
        while (!diasValidos) {
            try {
                System.out.print("\nDigite a quantidade de dias a adicionar: ");
                diasAdicionar = Integer.parseInt(scanner.nextLine());

                if (diasAdicionar < 0) {
                    System.out.println("Erro: A quantidade de dias deve ser positiva!\n");
                    continue;
                }

                diasValidos = true;

                System.out.println("\n--- RESULTADO ---");
                System.out.print("Data inicial: ");
                dataInicial.exibirData();
                System.out.println();

                Data novaData = dataInicial.adicionarDias(diasAdicionar);
                System.out.print("Nova data: ");
                novaData.exibirData();
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!\n");
            } catch (Exception e) {
                System.out.println("Erro na entrada: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
    }

}