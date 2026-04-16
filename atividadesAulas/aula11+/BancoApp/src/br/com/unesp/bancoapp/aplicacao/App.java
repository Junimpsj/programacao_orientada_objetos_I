package br.com.unesp.bancoapp.aplicacao;

import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.Conta;
import br.com.unesp.bancoapp.modelo.ContaCorrente;
import br.com.unesp.bancoapp.modelo.ContaPoupanca;
import br.com.unesp.bancoapp.modelo.Funcionario;
import br.com.unesp.bancoapp.modelo.Gerente;
import br.com.unesp.bancoapp.servico.AtualizadorConta;
import br.com.unesp.bancoapp.servico.ControleBonificacoes;

public class App {

    public static void main(String[] args) throws Exception {

        Cliente cliente1 = new Cliente("Ana", "123.123.123-00");
        Conta c1 = new Conta(987, cliente1, 0.0);
        c1.deposita(200.0);
        c1.deposita(150.0);

        Cliente cliente2 = new Cliente("Carlos", "172.172.172-00");
        Conta c2 = new Conta(990, cliente2, 0.0);
        c2.deposita(500);

        System.out.println("Cliente: " + c1.getTitular().getNome() + "\n" + "Saldo atual: R$ " + c1.getSaldo());
        System.out.println();
        System.out.println("Cliente: " + c2.getTitular().getNome() + "\n" + "Saldo atual: R$ " + c2.getSaldo());

        System.out.println();
        c2.transfere(c1, 100);
        System.out.println("Transferência relizada! Carlos (- R$100) -> Ana (+ R$100)");
        System.out.println();

        System.out.println("Cliente: " + c1.getTitular().getNome() + "\n" + "Saldo atual: R$ " + c1.getSaldo());
        System.out.println();
        System.out.println("Cliente: " + c2.getTitular().getNome() + "\n" + "Saldo atual: R% " + c2.getSaldo());

        System.out.println("-----------------------------------------------------------------------------------------\n\n");

        System.out.println("Teste Polimorfismo:\n");

        Funcionario f1 = new Funcionario("123.456.789-00", "Pedro Augusto", 3000.0);
        Gerente g1 = new Gerente("Ana Silva", "123.456.789-00", 5000.0, 1500.0);
        System.out.println("Bônus do gerente: " + g1.getBonificacao());
        System.out.println("Bônus do funcionário: " + f1.getBonificacao());


        ControleBonificacoes controle = new ControleBonificacoes();
        controle.registra(f1);
        controle.registra(g1);
        System.out.println("Total de bonificações: " + controle.getTotal());

        System.out.println("-----------------------------------------------------------------------------------------\n\n");

        System.out.println("Atividade Polimorfismo\n");

        Conta cc = new ContaCorrente(1, cliente1, 1000.0);
        Conta cp = new ContaPoupanca(2, cliente2, 1000.0);

        AtualizadorConta atualizador = new AtualizadorConta();
        atualizador.atualizarConta(cc, 0.01); // ContaCorrente vai aplicar 2%
        atualizador.atualizarConta(cp, 0.01); // ContaPoupanca vai aplicar 3%

        System.out.println("Total atualizado: " + atualizador.getTotalAtualizado());
        
    }
    
}
