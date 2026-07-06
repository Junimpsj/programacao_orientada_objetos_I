package br.com.unesp.projetonetbeans.controller;

import br.com.unesp.projetonetbeans.view.DepartamentoView;

/**
 * Controlador da view de cadastro de departamentos.
 * Delega operações de persistência para {@link UniversidadeController}.
 */
public class DepartamentoController {

    private DepartamentoView view;
    private UniversidadeController universidadeController;

    /**
     * @param view                   view de cadastro de departamentos
     * @param universidadeController controlador central
     */
    public DepartamentoController(DepartamentoView view, UniversidadeController universidadeController) {
        this.view = view;
        this.universidadeController = universidadeController;
    }

    /**
     * Lê os dados da view, cadastra o departamento e atualiza a tabela de confirmação.
     * Exibe mensagem de erro se o código informado não for numérico.
     */
    public void salvarDepartamento() {
        try {
            int codigo = Integer.parseInt(view.getCodigo());
            String nome = view.getNome();
            String telefone = view.getTelefone();
            universidadeController.cadastrarDepartamento(codigo, nome, telefone);
            atualizarTabela();
            view.limparCampos();
            javax.swing.JOptionPane.showMessageDialog(null, "Departamento cadastrado com sucesso!");
        } catch(NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Código inválido.");
        }
    }

    private void atualizarTabela() {
        view.atualizarTabela(universidadeController.listarDepartamentos());
    }

}