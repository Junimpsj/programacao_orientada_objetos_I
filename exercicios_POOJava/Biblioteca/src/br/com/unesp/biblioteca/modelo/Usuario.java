package br.com.unesp.biblioteca.modelo;

import java.util.ArrayList;

/**
 * Classe que representa um Usuário da biblioteca da FCT.
 * Armazena os dados do usuário e controla os livros que ele possui emprestados.
 */
public class Usuario {

    /** Nome completo do usuário */
    private String nome;

    /** Lista de livros que o usuário possui emprestados no momento */
    private ArrayList<Livro> livrosEmprestados;

    /**
     * Construtor que inicializa um novo Usuário com seu nome.
     *
     * @param nome Nome completo do usuário
     */
    public Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return Nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de livros emprestados pelo usuário.
     *
     * @return Lista de livros emprestados
     */
    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    /**
     * Realiza o empréstimo de um livro para o usuário.
     * Verifica disponibilidade antes de realizar o empréstimo e registra o livro na lista do usuário.
     *
     * @param livro Livro a ser emprestado
     */
    public void pegarEmprestado(Livro livro) {
        boolean sucesso = livro.emprestar();

        if(sucesso) {
            this.livrosEmprestados.add(livro);
            System.out.println(this.nome + " pegou emprestado: \"" + livro.getTitulo() + "\"");
        } if(!sucesso) {
            System.out.println("Não foi possível realizar o empréstimo de \"" + livro.getTitulo() + "\" para " + this.nome);
        }
    }

    /**
     * Realiza a devolução de um livro pelo usuário.
     * Remove o livro da lista de empréstimos e atualiza os exemplares disponíveis.
     *
     * @param livro Livro a ser devolvido
     */
    public void devolver(Livro livro) {
        boolean encontrado = this.livrosEmprestados.remove(livro);

        if(encontrado) {
            livro.devolver();
            System.out.println(this.nome + " devolveu: \"" + livro.getTitulo() + "\"");
        } if(!encontrado) {
            System.out.println("O livro \"" + livro.getTitulo() + "\" não está na lista de empréstimos de " + this.nome);
        }
    }

    /**
     * Consulta e exibe quantos livros o usuário possui emprestados no momento.
     */
    public void consultarEmprestados() {
        int quantidade = this.livrosEmprestados.size();
        System.out.println(this.nome + " possui " + quantidade + " livro(s) emprestado(s).");

        for(Livro l : this.livrosEmprestados) {
            System.out.println("  - " + l.getTitulo());
        }
    }

}
