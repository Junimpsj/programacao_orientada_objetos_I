package br.com.unesp.bancoapp.modelo;

/**
 * Classe abstrata que representa um cliente do banco.
 * Pode ser pessoa física ({@link PessoaFisica}) ou jurídica ({@link PessoaJuridica}).
 */
public abstract class Cliente {

    protected String telefone;
    protected String email;
    protected Endereco endereco;

    /**
     * @param telefone telefone de contato do cliente
     * @param email    e-mail do cliente
     * @param endereco endereço do cliente
     */
    public Cliente(String telefone, String email, Endereco endereco) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    /**
     * @param telefone novo telefone de contato
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @param email novo e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param endereco novo endereço
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /** @return telefone de contato */
    public String getTelefone() {
        return telefone;
    }

    /** @return e-mail */
    public String getEmail() {
        return email;
    }

    /** @return endereço */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Retorna o nome de exibição do cliente.
     * Para PF retorna o nome; para PJ retorna a razão social.
     *
     * @return nome do cliente
     */
    public abstract String getNome();

}
