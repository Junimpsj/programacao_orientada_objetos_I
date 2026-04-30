package br.com.unesp.fctunesp.modelo;

/**
 * Classe base que representa um Funcionário da FCT/Unesp.
 * Contém os atributos fundamentais compartilhados por todos os tipos de funcionários.
 */
public class Funcionario {

    /** Código identificador do funcionário */
    private int codigo;

    /** Nome completo do funcionário */
    private String nome;

    /** Salário do funcionário em reais */
    private double salario;

    /**
     * Construtor que inicializa um novo Funcionário com seus dados básicos.
     *
     * @param codigo  Código identificador do funcionário
     * @param nome    Nome completo do funcionário
     * @param salario Salário do funcionário em reais
     */
    public Funcionario(int codigo, String nome, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
    }

    /**
     * Obtém o código identificador do funcionário.
     *
     * @return Código do funcionário
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define o código identificador do funcionário.
     *
     * @param codigo Código a ser atribuído
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém o nome do funcionário.
     *
     * @return Nome do funcionário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o salário do funcionário.
     *
     * @return Salário do funcionário em reais
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Define o salário do funcionário.
     *
     * @param salario Salário a ser atribuído em reais
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Exibe as informações do funcionário no console.
     */
    public void exibir() {
        System.out.println("Código: " + this.codigo + " | Nome: " + this.nome + " | Salário: R$ " + this.salario);
    }

}
