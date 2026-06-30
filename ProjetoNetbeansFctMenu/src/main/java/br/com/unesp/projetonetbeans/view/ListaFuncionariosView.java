package br.com.unesp.projetonetbeans.view;

import br.com.unesp.projetonetbeans.controller.UniversidadeController;
import br.com.unesp.projetonetbeans.model.Departamento;
import br.com.unesp.projetonetbeans.model.Docente;
import br.com.unesp.projetonetbeans.model.Funcionario;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * View de listagem de funcionários com filtro por departamento, edição e exclusão.
 */
public class ListaFuncionariosView extends JFrame {

    private UniversidadeController universidadeController;
    private JTable tabela;
    private JComboBox<String> comboDepartamentos;

    /**
     * @param universidadeController controlador central
     */
    public ListaFuncionariosView(UniversidadeController universidadeController) {
        this.universidadeController = universidadeController;

        setTitle("Funcionários Cadastrados");
        setSize(720, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // filtro
        comboDepartamentos = new JComboBox<>();
        comboDepartamentos.addItem("Todos os departamentos");
        for(Departamento d : universidadeController.listarDepartamentos()) {
            comboDepartamentos.addItem(d.getCodigo() + " - " + d.getNome());
        }
        comboDepartamentos.addActionListener(e -> carregarDados());

        JPanel painelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelFiltro.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        painelFiltro.add(new JLabel("Departamento:"));
        painelFiltro.add(comboDepartamentos);

        // tabela — coluna 5 (codDepto) oculta: removida da view mas mantida no model
        DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"Código", "Nome", "Função", "Salário", "Departamento", "codDepto"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tabela = new JTable(modelo);
        tabela.removeColumn(tabela.getColumnModel().getColumn(5));
        JScrollPane scroll = new JScrollPane(tabela);

        // botões
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
        add(painelFiltro, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        carregarDados();
    }

    private void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        String itemSelecionado = (String) comboDepartamentos.getSelectedItem();
        boolean todosDepts = itemSelecionado == null || itemSelecionado.equals("Todos os departamentos");

        for(Departamento d : universidadeController.listarDepartamentos()) {
            if(!todosDepts) {
                try {
                    int codSelecionado = Integer.parseInt(itemSelecionado.split(" - ")[0]);
                    if(d.getCodigo() != codSelecionado) { continue; }
                } catch(NumberFormatException e) {
                    continue;
                }
            }
            for(Funcionario f : d.getFuncionarios()) {
                String funcao = (f instanceof Docente) ? ((Docente) f).getFuncao() : "";
                modelo.addRow(new Object[]{
                    f.getCodigo(), f.getNome(), funcao,
                    "R$ " + f.getSalario(), d.getNome(), d.getCodigo()
                });
            }
        }
    }

    private void editarSelecionado() {
        int linha = tabela.getSelectedRow();
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela.");
            return;
        }

        int codFunc   = (int)    tabela.getModel().getValueAt(linha, 0);
        String nomeAtual  = (String) tabela.getModel().getValueAt(linha, 1);
        String funcaoAtual = (String) tabela.getModel().getValueAt(linha, 2);
        int codDept   = (int)    tabela.getModel().getValueAt(linha, 5);

        String salarioStr = tabela.getModel().getValueAt(linha, 3).toString().replace("R$ ", "").replace(",", ".");

        JTextField fieldNome   = new JTextField(nomeAtual, 22);
        JTextField fieldFuncao = new JTextField(funcaoAtual, 22);
        JTextField fieldSalario = new JTextField(salarioStr, 22);

        JPanel painel = new JPanel(new GridLayout(3, 2, 5, 5));
        painel.add(new JLabel("Nome:"));
        painel.add(fieldNome);
        painel.add(new JLabel("Função:"));
        painel.add(fieldFuncao);
        painel.add(new JLabel("Salário:"));
        painel.add(fieldSalario);

        int resultado = JOptionPane.showConfirmDialog(this, painel, "Editar Funcionário", JOptionPane.OK_CANCEL_OPTION);
        if(resultado == JOptionPane.OK_OPTION) {
            try {
                double novoSalario = Double.parseDouble(fieldSalario.getText());
                universidadeController.atualizarFuncionario(codDept, codFunc, fieldNome.getText(), fieldFuncao.getText(), novoSalario);
                carregarDados();
                JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Salário inválido.");
            }
        }
    }

    private void excluirSelecionado() {
        int linha = tabela.getSelectedRow();
        if(linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela.");
            return;
        }

        int codFunc  = (int)    tabela.getModel().getValueAt(linha, 0);
        String nome  = (String) tabela.getModel().getValueAt(linha, 1);
        int codDept  = (int)    tabela.getModel().getValueAt(linha, 5);

        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Excluir o funcionário \"" + nome + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        if(confirmacao == JOptionPane.YES_OPTION) {
            universidadeController.excluirFuncionario(codDept, codFunc);
            carregarDados();
            JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
        }
    }

}
