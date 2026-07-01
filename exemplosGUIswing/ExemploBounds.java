package exemplosGUIswing;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploBounds extends JFrame {

    public ExemploBounds() {

        setTitle("Exemplo");
        setSize(300, 200);
        setLayout(null);
        setLocation(120, 500);

        JButton botao = new JButton("Clique");

        // x, y, largura, altura
        botao.setBounds(80, 60, 120, 30);
        add(botao);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploBounds();
    }
}