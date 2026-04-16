package br.com.unesp.bancoapp.servico;

import br.com.unesp.bancoapp.modelo.Funcionario;

public class ControleBonificacoes {

    private double total = 0;

    public double getTotal() {
        return total;
    }

    public void registra(Funcionario f) {
        this.total += f.getBonificacao();
    }

}