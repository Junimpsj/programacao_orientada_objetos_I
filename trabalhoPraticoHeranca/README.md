# Trabalho Prático: Herança

Dois exercícios de herança em Java: sistema de biblioteca e sistema universitário (FCT).

## Estrutura

```
trabalhoPraticoHeranca/
├── src/br/com/unesp/
│   ├── bibliotecaapp/
│   │   ├── aplicacao/App.java
│   │   └── modelo/           Biblioteca, Livro, LivroDigital (herda Livro), Usuario
│   └── fctapp/
│       ├── aplicacao/App.java
│       └── modelo/           Universidade, Departamento, Funcionario, Docente (herda Funcionario)
├── docsBibliotecaApp/         javadoc gerado (biblioteca)
└── docsFctApp/                javadoc gerado (FCT)
```

## Como executar

```bash
cd src
javac br/com/unesp/bibliotecaapp/aplicacao/App.java
java br.com.unesp.bibliotecaapp.aplicacao.App

javac br/com/unesp/fctapp/aplicacao/App.java
java br.com.unesp.fctapp.aplicacao.App
```

## Requisitos

- JDK 8+
