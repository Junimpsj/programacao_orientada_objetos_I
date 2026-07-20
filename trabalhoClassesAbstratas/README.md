# Trabalho: Classes Abstratas

Dois exercícios de classes abstratas em Java: cartões comemorativos e formas geométricas.

## Estrutura

```
trabalhoClassesAbstratas/
├── src/br/com/unesp/
│   ├── cartao/
│   │   ├── aplicacao/MainCartao.java
│   │   └── modelo/           Aniversario, CartaoWeb (abstrata), DiaDosNamorados, Natal
│   └── geometria/
│       ├── aplicacao/MainGeometria.java
│       └── modelo/           GeometricShape (abstrata), Square, Triangle
└── docs/                     javadoc gerado
```

## Como executar

```bash
cd src
javac br/com/unesp/cartao/aplicacao/MainCartao.java
java br.com.unesp.cartao.aplicacao.MainCartao

javac br/com/unesp/geometria/aplicacao/MainGeometria.java
java br.com.unesp.geometria.aplicacao.MainGeometria
```

## Requisitos

- JDK 8+
