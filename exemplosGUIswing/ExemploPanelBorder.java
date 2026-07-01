package exemplosGUIswing;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploPanelBorder extends JFrame {

    public ExemploPanelBorder() {

        setTitle("BorderLayout com JPanel");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Painel Sul
        JPanel painelSul = new JPanel();
        painelSul.add(new JButton("Novo"));
        painelSul.add(new JButton("Salvar"));

        // Painel Centro
        JPanel painelCentro = new JPanel();
        painelCentro.add(new JLabel("Nome:"));
        painelCentro.add(new JTextField(15));

        // Adiciona os painéis
        add(painelSul, BorderLayout.SOUTH);
        add(painelCentro, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploPanelBorder();
    }
}