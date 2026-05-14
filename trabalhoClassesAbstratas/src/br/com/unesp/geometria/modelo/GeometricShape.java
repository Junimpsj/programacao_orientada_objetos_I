package br.com.unesp.geometria.modelo;

/**
 * Classe abstrata que representa uma forma geométrica.
 * <p>
 * Subclasses devem implementar o cálculo de área e perímetro
 * de acordo com a forma específica.
 */
public abstract class GeometricShape {

    /**
     * Calcula e retorna a área da forma geométrica.
     *
     * @return área da forma em unidades quadradas
     */
    public abstract double area();

    /**
     * Calcula e retorna o perímetro da forma geométrica.
     *
     * @return perímetro da forma em unidades lineares
     */
    public abstract double perimeter();

}
