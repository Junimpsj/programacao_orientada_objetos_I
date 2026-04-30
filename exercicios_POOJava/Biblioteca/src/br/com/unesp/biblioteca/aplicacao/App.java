package br.com.unesp.biblioteca.aplicacao;

import br.com.unesp.biblioteca.modelo.Livro;
import br.com.unesp.biblioteca.modelo.LivroDigital;
import br.com.unesp.biblioteca.modelo.Usuario;

/**
 * Classe principal que executa a aplicação do sistema de biblioteca da FCT.
 * Demonstra o uso das classes Livro, LivroDigital e Usuario realizando
 * operações de empréstimo, devolução e consulta.
 */
public class App {

    /**
     * Método principal que executa o programa.
     * Cria livros e usuários, realiza empréstimos e devoluções,
     * exibindo os resultados de cada operação no console.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        // Criação dos livros físicos
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0-261-10320-7", 1954, 3);
        Livro livro2 = new Livro("1984", "George Orwell", "978-0-452-28423-4", 1949, 1);
        Livro livro3 = new Livro("Dom Casmurro", "Machado de Assis", "978-85-359-0277-5", 1899, 2);

        // Criação dos livros digitais
        LivroDigital livroDigital1 = new LivroDigital("Introdução aos Algoritmos", "Thomas H. Cormen", "978-0-262-03384-8", 2009, "PDF", 45.5);
        LivroDigital livroDigital2 = new LivroDigital("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008, "EPUB", 12.3);

        // Criação dos usuários
        Usuario usuario1 = new Usuario("Frodo Baggins");
        Usuario usuario2 = new Usuario("Bilbo Bolseiro");

        System.out.println("--- Acervo da Biblioteca ---\n");

        livro1.exibir();
        livro2.exibir();
        livro3.exibir();
        livroDigital1.exibir();
        livroDigital2.exibir();

        System.out.println();
        System.out.println("--- Realizando Empréstimos ---\n");

        usuario1.pegarEmprestado(livro1);
        usuario1.pegarEmprestado(livro2);
        usuario2.pegarEmprestado(livro2);
        usuario2.pegarEmprestado(livro3);
        usuario1.pegarEmprestado(livroDigital1);
        usuario2.pegarEmprestado(livroDigital1);

        System.out.println();
        System.out.println("--- Situação dos Livros Após Empréstimos ---\n");

        livro1.exibir();
        livro2.exibir();
        livro3.exibir();

        System.out.println();
        System.out.println("--- Livros Emprestados por Usuário ---\n");

        usuario1.consultarEmprestados();
        System.out.println();
        usuario2.consultarEmprestados();

        System.out.println();
        System.out.println("--- Realizando Devoluções ---\n");

        usuario1.devolver(livro2);
        usuario2.devolver(livro3);

        System.out.println();
        System.out.println("--- Situação Após Devoluções ---\n");

        livro2.exibir();
        livro3.exibir();

        System.out.println();
        System.out.println("--- Livros Emprestados por Usuário (após devoluções) ---\n");

        usuario1.consultarEmprestados();
        System.out.println();
        usuario2.consultarEmprestados();

    }

}
