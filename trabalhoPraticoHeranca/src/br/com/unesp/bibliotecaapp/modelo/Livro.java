package br.com.unesp.bibliotecaapp.modelo;

/**
 * Representa um livro fisico da biblioteca.
 */
public class Livro {

    protected String titulo;
    protected String autor;
    protected String isbn;
    protected int anoPublicacao;
    protected int exemplares;
    protected boolean disponivel;

    /** Construtor padrao. */
    public Livro() {

    }

    /**
     * @param titulo       titulo do livro
     * @param autor        autor do livro
     * @param isbn         codigo ISBN do livro
     * @param anoPublicacao ano de publicacao
     * @param exemplares   quantidade de exemplares disponiveis
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
     * @return titulo do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return autor do livro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @return ISBN do livro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @return ano de publicacao do livro
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * @return quantidade de exemplares disponiveis
     */
    public int getExemplares() {
        return exemplares;
    }

    /**
     * @return true se houver ao menos um exemplar disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Realiza o emprestimo do livro, decrementando os exemplares disponiveis.
     *
     * @return true se o emprestimo foi realizado, false se nao houver exemplares
     */
    public boolean emprestar() {
        if (!disponivel) {
            return false;
        }
        exemplares--;
        disponivel = exemplares > 0;
        return true;
    }

    /**
     * Registra a devolucao do livro, incrementando os exemplares disponiveis.
     */
    public void devolver() {
        exemplares++;
        disponivel = true;
    }

}
