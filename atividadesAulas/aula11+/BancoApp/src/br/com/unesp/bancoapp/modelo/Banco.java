package br.com.unesp.bancoapp.modelo;

import java.util.ArrayList;

/**
 * Representa o banco como repositório central de funcionários e clientes.
 * Mantém as listas que serão usadas pelo controlador central durante a execução.
 */
public class Banco {

    private String nome;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Cliente> clientes;

    /**
     * @param nome nome do banco
     */
    public Banco(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<Funcionario>();
        this.clientes = new ArrayList<Cliente>();
    }

    /** @return nome do banco */
    public String getNome() {
        return nome;
    }

    /** @return lista de funcionários cadastrados */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /** @return lista de clientes cadastrados */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Adiciona um funcionário ao banco.
     *
     * @param f funcionário a adicionar
     */
    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    /**
     * Adiciona um cliente ao banco.
     *
     * @param c cliente a adicionar
     */
    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

}
