package br.com.unesp.bancoapp.modelo;

/**
 * Funcionário com cargo de diretor. Bonificação baseada em participação nos lucros.
 */
public class Diretor extends Funcionario {

    private double participacaoLucros;
    private String areaResponsavel;

    /**
     * @param nome               nome completo
     * @param cpf                CPF no formato "000.000.000-00"
     * @param salario            salário base
     * @param participacaoLucros taxa de participação nos lucros (ex: 0.35 = 35%)
     * @param areaResponsavel    área de responsabilidade do diretor
     */
    public Diretor(String nome, String cpf, double salario, double participacaoLucros, String areaResponsavel) {
        super(nome, cpf, salario);
        this.participacaoLucros = participacaoLucros;
        this.areaResponsavel = areaResponsavel;
    }

    /**
     * @param participacaoLucros nova taxa de participação nos lucros
     */
    public void setParticipacaoLucros(double participacaoLucros) {
        this.participacaoLucros = participacaoLucros;
    }

    /**
     * @param areaResponsavel nova área de responsabilidade
     */
    public void setAreaResponsavel(String areaResponsavel) {
        this.areaResponsavel = areaResponsavel;
    }

    /** @return taxa de participação nos lucros */
    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    /** @return área de responsabilidade */
    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    /**
     * Bonificação do diretor: salário base * participação nos lucros.
     *
     * @return valor da bonificação
     */
    @Override
    public double getBonificacao() {
        return this.salario * this.participacaoLucros;
    }

}
