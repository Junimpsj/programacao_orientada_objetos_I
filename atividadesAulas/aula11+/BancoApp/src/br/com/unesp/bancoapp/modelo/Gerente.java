package br.com.unesp.bancoapp.modelo;

/**
 * Funcionário com cargo de gerente. Bonificação de 20% sobre o salário base.
 */
public class Gerente extends Funcionario {

    private String agencia;

    /**
     * @param nome    nome completo
     * @param cpf     CPF no formato "000.000.000-00"
     * @param salario salário base
     * @param agencia agência que o gerente administra
     */
    public Gerente(String nome, String cpf, double salario, String agencia) {
        super(nome, cpf, salario);
        this.agencia = agencia;
    }

    /**
     * @param agencia nova agência
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /** @return agência do gerente */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Bonificação do gerente: 20% do salário base.
     *
     * @return valor da bonificação
     */
    @Override
    public double getBonificacao() {
        return this.salario * 0.20;
    }

}
