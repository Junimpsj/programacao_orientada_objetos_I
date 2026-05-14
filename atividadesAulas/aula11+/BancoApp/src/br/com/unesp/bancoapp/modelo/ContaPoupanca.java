package br.com.unesp.bancoapp.modelo;

/**
 * Conta poupança. A taxa de atualização de saldo é aplicada ao triplo
 * da taxa base recebida.
 */
public class ContaPoupanca extends Conta {

    /**
     * @param numero  número da conta
     * @param titular cliente titular
     * @param saldo   saldo inicial
     */
    public ContaPoupanca(int numero, Cliente titular, double saldo) {
        super(numero, titular, saldo);
    }

    /**
     * Aplica o triplo da taxa base no saldo (taxa * 3).
     *
     * @param taxa taxa base de rendimento
     */
    @Override
    public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 3);
}

}
