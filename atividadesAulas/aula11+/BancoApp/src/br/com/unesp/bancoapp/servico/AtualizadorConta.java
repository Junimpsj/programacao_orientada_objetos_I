package br.com.unesp.bancoapp.servico;

import br.com.unesp.bancoapp.modelo.Conta;

public class AtualizadorConta {
    
    private double totalAtualizado;

    public double getTotalAtualizado() {
        return totalAtualizado;
    }

    public void atualizarConta(Conta conta, double taxa) {
    conta.atualizaSaldo(taxa);
    this.totalAtualizado += conta.getSaldo();
    }

}
