public class Cofrinho{
    private int capacidade;
    private int proxLivre;
    private Moeda moedas[];

    public Cofrinho(int capacidade){
        this.capacidade = capacidade;
        moedas = new Moeda[this.capacidade];
    }

    public boolean insereMoeda(Moeda moeda){
        return true;
    }

    public Moeda retira(){
        return null;
    }

}