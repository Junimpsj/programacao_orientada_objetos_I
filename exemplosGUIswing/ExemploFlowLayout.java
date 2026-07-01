package exemplosGUIswing;
import java.awt.*;
import javax.swing.*;

public class ExemploFlowLayout extends JFrame {

    public ExemploFlowLayout() {

        setTitle("Exemplo FlowLayout");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Define o FlowLayout centralizado
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btn1 = new JButton("Botão 1");
        JButton btn2 = new JButton("Botão 2");
        JButton btn3 = new JButton("Botão 3");

        add(btn1);
        add(btn2);
        add(btn3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploFlowLayout();
    }
}