public class Locomotiva extends ElementoTrem{
    private int nroMaxVagoes;

    public Locomotiva(double capacidadeMaxima, int nroMaxVagoes) {
        super(capacidadeMaxima);
        this.nroMaxVagoes = nroMaxVagoes;
    }
    
    
    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }

    @Override
    public String toString() {
        return "Id Locomotiva: "+super.getCodigo()+" | Capacidade Max: "+getCapacidadeMaxima();
    }
    
}
