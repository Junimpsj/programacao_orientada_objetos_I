package br.com.unesp.bancoapp.controller;

import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.Endereco;
import br.com.unesp.bancoapp.modelo.PessoaFisica;
import br.com.unesp.bancoapp.modelo.PessoaJuridica;
import br.com.unesp.bancoapp.view.ClienteView;
import javax.swing.JOptionPane;

/**
 * Controlador da tela de cadastro de clientes.
 * Lê os dados da view, cria o cliente do tipo selecionado (PF ou PJ)
 * e delega o armazenamento ao {@link BancoController}.
 */
public class ClienteController {

    private ClienteView view;
    private BancoController bancoController;

    /**
     * @param view            tela de cadastro de clientes
     * @param bancoController controlador central do banco
     */
    public ClienteController(ClienteView view, BancoController bancoController) {
        this.view = view;
        this.bancoController = bancoController;
    }

    /**
     * Lê os dados da view, valida, cria o cliente (PF ou PJ) e o cadastra no banco.
     * Exibe mensagens de erro para campos obrigatórios em branco.
     */
    public void salvar() {
        String tipo        = view.getTipo();
        String nomeOuRazao = view.getNomeOuRazao();
        String cpfOuCnpj   = view.getCpfOuCnpj();
        String telefone    = view.getTelefone();
        String email       = view.getEmail();

        if(nomeOuRazao.isEmpty() || cpfOuCnpj.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                "Nome/Razão Social, CPF/CNPJ e E-mail são obrigatórios.",
                "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Endereco endereco = new Endereco(
            view.getRua(), view.getNumero(), view.getBairro(),
            view.getCidade(), view.getEstado(), view.getCep()
        );

        Cliente c;
        if(tipo.equals("Pessoa Física")) {
            c = new PessoaFisica(nomeOuRazao, cpfOuCnpj, telefone, email, endereco);
        } else {
            c = new PessoaJuridica(nomeOuRazao, cpfOuCnpj, telefone, email, endereco);
        }

        bancoController.cadastrarCliente(c);
        carregarTabela();
        view.limpar();
        JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso!");
    }

    /**
     * Atualiza a tabela da view com todos os clientes cadastrados no banco.
     */
    public void carregarTabela() {
        view.atualizarTabela(bancoController.listarClientes());
    }

}
