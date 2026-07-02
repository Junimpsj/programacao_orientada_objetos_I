package br.com.unesp.bancoapp.view;

import br.com.unesp.bancoapp.controller.BancoController;
import br.com.unesp.bancoapp.modelo.Diretor;
import br.com.unesp.bancoapp.modelo.Funcionario;
import br.com.unesp.bancoapp.modelo.Gerente;
import br.com.unesp.bancoapp.modelo.TecnicoBancario;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de consulta de todos os funcionários cadastrados no banco.
 * Exibe nome, CPF, tipo, salário base, bônus e salário final em uma tabela.
 */
public class ListaFuncionariosView extends JFrame {

    private BancoController bancoController;
    private JTable tabela;

    /**
     * @param bancoController controlador central compartilhado com a janela principal
     */
    public ListaFuncionariosView(BancoController bancoController) {
        this.bancoController = bancoController;

        setTitle("Funcionários Cadastrados");
        setSize(740, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabela = new JTable(new DefaultTableModel(
            new String[]{"Nome", "CPF", "Tipo", "Salário Base", "Bônus", "Salário Final"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        painelBotoes.add(btnFechar);

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        carregarDados();
    }

    /**
     * Carrega os dados de todos os funcionários do banco na tabela.
     */
    private void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        ArrayList<Funcionario> funcionarios = bancoController.listarFuncionarios();
        for(int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);

            String tipo;
            if(f instanceof Gerente) {
                tipo = "Gerente";
            } else if(f instanceof TecnicoBancario) {
                tipo = "Técnico Bancário";
            } else if(f instanceof Diretor) {
                tipo = "Diretor";
            } else {
                tipo = "Funcionário";
            }

            modelo.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                tipo,
                String.format("R$ %.2f", f.getSalario()),
                String.format("R$ %.2f", f.getBonificacao()),
                String.format("R$ %.2f", f.getSalarioFinal())
            });
        }
    }

}
