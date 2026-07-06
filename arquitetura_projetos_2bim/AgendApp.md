# AgendApp — Agenda de Compromissos com Manipulação de Datas

## Nome do Projeto
**AgendApp** — Agenda de linha de comando (console) que permite cadastrar compromissos, calcular datas futuras, filtrar por data e verificar quantos dias faltam para um evento. Implementa manipulação de datas **do zero**, sem usar `LocalDate` ou `Calendar` para os cálculos.

**Localização:** `trabalhoPraticoAgenda/`

---

## Descrição Geral
Aplicação 100% console (sem interface gráfica). O usuário interage por meio de um menu numérico:

```
1 - Calcular data futura       (data + N dias)
2 - Cadastrar compromisso      (descrição + data)
3 - Listar todos os compromissos
4 - Listar compromissos por data
5 - Dias faltando para um compromisso
6 - Comparar duas datas
0 - Sair
```

---

## Modelagem de Entidades

```
Agenda (classe principal com main)
  └── ArrayList<Compromisso>
        └── Compromisso
              ├── String descricao
              └── Data
                    ├── int dia
                    ├── int mes
                    └── int ano

ValidaData (utilitário estático)
```

| Classe | Responsabilidade |
|--------|-----------------|
| `Data` | Representa uma data e implementa toda a lógica de comparação, diferença e adição de dias |
| `Compromisso` | Agrupa uma descrição com uma `Data` |
| `ValidaData` | Valida se uma data é válida (dias do mês, ano bissexto) |
| `Agenda` | Classe principal: menu, Scanner, lista de compromissos |

---

## Arquitetura do Projeto — Estrutura simples por diretórios

```
trabalhoPraticoAgenda/src/br/com/unesp/agendapp/
├── aplicacao/ → Agenda.java          (main, menu, fluxo do programa)
├── modelo/    → Data.java, Compromisso.java
└── util/      → ValidaData.java
```

**Não usa MVC** — é uma aplicação console sem interface, então não há View separada. A `Agenda` concentra toda a interação com o usuário.

---

## Trechos Importantes do Código Explicados

### 1. `Data.java` — Verificação de ano bissexto
```java
private boolean isAnoBissexto(int ano) {
    return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
}
```
Regra do calendário gregoriano:
- Divisível por 4 → bissexto (ex: 2024)
- **Exceto** se divisível por 100 (ex: 1900 **não** é bissexto)
- **Mas** se divisível por 400 → bissexto mesmo assim (ex: 2000 é bissexto)

---

### 2. `Data.java` — Dias de cada mês
```java
private int getDiasDoMes(int mes, int ano) {
    switch (mes) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            return isAnoBissexto(ano) ? 29 : 28;
        default:
            return 0;
    }
}
```
Janeiro, março, maio, julho, agosto, outubro, dezembro = 31 dias.  
Abril, junho, setembro, novembro = 30 dias.  
Fevereiro = 28 ou 29 (se bissexto).

---

### 3. `Data.java` — Comparação de datas
```java
public int compararCom(Data outra) {
    if (this.ano != outra.getAno()) {
        return this.ano > outra.getAno() ? 1 : -1;  // compara anos primeiro
    }
    if (this.mes != outra.getMes()) {
        return this.mes > outra.getMes() ? 1 : -1;  // depois meses
    }
    if (this.dia != outra.getDia()) {
        return this.dia > outra.getDia() ? 1 : -1;  // depois dias
    }
    return 0;  // datas iguais
}
```
Retorna `1` se `this` é mais recente, `-1` se é mais antiga, `0` se iguais. Segue a mesma convenção do `Comparable` do Java.

---

### 4. `Data.java` — `totalDias()` — o algoritmo central
```java
private int totalDias() {
    int a = this.ano - 1;
    // total de dias de todos os anos completos antes do ano atual
    int total = a * 365 + a / 4 - a / 100 + a / 400;

    // soma os dias dos meses anteriores do ano atual
    for (int m = 1; m < this.mes; m++) {
        total += getDiasDoMes(m, this.ano);
    }

    total += this.dia;  // adiciona o dia do mês
    return total;
}
```
Converte a data em **total de dias desde o dia 1 do ano 1 do calendário gregoriano**. A fórmula `a*365 + a/4 - a/100 + a/400` conta corretamente os anos bissextos acumulados.

Isso é usado para calcular diferença entre datas:
```java
public int diferencaDias(Data outra) {
    return Math.abs(this.totalDias() - outra.totalDias());
}
```
Subtrai os totais — `Math.abs` garante resultado sempre positivo.

---

### 5. `Data.java` — `adicionarDias()` — loop de carry
```java
public Data adicionarDias(int dias) {
    int novoDia = this.dia + dias;   // pode ultrapassar o mês
    int novoMes = this.mes;
    int novoAno = this.ano;

    while(novoDia > getDiasDoMes(novoMes, novoAno)) {
        novoDia -= getDiasDoMes(novoMes, novoAno);  // subtrai os dias do mês atual
        novoMes++;

        if(novoMes > 12) {    // virou o ano
            novoMes = 1;
            novoAno++;
        }
    }

    return new Data(novoDia, novoMes, novoAno);  // retorna NOVA instância (imutabilidade)
}
```
**Exemplo:** 25/01/2025 + 10 dias:
- `novoDia = 35`, `novoMes = 1` (janeiro tem 31 dias)
- `35 > 31` → `novoDia = 35-31 = 4`, `novoMes = 2` (fevereiro)
- `4 > 28`? Não → resultado: `04/02/2025`

