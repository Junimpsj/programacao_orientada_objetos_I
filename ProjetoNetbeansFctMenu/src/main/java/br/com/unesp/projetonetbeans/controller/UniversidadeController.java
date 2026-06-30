package br.com.unesp.projetonetbeans.controller;

import br.com.unesp.projetonetbeans.model.Departamento;
import br.com.unesp.projetonetbeans.model.Docente;
import br.com.unesp.projetonetbeans.model.Funcionario;
import br.com.unesp.projetonetbeans.model.Universidade;
import java.util.ArrayList;

/**
 * Controlador central da universidade.
 * Ponto único de acesso para todas as operações sobre departamentos e funcionários.
 */
public class UniversidadeController {

    private Universidade universidade;

    /**
     * @param nomeUniversidade nome da universidade
     */
    public UniversidadeController(String nomeUniversidade) {
        this.universidade = new Universidade(nomeUniversidade);
    }

    /**
     * Cadastra um novo departamento na universidade.
     *
     * @param codigo   código identificador do departamento
     * @param nome     nome do departamento
     * @param telefone telefone de contato
     */
    public void cadastrarDepartamento(int codigo, String nome, String telefone) {
        universidade.adicionarDepartamento(new Departamento(codigo, nome, telefone));
    }

    /**
     * Remove o departamento com o código informado.
     *
     * @param codigo código do departamento a excluir
     * @return {@code true} se removido com sucesso
     */
    public boolean excluirDepartamento(int codigo) {
        return universidade.removerDepartamento(codigo);
    }

    /**
     * @return lista de todos os departamentos cadastrados
     */
    public ArrayList<Departamento> listarDepartamentos() {
        return universidade.getDepartamentos();
    }

    /**
     * Busca um departamento pelo código.
     *
     * @param codigoDept código do departamento
     * @return departamento encontrado, ou {@code null} se não existir
     */
    public Departamento consultarDepartamento(int codigoDept) {
        return universidade.buscarDepartamento(codigoDept);
    }

    /**
     * Atualiza nome e telefone de um departamento existente.
     *
     * @param codigo       código do departamento a atualizar
     * @param novoNome     novo nome do departamento
     * @param novoTelefone novo telefone do departamento
     * @return {@code true} se atualizado com sucesso, {@code false} se não encontrado
     */
    public boolean atualizarDepartamento(int codigo, String novoNome, String novoTelefone) {
        Departamento d = universidade.buscarDepartamento(codigo);
        if(d != null) {
            d.setNome(novoNome);
            d.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    /**
     * Cadastra um docente no departamento indicado.
     * Retorna {@code false} se o departamento não existe ou se o docente já pertence a outro departamento.
     *
     * @param codDept  código do departamento de destino
     * @param codFunc  código identificador do docente
     * @param nome     nome do docente
     * @param funcao   função acadêmica do docente
     * @param salario  salário do docente
     * @return {@code true} se cadastrado com sucesso
     */
    public boolean cadastrarFuncionario(int codDept, int codFunc, String nome, String funcao, double salario) {
        for(Departamento d : universidade.getDepartamentos()) {
            if(d.buscarFuncionario(codFunc) != null) {
                return false;
            }
        }
        Departamento dept = universidade.buscarDepartamento(codDept);
        if(dept != null) {
            dept.adicionarFuncionario(new Docente(codFunc, nome, funcao, salario));
            return true;
        }
        return false;
    }

    /**
     * Remove um funcionário de um departamento.
     *
     * @param codDept código do departamento
     * @param codFunc código do funcionário a excluir
     * @return {@code true} se removido com sucesso
     */
    public boolean excluirFuncionario(int codDept, int codFunc) {
        Departamento dept = universidade.buscarDepartamento(codDept);
        if(dept != null) {
            return dept.removerFuncionario(codFunc);
        }
        return false;
    }

    /**
     * Lista os funcionários de um departamento.
     *
     * @param codDept código do departamento
     * @return lista de funcionários, ou {@code null} se departamento não existir
     */
    public ArrayList<Funcionario> listarFuncionarios(int codDept) {
        Departamento d = universidade.buscarDepartamento(codDept);
        return (d != null) ? d.getFuncionarios() : null;
    }

    /**
     * Atualiza os dados de um funcionário existente.
     *
     * @param codDept      código do departamento do funcionário
     * @param codFunc      código do funcionário a atualizar
     * @param novoNome     novo nome
     * @param novaFuncao   nova função acadêmica
     * @param novoSalario  novo salário
     * @return {@code true} se atualizado com sucesso
     */
    public boolean atualizarFuncionario(int codDept, int codFunc, String novoNome, String novaFuncao, double novoSalario) {
        Departamento d = universidade.buscarDepartamento(codDept);
        if(d != null) {
            Funcionario f = d.buscarFuncionario(codFunc);
            if(f != null) {
                f.setNome(novoNome);
                f.setSalario(novoSalario);
                if(f instanceof Docente) {
                    ((Docente) f).setFuncao(novaFuncao);
                }
                return true;
            }
        }
        return false;
    }

}
