public class Locomotiva extends ElementoTrem{
    private int nroMaxVagoes;
    private boolean livre;

    public Locomotiva(double cap_max, int nroMaxVagoes) {
        super(cap_max);
        this.nroMaxVagoes = nroMaxVagoes;
        this.livre = true;
    }
    
    public void setEstado(boolean livre){
        this.livre = livre;
    }
    public double getCap_Max_Locomotiva(){
        return super.getCap_max();
    }

    public boolean getEstado(){
        return this.livre;
    }
    
    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }

    @Override
    public String toString() {
        return "Locomotiva [livre=" + livre + ", nroMaxVagoes=" + nroMaxVagoes + "]";
    }
    
}
