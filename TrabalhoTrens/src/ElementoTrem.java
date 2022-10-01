public abstract class ElementoTrem{
    private int codigo;
    private double cap_max;
    private Trem trem;
    private boolean livre;
    private static int ultimoId = 0;

    public ElementoTrem(double cap_max) {
        this.codigo = ultimoId + 1;
        ultimoId = this.codigo;
        this.cap_max = cap_max;
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
    public double getCap_max() {
        return cap_max;
    }
    public void setCap_max(double cap_max) {
        this.cap_max = cap_max;
    }
    public Trem getTrem() {
        return trem;
    }
    public void setTrem(Trem trem) {
        this.trem = trem;
    }
    @Override
    public String toString() {
        return "ElementoTrem [cap_max=" + cap_max + ", codigo=" + codigo + ", trem=" + trem + "]";
    }
}