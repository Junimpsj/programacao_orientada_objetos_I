# Programação Orientada a Objetos I

Repositório da disciplina Programação Orientada a Objetos I, em Java.

## Sobre o projeto

Reúne exercícios de aula, trabalhos avaliativos, exemplos de GUI com Swing e um projeto Maven, cobrindo do básico da linguagem até herança, classes abstratas e interfaces gráficas.

## Conteúdo

- [`trabalho01_introJava/`](trabalho01_introJava/README.md): trabalho 1, introdução à linguagem
- [`trabalho02_conceitosJava/`](trabalho02_conceitosJava/README.md): trabalho 2, conceitos básicos
- [`trabalho03_colecoesAndMatrizes/`](trabalho03_colecoesAndMatrizes/README.md): trabalho 3, coleções e matrizes
- [`trabalho04_arquivosJava/`](trabalho04_arquivosJava/README.md): trabalho 4, manipulação de arquivos
- [`trabalhoClassesAbstratas/`](trabalhoClassesAbstratas/README.md): classes abstratas (cartões e formas geométricas)
- [`trabalhoPraticoHeranca/`](trabalhoPraticoHeranca/README.md): herança (Biblioteca e FCT)
- [`trabalhoPraticoAgenda/`](trabalhoPraticoAgenda/README.md): agenda de compromissos
- [`exercicios_POOJava/`](exercicios_POOJava/README.md): exercícios avulsos de POO (Academia, Biblioteca, SistemaVoo, etc.)
- [`exemplosGUIswing/`](exemplosGUIswing/README.md): exemplos de interface gráfica com Swing
- [`exerciciosNetbeans_interface/`](exerciciosNetbeans_interface/README.md): exercícios de interface feitos no NetBeans
- [`ProjetoNetbeansFctMenu/`](ProjetoNetbeansFctMenu/README.md): projeto Maven, menu FCT
- [`arquitetura_projetos_2bim/`](arquitetura_projetos_2bim/README.md): documentos de design dos projetos do 2º bimestre
- [`anotaçõesP1.md`](anotaçõesP1.md): anotações de estudo para a prova (modificadores, polimorfismo, coleções)

## Como executar

Ver instruções específicas no README de cada trabalho. Resumo geral:

**Arquivos Java soltos** (trabalhos e exercícios):

```bash
cd <pasta_do_trabalho>
javac NomeDoArquivo.java
java NomeDoArquivo
```

**ProjetoNetbeansFctMenu** (projeto Maven):

```bash
cd ProjetoNetbeansFctMenu
mvn compile exec:java
```

## Requisitos

- JDK 8+
- Maven (só para `ProjetoNetbeansFctMenu/`)
