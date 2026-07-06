# ProjetoBanco — Sistema Bancário com Interface Gráfica

## Nome do Projeto
**BancoApp** — Sistema bancário com interface Swing para cadastro de funcionários (Gerente, Técnico Bancário, Diretor) e clientes (Pessoa Física e Jurídica), com cálculo automático de salário final e bonificação.

**Localização:** `atividadesAulas/aula11+/BancoApp/`

---

## Descrição Geral
Aplicação desktop que simula o cadastro de um banco. Permite:
- Cadastrar funcionários de 3 tipos com regras distintas de bonificação
- Cadastrar clientes (PF ou PJ) com endereço completo
- Listar funcionários com salário base + salário final (após bonificação)
- Listar clientes com seus dados e documentos
- Gerenciar contas bancárias (ContaCorrente e ContaPoupanca) com operações de saque, depósito e transferência

Dados apenas em memória (sem persistência em arquivo ou banco).

---

## Modelagem de Entidades

### Hierarquia de Funcionários
```
Funcionario
  ├── Gerente         (+agencia)              bonificação: 20% do salário
  ├── TecnicoBancario (+setorAtendimento,      bonificação: R$30,00 × horas extras
  │                    +quantidadeHorasExtras)
  └── Diretor         (+participacaoLucros,    bonificação: salário × participacaoLucros
                       +areaResponsavel)
```

### Hierarquia de Clientes
```
Cliente (abstrata)
  ├── PessoaFisica   (+nome, +cpf)
  └── PessoaJuridica (+razaoSocial, +cnpj)
```
Ambas herdam: `telefone`, `email`, `Endereco` (objeto composto).

### Hierarquia de Contas
```
Conta (abstrata)
  ├── ContaCorrente  (+limite)      atualizaSaldo: taxa × 2
  └── ContaPoupanca                atualizaSaldo: taxa × 3
```

### Repositório Central
```
Banco
  ├── ArrayList<Funcionario>
  └── ArrayList<Cliente>
```

---

## Arquitetura do Projeto — MVC

```
br.com.unesp.bancoapp
├── aplicacao/   → App.java
├── modelo/      → Banco, Funcionario, Gerente, TecnicoBancario, Diretor,
│                  Cliente, PessoaFisica, PessoaJuridica, Endereco,
│                  Conta, ContaCorrente, ContaPoupanca
├── controller/  → BancoController, FuncionarioController, ClienteController
└── view/        → Principal, FuncionarioView, ClienteView,
                   ListaFuncionariosView, ListaClientesView
```

**Fluxo:**
```
App → Principal (cria BancoController)
         │
         ├── FuncionarioView → FuncionarioController → BancoController
         ├── ClienteView     → ClienteController     → BancoController
         ├── ListaFuncionariosView → BancoController
         └── ListaClientesView    → BancoController
```

> Mesmo padrão do ProjetoFCT: `BancoController` criado uma vez na `Principal` e passado para todas as janelas.

---

## Trechos Importantes do Código Explicados

### 1. `Funcionario.java` — Método `getBonificacao` e `getSalarioFinal`
```java
public double getBonificacao() {
    return this.salario * 0.10;   // padrão: 10% (nunca usado diretamente — subclasses sobrescrevem)
}

public double getSalarioFinal() {
    return this.salario + this.getBonificacao();  // chama a versão polimórfica!
}
```
`getSalarioFinal()` usa `this.getBonificacao()` — quando chamado em um `Gerente`, o Java executa `Gerente.getBonificacao()` (20%), não o da classe-base. Isso é **polimorfismo em ação**.

---

### 2. `Conta.java` — Operações bancárias com reaproveitamento
```java
public boolean saca(double valor) {
    if(this.saldo < valor) return false;
    this.saldo -= valor;
    return true;
}

public void deposita(double quantidade) {
    this.saldo += quantidade;
}

public void transfere(Conta destino, double valor) {
    if(this.saca(valor)) {      // reutiliza saca() que já valida saldo
        destino.deposita(valor); // reutiliza deposita()
    }
}
```
`transfere` não duplica a lógica — delega para `saca` e `deposita`. Se o saldo for insuficiente, `saca` retorna `false` e a transferência não acontece.

---

### 3. `Conta.java` — `atualizaSaldo` com sobrescrita nas subclasses
```java
// Conta (base):
public void atualizaSaldo(double taxa) {
    this.saldo += this.saldo * taxa;   // aplica taxa diretamente
}

// ContaCorrente:
@Override
public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 2);     // chama a base com o dobro da taxa
}

// ContaPoupanca:
@Override
public void atualizaSaldo(double taxa) {
    super.atualizaSaldo(taxa * 3);     // chama a base com o triplo da taxa
}
```
Padrão elegante: a lógica de `saldo += saldo * taxa` existe **um único lugar** (classe base). As subclasses só ajustam o multiplicador e delegam com `super`.

