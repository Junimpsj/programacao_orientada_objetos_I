package controller;

import view.CalculadoraView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador da calculadora.
 * Guarda o estado da operacao (primeiro operando, operador e flag de espera)
 * e registra o listener em todos os botoes da view.
 */
public class CalculadoraController {

    private CalculadoraView view;
    private double primeiroOperando;
    private String operador;
    private boolean aguardandoSegundo;

    /**
     * @param view tela da calculadora que sera controlada
     */
    public CalculadoraController(CalculadoraView view) {
        this.view = view;
        primeiroOperando = 0;
        operador = null;
        aguardandoSegundo = false;

        // um unico listener para todos os botoes; o comportamento e decidido
        // por getActionCommand() dentro do actionPerformed
        BotaoListener listener = new BotaoListener();
        for(int i = 0; i < view.botoes.length; i++) {
            view.botoes[i].addActionListener(listener);
        }
    }

    /**
     * Trata os cliques em todos os botoes da calculadora.
     * Decide a acao com base no texto do botao pressionado:
     * digito, operador (+,-,*,/), igual ou limpar (C).
     */
    private class BotaoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if(cmd.equals("C")) {
                // limpa tudo e volta ao estado inicial
                view.display.setText("0");
                primeiroOperando = 0;
                operador = null;
                aguardandoSegundo = false;

            } else if(cmd.equals("+") || cmd.equals("-")
                   || cmd.equals("*") || cmd.equals("/")) {
                // guarda o primeiro operando e aguarda o segundo
                try {
                    primeiroOperando = Double.parseDouble(view.display.getText());
                } catch(NumberFormatException ex) {
                    primeiroOperando = 0;
                }
                operador = cmd;
                aguardandoSegundo = true;

            } else if(cmd.equals("=")) {
                if(operador != null) {
                    double segundoOperando;
                    try {
                        segundoOperando = Double.parseDouble(view.display.getText());
                    } catch(NumberFormatException ex) {
                        segundoOperando = 0;
                    }

                    double resultado = calcular(primeiroOperando, segundoOperando, operador);

                    if(Double.isNaN(resultado) || Double.isInfinite(resultado)) {
                        view.display.setText("Erro");
                    } else if(resultado == (long) resultado) {
                        view.display.setText(String.valueOf((long) resultado));
                    } else {
                        view.display.setText(String.valueOf(resultado));
                    }

                    operador = null;
                    aguardandoSegundo = true;
                }

            } else {
                // digito pressionado
                if(aguardandoSegundo) {
                    view.display.setText(cmd);
                    aguardandoSegundo = false;
                } else if(view.display.getText().equals("0")
                       || view.display.getText().equals("Erro")) {
                    view.display.setText(cmd);
                } else {
                    view.display.setText(view.display.getText() + cmd);
                }
            }
        }

        /**
         * Executa a operacao aritmetica entre dois operandos.
         * @param a  primeiro operando
         * @param b  segundo operando
         * @param op operador como string (+, -, *, /)
         * @return resultado da operacao, ou Double.NaN em caso de divisao por zero
         */
        private double calcular(double a, double b, String op) {
            if(op.equals("+")) return a + b;
            if(op.equals("-")) return a - b;
            if(op.equals("*")) return a * b;
            if(op.equals("/")) {
                if(b == 0) return Double.NaN;
                return a / b;
            }
            return 0;
        }
    }
}