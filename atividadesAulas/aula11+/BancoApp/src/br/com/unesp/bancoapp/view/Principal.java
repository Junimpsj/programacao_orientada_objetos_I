package br.com.unesp.bancoapp.view;

import br.com.unesp.bancoapp.controller.BancoController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Janela principal do sistema bancário.
 * Exibe o menu de navegação e os botões de acesso às telas de cadastro e consulta.
 * Mantém uma única instância de {@link BancoController} compartilhada entre todas
 * as janelas abertas a partir daqui.
 */
public class Principal extends JFrame {

    private BancoController bancoController;

    /**
     * Monta a janela principal com menu bar e painel de botões.
     */
    public Principal() {
        setTitle("BancoApp - Sistema Bancário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bancoController = new BancoController("BancoApp");

        // menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFuncionarios = new JMenu("Funcionários");
        JMenuItem itemCadastrarFunc = new JMenuItem("Cadastrar");
        JMenuItem itemListarFunc    = new JMenuItem("Listar / Consultar");
        itemCadastrarFunc.addActionListener(e -> new FuncionarioView(bancoController).setVisible(true));
        itemListarFunc.addActionListener(e    -> new ListaFuncionariosView(bancoController).setVisible(true));
        menuFuncionarios.add(itemCadastrarFunc);
        menuFuncionarios.add(itemListarFunc);

        JMenu menuClientes = new JMenu("Clientes");
        JMenuItem itemCadastrarCli = new JMenuItem("Cadastrar");
        JMenuItem itemListarCli    = new JMenuItem("Listar / Consultar");
        itemCadastrarCli.addActionListener(e -> new ClienteView(bancoController).setVisible(true));
        itemListarCli.addActionListener(e    -> new ListaClientesView(bancoController).setVisible(true));
        menuClientes.add(itemCadastrarCli);
        menuClientes.add(itemListarCli);

        menuBar.add(menuFuncionarios);
        menuBar.add(menuClientes);
        setJMenuBar(menuBar);

        // painel de botões no corpo da janela
        JPanel painel = new JPanel(new GridLayout(2, 2, 15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JButton btnCadastrarFunc = new JButton("Cadastrar Funcionário");
        JButton btnListarFunc    = new JButton("Listar / Consultar Funcionários");
        JButton btnCadastrarCli  = new JButton("Cadastrar Cliente");
        JButton btnListarCli     = new JButton("Listar / Consultar Clientes");

        btnCadastrarFunc.addActionListener(e -> new FuncionarioView(bancoController).setVisible(true));
        btnListarFunc.addActionListener(e    -> new ListaFuncionariosView(bancoController).setVisible(true));
        btnCadastrarCli.addActionListener(e  -> new ClienteView(bancoController).setVisible(true));
        btnListarCli.addActionListener(e     -> new ListaClientesView(bancoController).setVisible(true));

        painel.add(btnCadastrarFunc);
        painel.add(btnListarFunc);
        painel.add(btnCadastrarCli);
        painel.add(btnListarCli);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
