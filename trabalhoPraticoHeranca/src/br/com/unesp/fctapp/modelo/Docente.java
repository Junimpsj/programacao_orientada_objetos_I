package br.com.unesp.fctapp.modelo;

/**
 * Representa um docente, especialização de {@link Funcionario} com funcao academica.
 */
public class Docente extends Funcionario {

    private String funcao;

    /**
     * @param codigo identificador unico do docente
     * @param nome   nome do docente
     */
    public Docente(int codigo, String nome) {
        super(codigo, nome);
    }

    /**
     * @param codigo identificador unico do docente
     * @param nome   nome do docente
     * @param funcao funcao academica do docente (ex: Professor Titular)
     */
    public Docente(int codigo, String nome, String funcao) {
        super(codigo, nome);
        this.funcao = funcao;
    }

    /**
     * @return funcao academica do docente
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao nova funcao academica do docente
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
