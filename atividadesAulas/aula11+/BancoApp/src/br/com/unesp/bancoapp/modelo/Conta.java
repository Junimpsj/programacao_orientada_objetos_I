package br.com.unesp.bancoapp.modelo;

public class Conta {

    protected int numero;
    protected Cliente titular;
    protected double saldo;

    public Conta() {
        
    }

    public Conta(int numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método publico que tenta sacar e retorna se foi sucedido ou não
    public boolean saca(double valor) {

        if(this.saldo < valor) {
            return false; // saldo insuficiente
        } else {
            this.saldo -= valor;
            return true; //saque realizado
        }

    }

    // Método publico para depositar dinheiro
    public void deposita(double quantidade) {

        this.saldo += quantidade;

    }
    
    public void transfere(Conta destino, double valor) { //quando passar para o projeto com estrutura correta faz esse método como booleano porque é a melhor maneira
        
        if(this.saca(valor)) {
            destino.deposita(valor);
        } // vamos utilizar os métodos ja existentes para facilitar

    }

    public void atualizaSaldo(double taxa) {
        this.saldo += this.saldo * taxa;
    }

}