package br.com.unesp.bancoapp.controller;

import br.com.unesp.bancoapp.modelo.Diretor;
import br.com.unesp.bancoapp.modelo.Funcionario;
import br.com.unesp.bancoapp.modelo.Gerente;
import br.com.unesp.bancoapp.modelo.TecnicoBancario;
import br.com.unesp.bancoapp.view.FuncionarioView;
import javax.swing.JOptionPane;

/**
 * Controlador da tela de cadastro de funcionários.
 * Lê os dados da view, cria o funcionário do tipo selecionado e
 * delega o armazenamento ao {@link BancoController}.
 */
public class FuncionarioController {

    private FuncionarioView view;
    private BancoController bancoController;

    /**
     * @param view            tela de cadastro de funcionários
     * @param bancoController controlador central do banco
     */
    public FuncionarioController(FuncionarioView view, BancoController bancoController) {
        this.view = view;
        this.bancoController = bancoController;
    }

    /**
     * Lê os dados da view, valida, cria o funcionário do tipo correto
     * e o cadastra no banco. Exibe mensagens de erro para campos inválidos.
     */
    public void salvar() {
        String nome = view.getNome();
        String cpf  = view.getCpf();
        String tipo = view.getTipo();

        if(nome.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                "Nome e CPF são obrigatórios.",
                "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double salario;
        try {
            salario = Double.parseDouble(view.getSalario().replace(",", "."));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(view,
                "Salário inválido.",
                "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Funcionario f;
        try {
            if(tipo.equals("Gerente")) {
                String agencia = view.getAgencia();
                if(agencia.isEmpty()) {
                    JOptionPane.showMessageDialog(view,
                        "Informe a agência do gerente.",
                        "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                f = new Gerente(nome, cpf, salario, agencia);

            } else if(tipo.equals("Técnico Bancário")) {
                String setor = view.getSetor();
                if(setor.isEmpty()) {
                    JOptionPane.showMessageDialog(view,
                        "Informe o setor de atendimento.",
                        "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int horas = Integer.parseInt(view.getHorasExtras());
                f = new TecnicoBancario(nome, cpf, salario, setor, horas);

            } else {
                // Diretor
                String area = view.getArea();
                if(area.isEmpty()) {
                    JOptionPane.showMessageDialog(view,
                        "Informe a área responsável do diretor.",
                        "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double participacao = Double.parseDouble(view.getParticipacao().replace(",", ".")) / 100.0;
                f = new Diretor(nome, cpf, salario, participacao, area);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(view,
                "Valor numérico inválido (horas extras ou participação nos lucros).",
                "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        bancoController.cadastrarFuncionario(f);
        carregarTabela();
        view.limpar();
        JOptionPane.showMessageDialog(view, "Funcionário cadastrado com sucesso!");
    }

    /**
     * Atualiza a tabela da view com todos os funcionários cadastrados no banco.
     */
    public void carregarTabela() {
        view.atualizarTabela(bancoController.listarFuncionarios());
    }

}
