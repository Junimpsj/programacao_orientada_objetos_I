# Exercícios de POO em Java

Seis mini-projetos independentes de fixação de POO, cada um modelando um domínio diferente.

## Estrutura

```
exercicios_POOJava/
├── Academia/       AlunoAcademia
├── AlunosFCT/       Aluno
├── Biblioteca/       Livro, LivroDigital, Usuario
├── FCTUnesp/          Universidade, Departamento, Funcionario, Docente
├── Restaurante/       Item, Mesa, Pedido
└── SistemaVoo/        SistemaReserva, CartaoEmbarque, Passageiro, Reserva, Voo
```

Cada pasta segue o mesmo padrão: `src/br/com/unesp/<dominio>/aplicacao/App.java` como ponto de entrada e `src/br/com/unesp/<dominio>/modelo/` com as classes de domínio.

## Como executar

```bash
cd <Projeto>/src
javac br/com/unesp/<dominio>/aplicacao/App.java
java br.com.unesp.<dominio>.aplicacao.App
```

## Requisitos

- JDK 8+
