public class Deque {
    public static final int TAM_MAX_DEQUE = 104;
    private Carta[] cartas;
    private int proxLivre;

    public Deque() {
        cartas = new Carta[TAM_MAX_DEQUE];
        proxLivre = 0;

    }

    public Carta topo() {
        if(proxLivre == 0){
            return null;
        }
        proxLivre--;
        Carta carta = cartas[proxLivre];
        cartas[proxLivre] = null;
        return carta;
    }

    public int getQtdadeCartas(){
        return proxLivre;
    }

    public String toString(){
        String aux = "Quantidade de cartas: "+getQtdadeCartas()+"\n";
        for(int i=0;i<proxLivre;i++){
            aux+= cartas[i].toString()+"\n";
        }
        return aux;
    }

    public void insereTopo(Carta carta){
        if(proxLivre >= TAM_MAX_DEQUE){
            return;
        }
        cartas[proxLivre] = carta;
        proxLivre++;
        
    }
}

