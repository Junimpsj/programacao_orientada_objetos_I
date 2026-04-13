package trabalhoPraticoAgenda.src.br.com.unesp.agendapp.modelo;

public class Data {

    private int dia;
    private int mes;
    private int ano;
    
    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void exibirData() {

        System.out.printf("%02d/%02d/%04d", this.dia, this.mes, this.ano);

    }

    private boolean isAnoBissexto (int ano) {

        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

    }

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