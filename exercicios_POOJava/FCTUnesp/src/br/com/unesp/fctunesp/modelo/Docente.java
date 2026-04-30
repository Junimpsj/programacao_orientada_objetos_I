package br.com.unesp.fctunesp.modelo;

/**
 * Classe que representa um Docente da FCT/Unesp.
 * Herda as características de Funcionário e acrescenta o atributo função.
 * Um docente só pode pertencer a um único departamento.
 */
public class Docente extends Funcionario {

    /** Função ou cargo do docente dentro do departamento */
    private String funcao;

    /**
     * Construtor que inicializa um novo Docente com todos os seus dados.
     *
     * @param codigo  Código identificador do docente
     * @param nome    Nome completo do docente
     * @param salario Salário do docente em reais
     * @param funcao  Função ou cargo do docente no departamento
     */
    public Docente(int codigo, String nome, double salario, String funcao) {
        super(codigo, nome, salario);
        this.funcao = funcao;
    }

    /**
     * Obtém a função do docente.
     *
     * @return Função ou cargo do docente
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * Define a função do docente.
     *
     * @param funcao Função ou cargo a ser atribuído
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * Exibe as informações do docente no console, incluindo a função.
     */
    @Override
    public void exibir() {
        System.out.println("Código: " + this.getCodigo() + " | Nome: " + this.getNome() +
                " | Salário: R$ " + this.getSalario() + " | Função: " + this.funcao);
    }

}
