package br.com.unesp.bancoapp.modelo;

/**
 * Cliente pessoa física, identificado por nome e CPF.
 */
public class PessoaFisica extends Cliente {

    private String nome;
    private String cpf;

    /**
     * @param nome     nome completo
     * @param cpf      CPF no formato "000.000.000-00"
     * @param telefone telefone de contato
     * @param email    e-mail
     * @param endereco endereço residencial
     */
    public PessoaFisica(String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(telefone, email, endereco);
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * @param nome novo nome completo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf novo CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** @return CPF */
    public String getCpf() {
        return cpf;
    }

    /** @return nome completo da pessoa física */
    @Override
    public String getNome() {
        return nome;
    }

}
