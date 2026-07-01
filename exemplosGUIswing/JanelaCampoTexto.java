package exemplosGUIswing;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaCampoTexto extends JFrame {

    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JPasswordField passwordField;

    public JanelaCampoTexto() {
        super("Janela com JTextField e JPasswordField");
        setLayout(new FlowLayout());

        // textfield com 10 colunas
        textField1 = new JTextField(10);
        add(textField1);

        // textfield com texto default
        textField2 = new JTextField("Insira seu texto aqui");
        add(textField2);

        // textfield com texto default e 21 colunas
        textField3 = new JTextField("Campo de texto não editável", 21);
        textField3.setEditable(false); // desabilita edição
        add(textField3);

        // passwordfield com texto default
        passwordField = new JPasswordField("Texto oculto");
        add(passwordField);

        // registra tratador de eventos
        TratadorEventosCampoTexto handler = new TratadorEventosCampoTexto();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }

    // classe privada interna para tratar eventos
    private class TratadorEventosCampoTexto implements ActionListener {
        // processa os eventos do textfield

        @Override
        public void actionPerformed(ActionEvent event) {
            String string = "";
            // usuário pressionou Enter em textField1
            if (event.getSource() == textField1) {
                //string = String.format("textField1: %s",
                //   event.getActionCommand());

                string = textField1.getText();
            } // usuário pressionou Enter em textField2
            else if (event.getSource() == textField2) {
                string = String.format("textField2: %s",
                        event.getActionCommand()); 
            }// usuário pressionou Enter em textField3
            else if (event.getSource() == textField3) {
                string = String.format("textField3: %s",
                        event.getActionCommand()); 
            }// usuário pressionou Enter em  passwordField
            else if (event.getSource() == passwordField) {
                string = String.format("passwordField: %s",
                        event.getActionCommand());
            }

            // mostra o conteúdo do textfield
            JOptionPane.showMessageDialog(null, string);
        }
    }

    public static void main(String[] args) {
        JanelaCampoTexto textFieldFrame = new JanelaCampoTexto();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(350, 100);
        textFieldFrame.setVisible(true);
    }
}
