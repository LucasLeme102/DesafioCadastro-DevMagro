package repository;

public enum SexoPet {
    MACHO("macho"),
    FEMEA("femea");
    private String sexo;

     SexoPet(String tipo) {
        this.sexo = tipo;
    }
    public static SexoPet sexoPets(String sexo){
        for (SexoPet x: values()){
            if(x.getSexo().equals(sexo)){
                return x;
            }
        }
        return null;
    }

    public String getSexo() {
        return sexo;
    }
}
