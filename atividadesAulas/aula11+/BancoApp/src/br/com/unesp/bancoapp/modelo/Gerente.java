package br.com.unesp.bancoapp.modelo;

public class Gerente extends Funcionario{

    private double bonus;

    public Gerente(String nome, String cpf, double salario, double bonus) {
        super(nome,cpf,salario);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
    
}
