package br.com.unesp.bibliotecaapp.aplicacao;

import java.util.Scanner;
import br.com.unesp.bibliotecaapp.modelo.Biblioteca;

/**
 * Ponto de entrada da aplicacao Biblioteca FCT.
 * Oferece menu interativo para gerenciar livros, usuarios, emprestimos e devolucoes.
 */
public class App {

    /**
     * Metodo principal. Exibe menu em loop ate o usuario escolher sair.
     *
     * @param args argumentos de linha de comando (nao utilizados)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca FCT/Unesp");
        int opcao;

        do {
            System.out.println("=== Biblioteca FCT/Unesp ===");
            System.out.println("1  - Adicionar livro fisico");
            System.out.println("2  - Adicionar livro digital");
            System.out.println("3  - Remover livro");
            System.out.println("4  - Listar livros");
            System.out.println("5  - Consultar exemplares disponiveis");
            System.out.println("6  - Adicionar usuario");
            System.out.println("7  - Remover usuario");
            System.out.println("8  - Listar usuarios");
            System.out.println("9  - Emprestar livro");
            System.out.println("10 - Devolver livro");
            System.out.println("11 - Consultar livros emprestados por usuario");
            System.out.println("0  - Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch(opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Ano de publicacao: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Quantidade de exemplares: ");
                    int exemplares = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.addLivro(titulo, autor, isbn, ano, exemplares);
                    System.out.println("Livro adicionado.\n");
                    break;

                case 2:
                    System.out.print("Titulo: ");
                    String tituloD = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorD = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbnD = scanner.nextLine();
                    System.out.print("Ano de publicacao: ");
                    int anoD = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Formato (ex: PDF, EPUB): ");
                    String formato = scanner.nextLine();
                    System.out.print("Tamanho em MB: ");
                    double tamanho = scanner.nextDouble();
                    scanner.nextLine();
                    biblioteca.addLivroDigital(tituloD, autorD, isbnD, anoD, formato, tamanho);
                    System.out.println("Livro digital adicionado.\n");
                    break;

                case 3:
                    System.out.print("ISBN do livro a remover: ");
                    String isbnRmv = scanner.nextLine();
                    biblioteca.rmvLivro(isbnRmv);
                    System.out.println("Livro removido.\n");
                    break;

                case 4:
                    biblioteca.listLivros();
                    break;

                case 5:
                    System.out.print("ISBN do livro: ");
                    String isbnConsult = scanner.nextLine();
                    biblioteca.consultarExemplares(isbnConsult);
                    break;

                case 6:
                    System.out.print("Codigo do usuario: ");
                    int codUser = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do usuario: ");
                    String nomeUser = scanner.nextLine();
                    biblioteca.addUsuario(codUser, nomeUser);
                    System.out.println("Usuario adicionado.\n");
                    break;

                case 7:
                    System.out.print("Codigo do usuario a remover: ");
                    int codRmvUser = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.rmvUsuario(codRmvUser);
                    System.out.println("Usuario removido.\n");
                    break;

                case 8:
                    biblioteca.listUsuarios();
                    break;

                case 9:
                    System.out.print("Codigo do usuario: ");
                    int codEmp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbnEmp = scanner.nextLine();
                    biblioteca.emprestar(codEmp, isbnEmp);
                    break;

                case 10:
                    System.out.print("Codigo do usuario: ");
                    int codDev = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ISBN do livro: ");
                    String isbnDev = scanner.nextLine();
                    biblioteca.devolver(codDev, isbnDev);
                    break;

                case 11:
                    System.out.print("Codigo do usuario: ");
                    int codConsultEmp = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.consultarEmprestados(codConsultEmp);
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
