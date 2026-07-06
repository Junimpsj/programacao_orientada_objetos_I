import javax.swing.JFrame;
import java.awt.Color;

public class TelaSimples2 extends JFrame {

    //Construtor
    //Porque nesse exemplo, a minha classe É UM JFRAME!
    public TelaSimples2() {

        setTitle("Janela Teste 2");
        setSize(400,400);
        getContentPane().setBackground(Color.YELLOW);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    //Metodo principal
    public static void main(String[] args) {
        new TelaSimples2(); //Instanciamos a tela definida pelo construtor acima
    }
    
}