# ExercíciosNetbeans — Atividades de Interface Gráfica Swing

## Nome do Projeto
**exerciciosNetbeans_interface** — Coleção de 3 atividades independentes que praticam criação de interfaces gráficas com Java Swing no padrão MVC.

**Localização:** `exerciciosNetbeans_interface/`

---

## Descrição Geral
Três mini-projetos autônomos, cada um em sua própria pasta, exercitando diferentes aspectos de interfaces Swing:

| Atividade | Nome | Funcionalidade principal |
|-----------|------|--------------------------|
| `atividade1-loja` | Loja Teste | Lista de produtos com quantidade e cálculo de total |
| `atividade2-cadastro` | Formulário de Cadastro | Formulário completo com impressão/exportação PDF |
| `atividade3-calculadora` | Calculadora | Calculadora com 4 operações básicas |

---

## Arquitetura — MVC em diretórios simples

Todos os 3 projetos seguem a mesma estrutura de pacotes (sem subpacotes da Unesp):

```
atividade-X/src/
  ├── app/        → Main.java
  ├── model/      → (entidade de dados)
  ├── controller/ → (lógica de negócio, listeners)
  └── view/       → (janela Swing)
```

---

## Atividade 1 — Loja Teste

### Descrição
Exibe uma lista de 7 produtos com nome, preço e campo de quantidade. Ao clicar em "Comprar", calcula e exibe o total da compra.

### Entidade: `Produto.java`
```java
public class Produto {
    private String nome;
    private double valor;
    // construtor, getNome(), getValor()
}
```
Simples — apenas armazena nome e preço unitário.

### View: `LojaView.java`
```java
produtos = new Produto[]{
    new Produto("Rapadura", 1.50),
    new Produto("Salame",   3.00),
    // ... 7 produtos no total
};
```
Cria arrays paralelos: `produtos[]` (os dados), `checkBoxes[]` e `camposQtd[]` (campos de entrada). Usa `GridLayout(8, 3)` — 1 linha de cabeçalho + 7 linhas de produtos, cada uma com 3 colunas (nome, preço, quantidade).

> Os arrays são `public` — o controller acessa diretamente `view.produtos[i]`, `view.camposQtd[i]`.

### Controller: `LojaController.java` — Cálculo do total
```java
for(int i = 0; i < view.produtos.length; i++) {
    String texto = view.camposQtd[i].getText().trim();
    int qtd = 0;

    try {
        int parsed = Integer.parseInt(texto);
        if(parsed > 0) qtd = parsed;   // ignora quantidades negativas
    } catch(NumberFormatException ex) {
        qtd = 0;                        // campo inválido tratado como 0
    }

    total += view.produtos[i].getValor() * qtd;
}

String totalStr = String.format("%.2f", total).replace('.', ',');  // formato R$ brasileiro
view.lblTotal.setText("Total a pagar: " + totalStr);
```
**Ponto importante:** usa `ActionListener` como classe interna privada (`EventoComprar implements ActionListener`). Itera com índice `i` para acessar `view.produtos[i]` e `view.camposQtd[i]` em sincronia.

---

## Atividade 2 — Formulário de Cadastro

### Descrição
Formulário completo com campos pessoais, seleção múltipla de cursos (checkboxes), rádio-buttons para sexo e combobox de UF. Ao salvar, gera saída impressa (PDF via driver de impressora) ou arquivo `.txt`.

### Entidade: `Cadastro.java`
```java
public class Cadastro {
    private String nome, telefone, endereco, cidade, uf, email, sexo;
    private ArrayList<String> cursos;   // lista de cursos selecionados
    private String motivo;
}
```
Objeto imutável (sem setters) — criado de uma vez com todos os dados coletados do formulário.

### Controller: `CadastroController.java` — Dois caminhos de saída

#### Caminho 1: Impressão via `PrinterJob` (se há impressora/PDF disponível)
```java
PrintService[] servicos = PrintServiceLookup.lookupPrintServices(null, null);

if(servicos.length > 0) {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setJobName("Cadastro - " + nome);
    job.setPrintable(new CadastroPrintable(cadastro));

    if(job.printDialog()) {    // abre o diálogo de impressão nativo do SO
        job.print();
    }
}
```
`PrintServiceLookup.lookupPrintServices(null, null)` detecta se o sistema tem qualquer impressora (incluindo "Imprimir para PDF" do Windows/Mac). Se tiver, usa o diálogo nativo — o usuário pode escolher salvar como PDF.

#### Caminho 2: Arquivo `.txt` via `JFileChooser` (fallback)
```java
JFileChooser chooser = new JFileChooser();
chooser.setSelectedFile(new File("cadastro_" + nome.replaceAll("\\s+", "_") + ".txt"));
int resultado = chooser.showSaveDialog(view);

if(resultado == JFileChooser.APPROVE_OPTION) {
    PrintWriter pw = new PrintWriter(arquivo, "UTF-8");
    pw.println("Nome:   " + cadastro.getNome());
    // ... escreve todos os campos
    pw.close();
}
```
`replaceAll("\\s+", "_")` substitui espaços em branco (incluindo múltiplos) por underscore no nome do arquivo.

