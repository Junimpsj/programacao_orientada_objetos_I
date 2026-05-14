package br.com.unesp.bancoapp.modelo;

/**
 * Funcionário técnico bancário. Bonificação calculada sobre horas extras (R$ 30,00/hora).
 */
public class TecnicoBancario extends Funcionario {

    private String setorAtendimento;
    private int quantidadeHorasExtras;

    /**
     * @param nome                 nome completo
     * @param cpf                  CPF no formato "000.000.000-00"
     * @param salario              salário base
     * @param setorAtendimento     setor de atuação
     * @param quantidadeHorasExtras número de horas extras no período
     */
    public TecnicoBancario(String nome, String cpf, double salario, String setorAtendimento, int quantidadeHorasExtras) {
        super(nome, cpf, salario);
        this.setorAtendimento = setorAtendimento;
        this.quantidadeHorasExtras = quantidadeHorasExtras;
    }

    /**
     * @param setorAtendimento novo setor de atendimento
     */
    public void setSetorAtendimento(String setorAtendimento) {
        this.setorAtendimento = setorAtendimento;
    }

    /**
     * @param quantidadeHorasExtras nova quantidade de horas extras
     */
    public void setQuantidadeHorasExtras(int quantidadeHorasExtras) {
        this.quantidadeHorasExtras = quantidadeHorasExtras;
    }

    /** @return setor de atendimento */
    public String getSetorAtendimento() {
        return setorAtendimento;
    }

    /** @return quantidade de horas extras */
    public int getQuantidadeHorasExtras() {
        return quantidadeHorasExtras;
    }

    /**
     * Bonificação do técnico bancário: R$ 30,00 por hora extra trabalhada.
     *
     * @return valor da bonificação
     */
    @Override
    public double getBonificacao() {
        return this.quantidadeHorasExtras * 30.0;
    }

}
