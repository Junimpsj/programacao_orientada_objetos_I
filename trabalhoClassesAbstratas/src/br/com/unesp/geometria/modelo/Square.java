package br.com.unesp.geometria.modelo;

/**
 * Representa um quadrado, forma geométrica com quatro lados iguais.
 */
public class Square extends GeometricShape {

    /** Medida do lado do quadrado. */
    private double lado;

    /** Construtor padrão. */
    public Square() {}

    /**
     * Cria quadrado com o lado informado.
     *
     * @param lado medida do lado
     */
    public Square(double lado) {
        this.lado = lado;
    }

    /**
     * @return medida do lado
     */
    public double getLado() {
        return lado;
    }

    /**
     * @param lado nova medida do lado
     */
    public void setLado(double lado) {
        this.lado = lado;
    }

    /**
     * Área = lado².
     *
     * @return área do quadrado
     */
    @Override
    public double area() {
        return lado * lado;
    }

    /**
     * Perímetro = lado × 4.
     *
     * @return perímetro do quadrado
     */
    @Override
    public double perimeter() {
        return lado * 4;
    }

}
