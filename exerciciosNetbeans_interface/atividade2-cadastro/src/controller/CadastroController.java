package controller;

import model.Cadastro;
import view.CadastroView;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Controlador do formulario de cadastro.
 * Registra o listener no botao Salvar, valida os campos obrigatorios,
 * cria o objeto Cadastro e dispara a impressao/exportacao para PDF.
 */
public class CadastroController {

    private CadastroView view;

    /**
     * @param view tela de cadastro que sera controlada
     */
    public CadastroController(CadastroView view) {
        this.view = view;
        view.btnSalvar.addActionListener(new EventoSalvar());
    }

    /**
     * Trata o clique no botao Salvar.
     * Valida nome e e-mail, coleta os dados do formulario e exporta o cadastro.
     * Se houver impressora/driver PDF disponivel, abre o dialogo de impressao nativo.
     * Caso contrario, oferece salvar os dados em arquivo .txt via JFileChooser.
     */
    private class EventoSalvar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome  = view.txtNome.getText().trim();
            String email = view.txtEmail.getText().trim();

            // validacao dos campos obrigatorios
            if(nome.isEmpty()) {
                JOptionPane.showMessageDialog(view,
                    "O campo NOME não pode estar vazio.",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(email.isEmpty()) {
                JOptionPane.showMessageDialog(view,
                    "O campo E-MAIL não pode estar vazio.",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // coleta dos dados
            String telefone = view.txtTelefone.getText().trim();
            String endereco = view.txtEndereco.getText().trim();
            String cidade   = view.txtCidade.getText().trim();
            String uf       = (String) view.cbUF.getSelectedItem();
            String sexo     = view.rbFeminino.isSelected() ? "Feminino" : "Masculino";

            ArrayList<String> cursos = new ArrayList<String>();
            if(view.cbAlemao.isSelected())   cursos.add("Alemão");
            if(view.cbEspanhol.isSelected())  cursos.add("Espanhol");
            if(view.cbFrances.isSelected())   cursos.add("Francês");
            if(view.cbIngles.isSelected())    cursos.add("Inglês");
            if(view.cbItaliano.isSelected())  cursos.add("Italiano");
            if(view.cbJapones.isSelected())   cursos.add("Japonês");

            String motivo = view.txtMotivo.getText().trim();

            Cadastro cadastro = new Cadastro(nome, telefone, endereco, cidade,
                                             uf, email, sexo, cursos, motivo);

            // verifica se o sistema possui alguma impressora ou driver PDF disponivel
            PrintService[] servicos = PrintServiceLookup.lookupPrintServices(null, null);

            if(servicos.length > 0) {
                // ha impressora disponivel: usa dialogo de impressao nativo (pode direcionar para PDF)
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Cadastro - " + nome);
                job.setPrintable(new CadastroPrintable(cadastro));

                if(job.printDialog()) {
                    try {
                        job.print();
                        JOptionPane.showMessageDialog(view,
                            "Cadastro enviado para impressão/PDF com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch(PrinterException ex) {
                        JOptionPane.showMessageDialog(view,
                            "Erro ao imprimir: " + ex.getMessage(),
                            "Erro de Impressão", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                // sem impressora configurada: salva os dados em arquivo .txt
                salvarComoArquivo(cadastro);
            }
        }

        /**
         * Abre JFileChooser para o usuario escolher onde salvar o cadastro como .txt.
         * Usado como alternativa quando nenhuma impressora esta disponivel no sistema.
         * @param cadastro dados a serem gravados no arquivo
         */
        private void salvarComoArquivo(Cadastro cadastro) {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File("cadastro_" + cadastro.getNome().replaceAll("\\s+", "_") + ".txt"));
            int resultado = chooser.showSaveDialog(view);

            if(resultado == JFileChooser.APPROVE_OPTION) {
                File arquivo = chooser.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(arquivo, "UTF-8");

                    pw.println("========================================");
                    pw.println("CADASTRO");
                    pw.println("========================================");
                    pw.println("Nome:      " + cadastro.getNome());
                    pw.println("Telefone:  " + cadastro.getTelefone());
                    pw.println("Endereço:  " + cadastro.getEndereco());
                    pw.println("Cidade:    " + cadastro.getCidade());
                    pw.println("UF:        " + cadastro.getUf());
                    pw.println("E-mail:    " + cadastro.getEmail());
                    pw.println("Sexo:      " + cadastro.getSexo());
                    pw.println();
                    pw.println("CURSOS");
                    pw.println("----------------------------------------");

                    if(cadastro.getCursos().isEmpty()) {
                        pw.println("Nenhum curso selecionado.");
                    } else {
                        for(int i = 0; i < cadastro.getCursos().size(); i++) {
                            pw.println("- " + cadastro.getCursos().get(i));
                        }
                    }

                    pw.println();
                    pw.println("Motivo/Interesse:");
                    pw.println(cadastro.getMotivo());
                    pw.println("========================================");

                    pw.close();

                    JOptionPane.showMessageDialog(view,
                        "Cadastro salvo em: " + arquivo.getName(),
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(view,
                        "Erro ao salvar arquivo: " + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Implementacao de Printable que desenha os dados do cadastro via Graphics2D.
     * Permite que o PrinterJob redirecione a saida para um arquivo PDF pelo driver do SO.
     */
    private class CadastroPrintable implements Printable {

        private Cadastro cadastro;

        /**
         * @param cadastro objeto com os dados a serem impressos
         */
        CadastroPrintable(Cadastro cadastro) {
            this.cadastro = cadastro;
        }

        /**
         * Desenha o conteudo do cadastro na pagina de impressao.
         * @param graphics   contexto grafico da pagina
         * @param pageFormat formato e dimensoes da pagina
         * @param pageIndex  indice da pagina (apenas pagina 0 existe)
         * @return PAGE_EXISTS para a primeira pagina, NO_SUCH_PAGE para as demais
         */
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {
            if(pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

            Font fonteNegrito = new Font("SansSerif", Font.BOLD, 14);
            Font fonteNormal  = new Font("SansSerif", Font.PLAIN, 12);

            int x  = 50;
            int y  = 50;
            int lh = 22;

            // cabecalho
            g2d.setFont(fonteNegrito);
            g2d.drawString("CADASTRO", x, y);
            y += lh * 2;

            // dados pessoais
            g2d.setFont(fonteNormal);
            g2d.drawString("Nome:      " + cadastro.getNome(),     x, y); y += lh;
            g2d.drawString("Telefone:  " + cadastro.getTelefone(), x, y); y += lh;
            g2d.drawString("Endereço:  " + cadastro.getEndereco(), x, y); y += lh;
            g2d.drawString("Cidade:    " + cadastro.getCidade(),   x, y); y += lh;
            g2d.drawString("UF:        " + cadastro.getUf(),       x, y); y += lh;
            g2d.drawString("E-mail:    " + cadastro.getEmail(),    x, y); y += lh;
            g2d.drawString("Sexo:      " + cadastro.getSexo(),     x, y); y += lh * 2;

            // cursos
            g2d.setFont(fonteNegrito);
            g2d.drawString("CURSOS", x, y);
            y += lh;

            g2d.setFont(fonteNormal);
            if(cadastro.getCursos().isEmpty()) {
                g2d.drawString("Nenhum curso selecionado.", x, y);
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < cadastro.getCursos().size(); i++) {
                    if(i > 0) sb.append(", ");
                    sb.append(cadastro.getCursos().get(i));
                }
                g2d.drawString(sb.toString(), x, y);
            }
            y += lh * 2;

            // motivo
            g2d.drawString("Motivo/Interesse:", x, y);
            y += lh;

            String motivo = cadastro.getMotivo();
            int maxChars  = 80;
            while(motivo.length() > maxChars) {
                g2d.drawString(motivo.substring(0, maxChars), x, y);
                motivo = motivo.substring(maxChars);
                y += lh;
            }
            g2d.drawString(motivo, x, y);

            return PAGE_EXISTS;
        }
    }
}
