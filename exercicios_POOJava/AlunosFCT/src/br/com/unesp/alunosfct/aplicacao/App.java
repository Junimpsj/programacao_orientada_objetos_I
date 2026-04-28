package br.com.unesp.alunosfct.aplicacao;

import br.com.unesp.alunosfct.modelo.Aluno;

/**
 * Classe principal que executa a aplicação de verificação de aprovação de alunos.
 * Instancia alunos e exibe suas médias e situação de aprovação.
 */
public class App {

    /**
     * Método principal que executa o programa.
     * Cria instâncias de alunos com suas informações acadêmicas,
     * calcula suas médias e exibe sua situação de aprovação.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

    Aluno al1 = new Aluno(231254024, "Harry Potter da Silva", 6, 8, 5, 6);
    Aluno al2 = new Aluno(231256721, "Hermione Granger Santos", 10, 9.9, 10, 10);
    Aluno al3 = new Aluno(231259010, "Ron Weasley Machado", 4, 5, 3, 4);
    Aluno al4 = new Aluno(231257788, "Dobby Pereira", 2, 3, 7, 1);

    double mediaAl1 = al1.calcularMedia();
    double mediaAl2 = al2.calcularMedia();
    double mediaAl3 = al3.calcularMedia();
    double mediaAl4 = al4.calcularMedia();

    System.out.print("Aluno: " + al1.getNome() + " | Situação: ");
    if(al1.estaAprovado(mediaAl1)) {
        System.out.println("Aprovado!");
    } if(!al1.estaAprovado(mediaAl1)) {
        System.out.println("Reprovado!");
    }

    System.out.print("Aluno: " + al2.getNome() + " | Situação: ");
    if(al1.estaAprovado(mediaAl2)) {
        System.out.println("Aprovado!");
    } if(!al1.estaAprovado(mediaAl2)) {
        System.out.println("Reprovado!");
    }
    System.out.print("Aluno: " + al3.getNome() + " | Situação: ");
    if(al1.estaAprovado(mediaAl3)) {
        System.out.println("Aprovado!");
    } if(!al1.estaAprovado(mediaAl3)) {
        System.out.println("Reprovado!");
    }
    System.out.print("Aluno: " + al4.getNome() + " | Situação: ");
    if(al1.estaAprovado(mediaAl4)) {
        System.out.println("Aprovado!");
    } if(!al1.estaAprovado(mediaAl4)) {
        System.out.println("Reprovado!");
    }

    }
    
}