package exemplosGUIswing;
import javax.swing.JOptionPane;

public class InputDialogGUI {

    public static void main(String[] args) {

        // Entrada do primeiro número
        String s1 = JOptionPane.showInputDialog(
                null, "Primeiro número:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

// Entrada do segundo número
        String s2 = JOptionPane.showInputDialog(
                null, "Segundo número:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

// Saída do resultado
        JOptionPane.showMessageDialog(
                null, "Soma: " + (Integer.parseInt(s1) + Integer.parseInt(s2)),
                "Resultado", JOptionPane.PLAIN_MESSAGE
        );
    }
}