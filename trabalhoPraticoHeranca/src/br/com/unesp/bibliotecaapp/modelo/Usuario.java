package br.com.unesp.bibliotecaapp.modelo;

import java.util.ArrayList;

/**
 * Representa um usuario da biblioteca.
 */
public class Usuario {

    private int codigo;
    private String nome;
    private ArrayList<Livro> livrosEmprestados;

    /** Construtor padrao. Inicializa lista de livros emprestados vazia. */
    public Usuario() {
        this.livrosEmprestados = new ArrayList<>();
    }

    /**
     * @param codigo identificador unico do usuario
     * @param nome   nome do usuario
     */
    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    /**
     * @return codigo do usuario
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return nome do usuario
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome novo nome do usuario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Registra um livro como emprestado para este usuario.
     *
     * @param livro livro a adicionar na lista de emprestados
     */
    public void addLivroEmprestado(Livro livro) {
        this.livrosEmprestados.add(livro);
    }

    /**
     * Remove o livro com o ISBN informado da lista de emprestados.
     *
     * @param isbn ISBN do livro a remover
     */
    public void rmvLivroEmprestado(String isbn) {
        for(int i = 0 ; i < livrosEmprestados.size() ; i++) {
            if(livrosEmprestados.get(i).getIsbn().equals(isbn)) {
                livrosEmprestados.remove(i);
                break;
            }
        }
    }

    /**
     * Verifica se o usuario possui o livro com o ISBN informado emprestado.
     *
     * @param isbn ISBN do livro
     * @return true se o usuario possui o livro emprestado
     */
    public boolean possuiLivro(String isbn) {
        for(Livro l : livrosEmprestados) {
            if(l.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Exibe no console a quantidade e os titulos dos livros emprestados ao usuario.
     */
    public void consultarEmprestados() {
        System.out.println("Usuario: " + nome + " | Livros emprestados: " + livrosEmprestados.size());
        for(Livro l : livrosEmprestados) {
            System.out.println("  - " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ")");
        }
        System.out.println();
    }

}
