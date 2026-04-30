package br.com.unesp.fctapp.modelo;

/**
 * Representa um funcionario da universidade.
 */
public class Funcionario {

    protected int codigo;
    protected String nome;
    protected double salario;

    /** Construtor padrao. */
    public Funcionario() {

    }

    /**
     * @param codigo identificador unico do funcionario
     * @param nome   nome do funcionario
     */
    public Funcionario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    /**
     * @return codigo do funcionario
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return nome do funcionario
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome novo nome do funcionario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return salario do funcionario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario novo salario do funcionario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

}
