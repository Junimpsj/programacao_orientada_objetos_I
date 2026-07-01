package exemplosGUIswing;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SomaComConfirmacao {

    public static void main(String[] args) {

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        // Entrada do primeiro número
        String s1 = JOptionPane.showInputDialog(
            null, "Primeiro número:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

        // Entrada do segundo número
        String s2 = JOptionPane.showInputDialog(
            null, "Segundo número:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

        // Confirmação
        int resp = JOptionPane.showConfirmDialog(
            null, "Deseja calcular a soma?",
            "Confirmação", JOptionPane.YES_NO_OPTION
        );
        
        // Processamento + saída
        if (resp == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                null,
                "Soma: " + (Integer.parseInt(s1) + Integer.parseInt(s2)),
                "Resultado", JOptionPane.PLAIN_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null, "Operação cancelada",
                "Aviso", JOptionPane.WARNING_MESSAGE
            );
        }
    }
}