> Retorna **uma nova instância** de `Data` em vez de modificar `this`. Isso é o conceito de imutabilidade — o objeto original não muda.

---

### 6. `ValidaData.java` — Separação da validação
```java
public static boolean validar(Data data) {
    int dia = data.getDia();
    int mes = data.getMes();
    int ano = data.getAno();

    if (ano <= 0) return false;       // ano inválido
    if (mes < 1 || mes > 12) return false;  // mês inválido
    if (dia < 1) return false;        // dia inválido

    return dia <= getDiasDoMes(mes, ano);   // dia cabe no mês?
}
```
Classe utilitária com métodos `static` — não precisa instanciar para usar. A lógica de validação foi **separada** da classe `Data` para respeitar a separação de responsabilidades.

---

### 7. `Agenda.java` — `lerData()` com loop de reentrada
```java
private static Data lerData(String mensagem) {
    System.out.println(mensagem);
    Data data = null;
    boolean valida = false;

    while (!valida) {
        try {
            System.out.print("Dia: ");
            int dia = Integer.parseInt(scanner.nextLine());
            System.out.print("Mês: ");
            int mes = Integer.parseInt(scanner.nextLine());
            System.out.print("Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());

            data = new Data(dia, mes, ano);

            if (!ValidaData.validar(data)) {
                System.out.println("Erro: data inválida! Tente novamente.\n");
                continue;     // volta ao início do while sem sair
            }
            valida = true;    // só sai do loop com data válida

        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido!\n");
            // não lança exceção — volta ao loop
        }
    }
    return data;
}
```
O `while(!valida)` garante que o programa nunca avança com uma data inválida — fica pedindo até receber uma correta. `continue` pula para o próximo ciclo do while sem executar `valida = true`.

---

### 8. `Agenda.java` — `diasFaltando()` usando `Calendar` para data de hoje
```java
Calendar cal = Calendar.getInstance();  // data/hora atual do sistema
Data hoje = new Data(
    cal.get(Calendar.DAY_OF_MONTH),
    cal.get(Calendar.MONTH) + 1,   // +1 porque Calendar começa em 0 (janeiro = 0)
    cal.get(Calendar.YEAR)
);

int diff = hoje.diferencaDias(c.getData());

int comparacao = c.getData().compararCom(hoje);
if (comparacao < 0) {
    System.out.println("Esse compromisso já passou há " + diff + " dia(s).");
} else if (comparacao == 0) {
    System.out.println("Esse compromisso é HOJE!");
} else {
    System.out.println("Faltam " + diff + " dia(s) para esse compromisso.");
}
```
`Calendar.MONTH + 1`: essa é uma armadilha clássica do Java — `Calendar` usa índice base-0 para meses (janeiro = 0, dezembro = 11). Por isso soma-se 1 para converter para o formato humano.

---

## Trechos com Maior Complexidade

### `totalDias()` — Fórmula do calendário gregoriano
A fórmula `a*365 + a/4 - a/100 + a/400` conta anos bissextos acumulados:
- `a/4`: adiciona um dia para cada 4 anos (bissextos simples)
- `-a/100`: remove o dia dos anos centenários (não bissextos)
- `+a/400`: recoloca o dia dos múltiplos de 400 (bissextos mesmo sendo centenários)

Divisão inteira em Java descarta a parte decimal — `7/4 = 1`, `100/4 = 25` — exatamente o comportamento desejado para contar anos.

### `adicionarDias()` — Loop de carry mês a mês
O while processa as "viradas" de mês uma a uma. Se adicionar 400 dias, o loop roda quantas vezes for necessário até o dia caber no mês atual. Também trata a virada de ano.

---

## Conceitos de POO Demonstrados

| Conceito | Onde aparece |
|----------|-------------|
| **Encapsulamento** | `Data` com atributos privados; lógica interna (`totalDias`, `getDiasDoMes`, `isAnoBissexto`) como `private` |
| **Composição** | `Compromisso` tem um objeto `Data` |
| **Imutabilidade** | `adicionarDias()` retorna nova instância em vez de modificar `this` |
| **Classe utilitária estática** | `ValidaData` com métodos `static` — padrão comum para helpers |
| **Separação de responsabilidades** | `Data` → lógica de data; `ValidaData` → validação; `Agenda` → fluxo do usuário |
| **`ArrayList`** | Lista dinâmica de compromissos |
| **Tratamento de exceções** | `NumberFormatException` capturada no loop de leitura |
| **`Scanner`** | Leitura de entrada do usuário via console |
| **`Calendar`** | Única integração com a API padrão Java — apenas para obter a data atual do sistema |
