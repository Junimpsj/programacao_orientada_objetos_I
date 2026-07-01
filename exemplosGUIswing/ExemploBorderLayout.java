package exemplosGUIswing;
import java.awt.*;
import javax.swing.*;

public class ExemploBorderLayout extends JFrame {

    public ExemploBorderLayout() {

        setTitle("Exemplo BorderLayout");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Define o BorderLayout
        setLayout(new BorderLayout());

        // Componentes nas regiões
        add(new JButton("Norte"), BorderLayout.NORTH);
        add(new JButton("Sul"), BorderLayout.SOUTH);
        add(new JButton("Leste"), BorderLayout.EAST);
        add(new JButton("Oeste"), BorderLayout.WEST);
        add(new JButton("Centro"), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ExemploBorderLayout();
    }
}