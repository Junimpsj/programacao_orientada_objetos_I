import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class InputDialogGUI {
    
    public static void main(String[] args) {

        //Entrada do primeiro numero
        String s1 = JOptionPane.showInputDialog(
            null, "Primeiro numero:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

        //Entrada do segundo numero
        String s2 = JOptionPane.showInputDialog(
            null, "Segundo numero:", "Entrada", JOptionPane.QUESTION_MESSAGE
        );

        //Confirmacao
        int resp = JOptionPane.showConfirmDialog(
            null,
            "Deseja calcular a soma?",
            "Confirmação", JOptionPane.YES_NO_OPTION
        );

        //Processamento + Saida do resultado
        if(resp == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                null, 
                "Soma: " + (Integer.parseInt(s1) + Integer.parseInt(s2)),
                "Resultado", JOptionPane.PLAIN_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Operação cancelada",
                "Aviso", JOptionPane.WARNING_MESSAGE
            );
        }

    }

}