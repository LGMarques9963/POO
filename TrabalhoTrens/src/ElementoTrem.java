public abstract class ElementoTrem{
    private int codigo;
    private double capacidadeMaxima;
    private Trem trem;
    private boolean livre;
    private static int ultimoId = 0;

    public ElementoTrem(double capacidadeMaxima) {
        this.codigo = ultimoId + 1;
        ultimoId = this.codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.trem = null;
        this.livre = true;
    }

    public boolean getEstado(){
        return this.livre;
    }

    public void setEstado(boolean livre){
        this.livre = livre;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public Trem getTrem() {
        return trem;
    }
    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    @Override
    public String toString() {
        return "ElementoTrem [cap_max=" + getCapacidadeMaxima() + ", codigo=" + getCodigo() + ", trem=" + getTrem() + "]";
    }
}