package view;

import javax.swing.*;
import java.awt.*;

/**
 * Tela de cadastro de usuarios com secao de dados pessoais e secao de cursos.
 * Usa BorderLayout no frame principal, com paineis aninhados para organizar
 * labels e campos em colunas (padrao west/center da aula 19).
 */
public class CadastroView extends JFrame {

    // campos da secao CADASTRO
    public JTextField txtNome;
    public JTextField txtTelefone;
    public JTextField txtEndereco;
    public JTextField txtCidade;
    public JComboBox<String> cbUF;
    public JTextField txtEmail;
    public JRadioButton rbFeminino;
    public JRadioButton rbMasculino;
    public ButtonGroup grupSexo;

    // campos da secao CURSOS
    public JCheckBox cbAlemao;
    public JCheckBox cbEspanhol;
    public JCheckBox cbFrances;
    public JCheckBox cbIngles;
    public JCheckBox cbItaliano;
    public JCheckBox cbJapones;
    public JTextArea txtMotivo;

    public JButton btnSalvar;

    private static final String[] ESTADOS = {
        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
        "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    };

    /**
     * Monta a janela com as duas secoes (CADASTRO e CURSOS) e o botao Salvar.
     */
    public CadastroView() {
        setTitle("Formulário de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // secao CADASTRO no topo (NORTH)
        JPanel painelCadastro = new JPanel(new BorderLayout(8, 5));
        painelCadastro.setBorder(BorderFactory.createTitledBorder("CADASTRO"));

        JPanel painelLabels = new JPanel(new GridLayout(7, 1, 5, 5));
        JPanel painelCampos = new JPanel(new GridLayout(7, 1, 5, 5));

        // labels das linhas
        painelLabels.add(new JLabel("NOME:"));
        painelLabels.add(new JLabel("TELEFONE:"));
        painelLabels.add(new JLabel("ENDEREÇO:"));
        painelLabels.add(new JLabel("CIDADE:"));
        painelLabels.add(new JLabel("UF:"));
        painelLabels.add(new JLabel("E-MAIL:"));
        painelLabels.add(new JLabel("SEXO:"));

        // campos correspondentes
        txtNome     = new JTextField();
        txtTelefone = new JTextField();
        txtEndereco = new JTextField();
        txtCidade   = new JTextField();
        cbUF        = new JComboBox<String>(ESTADOS);
        txtEmail    = new JTextField();

        rbFeminino  = new JRadioButton("Feminino", true);
        rbMasculino = new JRadioButton("Masculino");
        grupSexo = new ButtonGroup();
        grupSexo.add(rbFeminino);
        grupSexo.add(rbMasculino);

        // painel para os radio buttons caber em uma celula do GridLayout
        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        painelSexo.add(rbFeminino);
        painelSexo.add(rbMasculino);

        painelCampos.add(txtNome);
        painelCampos.add(txtTelefone);
        painelCampos.add(txtEndereco);
        painelCampos.add(txtCidade);
        painelCampos.add(cbUF);
        painelCampos.add(txtEmail);
        painelCampos.add(painelSexo);

        painelCadastro.add(painelLabels, BorderLayout.WEST);
        painelCadastro.add(painelCampos, BorderLayout.CENTER);
        add(painelCadastro, BorderLayout.NORTH);

        // secao CURSOS no centro
        JPanel painelCursos = new JPanel(new BorderLayout(8, 5));
        painelCursos.setBorder(BorderFactory.createTitledBorder("CURSOS"));

        // checkboxes dos cursos (lado esquerdo)
        JPanel painelCheckArea = new JPanel(new BorderLayout(0, 5));
        painelCheckArea.add(new JLabel("Selecione o(s) curso(s):"), BorderLayout.NORTH);

        JPanel painelCBs = new JPanel(new GridLayout(6, 1, 2, 2));
        cbAlemao   = new JCheckBox("Alemão");
        cbEspanhol = new JCheckBox("Espanhol");
        cbFrances  = new JCheckBox("Francês");
        cbIngles   = new JCheckBox("Inglês");
        cbItaliano = new JCheckBox("Italiano");
        cbJapones  = new JCheckBox("Japonês");

        painelCBs.add(cbAlemao);
        painelCBs.add(cbEspanhol);
        painelCBs.add(cbFrances);
        painelCBs.add(cbIngles);
        painelCBs.add(cbItaliano);
        painelCBs.add(cbJapones);

        painelCheckArea.add(painelCBs, BorderLayout.CENTER);

        // area de texto para o motivo (lado direito)
        // JTextArea com JScrollPane: necessario para texto multilinha rolavel
        JPanel painelMotivoArea = new JPanel(new BorderLayout(0, 5));
        painelMotivoArea.add(new JLabel("Por que se interessa por esse(s) curso(s):"), BorderLayout.NORTH);

        txtMotivo = new JTextArea(5, 25);
        txtMotivo.setLineWrap(true);
        txtMotivo.setWrapStyleWord(true);
        painelMotivoArea.add(new JScrollPane(txtMotivo), BorderLayout.CENTER);

        painelCursos.add(painelCheckArea, BorderLayout.WEST);
        painelCursos.add(painelMotivoArea, BorderLayout.CENTER);
        add(painelCursos, BorderLayout.CENTER);

        // botao Salvar alinhado a direita
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvar = new JButton("Salvar");
        painelBotao.add(btnSalvar);
        add(painelBotao, BorderLayout.SOUTH);

        setSize(620, 520);
        setLocationRelativeTo(null);
    }
}
