package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo;

/**
 * Representa uma data composta por dia, mês e ano.
 * Oferece operações de comparação, cálculo de diferença e adição de dias.
 */
public class Data {

    private int dia;
    private int mes;
    private int ano;

    /**
     * Construtor padrão. Cria uma data sem valores definidos.
     */
    public Data() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param dia dia da data
     * @param mes mês da data
     * @param ano ano da data
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Retorna o dia.
     *
     * @return dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Define o dia.
     *
     * @param dia novo valor do dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Retorna o mês.
     *
     * @return mês
     */
    public int getMes() {
        return mes;
    }

    /**
     * Define o mês.
     *
     * @param mes novo valor do mês
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Retorna o ano.
     *
     * @return ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o ano.
     *
     * @param ano novo valor do ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Exibe a data no formato dd/mm/aaaa no console.
     */
    public void exibirData() {

        System.out.printf("%02d/%02d/%04d", this.dia, this.mes, this.ano);

    }

    /**
     * Verifica se o ano informado é bissexto.
     *
     * @param ano ano a ser verificado
     * @return true se for bissexto, false caso contrário
     */
    private boolean isAnoBissexto(int ano) {

        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

    }

    /**
     * Retorna a quantidade de dias de um determinado mês e ano.
     *
     * @param mes mês (1 a 12)
     * @param ano ano (necessário para verificar ano bissexto em fevereiro)
     * @return número de dias do mês
     */
    private int getDiasDoMes(int mes, int ano) {

        switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31; //janeiro, março, maio, julho, agosto, outubro, dezembro
        case 4: case 6: case 9: case 11:
            return 30; //abril, junho, setembro, novembro
        case 2:
            return isAnoBissexto(ano) ? 29 : 28; //fevereiro
        default:
            return 0;
    }

    }

    /**
     * Compara esta data com outra.
     *
     * @param outra data a ser comparada
     * @return 1 se esta data for maior, -1 se for menor, 0 se forem iguais
     */
    public int compararCom(Data outra) {

        if (this.ano != outra.getAno()) {
            return this.ano > outra.getAno() ? 1 : -1;
        }

        if (this.mes != outra.getMes()) {
            return this.mes > outra.getMes() ? 1 : -1;
        }

        if (this.dia != outra.getDia()) {
            return this.dia > outra.getDia() ? 1 : -1;
        }

        return 0;

    }

    /**
     * Converte a data para o total de dias desde o ano 1 do calendário gregoriano.
     * Usado internamente para calcular a diferença entre datas.
     *
     * @return total de dias
     */
    private int totalDias() {

        int a = this.ano - 1;
        int total = a * 365 + a / 4 - a / 100 + a / 400;

        for (int m = 1; m < this.mes; m++) {
            total += getDiasDoMes(m, this.ano);
        }

        total += this.dia;
        return total;

    }

    /**
     * Calcula a diferença em dias entre esta data e outra.
     *
     * @param outra data a ser comparada
     * @return número de dias de diferença (sempre positivo)
     */
    public int diferencaDias(Data outra) {

        return Math.abs(this.totalDias() - outra.totalDias());

    }

    /**
     * Adiciona um número de dias a esta data e retorna o resultado como nova instância.
     *
     * @param dias quantidade de dias a adicionar
     * @return novo objeto {@code Data} com a data resultante
     */
    public Data adicionarDias(int dias) {

        int novoDia = this.dia;
        int novoMes = this.mes;
        int novoAno = this.ano;

        novoDia += dias;

        while(novoDia > getDiasDoMes(novoMes, novoAno)) {

            novoDia -= getDiasDoMes(novoMes, novoAno);
            novoMes++;

            if(novoMes > 12) {
                novoMes = 1;
                novoAno++;
            }

        }

        return new Data(novoDia, novoMes, novoAno);

    }

}
