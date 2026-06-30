package br.com.unesp.projetonetbeans.model;

import java.util.ArrayList;

/**
 * Representa a universidade FCT/Unesp.
 * Armazena o nome da instituição e a lista de departamentos cadastrados.
 */
public class Universidade {

    private String nome;
    private ArrayList<Departamento> departamentos;

    /**
     * @param nome nome da universidade
     */
    public Universidade(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    /** @return nome da universidade */
    public String getNome() {
        return this.nome;
    }

    /** @return lista de departamentos cadastrados */
    public ArrayList<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    /**
     * Adiciona um departamento à universidade.
     *
     * @param d departamento a adicionar
     */
    public void adicionarDepartamento(Departamento d) {
        this.departamentos.add(d);
    }

    /**
     * Remove o departamento com o código informado.
     *
     * @param codigoDept código do departamento a remover
     * @return {@code true} se removido com sucesso, {@code false} se não encontrado
     */
    public boolean removerDepartamento(int codigoDept) {
        for(int i = 0; i < this.departamentos.size(); i++) {
            if(this.departamentos.get(i).getCodigo() == codigoDept) {
                this.departamentos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca um departamento pelo código.
     *
     * @param codigoDept código do departamento
     * @return departamento encontrado, ou {@code null} se não existir
     */
    public Departamento buscarDepartamento(int codigoDept) {
        for(Departamento d : this.departamentos) {
            if(d.getCodigo() == codigoDept) {
                return d;
            }
        }
        return null;
    }

}
