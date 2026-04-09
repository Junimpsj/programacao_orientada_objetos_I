package br.com.unesp.academia.aplicacao;

import br.com.unesp.academia.modelo.AlunoAcademia;

/**
 * Classe principal que executa a aplicação de gerenciamento de alunos de academia.
 * Demonstra o uso da classe AlunoAcademia ao criar instâncias de alunos,
 * calcular seu IMC e verificar elegibilidade para desconto.
 * 
 * @author Academia
 * @version 1.0
 */
public class App {

    /**
     * Método principal que executa a aplicação.
     * Cria dados de quatro alunos, calcula seus IMCs e verifica se têm
     * direito a desconto, exibindo os resultados no console.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Criação de instâncias de alunos com nome, idade, peso e altura
        AlunoAcademia al1 = new AlunoAcademia("Walter White", 40, 77.5, 1.80);
        AlunoAcademia al2 = new AlunoAcademia("Jessy Pinkman", 27, 70, 1.75);
        AlunoAcademia al3 = new AlunoAcademia("Skyler White", 38, 64, 1.68);
        AlunoAcademia al4 = new AlunoAcademia("Walter Junior", 16, 71.5, 1.77);

        // Cálculo do IMC para cada aluno
        double imcAl1 = al1.calcularIMC();
        double imcAl2 = al2.calcularIMC();
        double imcAl3 = al3.calcularIMC();
        double imcAl4 = al4.calcularIMC();

        // Exibição dos dados dos alunos com seus IMCs e elegibilidade para desconto
        System.out.println("--- Dados dos Alunos da Academia: ---\n");

        System.out.print("Nome: " + al1.getNome() + " | IMC: " + imcAl1 + " | Desconto: ");
        if(al1.temDesconto()) {
            System.out.println("Aprovado!");
        } if(!al1.temDesconto()) {
            System.out.println("Não aprovado!");
        }

        System.out.print("Nome: " + al2.getNome() + " | IMC: " + imcAl2 + " | Desconto: ");
        if(al2.temDesconto()) {
            System.out.println("Aprovado!");
        } if(!al2.temDesconto()) {
            System.out.println("Não aprovado!");
        }

        System.out.print("Nome: " + al3.getNome() + " | IMC: " + imcAl3 + " | Desconto: ");
        if(al3.temDesconto()) {
            System.out.println("Aprovado!");
        } if(!al3.temDesconto()) {
            System.out.println("Não aprovado!");
        }

        System.out.print("Nome: " + al4.getNome() + " | IMC: " + imcAl4 + " | Desconto: ");
        if(al4.temDesconto()) {
            System.out.println("Aprovado!");
        } if(!al4.temDesconto()) {
            System.out.println("Não aprovado!");
        }

    }

}