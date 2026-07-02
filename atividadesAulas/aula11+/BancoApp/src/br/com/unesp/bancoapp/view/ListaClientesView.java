package br.com.unesp.bancoapp.view;

import br.com.unesp.bancoapp.controller.BancoController;
import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.PessoaFisica;
import br.com.unesp.bancoapp.modelo.PessoaJuridica;
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
 * Tela de consulta de todos os clientes cadastrados no banco.
 * Exibe tipo, nome/razão social, CPF/CNPJ, telefone, e-mail e cidade em uma tabela.
 */
public class ListaClientesView extends JFrame {

    private BancoController bancoController;
    private JTable tabela;

    /**
     * @param bancoController controlador central compartilhado com a janela principal
     */
    public ListaClientesView(BancoController bancoController) {
        this.bancoController = bancoController;

        setTitle("Clientes Cadastrados");
        setSize(780, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabela = new JTable(new DefaultTableModel(
            new String[]{"Tipo", "Nome / Razão Social", "CPF / CNPJ", "Telefone", "E-mail", "Cidade/UF"}, 0
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
     * Carrega os dados de todos os clientes do banco na tabela.
     */
    private void carregarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        ArrayList<Cliente> clientes = bancoController.listarClientes();
        for(int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);

            String tipo;
            String documento;
            if(c instanceof PessoaFisica) {
                tipo      = "Pessoa Física";
                documento = ((PessoaFisica) c).getCpf();
            } else {
                tipo      = "Pessoa Jurídica";
                documento = ((PessoaJuridica) c).getCnpj();
            }

            String cidadeUf = c.getEndereco().getCidade() + "/" + c.getEndereco().getEstado();

            modelo.addRow(new Object[]{
                tipo,
                c.getNome(),
                documento,
                c.getTelefone(),
                c.getEmail(),
                cidadeUf
            });
        }
    }

}
