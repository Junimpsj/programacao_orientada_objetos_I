package br.com.unesp.bancoapp.servico;

import br.com.unesp.bancoapp.modelo.Conta;

/**
 * Serviço responsável por atualizar o saldo das contas e acumular
 * o total atualizado para controle.
 */
public class AtualizadorConta {

    private double totalAtualizado;

    /**
     * @return soma dos saldos de todas as contas atualizadas até agora
     */
    public double getTotalAtualizado() {
        return totalAtualizado;
    }

    /**
     * Aplica a taxa de rendimento na conta e acumula seu saldo no total.
     *
     * @param conta conta a ser atualizada
     * @param taxa  taxa de rendimento (ex: 0.01 = 1%)
     */
    public void atualizarConta(Conta conta, double taxa) {
    conta.atualizaSaldo(taxa);
    this.totalAtualizado += conta.getSaldo();
    }

}
