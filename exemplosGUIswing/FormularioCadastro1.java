package exemplosGUIswing;
import javax.swing.*;

public class FormularioCadastro1 extends JFrame {

    public FormularioCadastro1() {

        setTitle("Cadastro de Dados");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Título
        JLabel titulo = new JLabel("Cadastro de Dados");
        titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        titulo.setBounds(90, 10, 250, 30);
        add(titulo);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 60, 100, 20);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 60, 200, 25);
        add(txtNome);

        // Sexo
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 100, 100, 20);
        add(lblSexo);

        JRadioButton rbMasc = new JRadioButton("Masculino");
        rbMasc.setBounds(120, 100, 100, 20);

        JRadioButton rbFem = new JRadioButton("Feminino");
        rbFem.setBounds(220, 100, 100, 20);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasc);
        grupoSexo.add(rbFem);

        add(rbMasc);
        add(rbFem);

        // Profissão
        JLabel lblProf = new JLabel("Profissão:");
        lblProf.setBounds(50, 140, 100, 20);
        add(lblProf);

        String[] profissoes = {"Selecione", "Estudante", "Professor", "Programador"};
        JComboBox<String> cbProf = new JComboBox<>(profissoes);
        cbProf.setBounds(120, 140, 200, 25);
        add(cbProf);

        // Idiomas
        JLabel lblIdioma = new JLabel("Idiomas:");
        lblIdioma.setBounds(50, 180, 100, 20);
        add(lblIdioma);

        JCheckBox cbIng = new JCheckBox("Inglês");
        cbIng.setBounds(120, 180, 80, 20);

        JCheckBox cbEsp = new JCheckBox("Espanhol");
        cbEsp.setBounds(200, 180, 100, 20);

        add(cbIng);
        add(cbEsp);

        // Botões (sem ação)
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(80, 250, 100, 30);
        add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 250, 100, 30);
        add(btnCancelar);

        setVisible(true);
    }

    public static void main(String[] args) {
        FormularioCadastro1 formularioCadastro1 = new FormularioCadastro1();
    }
}