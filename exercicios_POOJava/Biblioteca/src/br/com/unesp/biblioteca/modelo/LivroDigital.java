package br.com.unesp.biblioteca.modelo;

/**
 * Classe que representa um Livro Digital da biblioteca da FCT.
 * Herda as características de Livro e acrescenta formato e tamanho do arquivo.
 * Diferentemente dos livros físicos, não possui limitação de exemplares para empréstimo simultâneo.
 */
public class LivroDigital extends Livro {

    /** Formato do arquivo digital (ex: PDF, EPUB) */
    private String formato;

    /** Tamanho do arquivo em megabytes */
    private double tamanhoArquivo;

    /**
     * Construtor que inicializa um novo Livro Digital com todos os seus dados.
     *
     * @param titulo         Título do livro
     * @param autor          Autor do livro
     * @param isbn           ISBN do livro
     * @param anoPublicacao  Ano de publicação do livro
     * @param formato        Formato do arquivo digital (ex: PDF, EPUB)
     * @param tamanhoArquivo Tamanho do arquivo em megabytes
     */
    public LivroDigital(String titulo, String autor, String isbn, int anoPublicacao, String formato, double tamanhoArquivo) {
        super(titulo, autor, isbn, anoPublicacao, Integer.MAX_VALUE);
        this.formato = formato;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    /**
     * Obtém o formato do arquivo digital.
     *
     * @return Formato do arquivo (ex: PDF, EPUB)
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Define o formato do arquivo digital.
     *
     * @param formato Formato a ser atribuído
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Obtém o tamanho do arquivo em megabytes.
     *
     * @return Tamanho do arquivo em MB
     */
    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    /**
     * Define o tamanho do arquivo em megabytes.
     *
     * @param tamanhoArquivo Tamanho do arquivo em MB
     */
    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    /**
     * Realiza o empréstimo do livro digital.
     * Livros digitais não possuem limite de exemplares, então o empréstimo sempre é permitido.
     *
     * @return {@code true} sempre, pois livros digitais não têm limite de empréstimos simultâneos
     */
    @Override
    public boolean emprestar() {
        return true;
    }

    /**
     * Exibe as informações do livro digital no console, incluindo formato e tamanho.
     */
    @Override
    public void exibir() {
        System.out.println("Título: " + this.getTitulo() + " | Autor: " + this.getAutor() +
                " | ISBN: " + this.getIsbn() + " | Ano: " + this.getAnoPublicacao() +
                " | Formato: " + this.formato + " | Tamanho: " + this.tamanhoArquivo + " MB | [Digital - sem limite de empréstimos]");
    }

}
