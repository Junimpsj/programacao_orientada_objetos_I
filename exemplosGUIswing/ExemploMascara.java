package exemplosGUIswing;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class ExemploMascara {

    public static void main(String[] args) throws Exception {

        JFrame tela = new JFrame("Máscara");
        tela.setSize(350, 150);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Máscara para data
        MaskFormatter mascara = new MaskFormatter("##/##/####");

        JFormattedTextField txtData = new JFormattedTextField(mascara);
        
        txtData.setBounds(30, 50, 300, 25);

        tela.add(txtData);


        tela.setVisible(true);
    }
}