### Classe interna `CadastroPrintable implements Printable` — o mais complexo da atividade
```java
@Override
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {

    if(pageIndex > 0) return NO_SUCH_PAGE;  // só tem 1 página

    Graphics2D g2d = (Graphics2D) graphics;
    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY()); // margem da página

    int x = 50, y = 50, lh = 22;  // posição X, posição Y, altura de linha

    g2d.setFont(new Font("SansSerif", Font.BOLD, 14));
    g2d.drawString("CADASTRO", x, y);
    y += lh * 2;

    g2d.setFont(new Font("SansSerif", Font.PLAIN, 12));
    g2d.drawString("Nome: " + cadastro.getNome(), x, y); y += lh;
    // ... demais campos

    // quebra manual de texto longo (motivo)
    String motivo = cadastro.getMotivo();
    int maxChars = 80;
    while(motivo.length() > maxChars) {
        g2d.drawString(motivo.substring(0, maxChars), x, y);
        motivo = motivo.substring(maxChars);
        y += lh;
    }
    g2d.drawString(motivo, x, y);

    return PAGE_EXISTS;
}
```
`Graphics2D` é como desenhar numa tela — não há layout automático. Tudo é posicionado manualmente com `drawString(texto, x, y)`. A variável `y` vai aumentando de `lh` (line height) a cada linha para simular parágrafos.

A quebra de linha do motivo é feita manualmente cortando `substring(0, 80)` em loop — não existe `WordWrap` automático no `Graphics2D`.

---

## Atividade 3 — Calculadora

### Descrição
Calculadora com dígitos 0–9, ponto decimal, operadores `+`, `-`, `*`, `/`, `=` e botão `C` (limpar).

### Controller: `CalculadoraController.java` — Máquina de estados

O controller mantém **estado interno** entre cliques de botão:
```java
private double primeiroOperando;
private String operador;
private boolean aguardandoSegundo;
```

**Fluxo de uma operação:**
```
Usuário clica "5" → display mostra "5"
Usuário clica "+" → primeiroOperando=5, operador="+", aguardandoSegundo=true
Usuário clica "3" → aguardandoSegundo=true → substitui display por "3" (não concatena!)
Usuário clica "=" → resultado = calcular(5, 3, "+") = 8 → display mostra "8"
```

#### Lógica do digito com `aguardandoSegundo`:
```java
} else {  // é um dígito
    if(aguardandoSegundo) {
        view.display.setText(cmd);        // começa número novo — substitui display
        aguardandoSegundo = false;
    } else if(view.display.getText().equals("0") || view.display.getText().equals("Erro")) {
        view.display.setText(cmd);        // substitui "0" inicial ou "Erro"
    } else {
        view.display.setText(view.display.getText() + cmd);  // concatena ao número atual
    }
}
```

#### Tratamento de divisão por zero:
```java
private double calcular(double a, double b, String op) {
    if(op.equals("/")) {
        if(b == 0) return Double.NaN;   // divisão por zero → NaN
        return a / b;
    }
    // ...
}

// no resultado:
if(Double.isNaN(resultado) || Double.isInfinite(resultado)) {
    view.display.setText("Erro");
} else if(resultado == (long) resultado) {
    view.display.setText(String.valueOf((long) resultado));  // ex: 6.0 → "6"
} else {
    view.display.setText(String.valueOf(resultado));         // ex: 3.14 → "3.14"
}
```
`resultado == (long) resultado` verifica se o double é um número inteiro (sem parte decimal). Se for, exibe sem `.0` — melhor experiência para o usuário.

#### Um único `ActionListener` para todos os botões:
```java
BotaoListener listener = new BotaoListener();
for(int i = 0; i < view.botoes.length; i++) {
    view.botoes[i].addActionListener(listener);  // mesmo listener em todos
}
```
Dentro do listener, `e.getActionCommand()` retorna o texto do botão (`"5"`, `"+"`, `"="`, `"C"`). Um único método `actionPerformed` trata todos os casos com `if/else`.

---

## Comparação entre as 3 Atividades

| Aspecto | Atividade 1 | Atividade 2 | Atividade 3 |
|---------|------------|------------|------------|
| Complexidade | Baixa | Alta | Média |
| Conceito novo | GridLayout + arrays paralelos | `PrinterJob`, `JFileChooser`, `Graphics2D` | Máquina de estados |
| Listener | Inner class por evento | Inner class `EventoSalvar` | Inner class única para todos os botões |
| Saída | Label na tela | Impressão/arquivo | Label na tela |

---

## Conceitos de POO Demonstrados

| Conceito | Onde aparece |
|----------|-------------|
| **Encapsulamento** | `Produto` com `private` + getters; `Cadastro` com todos os campos privados |
| **MVC** | Todos os 3 projetos com `model/`, `controller/`, `view/` |
| **Inner class** | `EventoComprar`, `EventoSalvar`, `BotaoListener` — classes internas do controller |
| **Interface `ActionListener`** | Implementada nas inner classes para responder a eventos de botão |
| **Interface `Printable`** | `CadastroPrintable` implementa `Printable` para desenho na página de impressão |
| **`ArrayList`** | `Cadastro.cursos` — número variável de cursos selecionados |
| **Tratamento de exceções** | `NumberFormatException` na loja e calculadora; `PrinterException` no cadastro |
