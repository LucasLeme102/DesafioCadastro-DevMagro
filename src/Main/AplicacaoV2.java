package Main;

import PetCadastro.Pet;
import PetCadastro.Petcadastro;

import java.util.Scanner;

public class AplicacaoV2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Petcadastro petCadastro = new Petcadastro();
    public static void main(String[] args) {
        boolean opcaoValida = false;
        while(!opcaoValida){
            mostrarMenuPrincipal();
            int numeroUsuario = scanner.nextInt();
            scanner.nextLine();
            switch (numeroUsuario){
                case 1:
                    cadastrarPet();
                    break;
                case 2:
                    alterarPet();
                    break;
                case 3:
                    deletarPet();
                    break;
                case 4:
                    imprimirPets();
                    break;
                case 5:
                    buscarComFiltro();
                    break;
                case 6:
                    System.out.println("Programa encerrado!");
                    opcaoValida = true;
                    break;
                default:
                    System.out.println("Digite um número de 1 a 6!");

            }
        }
    }
    //-------------------------Métodos Principais----------------------
    public static  void alterarPet(){
        System.out.println("Qual tipo deseja buscar para ALTERAR?");
        System.out.println("OBS: Para alterar pet use seu númeroPet!!");
        String tipoanimal = scanner.nextLine().toLowerCase();
        menuDeBusca();
        int numeroDeBusca = scanner.nextInt();
        scanner.nextLine();
        switch (numeroDeBusca){
            case 1:
                buscaPorNome(tipoanimal);
                break;
            case 2:
                buscaPorSexo(tipoanimal);
                break;
            case 3:
                buscaPorIdade(tipoanimal);
                break;
            case 4:
                buscaPorPeso(tipoanimal);
                break;
            case 5:
                buscaPorRaca(tipoanimal);
                break;
            case 6:
                buscaPorCidade(tipoanimal);
                break;
            default:
                System.out.println("Opção inválida");
        }
        System.out.println("Qual número do pet?");
        int numeroDigitado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("qual o novo nome?");
        String nomeDigitado1 = scanner.nextLine();
        if(nomeDigitado1.isEmpty()){
            nomeDigitado1 = "Nenhuma informação";
        }
        System.out.println("qual a nova idade?");
        String idadeDigitado = scanner.nextLine();
        if(idadeDigitado.isEmpty()){
            idadeDigitado= "Nenhuma informação";
        }
        System.out.println("qual o novo peso?");
        String pesoDigitado = scanner.nextLine();
        if(pesoDigitado.isEmpty()){
            pesoDigitado = "Nenhuma informação";
        }
        System.out.println("qual a nova cidade?");
        String enderecoDigitado = scanner.nextLine();
        if(enderecoDigitado.isEmpty()){
            enderecoDigitado = "Nenhuma informação";
        }

        System.out.println(petCadastro.alterarPet(numeroDigitado,nomeDigitado1,idadeDigitado,pesoDigitado,enderecoDigitado));
    }
    public static void cadastrarPet(){
        Pet pet = new Pet();
        pet.cadastrarPet();
        petCadastro.adiconarPet(pet);
    }
    public static void deletarPet(){
        System.out.println("Qual tipo deseja buscar para REMOVER?");
        String tipoanimal2 = scanner.nextLine().toLowerCase();
        menuDeBusca();
        int entradaUsuario = scanner.nextInt();
        scanner.nextLine();
        switch (entradaUsuario){
            case 1:
                buscaPorNome(tipoanimal2);
                break;
            case 2:
                buscaPorSexo(tipoanimal2);
                break;
            case 3:
                buscaPorIdade(tipoanimal2);
                break;
            case 4:
                buscaPorPeso(tipoanimal2);
                break;
            case 5:
                buscaPorRaca(tipoanimal2);
                break;
            case 6:
                buscaPorCidade(tipoanimal2);
                break;
            default:
                System.out.println("Opção inválida");


        }
        System.out.println("Qual o número do Pet que deseja deletar?");
        int numeroParaDeletar = scanner.nextInt();
        scanner.nextLine();

        petCadastro.removerPetNumber(numeroParaDeletar,tipoanimal2);

    }
    public static void imprimirPets(){
        petCadastro.imprimirlista();
    }
    public static void buscarComFiltro(){
        System.out.println("Qual tipo deseja buscar?");
        String tipoanimal = scanner.nextLine().toLowerCase();
        menuDeBusca();
        int entradaUsuario = scanner.nextInt();
        scanner.nextLine();
        switch (entradaUsuario){
            case 1:
                buscaPorNome(tipoanimal);
            break;
            case 2:
                buscaPorSexo(tipoanimal);
            break;
            case 3:
                buscaPorIdade(tipoanimal);
            break;
            case 4:
                buscaPorPeso(tipoanimal);
            break;
            case 5:
                buscaPorRaca(tipoanimal);
            break;
            case 6:
                buscaPorCidade(tipoanimal);
            break;
            default:
                System.out.println("Opção inválida");

        }

    }
    // -------------------------Menus----------------------
    public static void mostrarMenuPrincipal(){
        System.out.println("1 - Cadastar Pet ");
        System.out.println("2 - Alterar dados de algum pet cadastrado ");
        System.out.println("3 - Deletar pet cadastrado ");
        System.out.println("4 - Listar todos os pets cadastrados ");
        System.out.println("5 - Buscar pets por algum critério ");
        System.out.println("6 - Finalizar aplicação ");
    }
    public static void menuDeBusca(){
        System.out.println("1 -  Nome e/ou Sobrenome");
        System.out.println("2 -  Sexo ");
        System.out.println("3 -  Idade");
        System.out.println("4 -  Peso");
        System.out.println("5 -  Raça");
        System.out.println("6 -  Cidade");
        System.out.println("7 -  Finalizar busca!");
    }
    //-------------------------Buscas----------------------
    public static void buscaPorNome(String tipoanimal){
        System.out.println("Busca por nome ou sobrenome: ");
        String nomeDeBusca = scanner.nextLine();
        System.out.println(petCadastro.buscarPetNome(nomeDeBusca,tipoanimal));
    }
    public static void buscaPorSexo(String tipoanimal){
        System.out.println("Busca por sexo: ");
        String sexoDeBusca = scanner.nextLine();


        System.out.println(petCadastro.buscaporSexo(sexoDeBusca,tipoanimal));
    }
    public static void buscaPorIdade(String tipoanimal){
        System.out.println("Busca por Idade: ");
        String idadedeBusca;
        idadedeBusca = scanner.nextLine();
        System.out.println(petCadastro.buscaporIdade(idadedeBusca,tipoanimal));
    }
    public static void buscaPorPeso(String tipoanimal){
        System.out.println("Busca por peso: ");
        String pesodeBusca = scanner.nextLine();
        System.out.println(petCadastro.buscaporPeso(pesodeBusca,tipoanimal));
    }
    public static void buscaPorCidade(String tipoanimal){
        System.out.println("Busca por Cidade: ");
        String cidadeBusca = scanner.nextLine();
        System.out.println(petCadastro.buscaporCidade(cidadeBusca,tipoanimal));
    }
    public static void buscaPorRaca(String tipoanimal){
        System.out.println("Busca por raça: ");
        String racadeBusca = scanner.nextLine();
        System.out.println(petCadastro.buscaporRaca(racadeBusca,tipoanimal));
    }
    //-------------------------Utilitário----------------------

}
