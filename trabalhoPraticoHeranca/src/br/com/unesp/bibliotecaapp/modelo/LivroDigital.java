package br.com.unesp.bibliotecaapp.modelo;

/**
 * Representa um livro digital, especializacao de {@link Livro}.
 * Nao possui limite de exemplares para emprestimo simultaneo.
 */
public class LivroDigital extends Livro {

    private String formato;
    private double tamanhoMB;

    /**
     * @param titulo        titulo do livro
     * @param autor         autor do livro
     * @param isbn          codigo ISBN do livro
     * @param anoPublicacao ano de publicacao
     * @param formato       formato do arquivo (ex: PDF, EPUB)
     * @param tamanhoMB     tamanho do arquivo em megabytes
     */
    public LivroDigital(String titulo, String autor, String isbn, int anoPublicacao, String formato, double tamanhoMB) {
        super(titulo, autor, isbn, anoPublicacao, 0);
        this.formato = formato;
        this.tamanhoMB = tamanhoMB;
        this.disponivel = true;
    }

    /**
     * @return formato do arquivo do livro digital
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato novo formato do arquivo
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * @return tamanho do arquivo em megabytes
     */
    public double getTamanhoMB() {
        return tamanhoMB;
    }

    /**
     * @param tamanhoMB novo tamanho do arquivo em megabytes
     */
    public void setTamanhoMB(double tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }

    /**
     * Livros digitais nao possuem limite de exemplares.
     * O emprestimo e sempre permitido.
     *
     * @return true sempre
     */
    @Override
    public boolean emprestar() {
        return true;
    }

    /**
     * Livros digitais nao possuem exemplares para atualizar na devolucao.
     */
    @Override
    public void devolver() {

    }

}
