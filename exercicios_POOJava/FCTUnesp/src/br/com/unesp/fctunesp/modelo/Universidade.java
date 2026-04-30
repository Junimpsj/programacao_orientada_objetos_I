package br.com.unesp.fctunesp.modelo;

import java.util.ArrayList;

/**
 * Classe que representa a Universidade FCT/Unesp.
 * Armazena o nome da universidade e gerencia seus departamentos.
 */
public class Universidade {

    /** Nome da universidade */
    private String nome;

    /** Lista de departamentos da universidade */
    private ArrayList<Departamento> departamentos;

    /**
     * Construtor que inicializa uma nova Universidade com seu nome.
     *
     * @param nome Nome da universidade
     */
    public Universidade(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    /**
     * Obtém o nome da universidade.
     *
     * @return Nome da universidade
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da universidade.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a lista de departamentos da universidade.
     *
     * @return Lista de departamentos
     */
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    /**
     * Adiciona um departamento à universidade.
     *
     * @param departamento Departamento a ser adicionado
     */
    public void adicionarDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
        System.out.println("Departamento " + departamento.getNome() + " adicionado à universidade " + this.nome);
    }

    /**
     * Remove um departamento da universidade pelo código.
     * Exibe mensagem de sucesso ou erro dependendo se o departamento foi encontrado.
     *
     * @param codigo Código do departamento a ser removido
     */
    public void removerDepartamento(int codigo) {
        Departamento paraRemover = null;

        for(Departamento d : this.departamentos) {
            if(d.getCodigo() == codigo) {
                paraRemover = d;
            }
        }

        if(paraRemover != null) {
            this.departamentos.remove(paraRemover);
            System.out.println("Departamento " + paraRemover.getNome() + " removido da universidade.");
        } if(paraRemover == null) {
            System.out.println("Departamento com código " + codigo + " não encontrado.");
        }
    }

    /**
     * Consulta e exibe as informações de um departamento pelo código.
     *
     * @param codigo Código do departamento a ser consultado
     */
    public void consultarDepartamento(int codigo) {
        boolean encontrado = false;

        for(Departamento d : this.departamentos) {
            if(d.getCodigo() == codigo) {
                d.exibir();
                encontrado = true;
            }
        }

        if(!encontrado) {
            System.out.println("Departamento com código " + codigo + " não encontrado.");
        }
    }

    /**
     * Lista todos os departamentos da universidade no console.
     */
    public void listarDepartamentos() {
        System.out.println("--- Departamentos da " + this.nome + " ---");
        for(Departamento d : this.departamentos) {
            d.exibir();
        }
    }

}
