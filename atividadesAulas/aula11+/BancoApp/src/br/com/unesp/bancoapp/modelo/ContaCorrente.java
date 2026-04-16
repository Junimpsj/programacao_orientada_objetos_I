package br.com.unesp.bancoapp.modelo;

public class ContaCorrente extends Conta{

    private double limite;


    public ContaCorrente(int numero, Cliente titular, double saldo) {
        super(numero, titular, saldo);
    }

    public ContaCorrente(int numero, Cliente titular, double saldo, double limite) {
        super(numero, titular, saldo);
        this. limite = limite;
    }

    @Override
    public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 2);
}
}