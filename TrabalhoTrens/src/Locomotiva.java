public class Locomotiva {
    private int id;
    private double pesoMax;
    private int nroMaxVagoes;
    private Trem trem;
    private static int ultimoId = 0;
    private boolean livre;

    public Locomotiva(double pesoMax, int nroMaxVagoes) {
        this.id = ultimoId + 1;
        ultimoId = this.id;
        this.pesoMax = pesoMax;
        this.nroMaxVagoes = nroMaxVagoes;
        this.livre = true;
    }
    
    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    public void setEstado(boolean livre){
        this.livre = livre;
    }


    public boolean getEstado(){
        return this.livre;
    }
    
    public int getId() {
        return id;
    }
    public double getPesoMax() {
        return pesoMax;
    }
    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }
    public Trem getTrem() {//Não seria num_identificador do trem, no uml ta como int
        return trem;
    }
    public String toString(){
        return "ID: "+this.id+" | Peso Max: "+this.pesoMax+" | Nro Max de Vagoes: "+this.nroMaxVagoes+ " | Livre: "+getEstado();
    }
    
}
