public class Vagao extends ElementoTrem{
    private boolean livre;
    public Vagao(double cap_max){
        super(cap_max);
        this.livre = true;
    }

    public boolean getEstado(){
        return this.livre;
    }

    public void setEstado(boolean livre){
        this.livre = livre;
    }

    public int getCodigo_Vagao(){
        return super.getCodigo();
    }
    public double getCapMax(){
        return super.getCap_max();
    }
    @Override
    public String toString(){
        return "Id Vagao: "+getCodigo_Vagao()+" | Capacidade Max: "+getCap_max();
    }
}
