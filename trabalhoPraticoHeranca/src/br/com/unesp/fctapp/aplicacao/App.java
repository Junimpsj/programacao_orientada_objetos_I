package br.com.unesp.fctapp.aplicacao;

import java.util.Scanner;
import br.com.unesp.fctapp.modelo.Departamento;
import br.com.unesp.fctapp.modelo.Universidade;

/**
 * Ponto de entrada da aplicacao FCT/Unesp.
 * Oferece menu interativo para gerenciar departamentos e funcionarios.
 */
public class App {

    /**
     * Metodo principal. Exibe menu em loop ate o usuario escolher sair.
     *
     * @param args argumentos de linha de comando (nao utilizados)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Universidade unesp = new Universidade("FCT/Unesp");
        int opcao;

        do {
            System.out.println("=== FCT/Unesp ===");
            System.out.println("1 - Adicionar departamento");
            System.out.println("2 - Remover departamento");
            System.out.println("3 - Listar departamentos");
            System.out.println("4 - Consultar departamento");
            System.out.println("5 - Adicionar funcionario");
            System.out.println("6 - Remover funcionario");
            System.out.println("7 - Listar funcionarios");
            System.out.println("8 - Consultar funcionario");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch(opcao) {
                case 1:
                    System.out.print("Codigo do departamento: ");
                    int codDepto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do departamento: ");
                    String nomeDepto = scanner.nextLine();
                    System.out.print("Telefone do departamento: ");
                    String telDepto = scanner.nextLine();
                    unesp.addDepartamento(codDepto, nomeDepto, telDepto);
                    System.out.println("Departamento adicionado.\n");
                    break;

                case 2:
                    System.out.print("Codigo do departamento a remover: ");
                    int codRmvDepto = scanner.nextInt();
                    scanner.nextLine();
                    unesp.rmvDepartamento(codRmvDepto);
                    System.out.println("Departamento removido.\n");
                    break;

                case 3:
                    unesp.listDepartamentos();
                    break;

                case 4:
                    System.out.print("Codigo do departamento: ");
                    int codConsultDepto = scanner.nextInt();
                    scanner.nextLine();
                    unesp.consultarDepartamento(codConsultDepto);
                    break;

                case 5:
                    System.out.print("Codigo do departamento: ");
                    int codDeptoFunc = scanner.nextInt();
                    scanner.nextLine();
                    Departamento deptoAdd = unesp.getDepartamento(codDeptoFunc);
                    if(deptoAdd == null) {
                        System.out.println("Departamento nao encontrado.\n");
                        break;
                    }
                    System.out.print("Codigo do funcionario: ");
                    int codFunc = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do funcionario: ");
                    String nomeFunc = scanner.nextLine();
                    System.out.print("Funcao do funcionario: ");
                    String funcaoFunc = scanner.nextLine();
                    System.out.print("Salario do funcionario: ");
                    double salarioFunc = scanner.nextDouble();
                    scanner.nextLine();
                    deptoAdd.addFuncionario(codFunc, nomeFunc, funcaoFunc);
                    deptoAdd.getFuncionario(codFunc).setSalario(salarioFunc);
                    System.out.println("Funcionario adicionado.\n");
                    break;

                case 6:
                    System.out.print("Codigo do departamento: ");
                    int codDeptoRmvFunc = scanner.nextInt();
                    scanner.nextLine();
                    Departamento deptoRmv = unesp.getDepartamento(codDeptoRmvFunc);
                    if(deptoRmv == null) {
                        System.out.println("Departamento nao encontrado.\n");
                        break;
                    }
                    System.out.print("Codigo do funcionario a remover: ");
                    int codRmvFunc = scanner.nextInt();
                    scanner.nextLine();
                    deptoRmv.rmvFuncionario(codRmvFunc);
                    System.out.println("Funcionario removido.\n");
                    break;

                case 7:
                    System.out.print("Codigo do departamento: ");
                    int codDeptoList = scanner.nextInt();
                    scanner.nextLine();
                    Departamento deptoList = unesp.getDepartamento(codDeptoList);
                    if(deptoList == null) {
                        System.out.println("Departamento nao encontrado.\n");
                        break;
                    }
                    deptoList.listFuncionario();
                    break;

                case 8:
                    System.out.print("Codigo do departamento: ");
                    int codDeptoConsult = scanner.nextInt();
                    scanner.nextLine();
                    Departamento deptoConsult = unesp.getDepartamento(codDeptoConsult);
                    if(deptoConsult == null) {
                        System.out.println("Departamento nao encontrado.\n");
                        break;
                    }
                    System.out.print("Codigo do funcionario: ");
                    int codConsultFunc = scanner.nextInt();
                    scanner.nextLine();
                    deptoConsult.consultarFuncionario(codConsultFunc);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.\n");
            }

        } while(opcao != 0);

        scanner.close();

    }

}
