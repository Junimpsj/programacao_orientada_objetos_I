# ProjetoFCT — Sistema de Gerenciamento FCT/Unesp

## Nome do Projeto
**ProjetoNetbeansFctMenu** — Sistema de gerenciamento de departamentos e funcionários (docentes) da FCT/Unesp com interface gráfica Swing.

---

## Descrição Geral
Aplicação desktop Java Swing que permite cadastrar, listar, editar e excluir departamentos e docentes da faculdade. O usuário navega por uma janela principal com menu e botões, abrindo janelas secundárias para cada operação. Os dados vivem apenas em memória (sem banco de dados ou arquivo).

**Operações disponíveis:**
- Cadastrar departamento (código, nome, telefone)
- Listar/consultar departamentos (com edição e exclusão)
- Cadastrar docente vinculado a um departamento (código, nome, função acadêmica, salário)
- Listar/consultar docentes com filtro por departamento (com edição e exclusão)

---

## Modelagem de Entidades

```
Universidade
  └── ArrayList<Departamento>
        └── ArrayList<Funcionario>
              └── Docente  (subclasse de Funcionario)
```

| Classe | Atributos principais | Observação |
|--------|---------------------|------------|
| `Universidade` | nome, `ArrayList<Departamento>` | raiz da estrutura |
| `Departamento` | codigo, nome, telefone, `ArrayList<Funcionario>` | contém os docentes |
| `Funcionario` | codigo, nome, salario | classe-base (protected) |
| `Docente extends Funcionario` | + funcao | único tipo de funcionário usado na prática |

**Herança:** `Docente` herda `codigo`, `nome` e `salario` de `Funcionario` via `super(codigo, nome, salario)`.

---

## Arquitetura do Projeto — MVC

O projeto segue o padrão **MVC (Model-View-Controller)** com separação em pacotes:

```
br.com.unesp.projetonetbeans
├── app/         → App.java          (ponto de entrada)
├── model/       → Universidade, Departamento, Funcionario, Docente
├── controller/  → UniversidadeController, DepartamentoController, FuncionarioController
└── view/        → Principal, DepartamentoView, FuncionarioView,
                   ListaDepartamentosView, ListaFuncionariosView
```

**Fluxo geral:**
```
App → Principal (view)
         │
         ├── cria UniversidadeController (mantém a Universidade em memória)
         │
         ├── DepartamentoView → DepartamentoController → UniversidadeController
         ├── FuncionarioView  → FuncionarioController  → UniversidadeController
         ├── ListaDepartamentosView → UniversidadeController
         └── ListaFuncionariosView  → UniversidadeController
```

> **Ponto chave:** o `UniversidadeController` é criado **uma vez** na `Principal` e passado como argumento para todas as janelas secundárias — isso garante que todas compartilham o mesmo estado (mesmos dados em memória).

---

## Trechos Importantes do Código Explicados

### 1. Ponto de entrada — `App.java`
```java
public static void main(String[] args) {
    new Principal();
}
```
Cria a janela principal. Simples — toda a lógica de inicialização está no construtor de `Principal`.

---

### 2. `Principal.java` — Compartilhamento do controlador
```java
public Principal() {
    initComponents();                                          // monta a janela pelo NetBeans
    this.universidadeController = new UniversidadeController("FCT/Unesp"); // cria o controlador central

    // passa o MESMO controlador para todas as janelas filhas
    btnCadastrarDepto.addActionListener(e -> new DepartamentoView(universidadeController).setVisible(true));
    btnListarDepto.addActionListener(e   -> new ListaDepartamentosView(universidadeController).setVisible(true));
    btnCadastrarFunc.addActionListener(e  -> new FuncionarioView(universidadeController).setVisible(true));
    btnListarFunc.addActionListener(e    -> new ListaFuncionariosView(universidadeController).setVisible(true));
}
```
Cada botão abre uma janela nova passando o mesmo `universidadeController`. Assim, se você cadastrar um departamento em `DepartamentoView`, ele aparece imediatamente no combobox de `FuncionarioView`.

---

### 3. `UniversidadeController.java` — Validação anti-duplicata de docente
```java
public boolean cadastrarFuncionario(int codDept, int codFunc, String nome, String funcao, double salario) {
    // varre TODOS os departamentos para garantir que o código não existe em nenhum
    for(Departamento d : universidade.getDepartamentos()) {
        if(d.buscarFuncionario(codFunc) != null) {
            return false;   // já existe — recusa o cadastro
        }
    }
    Departamento dept = universidade.buscarDepartamento(codDept);
    if(dept != null) {
        dept.adicionarFuncionario(new Docente(codFunc, nome, funcao, salario));
        return true;
    }
    return false;
}
```
Garante que o mesmo código de funcionário não seja duplicado em departamentos diferentes.

