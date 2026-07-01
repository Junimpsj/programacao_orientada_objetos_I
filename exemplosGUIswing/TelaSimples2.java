package exemplosGUIswing;
import java.awt.Color;
import javax.swing.JFrame;

public class TelaSimples2 extends JFrame {

    // Construtor
    public TelaSimples2() {
        setTitle("Tela Simples 2"); // Título
        setSize(400, 480); // Tamanho
        getContentPane().setBackground(Color.YELLOW); // Cor de fundo
        setLocationRelativeTo(null); // Centraliza
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha aplicação
        setVisible(true); // Torna visível
    }

    // Método principal
    public static void main(String[] args) {
        new TelaSimples2(); // Instancia a tela
    }
}