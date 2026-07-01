package br.com.unesp.bibliotecaapp.modelo;

import java.util.ArrayList;

/**
 * Representa a biblioteca, gerenciando livros, usuarios, emprestimos e devolucoes.
 */
public class Biblioteca {

    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    /** Construtor padrao. Inicializa listas de livros e usuarios vazias. */
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    /**
     * @param nome nome da biblioteca
     */
    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    /**
     * @return nome da biblioteca
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome novo nome da biblioteca
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um livro fisico ao acervo da biblioteca.
     *
     * @param titulo        titulo do livro
     * @param autor         autor do livro
     * @param isbn          codigo ISBN do livro
     * @param anoPublicacao ano de publicacao
     * @param exemplares    quantidade de exemplares disponiveis
     */
    public void addLivro(String titulo, String autor, String isbn, int anoPublicacao, int exemplares) {
        Livro novoLivro = new Livro(titulo, autor, isbn, anoPublicacao, exemplares);
        this.livros.add(novoLivro);
    }

    /**
     * Adiciona um livro digital ao acervo da biblioteca.
     *
     * @param titulo        titulo do livro
     * @param autor         autor do livro
     * @param isbn          codigo ISBN do livro
     * @param anoPublicacao ano de publicacao
     * @param formato       formato do arquivo (ex: PDF, EPUB)
     * @param tamanhoMB     tamanho do arquivo em megabytes
     */
    public void addLivroDigital(String titulo, String autor, String isbn, int anoPublicacao, String formato, double tamanhoMB) {
        LivroDigital novoLivro = new LivroDigital(titulo, autor, isbn, anoPublicacao, formato, tamanhoMB);
        this.livros.add(novoLivro);
    }

    /**
     * Remove o livro com o ISBN informado do acervo.
     *
     * @param isbn ISBN do livro a remover
     */
    public void rmvLivro(String isbn) {
        for(int i = 0 ; i < livros.size() ; i++) {
            if(livros.get(i).getIsbn().equals(isbn)) {
                livros.remove(i);
                break;
            }
        }
    }

    /**
     * Busca livro pelo ISBN.
     *
     * @param isbn ISBN do livro
     * @return o {@link Livro} encontrado, ou {@code null} se nao existir
     */
    public Livro getLivro(String isbn) {
        for(Livro l : livros) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Adiciona um usuario a biblioteca.
     *
     * @param codigo identificador unico do usuario
     * @param nome   nome do usuario
     */
    public void addUsuario(int codigo, String nome) {
        Usuario novoUsuario = new Usuario(codigo, nome);
        this.usuarios.add(novoUsuario);
    }

    /**
     * Remove o usuario com o codigo informado.
     *
     * @param codigo codigo do usuario a remover
     */
    public void rmvUsuario(int codigo) {
        for(int i = 0 ; i < usuarios.size() ; i++) {
            if(usuarios.get(i).getCodigo() == codigo) {
                usuarios.remove(i);
                break;
            }
        }
    }

    /**
     * Busca usuario pelo codigo.
     *
     * @param codigo codigo do usuario
     * @return o {@link Usuario} encontrado, ou {@code null} se nao existir
     */
    public Usuario getUsuario(int codigo) {
        for(Usuario u : usuarios) {
            if(u.getCodigo() == codigo) {
                return u;
            }
        }
        return null;
    }

    /**
     * Realiza o emprestimo de um livro para um usuario.
     * O emprestimo so e realizado se o livro estiver disponivel e o usuario
     * nao possuir o mesmo livro ja emprestado.
     *
     * @param codUsuario codigo do usuario
     * @param isbn       ISBN do livro
     */
    public void emprestar(int codUsuario, String isbn) {
        Usuario usuario = getUsuario(codUsuario);
        if(usuario == null) {
            System.out.println("Usuario com codigo " + codUsuario + " nao encontrado.\n");
            return;
        }
        Livro livro = getLivro(isbn);
        if(livro == null) {
            System.out.println("Livro com ISBN " + isbn + " nao encontrado.\n");
            return;
        }
        if(usuario.possuiLivro(isbn)) {
            System.out.println("Usuario ja possui este livro emprestado.\n");
            return;
        }
        if(livro.emprestar()) {
            usuario.addLivroEmprestado(livro);
            System.out.println("Emprestimo realizado: " + livro.getTitulo() + " para " + usuario.getNome() + ".\n");
        } else {
            System.out.println("Sem exemplares disponiveis para: " + livro.getTitulo() + ".\n");
        }
    }

    /**
     * Registra a devolucao de um livro por um usuario.
     *
     * @param codUsuario codigo do usuario
     * @param isbn       ISBN do livro a devolver
     */
    public void devolver(int codUsuario, String isbn) {
        Usuario usuario = getUsuario(codUsuario);
        if(usuario == null) {
            System.out.println("Usuario com codigo " + codUsuario + " nao encontrado.\n");
            return;
        }
        if(!usuario.possuiLivro(isbn)) {
            System.out.println("Usuario nao possui este livro emprestado.\n");
            return;
        }
        Livro livro = getLivro(isbn);
        if(livro != null) {
            livro.devolver();
        }
        usuario.rmvLivroEmprestado(isbn);
        System.out.println("Devolucao registrada para: " + usuario.getNome() + ".\n");
    }

    /**
     * Exibe os livros emprestados ao usuario com o codigo informado.
     *
     * @param codUsuario codigo do usuario a consultar
     */
    public void consultarEmprestados(int codUsuario) {
        Usuario usuario = getUsuario(codUsuario);
        if(usuario == null) {
            System.out.println("Usuario com codigo " + codUsuario + " nao encontrado.\n");
            return;
        }
        usuario.consultarEmprestados();
    }

    /**
     * Exibe a quantidade de exemplares disponiveis do livro com o ISBN informado.
     *
     * @param isbn ISBN do livro a consultar
     */
    public void consultarExemplares(String isbn) {
        Livro livro = getLivro(isbn);
        if(livro == null) {
            System.out.println("Livro com ISBN " + isbn + " nao encontrado.\n");
            return;
        }
        if(livro instanceof LivroDigital) {
            System.out.println("Livro: " + livro.getTitulo() + " | Digital | Disponivel: sim\n");
        } else {
            System.out.println("Livro: " + livro.getTitulo() + " | Exemplares disponiveis: " + livro.getExemplares() + "\n");
        }
    }

    /**
     * Lista todos os livros do acervo no console.
     */
    public void listLivros() {
        for(Livro l : livros) {
            System.out.print("Titulo: " + l.getTitulo() + " | Autor: " + l.getAutor() + " | ISBN: " + l.getIsbn() + " | Ano: " + l.getAnoPublicacao());
            if(l instanceof LivroDigital) {
                LivroDigital ld = (LivroDigital) l;
                System.out.println(" | Formato: " + ld.getFormato() + " | Tamanho: " + ld.getTamanhoMB() + " MB | Disponivel: sim");
            } else {
                System.out.println(" | Exemplares: " + l.getExemplares() + " | Disponivel: " + (l.isDisponivel() ? "sim" : "nao"));
            }
            System.out.println();
        }
    }

    /**
     * Lista todos os usuarios cadastrados no console.
     */
    public void listUsuarios() {
        for(Usuario u : usuarios) {
            System.out.println("Codigo: " + u.getCodigo() + " | Nome: " + u.getNome());
            System.out.println();
        }
    }

}
