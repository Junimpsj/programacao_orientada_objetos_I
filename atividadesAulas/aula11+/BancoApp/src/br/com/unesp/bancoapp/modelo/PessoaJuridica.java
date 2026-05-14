package br.com.unesp.bancoapp.modelo;

/**
 * Cliente pessoa jurídica, identificada por razão social e CNPJ.
 */
public class PessoaJuridica extends Cliente {

    private String razaoSocial;
    private String cnpj;

    /**
     * @param razaoSocial razão social da empresa
     * @param cnpj        CNPJ no formato "00.000.000/0000-00"
     * @param telefone    telefone de contato
     * @param email       e-mail corporativo
     * @param endereco    endereço da sede
     */
    public PessoaJuridica(String razaoSocial, String cnpj, String telefone, String email, Endereco endereco) {
        super(telefone, email, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    /**
     * @param razaoSocial nova razão social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @param cnpj novo CNPJ
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /** @return razão social */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /** @return CNPJ */
    public String getCnpj() {
        return cnpj;
    }

    /** @return razão social (usado como nome de exibição) */
    @Override
    public String getNome() {
        return razaoSocial;
    }

}
