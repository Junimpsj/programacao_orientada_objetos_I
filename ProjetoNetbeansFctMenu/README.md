# Projeto NetBeans: Menu FCT

Sistema com menu e telas Swing pra gerenciar departamentos, docentes e funcionários da FCT, em Maven.

## Sobre

Segue o padrão MVC: `model/` com as entidades, `controller/` com a lógica de negócio, `view/` com as telas Swing (`.java` + `.form` gerados pelo NetBeans).

## Estrutura

```
ProjetoNetbeansFctMenu/
├── pom.xml
└── src/main/java/br/com/unesp/projetonetbeans/
    ├── app/App.java              ponto de entrada
    ├── model/                     Departamento, Docente, Funcionario, Universidade
    ├── controller/                 DepartamentoController, FuncionarioController, UniversidadeController
    └── view/                       Principal, DepartamentoView, FuncionarioView, ListaDepartamentosView, ListaFuncionariosView
```

## Como executar

```bash
mvn compile exec:java
```

## Requisitos

- JDK 25 (definido no `pom.xml`)
- Maven
