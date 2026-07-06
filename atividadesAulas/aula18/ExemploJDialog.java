import javax.swing.JDialog;
import java.awt.Color;

public class ExemploJDialog extends JDialog{
    
    //Construtor
    public ExemploJDialog() {

        setTitle("Diálogo 1");
        setSize(600,200);
        setModal(true); //Definimos como Modal
        getContentPane().setBackground(Color.RED);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    //Método Principal
    public static void main(String[] args) {
        new ExemploJDialog();
    }

}
