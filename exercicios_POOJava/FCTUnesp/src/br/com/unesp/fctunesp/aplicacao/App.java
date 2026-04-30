package br.com.unesp.fctunesp.aplicacao;

import br.com.unesp.fctunesp.modelo.Departamento;
import br.com.unesp.fctunesp.modelo.Docente;
import br.com.unesp.fctunesp.modelo.Funcionario;
import br.com.unesp.fctunesp.modelo.Universidade;

/**
 * Classe principal que executa a aplicação de gerenciamento da FCT/Unesp.
 * Demonstra o uso das classes Universidade, Departamento, Funcionario e Docente
 * realizando operações de inclusão, remoção e consulta de dados.
 */
public class App {

    /**
     * Método principal que executa o programa.
     * Cria uma universidade com departamentos e funcionários,
     * realiza operações de inclusão, remoção e consulta de dados.
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Universidade unesp = new Universidade("FCT/Unesp");

        // Criação dos departamentos
        Departamento depInformatica = new Departamento(1, "Departamento de Computação", "(18) 3229-5676");
        Departamento depMatematica = new Departamento(2, "Departamento de Matemática", "(18) 3229-5600");
        Departamento depFisica = new Departamento(3, "Departamento de Física", "(18) 3229-5610");

        // Adicionando departamentos à universidade
        unesp.adicionarDepartamento(depInformatica);
        unesp.adicionarDepartamento(depMatematica);
        unesp.adicionarDepartamento(depFisica);

        System.out.println();

        // Criação dos funcionários
        Funcionario func1 = new Funcionario(101, "John Doe da Silva", 3500.00);
        Docente doc1 = new Docente(201, "Alan Turing Souza", 8500.00, "Professor Titular");
        Docente doc2 = new Docente(202, "Ada Lovelace Santos", 7800.00, "Professor Associado");
        Docente doc3 = new Docente(203, "Linus Torvalds Pereira", 9200.00, "Professor Titular");
        Docente doc4 = new Docente(204, "Grace Hopper Lima", 8100.00, "Professor Adjunto");

        // Adicionando funcionários nos departamentos
        depInformatica.adicionarFuncionario(func1);
        depInformatica.adicionarFuncionario(doc1);
        depInformatica.adicionarFuncionario(doc2);
        depMatematica.adicionarFuncionario(doc3);
        depFisica.adicionarFuncionario(doc4);

        System.out.println();

        // Listando departamentos da universidade
        unesp.listarDepartamentos();

        System.out.println();

        // Listando funcionários dos departamentos
        depInformatica.listarFuncionarios();
        System.out.println();
        depMatematica.listarFuncionarios();
        System.out.println();
        depFisica.listarFuncionarios();

        System.out.println();

        // Consultando um funcionário específico
        System.out.println("--- Consulta de Funcionário (código 202) ---");
        depInformatica.consultarFuncionario(202);

        System.out.println();

        // Removendo um funcionário
        System.out.println("--- Remoção de Funcionário ---");
        depInformatica.removerFuncionario(101);

        System.out.println();

        // Listando após remoção para confirmar
        depInformatica.listarFuncionarios();

        System.out.println();

        // Removendo um departamento
        System.out.println("--- Remoção de Departamento ---");
        unesp.removerDepartamento(3);

        System.out.println();

        // Listando departamentos após remoção
        unesp.listarDepartamentos();

        System.out.println();

        // Consultando um departamento
        System.out.println("--- Consulta de Departamento (código 1) ---");
        unesp.consultarDepartamento(1);

    }

}
