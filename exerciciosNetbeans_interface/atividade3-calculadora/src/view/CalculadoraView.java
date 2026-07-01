package view;

import javax.swing.*;
import java.awt.*;

/**
 * Tela da calculadora com display no topo e grade de botoes 4x4 no centro.
 * Layout: BorderLayout no frame, GridLayout(4,4) no painel de botoes.
 */
public class CalculadoraView extends JFrame {

    public JTextField display;
    public JButton[] botoes;

    private static final String[] LABELS = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "C", "0", "=", "/"
    };

    /**
     * Monta a janela com o display e os 16 botoes na ordem do enunciado.
     */
    public CalculadoraView() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // display no topo, somente leitura (atualizado pelos botoes)
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 28));
        add(display, BorderLayout.NORTH);

        // grade 4x4 de botoes
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 4, 4));
        botoes = new JButton[LABELS.length];

        for(int i = 0; i < LABELS.length; i++) {
            botoes[i] = new JButton(LABELS[i]);
            botoes[i].setFont(new Font("SansSerif", Font.BOLD, 20));
            painelBotoes.add(botoes[i]);
        }

        add(painelBotoes, BorderLayout.CENTER);

        pack();
        setMinimumSize(new Dimension(280, 250));
        setLocationRelativeTo(null);
    }
}
