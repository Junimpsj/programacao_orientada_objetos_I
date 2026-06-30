package br.com.unesp.projetonetbeans.controller;

import br.com.unesp.projetonetbeans.model.Departamento;
import br.com.unesp.projetonetbeans.model.Funcionario;
import br.com.unesp.projetonetbeans.view.FuncionarioView;
import java.util.ArrayList;

/**
 * Controlador da view de cadastro de funcionários.
 * Delega operações de persistência para {@link UniversidadeController}.
 */
public class FuncionarioController {

    private FuncionarioView view;
    private UniversidadeController universidadeController;

    /**
     * @param view                   view de cadastro de funcionários
     * @param universidadeController controlador central
     */
    public FuncionarioController(FuncionarioView view, UniversidadeController universidadeController) {
        this.view = view;
        this.universidadeController = universidadeController;
    }

    /**
     * Popula o combobox da view com os departamentos cadastrados na universidade.
     */
    public void carregarDepartamentos() {
        view.popularComboDepartamentos(universidadeController.listarDepartamentos());
    }

    /**
     * Lê os dados da view, cadastra o funcionário no departamento selecionado e atualiza a tabela.
     * Exibe mensagem de erro se os dados forem inválidos ou se o docente já pertencer a outro departamento.
     */
    public void salvarFuncionario() {
        try {
            int codFunc = Integer.parseInt(view.getCodigo());
            String nome = view.getNome();
            String funcao = view.getFuncao();
            double salario = Double.parseDouble(view.getSalario());
            int codDept = view.getCodigoDepartamentoSelecionado();

            if(codDept == -1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Selecione um departamento.");
                return;
            }

            boolean sucesso = universidadeController.cadastrarFuncionario(codDept, codFunc, nome, funcao, salario);
            if(sucesso) {
                atualizarTabela(codDept);
                view.limparCampos();
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Não foi possível cadastrar. Verifique se o departamento existe\nou se o docente já pertence a outro departamento.");
            }
        } catch(NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Código ou salário inválido.");
        }
    }

    /**
     * Atualiza a tabela da view com os funcionários do departamento selecionado no combobox.
     */
    public void filtrarPorDepartamento() {
        int codDept = view.getCodigoDepartamentoSelecionado();
        if(codDept != -1) {
            atualizarTabela(codDept);
        }
    }

    private void atualizarTabela(int codDept) {
        ArrayList<Funcionario> funcionarios = universidadeController.listarFuncionarios(codDept);
        Departamento dept = universidadeController.consultarDepartamento(codDept);
        String nomeDept = (dept != null) ? dept.getNome() : "";
        view.atualizarTabela(funcionarios, nomeDept);
    }

}