---

### 4. `UniversidadeController.java` — Atualização com cast para `Docente`
```java
public boolean atualizarFuncionario(int codDept, int codFunc, ...) {
    Funcionario f = d.buscarFuncionario(codFunc);
    if(f != null) {
        f.setNome(novoNome);
        f.setSalario(novoSalario);
        if(f instanceof Docente) {              // verifica o tipo real em tempo de execução
            ((Docente) f).setFuncao(novaFuncao); // cast para acessar setFuncao()
        }
    }
}
```
Usa `instanceof` + casting porque `buscarFuncionario` retorna `Funcionario` (tipo da lista), mas o objeto real pode ser `Docente`.

---

### 5. `ListaFuncionariosView.java` — Coluna oculta no `JTable`
```java
DefaultTableModel modelo = new DefaultTableModel(
    new String[]{"Código", "Nome", "Função", "Salário", "Departamento", "codDepto"}, 0
) {
    @Override
    public boolean isCellEditable(int row, int column) { return false; }
};

tabela = new JTable(modelo);
tabela.removeColumn(tabela.getColumnModel().getColumn(5)); // remove coluna 5 da VIEW, mas não do MODEL
```
A 6ª coluna (`codDepto`) guarda o código do departamento mas não é exibida ao usuário. Quando o usuário seleciona uma linha para editar/excluir, o código é recuperado pelo índice `5` do **model** (não da view):
```java
int codDept = (int) tabela.getModel().getValueAt(linha, 5);
```

---

### 6. `FuncionarioView.java` — Parse do combobox
```java
public int getCodigoDepartamentoSelecionado() {
    String item = (String) jComboBox1.getSelectedItem(); // ex: "1 - Matemática"
    return Integer.parseInt(item.split(" - ")[0]);       // extrai "1" e converte para int
}
```
O combobox armazena itens no formato `"codigo - nome"`. O `split(" - ")[0]` pega apenas a parte do código.

---

## Trechos com Maior Complexidade

### Busca linear em listas (`Departamento.java`)
```java
public boolean removerFuncionario(int codigoFuncionario) {
    for(int i = 0; i < this.funcionarios.size(); i++) {
        if(this.funcionarios.get(i).getCodigo() == codigoFuncionario) {
            this.funcionarios.remove(i);
            return true;
        }
    }
    return false;
}
```
Usa índice numérico (`for` com `i`) em vez de `for-each` porque é necessário chamar `remove(i)` — remover pelo índice enquanto itera com `for-each` lançaria `ConcurrentModificationException`.

### Edição inline via `JOptionPane` com `JPanel` customizado (`ListaFuncionariosView.java`)
```java
JTextField fieldNome   = new JTextField(nomeAtual, 22);
JTextField fieldFuncao = new JTextField(funcaoAtual, 22);
JTextField fieldSalario = new JTextField(salarioStr, 22);

JPanel painel = new JPanel(new GridLayout(3, 2, 5, 5));
// ... adiciona labels e campos ...

int resultado = JOptionPane.showConfirmDialog(this, painel, "Editar Funcionário", JOptionPane.OK_CANCEL_OPTION);
if(resultado == JOptionPane.OK_OPTION) {
    double novoSalario = Double.parseDouble(fieldSalario.getText());
    universidadeController.atualizarFuncionario(codDept, codFunc, ...);
}
```
`JOptionPane.showConfirmDialog` aceita qualquer `Component` como conteúdo — aqui recebe um `JPanel` com campos de texto, criando um mini-formulário modal reutilizando a API padrão do Swing.

---

## Conceitos de POO Demonstrados

| Conceito | Onde aparece |
|----------|-------------|
| **Herança** | `Docente extends Funcionario` |
| **Encapsulamento** | atributos `private`/`protected` com getters/setters |
| **Polimorfismo** | `instanceof` + cast para `Docente` no controller |
| **Composição** | `Universidade` tem `ArrayList<Departamento>`; `Departamento` tem `ArrayList<Funcionario>` |
| **MVC** | separação model/view/controller em pacotes distintos |
| **Singleton de estado** | `UniversidadeController` criado uma vez e compartilhado entre todas as views |
