package repository;

public enum TipoPets {
   CACHORRO("cachorro"),
    GATO("gato");
   private String tipo;

    TipoPets(String tipo) {
        this.tipo = tipo;
    }
    public static TipoPets tipoPets1(String tipo){
        for (TipoPets x: values()){
            if(x.getTipo().equals(tipo)){
                return x;
            }
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }
}
