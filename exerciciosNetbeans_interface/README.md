# Exercícios de Interface no NetBeans

Três atividades de interface gráfica desenvolvidas no NetBeans, seguindo o padrão MVC (model/view/controller).

## Estrutura

```
exerciciosNetbeans_interface/
├── atividade1-loja/         Produto, LojaController, LojaView
├── atividade2-cadastro/      Cadastro, CadastroController, CadastroView
└── atividade3-calculadora/   CalculadoraController, CalculadoraView
```

Cada atividade segue `src/app/Main.java`, `src/controller/`, `src/model/` (quando aplicável) e `src/view/`.

## Como executar

Abra o projeto no NetBeans, ou compile manualmente:

```bash
cd <atividade>/src
javac app/Main.java
java app.Main
```

## Requisitos

- JDK 8+
- NetBeans IDE (opcional, os `.java` são independentes da IDE)
