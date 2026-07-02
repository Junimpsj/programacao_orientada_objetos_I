package br.com.unesp.bancoapp.view;

import br.com.unesp.bancoapp.controller.BancoController;
import br.com.unesp.bancoapp.controller.FuncionarioController;
import br.com.unesp.bancoapp.modelo.Diretor;
import br.com.unesp.bancoapp.modelo.Funcionario;
import br.com.unesp.bancoapp.modelo.Gerente;
import br.com.unesp.bancoapp.modelo.TecnicoBancario;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de cadastro de funcionários do banco.
 * Exibe um formulário com campos comuns e campos específicos por tipo
 * (Gerente, Técnico Bancário, Diretor) e uma tabela com os já cadastrados.
 */
public class FuncionarioView extends JFrame {

    private FuncionarioController controller;

    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtSalario;
    private JComboBox<String> cbTipo;
    private JTextField txtAgencia;
    private JTextField txtSetor;
    private JTextField txtHorasExtras;
    private JTextField txtArea;
    private JTextField txtParticipacao;
    private JTable tabela;

    /**
     * @param bancoController controlador central compartilhado com a janela principal
     */
    public FuncionarioView(BancoController bancoController) {
        setTitle("Cadastro de Funcionário");
        setSize(620, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // campos do formulário
        txtNome         = new JTextField();
        txtCpf          = new JTextField();
        txtSalario      = new JTextField();
        cbTipo          = new JComboBox<>(new String[]{"Gerente", "Técnico Bancário", "Diretor"});
        txtAgencia      = new JTextField();
        txtSetor        = new JTextField();
        txtHorasExtras  = new JTextField();
        txtArea         = new JTextField();
        txtParticipacao = new JTextField();

        JPanel painelForm = new JPanel(new GridLayout(9, 2, 5, 8));
        painelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        painelForm.add(new JLabel("Nome:"));
        painelForm.add(txtNome);
        painelForm.add(new JLabel("CPF:"));
        painelForm.add(txtCpf);
        painelForm.add(new JLabel("Salário Base (R$):"));
        painelForm.add(txtSalario);
        painelForm.add(new JLabel("Tipo:"));
        painelForm.add(cbTipo);
        painelForm.add(new JLabel("Agência (Gerente):"));
        painelForm.add(txtAgencia);
        painelForm.add(new JLabel("Setor de Atendimento (Técnico):"));
        painelForm.add(txtSetor);
        painelForm.add(new JLabel("Horas Extras (Técnico):"));
        painelForm.add(txtHorasExtras);
        painelForm.add(new JLabel("Área Responsável (Diretor):"));
        painelForm.add(txtArea);
        painelForm.add(new JLabel("Participação nos Lucros % (Diretor):"));
        painelForm.add(txtParticipacao);

        // botões
        JButton btnSalvar  = new JButton("Salvar");
        JButton btnLimpar  = new JButton("Limpar");
        JButton btnFechar  = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnFechar);

        JPanel painelNorte = new JPanel(new BorderLayout());
        painelNorte.add(painelForm, BorderLayout.CENTER);
        painelNorte.add(painelBotoes, BorderLayout.SOUTH);

        // tabela de funcionários cadastrados
        tabela = new JTable(new DefaultTableModel(
            new String[]{"Nome", "CPF", "Tipo", "Salário Base", "Salário Final"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        JScrollPane scroll = new JScrollPane(tabela);

        setLayout(new BorderLayout(5, 5));
        add(painelNorte, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        controller = new FuncionarioController(this, bancoController);
        btnSalvar.addActionListener(e -> controller.salvar());
        btnLimpar.addActionListener(e -> limpar());
        btnFechar.addActionListener(e -> dispose());

        controller.carregarTabela();
    }

    /** @return texto do campo Nome */
    public String getNome() {
        return txtNome.getText().trim();
    }

    /** @return texto do campo CPF */
    public String getCpf() {
        return txtCpf.getText().trim();
    }

    /** @return texto do campo Salário Base */
    public String getSalario() {
        return txtSalario.getText().trim();
    }

    /** @return tipo de funcionário selecionado no combobox */
    public String getTipo() {
        return (String) cbTipo.getSelectedItem();
    }

    /** @return texto do campo Agência */
    public String getAgencia() {
        return txtAgencia.getText().trim();
    }

    /** @return texto do campo Setor de Atendimento */
    public String getSetor() {
        return txtSetor.getText().trim();
    }

    /** @return texto do campo Horas Extras */
    public String getHorasExtras() {
        return txtHorasExtras.getText().trim();
    }

    /** @return texto do campo Área Responsável */
    public String getArea() {
        return txtArea.getText().trim();
    }

    /** @return texto do campo Participação nos Lucros */
    public String getParticipacao() {
        return txtParticipacao.getText().trim();
    }

    /**
     * Atualiza a tabela com a lista de funcionários cadastrados.
     *
     * @param funcionarios lista de funcionários a exibir
     */
    public void atualizarTabela(ArrayList<Funcionario> funcionarios) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
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
                String.format("R$ %.2f", f.getSalarioFinal())
            });
        }
    }

    /** Limpa todos os campos de entrada do formulário. */
    public void limpar() {
        txtNome.setText("");
        txtCpf.setText("");
        txtSalario.setText("");
        txtAgencia.setText("");
        txtSetor.setText("");
        txtHorasExtras.setText("");
        txtArea.setText("");
        txtParticipacao.setText("");
        cbTipo.setSelectedIndex(0);
    }

}
