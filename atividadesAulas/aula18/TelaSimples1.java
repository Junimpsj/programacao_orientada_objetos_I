import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TelaSimples1 {
    
    public static void main(String[] args) {

        //Instanciamos a janela antes
        //Nesse exemplo eu TENHO um JFrame instanciado
        JFrame ts1 = new JFrame();

        ts1.setTitle("Janela Teste 1"); //Definindo o titulo da tela
        ts1.setSize(480,480); //Largura e altura da janela
        ts1.getContentPane().setBackground(Color.LIGHT_GRAY); //Definir cor de fundo
        ts1.setLocationRelativeTo(null); //Centraliza a tela
        ts1.setDefaultCloseOperation(EXIT_ON_CLOSE); //Encerra a aplicação ao fechar
        ts1.setVisible(true); //Deixamos a janela visivel

    }

}