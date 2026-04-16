package br.com.unesp.bancoapp.modelo;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 3);
}
    
}