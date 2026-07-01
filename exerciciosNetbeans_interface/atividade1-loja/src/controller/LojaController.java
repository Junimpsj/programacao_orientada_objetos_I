package controller;

import view.LojaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador da tela Loja Teste.
 * Registra o listener no botao Comprar e calcula o total da compra.
 */
public class LojaController {

    private LojaView view;

    /**
     * @param view tela da loja que sera controlada
     */
    public LojaController(LojaView view) {
        this.view = view;
        view.btnComprar.addActionListener(new EventoComprar());
    }

    /**
     * Trata o clique no botao Comprar.
     * Le a quantidade de cada produto, ignora campos invalidos (trata como 0)
     * e atualiza o label com o total no formato brasileiro.
     */
    private class EventoComprar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double total = 0.0;

            for(int i = 0; i < view.produtos.length; i++) {
                String texto = view.camposQtd[i].getText().trim();
                int qtd = 0;

                try {
                    int parsed = Integer.parseInt(texto);
                    if(parsed > 0) {
                        qtd = parsed;
                    }
                } catch(NumberFormatException ex) {
                    qtd = 0;
                }

                total += view.produtos[i].getValor() * qtd;
            }

            String totalStr = String.format("%.2f", total).replace('.', ',');
            view.lblTotal.setText("Total a pagar: " + totalStr);
        }
    }
}
