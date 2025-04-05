# Desafio Cadastro de Pets Concluído! 🐾

## Descrição do Desafio

Link do desafio: [Desafio Cadastro de Pets](https://github.com/karilho/desafioCadastro)

Este desafio tem como objetivo praticar conceitos de Java com interface de linha de comando (CLI), abordando:

- Orientação a Objetos (OO)
- Manipulação de arquivos e arrays
- Java IO
- Tratamento de exceções
- Boas práticas de código
- Sistemas de arquivos

## Funcionalidades do Programa

O programa permite realizar as seguintes ações:

1. Cadastrar um pet
2. Alterar dados de um pet
3. Deletar um pet
4. Listar todos os pets cadastrados
5. Realizar busca por diferentes critérios
6. Sair da aplicação

### Exemplo de Código do Menu Principal:

```java
public static void main(String[] args) {
    boolean opcaoValida = false;
    while(!opcaoValida){
        mostrarMenuPrincipal();
        int numeroUsuario = scanner.nextInt();
        scanner.nextLine();
        switch (numeroUsuario){
            case 1: cadastrarPet(); break;
            case 2: alterarPet(); break;
            case 3: deletarPet(); break;
            case 4: imprimirPets(); break;
            case 5: buscarComFiltro(); break;
            case 6: System.out.println("Programa encerrado!"); opcaoValida = true; break;
            default: System.out.println("Digite um número de 1 a 6!");
        }
    }
}
```

### Exemplo de Código de Busca:

```java
public static void buscaPorNome(String tipoanimal) {
    System.out.println("Busca por nome ou sobrenome: ");
    String nomeDeBusca = scanner.nextLine();
    System.out.println(petCadastro.buscarPetNome(nomeDeBusca, tipoanimal));
}
```

---

## Estrutura do Código

### Classe `Pet`

A classe `Pet` define os atributos e métodos que representam um animal de estimação, incluindo a manipulação de dados privados e o uso de modificadores de acesso para garantir a segurança e integridade das informações.

#### Exemplo de Código da Classe `Pet`:

```java
private String nome;
protected String tipoPets;
protected String sexoPet;
private String endereco;
private String idade;
private String peso;
private String raca;
private String cidade;
private final int NUMBER_PET;
private static final String FORMULARIO = ".../Formulario.txt";
private static final String CAMINHO_PATH = ".../Data/";
private static final Scanner scanner = new Scanner(System.in);
```

#### Método `toString`:

```java
@Override
public String toString() {
    return  "------------------------\n" +
            "nome e sobrenome: "+ nome + "\n" +
            "tipo: "+ tipoPets + "\n" +
            "sexo: "+ sexoPet + "\n" +
            "idade: "+ idade + "\n" +
            "peso: "+ peso + "\n" +
            "raça: "+ raca + "\n" +
            "numero de cadastro do pet: "+ NUMBER_PET + "\n" +
            "--------------------------";
}
```

---

### Cadastro de Pet e Leitura de Arquivo

O método `cadastrarPet()` realiza a leitura dos dados de um arquivo `.txt` e cria um objeto `Pet` com essas informações.

#### Exemplo de Código para Cadastro de Pet:

```java
public void cadastrarPet() {
    try(BufferedReader leitor = new BufferedReader(new FileReader(FORMULARIO))) {
        String linha;
        while((linha = leitor.readLine()) != null) {
            System.out.println(linha);
            leituraDadosFormulario(linha);
        }
        String dataAndHora = dataHora();
        salvarArquivos(dataAndHora);
    } catch (IOException e) {
        System.out.println("Erro de leitura");
    }
}
```

---

### Classe `PetCadastro`

A classe `PetCadastro` gerencia a coleção de pets utilizando uma lista (`List`), com métodos para adicionar, buscar, alterar e remover pets.

#### Exemplo de Código para Adicionar um Pet:

```java
public void adicionarPet(Pet pet) {
    petList.add(pet);
}
```

#### Exemplo de Código de Busca por Nome:

```java
public List<Pet> buscarPetNome(String nome, String tipo) {
    List<Pet> listaPorNome = new ArrayList<>();
    if (!petList.isEmpty()) {
        for (Pet x : petList) {
            if (x.getNome().equalsIgnoreCase(nome) || x.getNome().contains(nome) && x.getTipoPets().equalsIgnoreCase(tipo)) {
                listaPorNome.add(x);
            }
        }
    }
    return listaPorNome;
}
```

---

## Considerações Finais

Este desafio foi uma excelente oportunidade para aplicar e reforçar conhecimentos adquiridos em Java, como manipulação de arquivos, estrutura de dados e boas práticas de programação. Embora o código possa ser otimizado, a experiência foi valiosa para o meu aprendizado.

Futuras melhorias incluem a integração com banco de dados e a implementação de novas tecnologias e boas práticas, como testes automatizados e refatoração do código.
