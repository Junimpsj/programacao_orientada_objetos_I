package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo;

/**
 * Representa um compromisso da agenda, composto por uma descrição e uma data.
 */
public class Compromisso {

    private String descricao;
    private Data data;

    /**
     * Construtor padrão. Cria um compromisso sem valores definidos.
     */
    public Compromisso() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param descricao texto descritivo do compromisso
     * @param data      data associada ao compromisso
     */
    public Compromisso(String descricao, Data data) {
        this.descricao = descricao;
        this.data = data;
    }

    /**
     * Retorna a descrição do compromisso.
     *
     * @return descrição
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do compromisso.
     *
     * @param descricao nova descrição
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a data do compromisso.
     *
     * @return data
     */
    public Data getData() {
        return data;
    }

    /**
     * Define a data do compromisso.
     *
     * @param data nova data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Exibe o compromisso no console no formato: "- descrição | dd/mm/aaaa".
     */
    public void exibir() {

        System.out.print("- " + this.descricao + " | ");
        this.data.exibirData();
        System.out.println();

    }

}
