package br.com.unesp.bancoapp.view;

import br.com.unesp.bancoapp.controller.BancoController;
import br.com.unesp.bancoapp.controller.ClienteController;
import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.PessoaFisica;
import br.com.unesp.bancoapp.modelo.PessoaJuridica;
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
 * Tela de cadastro de clientes do banco.
 * Permite cadastrar Pessoa Física (nome e CPF) ou Pessoa Jurídica (razão social e CNPJ),
 * além dos dados de contato e endereço comuns. Exibe os já cadastrados em uma tabela.
 */
public class ClienteView extends JFrame {

    private ClienteController controller;

    private JComboBox<String> cbTipo;
    private JTextField txtNomeOuRazao;
    private JTextField txtCpfOuCnpj;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtRua;
    private JTextField txtNumero;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtEstado;
    private JTextField txtCep;
    private JTable tabela;

    /**
     * @param bancoController controlador central compartilhado com a janela principal
     */
    public ClienteView(BancoController bancoController) {
        setTitle("Cadastro de Cliente");
        setSize(620, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // campos do formulário
        cbTipo         = new JComboBox<>(new String[]{"Pessoa Física", "Pessoa Jurídica"});
        txtNomeOuRazao = new JTextField();
        txtCpfOuCnpj   = new JTextField();
        txtTelefone    = new JTextField();
        txtEmail       = new JTextField();
        txtRua         = new JTextField();
        txtNumero      = new JTextField();
        txtBairro      = new JTextField();
        txtCidade      = new JTextField();
        txtEstado      = new JTextField();
        txtCep         = new JTextField();

        JPanel painelForm = new JPanel(new GridLayout(11, 2, 5, 8));
        painelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        painelForm.add(new JLabel("Tipo:"));
        painelForm.add(cbTipo);
        painelForm.add(new JLabel("Nome / Razão Social:"));
        painelForm.add(txtNomeOuRazao);
        painelForm.add(new JLabel("CPF / CNPJ:"));
        painelForm.add(txtCpfOuCnpj);
        painelForm.add(new JLabel("Telefone:"));
        painelForm.add(txtTelefone);
        painelForm.add(new JLabel("E-mail:"));
        painelForm.add(txtEmail);
        painelForm.add(new JLabel("Rua:"));
        painelForm.add(txtRua);
        painelForm.add(new JLabel("Número:"));
        painelForm.add(txtNumero);
        painelForm.add(new JLabel("Bairro:"));
        painelForm.add(txtBairro);
        painelForm.add(new JLabel("Cidade:"));
        painelForm.add(txtCidade);
        painelForm.add(new JLabel("Estado:"));
        painelForm.add(txtEstado);
        painelForm.add(new JLabel("CEP:"));
        painelForm.add(txtCep);

        // botões
        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnFechar = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnFechar);

        JPanel painelNorte = new JPanel(new BorderLayout());
        painelNorte.add(painelForm, BorderLayout.CENTER);
        painelNorte.add(painelBotoes, BorderLayout.SOUTH);

        // tabela de clientes cadastrados
        tabela = new JTable(new DefaultTableModel(
            new String[]{"Tipo", "Nome / Razão Social", "CPF / CNPJ", "Telefone", "E-mail"}, 0
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

        controller = new ClienteController(this, bancoController);
        btnSalvar.addActionListener(e -> controller.salvar());
        btnLimpar.addActionListener(e -> limpar());
        btnFechar.addActionListener(e -> dispose());

        controller.carregarTabela();
    }

    /** @return tipo de cliente selecionado no combobox */
    public String getTipo() {
        return (String) cbTipo.getSelectedItem();
    }

    /** @return texto do campo Nome / Razão Social */
    public String getNomeOuRazao() {
        return txtNomeOuRazao.getText().trim();
    }

    /** @return texto do campo CPF / CNPJ */
    public String getCpfOuCnpj() {
        return txtCpfOuCnpj.getText().trim();
    }

    /** @return texto do campo Telefone */
    public String getTelefone() {
        return txtTelefone.getText().trim();
    }

    /** @return texto do campo E-mail */
    public String getEmail() {
        return txtEmail.getText().trim();
    }

    /** @return texto do campo Rua */
    public String getRua() {
        return txtRua.getText().trim();
    }

    /** @return texto do campo Número */
    public String getNumero() {
        return txtNumero.getText().trim();
    }

    /** @return texto do campo Bairro */
    public String getBairro() {
        return txtBairro.getText().trim();
    }

    /** @return texto do campo Cidade */
    public String getCidade() {
        return txtCidade.getText().trim();
    }

    /** @return texto do campo Estado */
    public String getEstado() {
        return txtEstado.getText().trim();
    }

    /** @return texto do campo CEP */
    public String getCep() {
        return txtCep.getText().trim();
    }

    /**
     * Atualiza a tabela com a lista de clientes cadastrados.
     *
     * @param clientes lista de clientes a exibir
     */
    public void atualizarTabela(ArrayList<Cliente> clientes) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
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
            modelo.addRow(new Object[]{
                tipo,
                c.getNome(),
                documento,
                c.getTelefone(),
                c.getEmail()
            });
        }
    }

    /** Limpa todos os campos de entrada do formulário. */
    public void limpar() {
        cbTipo.setSelectedIndex(0);
        txtNomeOuRazao.setText("");
        txtCpfOuCnpj.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtCep.setText("");
    }

}
