package br.com.unesp.projetonetbeans.view;

import br.com.unesp.projetonetbeans.controller.UniversidadeController;
import javax.swing.JFrame;

/**
 * Janela principal da aplicação FCT/Unesp.
 * Exibe o menu de navegação e os botões de acesso às telas de cadastro e consulta.
 * Mantém uma única instância de {@link br.com.unesp.projetonetbeans.controller.UniversidadeController}
 * compartilhada entre todas as janelas abertas a partir daqui.
 */
public class Principal extends javax.swing.JFrame {

    private UniversidadeController universidadeController;

    public Principal() {
        initComponents();
        this.universidadeController = new UniversidadeController("FCT/Unesp");

        // itens de menu adicionais
        javax.swing.JMenuItem itemListarDepto = new javax.swing.JMenuItem("Listar / Consultar");
        itemListarDepto.addActionListener(e -> new ListaDepartamentosView(universidadeController).setVisible(true));
        jMenu2.add(itemListarDepto);

        javax.swing.JMenuItem itemListarFunc = new javax.swing.JMenuItem("Listar / Consultar");
        itemListarFunc.addActionListener(e -> new ListaFuncionariosView(universidadeController).setVisible(true));
        jMenu3.add(itemListarFunc);

        // painel de botões no corpo da janela principal
        javax.swing.JPanel painel = new javax.swing.JPanel(new java.awt.GridLayout(3, 2, 15, 15));
        painel.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 60, 40, 60));

        javax.swing.JButton btnCadastrarDepto = new javax.swing.JButton("Cadastrar Departamento");
        javax.swing.JButton btnListarDepto    = new javax.swing.JButton("Listar / Consultar Departamentos");
        javax.swing.JButton btnCadastrarFunc  = new javax.swing.JButton("Cadastrar Funcionário");
        javax.swing.JButton btnListarFunc     = new javax.swing.JButton("Listar / Consultar Funcionários");

        btnCadastrarDepto.addActionListener(e -> new DepartamentoView(universidadeController).setVisible(true));
        btnListarDepto.addActionListener(e   -> new ListaDepartamentosView(universidadeController).setVisible(true));
        btnCadastrarFunc.addActionListener(e  -> new FuncionarioView(universidadeController).setVisible(true));
        btnListarFunc.addActionListener(e    -> new ListaFuncionariosView(universidadeController).setVisible(true));

        painel.add(btnCadastrarDepto);
        painel.add(btnListarDepto);
        painel.add(btnCadastrarFunc);
        painel.add(btnListarFunc);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCadastrarDepartamento = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Departamento");

        jMenuItemCadastrarDepartamento.setText("Cadastrar");
        jMenuItemCadastrarDepartamento.addActionListener(this::jMenuItemCadastrarDepartamentoActionPerformed);
        jMenu2.add(jMenuItemCadastrarDepartamento);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Funcionário");

        jMenuItem2.setText("Cadastrar");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastrarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarDepartamentoActionPerformed
        new DepartamentoView(universidadeController).setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarDepartamentoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FuncionarioView(universidadeController).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemCadastrarDepartamento;
    // End of variables declaration//GEN-END:variables
}
