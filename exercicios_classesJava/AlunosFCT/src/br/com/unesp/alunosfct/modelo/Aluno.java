package br.com.unesp.alunosfct.modelo;

/**
 * Classe que representa um Aluno com informações de notas e provas.
 * Contém métodos para calcular média e verificar aprovação.
 */
public class Aluno {

    private int ra;
    private String nome;
    private double nota1;
    private double nota2;
    private double prova1;
    private double prova2;

    /**
     * Construtor que inicializa um novo Aluno com suas informações acadêmicas.
     *
     * @param ra       RA (Registro Acadêmico) do aluno
     * @param nome     Nome completo do aluno
     * @param nota1    Primeira nota de trabalho
     * @param nota2    Segunda nota de trabalho
     * @param prova1   Nota da primeira prova
     * @param prova2   Nota da segunda prova
     */
    public Aluno(int ra, String nome, double nota1, double nota2, double prova1, double prova2) {
        this.ra = ra;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.prova1 = prova1;
        this.prova2 = prova2;
    }

    /**
     * Obtém o RA (Registro Acadêmico) do aluno.
     *
     * @return RA do aluno
     */
    public int getRa() {
        return ra;
    }

    /**
     * Define o RA (Registro Acadêmico) do aluno.
     *
     * @param ra RA a ser atribuído
     */
    public void setRa(int ra) {
        this.ra = ra;
    }

    /**
     * Obtém o nome do aluno.
     *
     * @return Nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     *
     * @param nome Nome a ser atribuído
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a primeira nota de trabalho.
     *
     * @return Primeira nota
     */
    public double getNota1() {
        return nota1;
    }

    /**
     * Define a primeira nota de trabalho.
     *
     * @param nota1 Primeira nota a ser atribuída
     */
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    /**
     * Obtém a segunda nota de trabalho.
     *
     * @return Segunda nota
     */
    public double getNota2() {
        return nota2;
    }

    /**
     * Define a segunda nota de trabalho.
     *
     * @param nota2 Segunda nota a ser atribuída
     */
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    /**
     * Obtém a nota da primeira prova.
     *
     * @return Nota da primeira prova
     */
    public double getProva1() {
        return prova1;
    }

    /**
     * Define a nota da primeira prova.
     *
     * @param prova1 Nota da primeira prova a ser atribuída
     */
    public void setProva1(double prova1) {
        this.prova1 = prova1;
    }

    /**
     * Obtém a nota da segunda prova.
     *
     * @return Nota da segunda prova
     */
    public double getProva2() {
        return prova2;
    }

    /**
     * Define a nota da segunda prova.
     *
     * @param prova2 Nota da segunda prova a ser atribuída
     */
    public void setProva2(double prova2) {
        this.prova2 = prova2;
    }

    /**
     * Calcula a média aritmética do aluno usando as notas de trabalho e provas armazenadas.
     * A média é a soma de todas as avaliações (nota1 + nota2 + prova1 + prova2) dividida por 4.
     *
     * @return Média do aluno
     */
    public double calcularMedia() {

        double soma = this.nota1 + this.nota2 + this.prova1 + this.prova2;

        double media = soma / 4;

        return media;
    }

    /**
     * Verifica se o aluno está aprovado com base em sua média.
     * Um aluno está aprovado se a média for maior ou igual a 5.0.
     *
     * @param media Média do aluno
     * @return {@code true} se o aluno está aprovado, {@code false} caso contrário
     */
    public boolean estaAprovado(double media) {
        if(media >= 5) {
            return true;
        } else {
            return false;
        }
    }

}