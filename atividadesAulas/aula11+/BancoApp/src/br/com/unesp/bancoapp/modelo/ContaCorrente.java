package br.com.unesp.bancoapp.modelo;

/**
 * Conta corrente. A taxa de atualização de saldo é aplicada em dobro
 * em relação à taxa base recebida.
 */
public class ContaCorrente extends Conta{

    private double limite;

    /**
     * @param numero  número da conta
     * @param titular cliente titular
     * @param saldo   saldo inicial
     */
    public ContaCorrente(int numero, Cliente titular, double saldo) {
        super(numero, titular, saldo);
    }

    /**
     * @param numero  número da conta
     * @param titular cliente titular
     * @param saldo   saldo inicial
     * @param limite  limite de crédito adicional
     */
    public ContaCorrente(int numero, Cliente titular, double saldo, double limite) {
        super(numero, titular, saldo);
        this. limite = limite;
    }

    /** @return limite de crédito da conta corrente */
    public double getLimite() {
        return limite;
    }

    /**
     * Aplica o dobro da taxa base no saldo (taxa * 2).
     *
     * @param taxa taxa base de rendimento
     */
    @Override
    public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 2);
}
}
