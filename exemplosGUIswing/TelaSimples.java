package exemplosGUIswing;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TelaSimples {

    public static void main(String[] args) {

        // Instancia a janela
        JFrame ts1 = new JFrame();

        ts1.setTitle("Tela Simples 1"); // Define o título
        ts1.setSize(480, 480); // Largura e altura
        ts1.getContentPane().setBackground(Color.MAGENTA); // Cor de fundo
        ts1.setLocationRelativeTo(null); // Centraliza na tela
        ts1.setDefaultCloseOperation(EXIT_ON_CLOSE); // Encerra a aplicação ao fechar
        ts1.setVisible(true); // Torna a janela visível
    }
}