package br.com.unesp.bancoapp.servico;

import br.com.unesp.bancoapp.modelo.Funcionario;

/**
 * Serviço que acumula o total de bonificações de todos os funcionários registrados.
 * Usa polimorfismo: aceita qualquer subclasse de {@link Funcionario}.
 */
public class ControleBonificacoes {

    private double total = 0;

    /**
     * @return soma de todas as bonificações registradas
     */
    public double getTotal() {
        return total;
    }

    /**
     * Registra a bonificação de um funcionário no total acumulado.
     *
     * @param f funcionário a registrar
     */
    public void registra(Funcionario f) {
        this.total += f.getBonificacao();
    }

}
