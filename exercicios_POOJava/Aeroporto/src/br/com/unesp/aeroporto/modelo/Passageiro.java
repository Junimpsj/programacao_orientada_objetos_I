package br.com.unesp.aeroporto.modelo;

public class Passageiro {

    //atributos

    private String nome;
    private String RG;
    private int idade;

    //construtores

    public Passageiro() {

    }

    public Passageiro(String nome, String RG, int idade) {
        this.nome = nome;
        this.RG = RG;
        this.idade = idade;
    };

    //getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    //métodos

    

}