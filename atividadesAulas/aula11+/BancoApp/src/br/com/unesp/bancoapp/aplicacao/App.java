package br.com.unesp.bancoapp.aplicacao;

import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.Conta;

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
        System.out.println("Cliente: " + c2.getTitular().getNome() + "\n" + "Saldo atual: R% " + c2.getSaldo());

        System.out.println();
        c2.transfere(c1, 100);
        System.out.println("Transferência relizada! Carlos (- R$100) -> Ana (+ R$100)");
        System.out.println();

        System.out.println("Cliente: " + c1.getTitular().getNome() + "\n" + "Saldo atual: R$ " + c1.getSaldo());
        System.out.println();
        System.out.println("Cliente: " + c2.getTitular().getNome() + "\n" + "Saldo atual: R% " + c2.getSaldo());

    }
    
}
