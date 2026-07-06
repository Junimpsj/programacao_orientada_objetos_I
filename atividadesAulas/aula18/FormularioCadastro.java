import javax.swing.*;
import java.awt.*;

public class FormularioCadastro extends JFrame{
 
    //Construtor da classe
    public FormularioCadastro() {

        setTitle("Cadastro");
        setSize(400,600);
        setLayout(null); //colocamos isso para o setBounds() funcionar
        //mas em aplicações reais e projetos maiores o ideal é deixar o JFrame organizar tudo automaticamente mesmo
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Titulo do formulario
        JLabel lblTitulo = new JLabel("Cadastro de Dados");
        lblTitulo.setBounds(110, 10, 200, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo);

        //Nome
        JLabel lblNome = new JLabel("Nome: ");
        lblNome.setBounds(50, 60, 100, 20);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120 ,60, 200, 25);
        add(txtNome);

        //Sexo
        JLabel lblSexo = new JLabel("Sexo: ");
        lblSexo.setBounds(50, 100, 100, 20);
        add(lblSexo);

        JRadioButton rbMasc = new JRadioButton("Masculino");
        rbMasc.setBounds(120, 100, 100, 20);
        add(rbMasc);

        JRadioButton rbFem = new JRadioButton("Feminino");
        rbFem.setBounds(220, 100, 100, 20);
        add(rbFem);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasc);
        grupoSexo.add(rbFem);

        //Profissao
        JLabel lblProf = new JLabel("Profissão: ");
        lblProf.setBounds(50, 140, 100, 20);
        add(lblProf);

        String[] profissoes = {"Selecione", "Estudante", "Professor", "Programador"};
        JComboBox<String> cbProf = new JComboBox<>(profissoes);
        cbProf.setBounds(120, 140, 200, 25);
        add(cbProf);

        //Idiomas
        JLabel lblIdioma = new JLabel("Idiomas: ");
        lblIdioma.setBounds(50, 180, 100, 20);
        add(lblIdioma);

        JCheckBox cbIng = new JCheckBox("Ingles");
        cbIng.setBounds(120, 180, 80, 20);
        add(cbIng);

        JCheckBox cbEsp = new JCheckBox("Espanhol");
        cbEsp.setBounds(200, 180, 100, 20);
        add(cbEsp);

        //E-mail
        JLabel lblMail = new JLabel("E-mail:");
        lblMail.setBounds(50, 220, 100, 20);
        add(lblMail);

        JTextField txtMail = new JTextField();
        txtMail.setBounds(120, 220, 200, 25);
        add(txtMail);

        //Telefone
        JLabel lblTel = new JLabel("Telefone:");
        lblTel.setBounds(50, 260, 100, 20);
        add(lblTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(120, 260, 200, 25);
        add(txtTel);

        //Idade
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(50, 300, 100, 20);
        add(lblIdade);

        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(120, 300, 200, 25);
        add(txtIdade);

        //Botões (sem ação por enqt)
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(50, 500, 100, 30);
        add(btnSalvar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(160, 500, 100, 30);
        add(btnLimpar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(270, 500, 100, 30);
        add(btnCancelar);

        setVisible(true);

    }

    public static void main(String[] args) {
        new FormularioCadastro();
    }
    
}