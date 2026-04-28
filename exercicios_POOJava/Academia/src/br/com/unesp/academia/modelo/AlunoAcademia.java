package br.com.unesp.academia.modelo;

/**
 * Classe que representa um aluno de academia com informações pessoais e métodos
 * para cálculo de IMC e verificação de elegibilidade para desconto.
 * 
 * @author Academia
 * @version 1.0
 */
public class AlunoAcademia {

    /** Nome do aluno */
    private String nome;
    
    /** Idade do aluno em anos */
    private int idade;
    
    /** Peso do aluno em quilogramas */
    private double peso;
    
    /** Altura do aluno em metros */
    private double altura;
    
    /**
     * Construtor que inicializa um novo aluno com seus dados pessoais.
     * 
     * @param nome o nome do aluno
     * @param idade a idade do aluno em anos
     * @param peso o peso do aluno em quilogramas
     * @param altura a altura do aluno em metros
     */
    public AlunoAcademia(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
    /**
     * Obtém o nome do aluno.
     * 
     * @return o nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     * 
     * @param nome o novo nome do aluno
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a idade do aluno.
     * 
     * @return a idade do aluno em anos
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do aluno.
     * 
     * @param idade a nova idade do aluno em anos
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtém o peso do aluno.
     * 
     * @return o peso do aluno em quilogramas
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Define o peso do aluno.
     * 
     * @param peso o novo peso do aluno em quilogramas
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtém a altura do aluno.
     * 
     * @return a altura do aluno em metros
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Define a altura do aluno.
     * 
     * @param altura a nova altura do aluno em metros
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Calcula o Índice de Massa Corporal (IMC) do aluno.
     * A fórmula utilizada é: IMC = peso / (altura²)
     * 
     * @return o valor do IMC calculado
     */
    public double calcularIMC() {
        double imc = this.peso/(this.altura*this.altura);
        return imc;
    }

    /**
     * Verifica se o aluno é elegível para desconto.
     * Um aluno tem desconto se sua idade for maior que 0 e menor que 18 anos.
     * 
     * @return true se o aluno tem direito a desconto, false caso contrário
     */
    public boolean temDesconto() {
        if(this.idade > 0 && this.idade < 18) {
            return true;
        } else {
            return false;
        }
    }
    
}