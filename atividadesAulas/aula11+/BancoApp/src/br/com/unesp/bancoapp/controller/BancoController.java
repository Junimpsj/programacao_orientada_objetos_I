package br.com.unesp.bancoapp.controller;

import br.com.unesp.bancoapp.modelo.Banco;
import br.com.unesp.bancoapp.modelo.Cliente;
import br.com.unesp.bancoapp.modelo.Funcionario;
import java.util.ArrayList;

/**
 * Controlador central do sistema bancário.
 * Ponto único de acesso para operações sobre funcionários e clientes.
 * Mantém uma instância de {@link Banco} compartilhada entre todas as telas.
 */
public class BancoController {

    private Banco banco;

    /**
     * @param nomeBanco nome do banco
     */
    public BancoController(String nomeBanco) {
        this.banco = new Banco(nomeBanco);
    }

    /**
     * Cadastra um funcionário no banco.
     *
     * @param f funcionário a cadastrar
     */
    public void cadastrarFuncionario(Funcionario f) {
        banco.adicionarFuncionario(f);
    }

    /**
     * @return lista de todos os funcionários cadastrados
     */
    public ArrayList<Funcionario> listarFuncionarios() {
        return banco.getFuncionarios();
    }

    /**
     * Cadastra um cliente no banco.
     *
     * @param c cliente a cadastrar
     */
    public void cadastrarCliente(Cliente c) {
        banco.adicionarCliente(c);
    }

    /**
     * @return lista de todos os clientes cadastrados
     */
    public ArrayList<Cliente> listarClientes() {
        return banco.getClientes();
    }

}
