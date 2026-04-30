package br.com.unesp.fctunesp.modelo;

import java.util.ArrayList;

/**
 * Classe que representa um Departamento da FCT/Unesp.
 * Armazena as informações do departamento e gerencia seus funcionários.
 */
public class Departamento {

    /** Código identificador do departamento */
    private int codigo;

    /** Nome do departamento */
    private String nome;

    /** Telefone de contato do departamento */
    private String telefone;

    /** Lista de funcionários vinculados ao departamento */
    private ArrayList<Funcionario> funcionarios;

    /**
     * Construtor que inicializa um novo Departamento com seus dados básicos.
     *
     * @param codigo   Código identificador do departamento
     * @param nome     Nome do departamento
     * @param telefone Telefone de contato do departamento
     */
    public Departamento(int codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.funcionarios = new ArrayList<>();
    }

    /**
     * Obtém o código identificador do departamento.
     *
     * @return Código do departamento
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define o código identificador do departamento.
     *
     * @param codigo Código a ser atribuído
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o nome do departamento.
     *
     * @return Nome do departamento
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do departamento.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone de contato do departamento.
     *
     * @return Telefone do departamento
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone de contato do departamento.
     *
     * @param telefone Telefone a ser atribuído
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém a lista de funcionários do departamento.
     *
     * @return Lista de funcionários
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * Adiciona um funcionário ao departamento.
     *
     * @param funcionario Funcionário a ser adicionado
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " adicionado ao departamento " + this.nome);
    }

    /**
     * Remove um funcionário do departamento pelo código.
     * Exibe mensagem de sucesso ou erro dependendo se o funcionário foi encontrado.
     *
     * @param codigo Código do funcionário a ser removido
     */
    public void removerFuncionario(int codigo) {
        Funcionario paraRemover = null;

        for(Funcionario f : this.funcionarios) {
            if(f.getCodigo() == codigo) {
                paraRemover = f;
            }
        }

        if(paraRemover != null) {
            this.funcionarios.remove(paraRemover);
            System.out.println("Funcionário " + paraRemover.getNome() + " removido do departamento " + this.nome);
        } if(paraRemover == null) {
            System.out.println("Funcionário com código " + codigo + " não encontrado no departamento " + this.nome);
        }
    }

    /**
     * Consulta e exibe as informações de um funcionário pelo código.
     *
     * @param codigo Código do funcionário a ser consultado
     */
    public void consultarFuncionario(int codigo) {
        boolean encontrado = false;

        for(Funcionario f : this.funcionarios) {
            if(f.getCodigo() == codigo) {
                f.exibir();
                encontrado = true;
            }
        }

        if(!encontrado) {
            System.out.println("Funcionário com código " + codigo + " não encontrado.");
        }
    }

    /**
     * Lista todos os funcionários do departamento no console.
     */
    public void listarFuncionarios() {
        System.out.println("--- Funcionários do Departamento " + this.nome + " ---");
        for(Funcionario f : this.funcionarios) {
            f.exibir();
        }
    }

    /**
     * Exibe as informações do departamento no console.
     */
    public void exibir() {
        System.out.println("Código: " + this.codigo + " | Nome: " + this.nome + " | Telefone: " + this.telefone);
    }

}
