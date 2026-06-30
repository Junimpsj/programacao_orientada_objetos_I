package br.com.unesp.projetonetbeans.view;

import br.com.unesp.projetonetbeans.controller.UniversidadeController;
import br.com.unesp.projetonetbeans.model.Departamento;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * View de listagem de departamentos com opções de edição e exclusão.
 */
public class ListaDepartamentosView extends JFrame {

    private UniversidadeController universidadeController;
    private JTable tabela;

    /**
     * @param universidadeController controlador central
     */
    public ListaDepartamentosView(UniversidadeController universidadeController) {
        this.universidadeController = universidadeController;

        setTitle("Departamentos Cadastrados");
        setSize(620, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Código", "Nome", "Telefone", "Nº Funcionários"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnEditar  = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnFechar  = new JButton("Fechar");

        btnEditar.addActionListener(e  -> editarSelecionado());
        btnExcluir.addActionListener(e -> excluirSelecionado());
        btnFechar.addActionListener(e  -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnFechar);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        carregarDados();
    }

    private void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        for(Departamento d : universidadeController.listarDepartamentos()) {
            modelo.addRow(new Object[]{d.getCodigo(), d.getNome(), d.getTelefone(), d.getFuncionarios().size()});
        }
    }

    private void editarSelecionado() {
        int linha = tabela.getSelectedRow();
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um departamento na tabela.");
            return;
        }

        int codigo      = (int)    tabela.getValueAt(linha, 0);
        String nomeAtual = (String) tabela.getValueAt(linha, 1);
        String telAtual  = (String) tabela.getValueAt(linha, 2);

        JTextField fieldNome = new JTextField(nomeAtual, 22);
        JTextField fieldTel  = new JTextField(telAtual, 22);

        JPanel painel = new JPanel(new GridLayout(2, 2, 5, 5));
        painel.add(new JLabel("Nome:"));
        painel.add(fieldNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(fieldTel);

        int resultado = JOptionPane.showConfirmDialog(this, painel, "Editar Departamento", JOptionPane.OK_CANCEL_OPTION);
        if(resultado == JOptionPane.OK_OPTION) {
            universidadeController.atualizarDepartamento(codigo, fieldNome.getText(), fieldTel.getText());
            carregarDados();
            JOptionPane.showMessageDialog(this, "Departamento atualizado com sucesso!");
        }
    }

    private void excluirSelecionado() {
        int linha = tabela.getSelectedRow();
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um departamento na tabela.");
            return;
        }

        int codigo = (int) tabela.getValueAt(linha, 0);
        String nome = (String) tabela.getValueAt(linha, 1);

        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Excluir o departamento \"" + nome + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        if(confirmacao == JOptionPane.YES_OPTION) {
            universidadeController.excluirDepartamento(codigo);
            carregarDados();
            JOptionPane.showMessageDialog(this, "Departamento excluído com sucesso!");
        }
    }

}
