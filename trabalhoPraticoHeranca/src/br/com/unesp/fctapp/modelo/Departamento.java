package br.com.unesp.fctapp.modelo;

import java.util.ArrayList;

/**
 * Representa um departamento da universidade, contendo uma lista de funcionarios.
 */
public class Departamento {

    private int codigo;
    private String nome;
    private String telefone;
    private ArrayList<Funcionario> funcionarios;

    /** Construtor padrao. Inicializa lista de funcionarios vazia. */
    public Departamento() {
        this.funcionarios = new ArrayList<>();
    }

    /**
     * @param codigo   identificador unico do departamento
     * @param nome     nome do departamento
     * @param telefone telefone de contato do departamento
     */
    public Departamento(int codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.funcionarios = new ArrayList<>();
    }

    /**
     * @return codigo do departamento
     */
    public int getCodigo(){
        return codigo;
    }

    /**
     * @return nome do departamento
     */
    public String getNome(){
        return nome;
    }

    /**
     * @param nome novo nome do departamento
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return telefone do departamento
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone novo telefone do departamento
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Cria e adiciona um {@link Docente} ao departamento.
     *
     * @param codigo identificador unico do docente
     * @param nome   nome do docente
     * @param funcao funcao academica do docente
     */
    public void addFuncionario(int codigo, String nome, String funcao) {
        Docente novoDocente = new Docente(codigo, nome, funcao);
        this.funcionarios.add(novoDocente);
    }

    /**
     * Remove o funcionario com o codigo informado.
     *
     * @param codigo codigo do funcionario a remover
     */
    public void rmvFuncionario(int codigo) {
        for(int i = 0 ; i < funcionarios.size() ; i++) {
            if(funcionarios.get(i).getCodigo() == codigo) {
                funcionarios.remove(i);
                break;
            }
        }
    }

    /**
     * Busca funcionario pelo codigo.
     *
     * @param codigo codigo do funcionario
     * @return o {@link Funcionario} encontrado, ou {@code null} se nao existir
     */
    public Funcionario getFuncionario(int codigo) {
        for(Funcionario f : funcionarios) {
            if(f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    /**
     * Exibe dados do funcionario com o codigo informado.
     * Imprime mensagem de erro se nao encontrado.
     *
     * @param codigo codigo do funcionario a consultar
     */
    public void consultarFuncionario(int codigo) {
        for(Funcionario f : funcionarios) {
            if(f.getCodigo() == codigo) {
                System.out.println("Nome: " + f.getNome() + " | Codigo: " + f.getCodigo() + " | Salario: " + f.getSalario());
                if(f instanceof Docente) {
                    System.out.println("Funcao: " + ((Docente) f).getFuncao());
                }
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Funcionario com codigo " + codigo + " nao encontrado.\n");
    }

    /**
     * Lista todos os funcionarios do departamento no console.
     */
    public void listFuncionario() {
        for(Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() + " | Codigo: " + f.getCodigo() + " | Salario: " + f.getSalario());
            if(f instanceof Docente) {
                System.out.println("Funcao: " + ((Docente) f).getFuncao());
            }
            System.out.println("\n");
        }
    }

}
