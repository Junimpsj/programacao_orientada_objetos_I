package br.com.unesp.aeroporto.modelo;

import java.util.ArrayList;

public class Voo {

    private ArrayList<Integer> assentos;
    private int capacidade;
    private int codigoVoo;

    public Voo() {
        
    }

    public Voo(int codigoVoo) {
        this.capacidade = 10;
        this.codigoVoo = codigoVoo;
        
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCodigoVoo() {
        return codigoVoo;
    }

    
}
