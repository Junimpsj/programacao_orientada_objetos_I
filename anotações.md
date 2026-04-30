## Anotações Rápida de Resumo para Prova de POO

### Modificadores de Acesso
- Public (todos veem)
- Privade (apenas a classe ve)
- Protected (a classe + filhos)

### Modificadores de comportamento
- static (pertence a classe nao ao objeto)
- final (o valor se torna imutável e não herda)

O modificador que eu mais tive dúvida foi o static. Utilizando o `static` vocẽ faz com que a variável pertença a classe e não ao objeto.  

De que modo? Bem, sem o static cada objeto tem uma cópia própria da variável ou método e quando definimos ele a variável se torna única para a classe sendo compartilhada por todos os objetos.  

### Polimorfismo
A ideia central do polimorfismo é um mesmo método sendo capaz de comportamentos diferentes.

Existem três tipos de Polimorfismo: Sobrecarga, Sobreposição e Inclusão

#### Sobrecarga (Overloading)
No polimorfismo de sobrecarga nós temos métodos com o mesmo nome mas parametros diferentes e o compilador decide qual método chamar de acordo com os parâmetros que foram passados.

Aparece muito em construtores, podemos criar construtores com diferentes quantidades de parâmetros.

#### Sopreposição (Overriding)
Aqui acontece quando a subclasse redefine um método da superclasse. A decisão acontece em tempo de execução quando o compiladore enxegar a descrição @Override que faz esse apontamento.

Para utilizar Overrido porém deve-se seguir regras simples:
- rescrever com mesmo nome
- rescrever com mesmos parametros
-rescrever com mesmo tipo de retorno

Uu seja, apenas a lógica interna do método pode mudar

#### Inclusão (Subtipagem)
É a capacidade de tratar um objeto da subclasse como se fosse superclasse. Isso permite escrever código genérico que funciona para qualquer subclasse.

Ou seja, inclui as subclasses como iguais para utilização de métodos feitos para a superclasse (pensando em seus parâmetros).

### Coleções

#### ArrayList
A ordem importa e pode ter repetição.

`ArrayList<String> nome = new ArrayList<>()`

Métodos:
- .add para adicionar elemento
- .remove para remover elemento
- .get() para acessar por indice
- .size para retornar o tamanho
- .contains para verificar se existe

#### HashSet
Não pode ter repetição. Não tem get por indice porque não tem índice.

#### HashMap
Precisa associar chave a valor.

Ex: 
```HashMap<String, Funcionario> funcionarios = new HashMap<>();  

funcionarios.put("123.456.789-00", f1)
```

Os métodos aqui são:
- .put para adicionar
- .get para buscar
- .remove para remover
- .containsKey para verificar pela chave
- .size para retornar tamanho


#### Qual utilizar?
Se precisa adicionar chave a valor -> HashMap

Pode ter duplicatas? Se sim, ArrayList

Se não, HashSet

A ordem importa? Se sim, ArrayList