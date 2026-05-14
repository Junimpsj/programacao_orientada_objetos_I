package br.com.unesp.bancoapp.aplicacao;

import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.Conta;
import br.com.unesp.bancoapp.modelo.ContaCorrente;
import br.com.unesp.bancoapp.modelo.ContaPoupanca;
import br.com.unesp.bancoapp.modelo.Diretor;
import br.com.unesp.bancoapp.modelo.Endereco;
import br.com.unesp.bancoapp.modelo.Funcionario;
import br.com.unesp.bancoapp.modelo.Gerente;
import br.com.unesp.bancoapp.modelo.PessoaFisica;
import br.com.unesp.bancoapp.modelo.PessoaJuridica;
import br.com.unesp.bancoapp.modelo.TecnicoBancario;
import br.com.unesp.bancoapp.servico.AtualizadorConta;
import br.com.unesp.bancoapp.servico.ControleBonificacoes;

/**
 * Classe principal da aplicação BancoApp.
 * Demonstra o uso das classes de modelo e serviços:
 * contas, clientes (PF e PJ), funcionários e polimorfismo.
 */
public class App {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos da linha de comando (não utilizados)
     * @throws Exception em caso de erro inesperado
     */
    public static void main(String[] args) throws Exception {

        Endereco endAna = new Endereco("Rua das Flores", "123", "Centro", "São Paulo", "SP", "01000-000");
        PessoaFisica cliente1 = new PessoaFisica("Ana", "123.123.123-00", "(11) 91234-5678", "ana@email.com", endAna);

        Endereco endCarlos = new Endereco("Av. Brasil", "456", "Jardim", "Campinas", "SP", "13000-000");
        PessoaFisica cliente2 = new PessoaFisica("Carlos", "172.172.172-00", "(19) 98765-4321", "carlos@email.com", endCarlos);

        Conta c1 = new ContaCorrente(987, cliente1, 0.0);
        c1.deposita(200.0);
        c1.deposita(150.0);

        Conta c2 = new ContaPoupanca(990, cliente2, 0.0);
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

        Funcionario f1 = new Funcionario("Pedro Augusto", "123.456.789-00", 3000.0);
        Gerente g1 = new Gerente("Ana Silva", "987.654.321-00", 5000.0, "Agência Centro");
        System.out.println("Bônus do gerente: " + g1.getBonificacao());
        System.out.println("Bônus do funcionário: " + f1.getBonificacao());


        ControleBonificacoes controle = new ControleBonificacoes();
        controle.registra(f1);
        controle.registra(g1);
        System.out.println("Total de bonificações: " + controle.getTotal());

        System.out.println("-----------------------------------------------------------------------------------------\n\n");

        System.out.println("Cadastro e exibição de funcionários:\n");

        TecnicoBancario tb1 = new TecnicoBancario("Lucas Mendes", "111.222.333-44", 2500.0, "Atendimento ao Cliente", 10);
        Diretor d1 = new Diretor("Marcia Oliveira", "555.666.777-88", 12000.0, 0.35, "Operações");

        System.out.println("--- Funcionário ---");
        System.out.println("Nome: " + f1.getNome() + " | CPF: " + f1.getCpf());
        System.out.println("Salário base: R$ " + f1.getSalario() + " | Bônus: R$ " + f1.getBonificacao() + " | Salário final: R$ " + f1.getSalarioFinal());

        System.out.println("\n--- Gerente ---");
        System.out.println("Nome: " + g1.getNome() + " | CPF: " + g1.getCpf());
        System.out.println("Agência: " + g1.getAgencia());
        System.out.println("Salário base: R$ " + g1.getSalario() + " | Bônus (20%): R$ " + g1.getBonificacao() + " | Salário final: R$ " + g1.getSalarioFinal());

        System.out.println("\n--- Técnico Bancário ---");
        System.out.println("Nome: " + tb1.getNome() + " | CPF: " + tb1.getCpf());
        System.out.println("Setor: " + tb1.getSetorAtendimento() + " | Horas extras: " + tb1.getQuantidadeHorasExtras());
        System.out.println("Salário base: R$ " + tb1.getSalario() + " | Bônus (horas extras): R$ " + tb1.getBonificacao() + " | Salário final: R$ " + tb1.getSalarioFinal());

        System.out.println("\n--- Diretor ---");
        System.out.println("Nome: " + d1.getNome() + " | CPF: " + d1.getCpf());
        System.out.println("Área: " + d1.getAreaResponsavel() + " | Participação nos lucros: " + (d1.getParticipacaoLucros() * 100) + "%");
        System.out.println("Salário base: R$ " + d1.getSalario() + " | Bônus (35%): R$ " + d1.getBonificacao() + " | Salário final: R$ " + d1.getSalarioFinal());

        System.out.println("-----------------------------------------------------------------------------------------\n\n");

        System.out.println("Atividade Polimorfismo\n");

        Conta cc = new ContaCorrente(1, cliente1, 1000.0);
        Conta cp = new ContaPoupanca(2, cliente2, 1000.0);

        AtualizadorConta atualizador = new AtualizadorConta();
        atualizador.atualizarConta(cc, 0.01); // ContaCorrente vai aplicar 2%
        atualizador.atualizarConta(cp, 0.01); // ContaPoupanca vai aplicar 3%

        System.out.println("Total atualizado: " + atualizador.getTotalAtualizado());

        System.out.println("-----------------------------------------------------------------------------------------\n\n");

        System.out.println("Cadastro e exibição de clientes:\n");

        Endereco endEmpresa = new Endereco("Rua do Comércio", "789", "Industrial", "São Paulo", "SP", "02000-000");
        PessoaJuridica pj1 = new PessoaJuridica("Tech Solutions Ltda", "12.345.678/0001-99", "(11) 3456-7890", "contato@techsolutions.com.br", endEmpresa);

        System.out.println("--- Cliente Pessoa Física ---");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("Telefone: " + cliente1.getTelefone() + " | E-mail: " + cliente1.getEmail());
        System.out.println("Endereço: " + cliente1.getEndereco().getRua() + ", " + cliente1.getEndereco().getNumero() + " - " + cliente1.getEndereco().getBairro() + ", " + cliente1.getEndereco().getCidade() + "/" + cliente1.getEndereco().getEstado() + " - CEP: " + cliente1.getEndereco().getCep());

        System.out.println("\n--- Cliente Pessoa Jurídica ---");
        System.out.println("Razão Social: " + pj1.getRazaoSocial());
        System.out.println("CNPJ: " + pj1.getCnpj());
        System.out.println("Telefone: " + pj1.getTelefone() + " | E-mail: " + pj1.getEmail());
        System.out.println("Endereço: " + pj1.getEndereco().getRua() + ", " + pj1.getEndereco().getNumero() + " - " + pj1.getEndereco().getBairro() + ", " + pj1.getEndereco().getCidade() + "/" + pj1.getEndereco().getEstado() + " - CEP: " + pj1.getEndereco().getCep());

    }

}
