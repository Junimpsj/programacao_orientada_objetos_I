package br.com.unesp.bancoapp.modelo;

/**
 * Representa um funcionário do banco.
 * Subclasses podem sobrescrever {@link #getBonificacao()} para definir
 * regras específicas de bonificação.
 */
public class Funcionario {

    protected String nome;
    protected String cpf;
    protected double salario;

    /**
     * @param nome    nome completo do funcionário
     * @param cpf     CPF no formato "000.000.000-00"
     * @param salario salário base mensal
     */
    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    /**
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf novo CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param salario novo salário base
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /** @return nome completo */
    public String getNome() {
        return nome;
    }

    /** @return CPF */
    public String getCpf() {
        return cpf;
    }

    /** @return salário base */
    public double getSalario() {
        return salario;
    }

    /**
     * Calcula a bonificação do funcionário.
     * Padrão: 10% do salário base.
     *
     * @return valor da bonificação
     */
    public double getBonificacao() {
        return this.salario * 0.10;
    }

    /**
     * Calcula o salário final (salário base + bonificação).
     *
     * @return salário final
     */
    public double getSalarioFinal() {
        return this.salario + this.getBonificacao();
    }

}
