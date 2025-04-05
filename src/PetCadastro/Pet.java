package PetCadastro;

import repository.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Pet {
    private String nome;
    protected String tipoPets;
    protected String sexoPet;
    private String endereco;
    private String idade;
    private String peso;
    private String raca;
    private String cidade;
    private final int NUMBER_PET;
    private static final String
            FORMULARIO ="/Users/lucasleme/java/DesafioCadastroDePets/src/Utils/Formulario.txt";
    private static final String CAMINHO_PATH = "/Users/lucasleme/java/DesafioCadastroDePets/src/Data/";
    private static final Scanner scanner = new Scanner(System.in);

    public void cadastrarPet(){
        try(BufferedReader leitor = new BufferedReader(new FileReader(FORMULARIO))){
            String linha;
            while((linha = leitor.readLine())!=null){
                System.out.println(linha);
                leituraDadosFormualrio(linha);
            }



            String dataAndHora = dataHora();
            SalvarArquivos(dataAndHora);
        }catch (IOException e){
            System.out.println("Erro de leitura");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public Pet() {
        Random random = new Random();
        NUMBER_PET = random.nextInt(1000)+1;
    }
    private void leituraDadosFormualrio(String linha) {
        try{
            if(linha.startsWith("1")){
                solicitarNome();
            } else if (linha.startsWith("2")) {
                solicitarTipoPet();
            }else if (linha.startsWith("3")) {
                solicitarSexo();
            }else if (linha.startsWith("4")) {
                solicitarEndereco();
            }else if (linha.startsWith("5")) {
                solicitarIdade();
            }else if (linha.startsWith("6")) {
                solicitarPeso();
            }else if (linha.startsWith("7")) {
                solicitarRaca();
            }

        } catch (Exception e){
            System.out.println("Erro na leitura do arquivo");
        }

    }

    //====================Métodos Utilitários=========================
    private String dataHora(){
        Date date = new Date();
        String dataFormatada = new SimpleDateFormat("yyyyMMdd'T'").format(date);
        String horaFormatada = new SimpleDateFormat("HHmm").format(date);
        return dataFormatada+horaFormatada;
    }
    private void SalvarArquivos(String dataAndHora){
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(CAMINHO_PATH+dataAndHora+(getNome().trim()).toUpperCase()+".txt",false))){
            escritor.write("Nome: "+nome+"\n");
            escritor.write("Animal: " + tipoPets + "\n");
            escritor.write("Sexo: " + sexoPet + "\n");
            escritor.write("Endereco: " + endereco + "\n");
            escritor.write("Idade: " + idade + "\n");
            escritor.write("Peso: " + peso + "\n");
            escritor.write("Raça: " + raca + "\n");

        }catch (IOException e){
            System.out.println("Erro no arquivo");


        }
    }
    //====================Métodos de entrada do usuário=========================
    private void solicitarNome()  {

        do{
            try {
                nome = scanner.nextLine();
                if(nome.isEmpty()){
                    nome = "Não informado";
                    break;
                }
                if(!nome.matches("^[a-zA-Z\\s]+$")){
                    throw new CaracteresException();

                }
                if (!nome.contains(" ")){
                    throw new NomeInvalidException();


                }
                break;



            } catch (NomeInvalidException e) {
                System.out.println("Nome tem que conter nome e sobrenome");
            } catch (CaracteresException e) {
                System.out.println("Deve conter apenas letras");

            }


        }while(true);
    }
    private void solicitarTipoPet() {
       do{
           try{
               tipoPets = scanner.nextLine().toLowerCase();
               TipoPets tipoDePets = TipoPets.tipoPets1(tipoPets);
               if(tipoDePets == null ){
                   throw new TipoInvalidoException();
               }
               break;
           } catch (TipoInvalidoException e) {
               System.out.println("Apenas cachorro/gato e macho/femêa");
           }

       }while(true);
    }
    private void solicitarSexo() {
        do {
            try {
                 sexoPet = scanner.nextLine();
                SexoPet sexoPet1 = SexoPet.sexoPets(sexoPet);
                if(sexoPet1==null ){
                    throw new SexoException();
                }
                break;
            } catch (SexoException e) {
                System.out.println("Apenas macho/femea");
            }
        }while(true);
    }
    private void solicitarIdade()  {
        do {
            try{
                idade = scanner.nextLine();
                double idadeEmNumero;
                if(idade.isEmpty()){
                    idade = "Não informado";
                    idadeEmNumero = -1;

                }else{
                    try{
                        idadeEmNumero = Double.parseDouble(idade);

                    }catch (NumberFormatException e){
                        System.out.println("Número inválido");
                        continue;
                    }
                }
                if(idadeEmNumero > 20){
                    throw new IdadeExeception();
                }else if(idadeEmNumero > 0 && idadeEmNumero < 1){
                    double calculo = idadeEmNumero * 10;
                    idade = String.format("%.1f mes(es)",calculo);

                }
                break;

            }catch (IdadeExeception e) {
                System.out.println("Idade até 20");
            }
        }while (true);
    }
    private void solicitarEndereco(){

            System.out.println("Cidade:");
            cidade = scanner.nextLine();
            System.out.println("Rua:");
        String rua = scanner.nextLine();
            System.out.println("Número da residência");
        String numero = scanner.nextLine();
            if(numero.isEmpty()){
                numero = "Não informado";
            }
            endereco = String.format("Cidade: %s/Rua: %s/Número da residência %s",cidade, rua, numero);



    }
    private void solicitarRaca()  {
        do {
            try{
                raca = scanner.nextLine();
                if(raca.isEmpty()){
                    raca = "Não informado";
                    break;
                }
                if(!raca.matches("[a-zA-Z\\s]+")){
                    throw new CaracteresException();
                }
                break;
            } catch (CaracteresException e) {
                System.out.println("Apenas letras");
            }
        }while (true);

    }
    private void solicitarPeso() {
        do {
            try{
                peso = scanner.nextLine();
                double pesoEmKg;
                if(peso.isEmpty()){
                    peso = "Não informado";
                    pesoEmKg = -1;
                    break;
                }else{
                    try{
                        pesoEmKg = Double.parseDouble(peso);

                    }catch (NumberFormatException e){
                        System.out.println("Número inválido");
                        continue;
                    }
                }
                if(pesoEmKg > 60 || pesoEmKg <= 0.5){
                    throw new PesoException();

                }
                break;
            } catch (PesoException e) {
                System.out.println("Peso máximo permitido (60Kg)");
            }

        }while(true);

    }
    //====================Métodos de Classe=========================
    @Override
    public String toString() {
        return  "------------------------\n"+
        "nome e sobrenome: "+nome+"\n"+
        "tipo: "+ tipoPets +"\n"+
        "sexo: "+sexoPet+"\n"+
        "idade: "+idade+"\n"+
        "peso: "+peso+"\n"+
        "raça: "+raca+"\n"+
        "numero de cadastro do pet: "+ NUMBER_PET +"\n"+
        "--------------------------";

    }

    public String getNome() {
        return nome;
    }

    public String getTipoPets() {
        return tipoPets;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public String getIdade() {
        return idade;
    }
    public String getPeso() {
        return peso;
    }
    public String getRaca() {
        return raca;
    }
    public String getCidade() {
        return cidade;
    }
    public int getNUMBER_PET() {
        return NUMBER_PET;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
