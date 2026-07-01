package view;

import model.Produto;
import javax.swing.*;
import java.awt.*;

/**
 * Tela principal da Loja Teste.
 * Exibe os produtos em tres colunas (nome, preco, quantidade),
 * botao de compra e label com o total calculado.
 */
public class LojaView extends JFrame {

    public Produto[] produtos;
    public JCheckBox[] checkBoxes;
    public JTextField[] camposQtd;
    public JButton btnComprar;
    public JLabel lblTotal;

    /**
     * Monta a janela com todos os componentes da loja.
     * A grade de produtos usa GridLayout(8, 3): 1 linha de cabecalho + 7 produtos.
     */
    public LojaView() {
        produtos = new Produto[]{
            new Produto("Rapadura", 1.50),
            new Produto("Salame", 3.00),
            new Produto("Doce de leite", 1.10),
            new Produto("Queijo", 12.35),
            new Produto("Gordura Animal (banha)", 1.85),
            new Produto("Iogurte", 0.80),
            new Produto("Mel", 11.17)
        };

        checkBoxes = new JCheckBox[produtos.length];
        camposQtd  = new JTextField[produtos.length];

        setTitle("Loja Teste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // grade de produtos
        JPanel painelGrid = new JPanel(new GridLayout(produtos.length + 1, 3, 5, 5));

        JLabel hProduto = new JLabel("Produtos", SwingConstants.CENTER);
        hProduto.setFont(hProduto.getFont().deriveFont(Font.BOLD));
        JLabel hValor = new JLabel("Valor", SwingConstants.CENTER);
        hValor.setFont(hValor.getFont().deriveFont(Font.BOLD));
        JLabel hQtd = new JLabel("Quantidade", SwingConstants.CENTER);
        hQtd.setFont(hQtd.getFont().deriveFont(Font.BOLD));

        painelGrid.add(hProduto);
        painelGrid.add(hValor);
        painelGrid.add(hQtd);

        for(int i = 0; i < produtos.length; i++) {
            checkBoxes[i] = new JCheckBox(produtos[i].getNome());

            String valorStr = "R$ " + String.format("%.2f", produtos[i].getValor()).replace('.', ',');
            JLabel lblValor = new JLabel(valorStr, SwingConstants.CENTER);

            camposQtd[i] = new JTextField("0");
            camposQtd[i].setHorizontalAlignment(JTextField.CENTER);

            painelGrid.add(checkBoxes[i]);
            painelGrid.add(lblValor);
            painelGrid.add(camposQtd[i]);
        }

        JPanel painelCentro = new JPanel(new BorderLayout());
        painelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        painelCentro.add(painelGrid, BorderLayout.CENTER);
        add(painelCentro, BorderLayout.CENTER);

        // painel sul com botao e total
        JPanel painelSul = new JPanel(new BorderLayout(5, 5));
        painelSul.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnComprar = new JButton("Comprar");
        painelBotao.add(btnComprar);

        JPanel painelTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblTotal = new JLabel("Total a pagar: 0,00");
        lblTotal.setFont(lblTotal.getFont().deriveFont(Font.BOLD));
        painelTotal.add(lblTotal);

        painelSul.add(painelBotao, BorderLayout.NORTH);
        painelSul.add(painelTotal, BorderLayout.SOUTH);

        add(painelSul, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
