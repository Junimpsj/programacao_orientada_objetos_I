package br.com.unesp.geometria.aplicacao;

import br.com.unesp.geometria.modelo.GeometricShape;
import br.com.unesp.geometria.modelo.Square;
import br.com.unesp.geometria.modelo.Triangle;

/**
 * Classe de entrada do exercício de geometria.
 * <p>
 * Demonstra o uso do polimorfismo com {@link GeometricShape},
 * instanciando um quadrado e um triângulo e exibindo área e perímetro.
 */
public class MainGeometria {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        GeometricShape square = new Square(5);

        System.out.println("--- Square ---");
        System.out.printf("Area:      %.2f%n", square.area());
        System.out.printf("Perimeter: %.2f%n", square.perimeter());

        GeometricShape triangle = new Triangle(3, 4, 5);
        System.out.println("\n--- Triangle ---");
        System.out.printf("Area:      %.2f%n", triangle.area());
        System.out.printf("Perimeter: %.2f%n", triangle.perimeter());
    }

}
