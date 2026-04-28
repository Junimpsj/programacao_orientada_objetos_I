package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.util;

import trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo.Data;

/**
 * Utilitário para validação de objetos {@link Data}.
 * Deve ser chamado sempre que uma nova data for criada.
 */
public class ValidaData {

    /**
     * Verifica se uma data é válida, considerando os dias de cada mês e anos bissextos.
     *
     * @param data objeto {@link Data} a ser validado
     * @return true se a data for válida, false caso contrário
     */
    public static boolean validar(Data data) {

        int dia = data.getDia();
        int mes = data.getMes();
        int ano = data.getAno();

        if (ano <= 0) return false;
        if (mes < 1 || mes > 12) return false;
        if (dia < 1) return false;

        return dia <= getDiasDoMes(mes, ano);

    }

    /**
     * Verifica se o ano informado é bissexto.
     *
     * @param ano ano a ser verificado
     * @return true se for bissexto, false caso contrário
     */
    private static boolean isAnoBissexto(int ano) {

        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

    }

    /**
     * Retorna a quantidade de dias de um determinado mês e ano.
     *
     * @param mes mês (1 a 12)
     * @param ano ano (necessário para verificar ano bissexto em fevereiro)
     * @return número de dias do mês
     */
    private static int getDiasDoMes(int mes, int ano) {

        switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            return isAnoBissexto(ano) ? 29 : 28;
        default:
            return 0;
        }

    }

}
