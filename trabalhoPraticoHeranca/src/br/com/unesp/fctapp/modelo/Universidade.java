package br.com.unesp.fctapp.modelo;

import java.util.ArrayList;

/**
 * Representa uma universidade contendo uma lista de departamentos.
 */
public class Universidade {

    private String nome;
    private ArrayList<Departamento> departamentos;

    /** Construtor padrao. Inicializa lista de departamentos vazia. */
    public Universidade() {
        this.departamentos = new ArrayList<>();
    }

    /**
     * @param nome nome da universidade
     */
    public Universidade(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    /**
     * @return nome da universidade
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome novo nome da universidade
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Cria e adiciona um {@link Departamento} a universidade.
     *
     * @param codigo   identificador unico do departamento
     * @param nome     nome do departamento
     * @param telefone telefone de contato do departamento
     */
    public void addDepartamento(int codigo, String nome, String telefone) {
        Departamento novoDepartamento = new Departamento(codigo, nome, telefone);
        this.departamentos.add(novoDepartamento);
    }

    /**
     * Remove o departamento com o codigo informado.
     *
     * @param codigo codigo do departamento a remover
     */
    public void rmvDepartamento(int codigo) {
        for(int i = 0 ; i < departamentos.size() ; i++){
            if(departamentos.get(i).getCodigo() == codigo) {
                departamentos.remove(i);
            }
        }
    }

    /**
     * Busca departamento pelo codigo.
     *
     * @param codigo codigo do departamento
     * @return o {@link Departamento} encontrado, ou {@code null} se nao existir
     */
    public Departamento getDepartamento(int codigo) {
        for(Departamento d : departamentos) {
            if(d.getCodigo() == codigo) {
                return d;
            }
        }
        return null;
    }

    /**
     * Exibe dados do departamento com o codigo informado.
     * Imprime mensagem de erro se nao encontrado.
     *
     * @param codigo codigo do departamento a consultar
     */
    public void consultarDepartamento(int codigo) {
        for(Departamento d : departamentos) {
            if(d.getCodigo() == codigo) {
                System.out.println("Departamento: " + d.getNome() + " | Codigo: " + d.getCodigo() + " | Telefone: " + d.getTelefone());
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Departamento com codigo " + codigo + " nao encontrado.\n");
    }

    /**
     * Lista todos os departamentos da universidade no console.
     */
    public void listDepartamentos(){
        for(Departamento d : departamentos) {
            System.out.println("Departamento: " + d.getNome() + " | Codigo: " + d.getCodigo() + " | Telefone: " + d.getTelefone());
            System.out.println("\n");
        }
    }

}
