package br.com.unesp.projetonetbeans.model;

import java.util.ArrayList;

/**
 * Representa um departamento da FCT/Unesp.
 * Cada departamento possui um código, nome, telefone e uma lista de funcionários.
 */
public class Departamento {

    private int codigo;
    private String nome;
    private String telefone;
    private ArrayList<Funcionario> funcionarios;

    /**
     * @param codigo   identificador único do departamento
     * @param nome     nome do departamento
     * @param telefone telefone de contato do departamento
     */
    public Departamento(int codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.funcionarios = new ArrayList<>();
    }

    /** @return código do departamento */
    public int getCodigo() {
        return this.codigo;
    }

    /** @return nome do departamento */
    public String getNome() {
        return this.nome;
    }

    /** @param nome novo nome do departamento */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return telefone do departamento */
    public String getTelefone() {
        return this.telefone;
    }

    /** @param telefone novo telefone do departamento */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /** @return lista de funcionários do departamento */
    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    /**
     * Adiciona um funcionário ao departamento.
     *
     * @param f funcionário a adicionar
     */
    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }

    /**
     * Remove o funcionário com o código informado.
     *
     * @param codigoFuncionario código do funcionário a remover
     * @return {@code true} se removido com sucesso, {@code false} se não encontrado
     */
    public boolean removerFuncionario(int codigoFuncionario) {
        for(int i = 0; i < this.funcionarios.size(); i++) {
            if(this.funcionarios.get(i).getCodigo() == codigoFuncionario) {
                this.funcionarios.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca um funcionário pelo código.
     *
     * @param codigoFuncionario código do funcionário
     * @return funcionário encontrado, ou {@code null} se não existir
     */
    public Funcionario buscarFuncionario(int codigoFuncionario) {
        for(Funcionario f : this.funcionarios) {
            if(f.getCodigo() == codigoFuncionario) {
                return f;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Departamento: " + this.nome + " (Tel: " + this.telefone + ") - Cód: " + this.codigo;
    }

}
