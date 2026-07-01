package exemplosGUIswing;
import java.awt.Color;
import javax.swing.JDialog;

public class ExemploJDialog extends JDialog {

    // Construtor
    public ExemploJDialog() {
        setTitle("Diálogo 1"); // Título
        setSize(600, 200); // Tamanho
        setModal(true); // Define como modal
        getContentPane().setBackground(Color.RED); // Cor de fundo
        setLocationRelativeTo(null); // Centraliza
        setVisible(true); // Torna visível
    }

    // Método principal
    public static void main(String[] args) {
        ExemploJDialog exemplo = new ExemploJDialog(); // Instancia o diálogo
    }
}