import javax.swing.JOptionPane;

public class Atividade1 {
    
    public static void main(String[] args) {

        String s1 = JOptionPane.showInputDialog(
            null,
            "Primeiro Número",
            "Entrada",
            JOptionPane.QUESTION_MESSAGE
        );

        String s2 = JOptionPane.showInputDialog(
            null,
            "Segundo Número",
            "Entrada",
            JOptionPane.QUESTION_MESSAGE
        );

        String operacao = JOptionPane.showInputDialog(
            null,
            "Operação Desejada (+, -, * ou /)",
            "Entrada",
            JOptionPane.QUESTION_MESSAGE
        );

        switch (operacao) {
            case "+":
                JOptionPane.showMessageDialog(
                    null,
                    "Soma: " + (Integer.parseInt(s1) + Integer.parseInt(s2)),
                    "Resultado", JOptionPane.PLAIN_MESSAGE
                );
            break;
                
            case "-":
                JOptionPane.showMessageDialog(
                    null,
                    "Subtração: " + (Integer.parseInt(s1) - Integer.parseInt(s2)),
                    "Resultado", JOptionPane.PLAIN_MESSAGE
                );
            break;

            case "*":
                JOptionPane.showMessageDialog(
                    null,
                    "Multiplicação: " + (Integer.parseInt(s1) * Integer.parseInt(s2)),
                    "Resultado", JOptionPane.PLAIN_MESSAGE
                );
            break;

            case "/":
                JOptionPane.showMessageDialog(
                    null,
                    "Divisão: " + (Integer.parseInt(s1) / Integer.parseInt(s2)),
                    "Resultado", JOptionPane.PLAIN_MESSAGE
                );
            break;

            default:
                JOptionPane.showMessageDialog(
                    null,
                    "Operação Inválida - Algum erro ocorreu!",
                    "Aviso", JOptionPane.WARNING_MESSAGE
                );
        }

    }

}
