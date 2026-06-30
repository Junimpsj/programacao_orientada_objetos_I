package br.com.unesp.projetonetbeans.model;

/**
 * Representa um docente da universidade.
 * Herda de {@link Funcionario} e acrescenta o atributo função.
 */
public class Docente extends Funcionario {

    private String funcao;

    /** Construtor padrão. */
    public Docente() {}

    /**
     * @param codigo  identificador único do docente
     * @param nome    nome do docente
     * @param funcao  função acadêmica do docente (ex: Professor Titular)
     * @param salario salário do docente
     */
    public Docente(int codigo, String nome, String funcao, double salario) {
        super(codigo, nome, salario);
        this.funcao = funcao;
    }

    /** @return função acadêmica do docente */
    public String getFuncao() {
        return this.funcao;
    }

    /** @param funcao nova função acadêmica */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Cód: " + this.codigo + " | Nome: " + this.nome + " | Função: " + this.funcao + " | Salário: R$ " + this.salario;
    }

}
