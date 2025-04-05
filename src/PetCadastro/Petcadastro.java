package PetCadastro;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Petcadastro extends Pet{
    private final List<Pet> petList;
    Scanner scanner = new Scanner(System.in);
    public Petcadastro() {
        this.petList = new ArrayList<>();

    }
    public  void adiconarPet(Pet pet){
        petList.add(pet);
    }
    public void imprimirlista(){
        if(!petList.isEmpty()){
            for (Pet x : petList){
                System.out.println(x);
            }
        }else{
            System.out.println("Nenhum pet cadastrado");
        }

    }
    public List<Pet> buscarPetNome(String nome, String tipo){
        List<Pet> listaPorNome =  new ArrayList<>();
        if(!petList.isEmpty()){
            for(Pet x: petList){
                if(x.getNome().equalsIgnoreCase(nome)||x.getNome().contains(nome)&& x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorNome.add(x);

                }

            }

        }
        return listaPorNome;
    }
    public List<Pet> buscaporSexo(String sexo, String tipo){
        List<Pet> listaPorSexo = new ArrayList<>();
        if(!petList.isEmpty()) {
            for (Pet x: petList){
                if(x.getSexoPet().equalsIgnoreCase(sexo) && x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorSexo.add(x);
                }
            }
        }
        return listaPorSexo;
    } public List<Pet> buscaporIdade(String idade, String tipo){
        List<Pet> listaPorIdade= new ArrayList<>();
        if(!petList.isEmpty()) {
            for (Pet x: petList){
                if(x.getIdade().equalsIgnoreCase(idade) && x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorIdade.add(x);
                }
            }
        }
        return listaPorIdade;
    }public List<Pet> buscaporPeso(String peso, String tipo){
        List<Pet> listaPorPeso= new ArrayList<>();
        if(!petList.isEmpty()) {
            for (Pet x: petList){
                if(x.getPeso().equalsIgnoreCase(peso)&& x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorPeso.add(x);
                }
            }
        }
        return listaPorPeso;
    }public List<Pet> buscaporRaca(String raca, String tipo){
        List<Pet> listaPorRaca= new ArrayList<>();
        if(!petList.isEmpty()) {
            for (Pet x: petList){
                if(x.getRaca().equalsIgnoreCase(raca)|| x.getRaca().contains(raca)&& x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorRaca.add(x);
                }
            }
        }
        return  listaPorRaca;

    }
    public List<Pet> buscaporCidade(String endereco, String tipo){
        List<Pet> listaPorCidade= new ArrayList<>();
        if(!petList.isEmpty()) {
            for (Pet x: petList){
                if(x.getCidade().equalsIgnoreCase(endereco)|| x.getCidade().contains(endereco)&& x.getTipoPets().equalsIgnoreCase(tipo)){
                    listaPorCidade.add(x);
                }
            }
        }
        return  listaPorCidade;

    }
    public Pet alterarPet(int number, String nome, String idade, String peso, String cidade){
        if(!petList.isEmpty()){
            for(Pet pet : petList){
                if(pet.getNUMBER_PET() == number){
                    pet.setNome(nome);
                    pet.setIdade(idade);
                    pet.setPeso(peso);
                    pet.setCidade(cidade);
                    return pet;

                } else if (pet.getNUMBER_PET() != number || pet.getNUMBER_PET() < 0 || pet.getNUMBER_PET() == 0 ) {
                    System.out.println("Digite o número novamente!");
                    String numerodigit = scanner.nextLine();

                    number =  Integer.parseInt(numerodigit);
                    if(pet.getNUMBER_PET() == number){
                        pet.setNome(nome);
                        pet.setIdade(idade);
                        pet.setPeso(peso);
                        pet.setCidade(cidade);
                    }
                    return pet;
                }

            }
        }
        return null;
    }
    public void removerPetNumber(int numeroPassado, String tipo){
        List<Pet> listRemovePet = new ArrayList<>();
        if(!petList.isEmpty()){
            for(Pet x: petList){
                if(x.getNUMBER_PET() == numeroPassado && x.getTipoPets().equalsIgnoreCase(tipo)){
                    listRemovePet.add(x);

                }

            }
            petList.removeAll(listRemovePet);
        }

    }

}