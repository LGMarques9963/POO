public class Carta {
    private Naipe naipe;
    private Valor valor;

    public Carta(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valor getValor() {
        return valor;
    }

    public boolean eMaiorQue(Carta outraCarta){
        if (this.getValor().ordinal() >= outraCarta.getValor().ordinal()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Carta [naipe=" + naipe + ", valor=" + valor + "]";
    }    
}
