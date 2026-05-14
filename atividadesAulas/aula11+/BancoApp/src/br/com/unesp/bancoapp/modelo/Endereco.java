package br.com.unesp.bancoapp.modelo;

/**
 * Representa o endereço completo de um cliente.
 */
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    /**
     * Cria um endereço com todos os campos preenchidos.
     *
     * @param rua    nome da rua ou avenida
     * @param numero número do imóvel
     * @param bairro bairro
     * @param cidade cidade
     * @param estado sigla do estado (ex: "SP")
     * @param cep    CEP no formato "00000-000"
     */
    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    /**
     * @param rua nome da rua ou avenida
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @param numero número do imóvel
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @param bairro bairro do endereço
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @param cidade cidade do endereço
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @param estado sigla do estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param cep CEP no formato "00000-000"
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /** @return nome da rua */
    public String getRua() {
        return rua;
    }

    /** @return número do imóvel */
    public String getNumero() {
        return numero;
    }

    /** @return bairro */
    public String getBairro() {
        return bairro;
    }

    /** @return cidade */
    public String getCidade() {
        return cidade;
    }

    /** @return sigla do estado */
    public String getEstado() {
        return estado;
    }

    /** @return CEP */
    public String getCep() {
        return cep;
    }

}
