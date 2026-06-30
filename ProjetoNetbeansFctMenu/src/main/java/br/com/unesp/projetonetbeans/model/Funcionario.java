package br.com.unesp.projetonetbeans.model;

/**
 * Classe base que representa um funcionário da universidade.
 * Subclasses acrescentam atributos específicos à sua função.
 */
public class Funcionario {

    protected int codigo;
    protected String nome;
    protected double salario;

    /** Construtor padrão. */
    public Funcionario() {}

    /**
     * @param codigo  identificador único do funcionário
     * @param nome    nome do funcionário
     * @param salario salário do funcionário
     */
    public Funcionario(int codigo, String nome, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
    }

    /** @return código do funcionário */
    public int getCodigo() {
        return this.codigo;
    }

    /** @param codigo novo código */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /** @return nome do funcionário */
    public String getNome() {
        return this.nome;
    }

    /** @param nome novo nome */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return salário do funcionário */
    public double getSalario() {
        return this.salario;
    }

    /** @param salario novo salário */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cód: " + this.codigo + " | Nome: " + this.nome + " | Salário: R$ " + this.salario;
    }

}
