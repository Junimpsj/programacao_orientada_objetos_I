package br.com.unesp.geometria.modelo;

/**
 * Representa um triângulo definido pelos comprimentos de seus três lados.
 */
public class Triangle extends GeometricShape {

    /** Primeiro lado do triângulo. */
    private double lado1;
    /** Segundo lado do triângulo. */
    private double lado2;
    /** Terceiro lado do triângulo. */
    private double lado3;

    /** Construtor padrão. */
    public Triangle() {}

    /**
     * Cria triângulo com os três lados informados.
     *
     * @param lado1 primeiro lado
     * @param lado2 segundo lado
     * @param lado3 terceiro lado
     */
    public Triangle(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    /** @return primeiro lado */
    public double getLado1() {
        return lado1;

    }

    /** @param lado1 novo valor do primeiro lado */
    public void setLado1(double lado1)
    { this.lado1 = lado1;

    }

    /** @return segundo lado */
    public double getLado2() {
        return lado2;
    }

    /** @param lado2 novo valor do segundo lado */
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    /** @return terceiro lado */
    public double getLado3() {
        return lado3;
    }

    /** @param lado3 novo valor do terceiro lado */
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    /**
     * Calcula área pela fórmula de Heron: √(s·(s−a)·(s−b)·(s−c)),
     * onde s é o semiperímetro.
     *
     * @return área do triângulo
     */
    @Override
    public double area() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    /**
     * Perímetro = soma dos três lados.
     *
     * @return perímetro do triângulo
     */
    @Override
    public double perimeter() {
        return lado1 + lado2 + lado3;
    }

}