---

### 4. `FuncionarioController.java` — Criação polimórfica por tipo selecionado
```java
Funcionario f;
if(tipo.equals("Gerente")) {
    f = new Gerente(nome, cpf, salario, agencia);

} else if(tipo.equals("Técnico Bancário")) {
    int horas = Integer.parseInt(view.getHorasExtras());
    f = new TecnicoBancario(nome, cpf, salario, setor, horas);

} else {
    double participacao = Double.parseDouble(view.getParticipacao().replace(",", ".")) / 100.0;
    f = new Diretor(nome, cpf, salario, participacao, area);
}

bancoController.cadastrarFuncionario(f);
```
A variável `f` é do tipo `Funcionario` (classe-base), mas recebe objetos concretos diferentes. O `.replace(",", ".")` normaliza separadores decimais do usuário.

A divisão por `100.0` converte a participação digitada como `35` (percentual) em `0.35` (fração decimal usada no cálculo).

---

### 5. `ClienteController.java` — Mesmo padrão para PF/PJ
```java
Cliente c;
if(tipo.equals("Pessoa Física")) {
    c = new PessoaFisica(nomeOuRazao, cpfOuCnpj, telefone, email, endereco);
} else {
    c = new PessoaJuridica(nomeOuRazao, cpfOuCnpj, telefone, email, endereco);
}
bancoController.cadastrarCliente(c);
```
`getNome()` é método **abstrato** em `Cliente` — `PessoaFisica` retorna `nome`; `PessoaJuridica` retorna `razaoSocial`. A tabela chama `c.getNome()` sem saber qual tipo é.

---

### 6. `FuncionarioView.java` — Tabela exibe salário final calculado
```java
modelo.addRow(new Object[]{
    f.getNome(),
    f.getCpf(),
    tipo,
    String.format("R$ %.2f", f.getSalario()),
    String.format("R$ %.2f", f.getSalarioFinal())  // polimorfismo: cada subclasse calcula diferente
});
```
A coluna "Salário Final" chama `getSalarioFinal()` que por sua vez chama `getBonificacao()` polimorficamente — cada tipo exibe o valor correto automaticamente.

---

### 7. `ClienteView.java` — Cast para recuperar CPF ou CNPJ na tabela
```java
if(c instanceof PessoaFisica) {
    tipo      = "Pessoa Física";
    documento = ((PessoaFisica) c).getCpf();
} else {
    tipo      = "Pessoa Jurídica";
    documento = ((PessoaJuridica) c).getCnpj();
}
```
`CPF` e `CNPJ` não existem na classe-base `Cliente`. É necessário fazer `instanceof` + cast para acessá-los.

---

## Trechos com Maior Complexidade

### Hierarquia dupla independente (Funcionario e Cliente)
O projeto possui **duas hierarquias de herança** paralelas e independentes:
- Uma para funcionários do banco (quem trabalha lá)
- Uma para clientes do banco (quem tem conta lá)

Isso demonstra que herança não é uma estrutura única no sistema — múltiplas hierarquias podem coexistir.

### Método abstrato `getNome()` em `Cliente`
```java
public abstract class Cliente {
    // ...
    public abstract String getNome();  // força PessoaFisica e PessoaJuridica a implementar
}
```
`PessoaFisica.getNome()` → retorna `this.nome`  
`PessoaJuridica.getNome()` → retorna `this.razaoSocial`

A interface é uniforme (`getNome()`), mas o comportamento é diferente — polimorfismo via método abstrato.

### `Conta` abstrata sem método abstrato explícito
`Conta` é `abstract` mas `atualizaSaldo` **não** é `abstract` — tem implementação padrão. As subclasses a sobrescrevem opcionalmente. Isso é diferente de forçar implementação: a classe-base fornece um comportamento default que as filhas podem especializar.

---

## Conceitos de POO Demonstrados

| Conceito | Onde aparece |
|----------|-------------|
| **Herança** | `Gerente/TecnicoBancario/Diretor extends Funcionario`; `PessoaFisica/PessoaJuridica extends Cliente`; `ContaCorrente/ContaPoupanca extends Conta` |
| **Polimorfismo** | `getBonificacao()` sobrescrito em cada cargo; `getNome()` em PF/PJ; `atualizaSaldo` nas contas |
| **Classe abstrata** | `Conta` e `Cliente` são `abstract` — não podem ser instanciadas diretamente |
| **Método abstrato** | `Cliente.getNome()` força cada subclasse a definir sua própria implementação |
| **Encapsulamento** | todos os atributos `private`/`protected` com getters/setters |
| **Composição** | `Cliente` tem `Endereco`; `Banco` tem listas de `Funcionario` e `Cliente` |
| **MVC** | separação clara model/view/controller |
