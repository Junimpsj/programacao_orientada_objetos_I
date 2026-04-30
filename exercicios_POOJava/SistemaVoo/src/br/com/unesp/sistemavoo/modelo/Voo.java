package br.com.unesp.sistemavoo.modelo;

/**
 * Classe que representa um Voo da companhia aérea.
 * Gerencia os 10 assentos do voo, sendo 5 de primeira classe (1-5) e 5 econômicos (6-10).
 */
public class Voo {

    /** Código identificador do voo */
    private String codigoVoo;

    /** Array de ocupação dos assentos: false = disponível, true = ocupado */
    private boolean[] assentos;

    /** Capacidade total do voo */
    private int capacidade;

    /**
     * Construtor que inicializa um novo Voo com seu código.
     * Todos os 10 assentos começam disponíveis.
     *
     * @param codigoVoo Código identificador do voo
     */
    public Voo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
        this.capacidade = 10;
        this.assentos = new boolean[this.capacidade + 1];

        for(int i = 1; i <= this.capacidade; i++) {
            this.assentos[i] = false;
        }
    }

    /**
     * Obtém o código do voo.
     *
     * @return Código do voo
     */
    public String getCodigoVoo() {
        return codigoVoo;
    }

    /**
     * Obtém a capacidade total do voo.
     *
     * @return Capacidade total do voo
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Verifica se um assento específico está disponível.
     *
     * @param poltrona Número da poltrona a ser verificada (1-10)
     * @return {@code true} se o assento está disponível, {@code false} se está ocupado
     */
    public boolean assentoDisponivel(int poltrona) {
        if(!this.assentos[poltrona]) {
            return true;
        } if(this.assentos[poltrona]) {
            return false;
        }
        return false;
    }

    /**
     * Verifica se há algum assento disponível na primeira classe (poltronas 1-5).
     *
     * @return {@code true} se há assentos disponíveis na primeira classe, {@code false} caso contrário
     */
    public boolean temPrimeiraClasseDisponivel() {
        for(int i = 1; i <= 5; i++) {
            if(!this.assentos[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se há algum assento disponível na classe econômica (poltronas 6-10).
     *
     * @return {@code true} se há assentos disponíveis na classe econômica, {@code false} caso contrário
     */
    public boolean temEconomicaDisponivel() {
        for(int i = 6; i <= 10; i++) {
            if(!this.assentos[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reserva o primeiro assento disponível na primeira classe (poltronas 1-5).
     *
     * @return Número da poltrona reservada, ou -1 se não houver assentos disponíveis
     */
    public int reservarPrimeiraClasse() {
        for(int i = 1; i <= 5; i++) {
            if(!this.assentos[i]) {
                this.assentos[i] = true;
                return i;
            }
        }
        return -1;
    }

    /**
     * Reserva o primeiro assento disponível na classe econômica (poltronas 6-10).
     *
     * @return Número da poltrona reservada, ou -1 se não houver assentos disponíveis
     */
    public int reservarEconomica() {
        for(int i = 6; i <= 10; i++) {
            if(!this.assentos[i]) {
                this.assentos[i] = true;
                return i;
            }
        }
        return -1;
    }

    /**
     * Libera um assento previamente ocupado.
     *
     * @param poltrona Número da poltrona a ser liberada (1-10)
     */
    public void liberarAssento(int poltrona) {
        this.assentos[poltrona] = false;
    }

    /**
     * Conta os assentos ocupados e disponíveis na primeira classe.
     *
     * @return Array onde [0] = ocupados e [1] = disponíveis
     */
    public int[] statusPrimeiraClasse() {
        int ocupados = 0;
        int disponiveis = 0;

        for(int i = 1; i <= 5; i++) {
            if(this.assentos[i]) {
                ocupados = ocupados + 1;
            } if(!this.assentos[i]) {
                disponiveis = disponiveis + 1;
            }
        }

        int[] status = {ocupados, disponiveis};
        return status;
    }

    /**
     * Conta os assentos ocupados e disponíveis na classe econômica.
     *
     * @return Array onde [0] = ocupados e [1] = disponíveis
     */
    public int[] statusEconomica() {
        int ocupados = 0;
        int disponiveis = 0;

        for(int i = 6; i <= 10; i++) {
            if(this.assentos[i]) {
                ocupados = ocupados + 1;
            } if(!this.assentos[i]) {
                disponiveis = disponiveis + 1;
            }
        }

        int[] status = {ocupados, disponiveis};
        return status;
    }

    /**
     * Exibe o mapa de assentos do voo no console.
     */
    public void exibirAssentos() {
        System.out.println("--- Mapa de Assentos do Voo " + this.codigoVoo + " ---");
        System.out.println("Primeira Classe (1-5):");

        for(int i = 1; i <= 5; i++) {
            System.out.print("  Poltrona " + i + ": ");
            if(!this.assentos[i]) {
                System.out.println("Disponível");
            } if(this.assentos[i]) {
                System.out.println("Ocupado");
            }
        }

        System.out.println("Classe Econômica (6-10):");

        for(int i = 6; i <= 10; i++) {
            System.out.print("  Poltrona " + i + ": ");
            if(!this.assentos[i]) {
                System.out.println("Disponível");
            } if(this.assentos[i]) {
                System.out.println("Ocupado");
            }
        }
    }

}
