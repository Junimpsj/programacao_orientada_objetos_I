package br.com.unesp.biblioteca.modelo;

/**
 * Classe que representa um Livro físico da biblioteca da FCT.
 * Gerencia as informações do livro e o controle de exemplares disponíveis para empréstimo.
 */
public class Livro {

    /** Título do livro */
    private String titulo;

    /** Autor do livro */
    private String autor;

    /** ISBN (International Standard Book Number) do livro */
    private String isbn;

    /** Ano de publicação do livro */
    private int anoPublicacao;

    /** Quantidade de exemplares disponíveis para empréstimo */
    private int exemplares;

    /** Indica se há exemplares disponíveis para empréstimo */
    private boolean disponivel;

    /**
     * Construtor que inicializa um novo Livro com seus dados e quantidade de exemplares.
     *
     * @param titulo        Título do livro
     * @param autor         Autor do livro
     * @param isbn          ISBN do livro
     * @param anoPublicacao Ano de publicação do livro
     * @param exemplares    Quantidade inicial de exemplares disponíveis
     */
    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int exemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = exemplares;
        this.disponivel = exemplares > 0;
    }

    /**
     * Obtém o título do livro.
     *
     * @return Título do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do livro.
     *
     * @param titulo Título a ser atribuído
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o autor do livro.
     *
     * @return Autor do livro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Define o autor do livro.
     *
     * @param autor Autor a ser atribuído
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtém o ISBN do livro.
     *
     * @return ISBN do livro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Define o ISBN do livro.
     *
     * @param isbn ISBN a ser atribuído
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtém o ano de publicação do livro.
     *
     * @return Ano de publicação do livro
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * Define o ano de publicação do livro.
     *
     * @param anoPublicacao Ano de publicação a ser atribuído
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * Obtém a quantidade de exemplares disponíveis do livro.
     *
     * @return Quantidade de exemplares disponíveis
     */
    public int getExemplares() {
        return exemplares;
    }

    /**
     * Define a quantidade de exemplares disponíveis e atualiza a flag de disponibilidade.
     *
     * @param exemplares Quantidade de exemplares a ser atribuída
     */
    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
        this.disponivel = exemplares > 0;
    }

    /**
     * Verifica se o livro possui exemplares disponíveis para empréstimo.
     *
     * @return {@code true} se há exemplares disponíveis, {@code false} caso contrário
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Realiza o empréstimo do livro, reduzindo a quantidade de exemplares disponíveis.
     * Atualiza a flag de disponibilidade após o empréstimo.
     * Exibe mensagem de erro caso não haja exemplares disponíveis.
     *
     * @return {@code true} se o empréstimo foi realizado com sucesso, {@code false} caso contrário
     */
    public boolean emprestar() {
        if(this.disponivel) {
            this.exemplares = this.exemplares - 1;
            this.disponivel = this.exemplares > 0;
            return true;
        } if(!this.disponivel) {
            System.out.println("Não há exemplares disponíveis de \"" + this.titulo + "\".");
            return false;
        }
        return false;
    }

    /**
     * Realiza a devolução do livro, aumentando a quantidade de exemplares disponíveis.
     * Atualiza a flag de disponibilidade após a devolução.
     */
    public void devolver() {
        this.exemplares = this.exemplares + 1;
        this.disponivel = true;
    }

    /**
     * Exibe as informações do livro no console.
     */
    public void exibir() {
        System.out.println("Título: " + this.titulo + " | Autor: " + this.autor +
                " | ISBN: " + this.isbn + " | Ano: " + this.anoPublicacao +
                " | Exemplares disponíveis: " + this.exemplares);
    }

}
