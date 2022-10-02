public class VagaoPassageiros extends Vagao{
    private int numeroPassageiros;
    private static final int pesoPassageiro = 70;

    public VagaoPassageiros(int numeroPassageiros){
        super(numeroPassageiros * pesoPassageiro);
        this.numeroPassageiros = numeroPassageiros;
    }

    public int getNumeroPassageiros() {
        return this.numeroPassageiros;
        
    }

    @Override
    public String toString(){
        return "Id Vagao: "+super.getCodigo()+" | Capacidade Max: "+getNumeroPassageiros() + " passageiros";
    }
}