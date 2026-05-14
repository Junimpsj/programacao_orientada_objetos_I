package br.com.unesp.bancoapp.modelo;

/**
 * Classe abstrata que representa uma conta bancária.
 * Subclasses definem a lógica de atualização de saldo ({@link #atualizaSaldo}).
 */
public abstract class Conta {

    protected int numero;
    protected Cliente titular;
    protected double saldo;

    /** Construtor padrão. */
    public Conta() {

    }

    /**
     * @param numero  número da conta
     * @param titular cliente titular
     * @param saldo   saldo inicial
     */
    public Conta(int numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * @param numero novo número da conta
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @param titular novo titular
     */
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    /**
     * @param saldo novo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /** @return número da conta */
    public int getNumero() {
        return numero;
    }

    /** @return titular da conta */
    public Cliente getTitular() {
        return titular;
    }

    /** @return saldo atual */
    public double getSaldo() {
        return saldo;
    }

    // Método publico que tenta sacar e retorna se foi sucedido ou não
    /**
     * Tenta realizar um saque.
     *
     * @param valor valor a sacar
     * @return {@code true} se o saque foi realizado; {@code false} se saldo insuficiente
     */
    public boolean saca(double valor) {

        if(this.saldo < valor) {
            return false; // saldo insuficiente
        } else {
            this.saldo -= valor;
            return true; //saque realizado
        }

    }

    // Método publico para depositar dinheiro
    /**
     * Deposita um valor na conta.
     *
     * @param quantidade valor a depositar
     */
    public void deposita(double quantidade) {

        this.saldo += quantidade;

    }

    /**
     * Transfere um valor desta conta para a conta de destino.
     * Usa {@link #saca} e {@link #deposita} internamente.
     *
     * @param destino conta de destino
     * @param valor   valor a transferir
     */
    public void transfere(Conta destino, double valor) { //quando passar para o projeto com estrutura correta faz esse método como booleano porque é a melhor maneira

        if(this.saca(valor)) {
            destino.deposita(valor);
        } // vamos utilizar os métodos ja existentes para facilitar

    }

    /**
     * Atualiza o saldo aplicando uma taxa de rendimento.
     * Subclasses podem sobrescrever para alterar o multiplicador da taxa.
     *
     * @param taxa taxa de rendimento (ex: 0.01 = 1%)
     */
    public void atualizaSaldo(double taxa) {
        this.saldo += this.saldo * taxa;
    }

}
