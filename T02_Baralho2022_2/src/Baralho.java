import java.util.Random;

public class Baralho {
    private Carta[] cartas;
    private int proxLivre;

    public Baralho() {
        cartas = new Carta[52];
        proxLivre = 0;

        Naipe[] naipes = Naipe.values();
        Valor[] valores = Valor.values();

        for (int i = 0; i < naipes.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                Carta carta = new Carta(naipes[i], valores[j]);
                cartas[proxLivre] = carta;
                proxLivre++;
            }
        }
    }

    // Embaralha as cartas que estão no arranjo
    public void embaralha() {
        Random r = new Random();
        for(int i=0;i<2000;i++){
            int pos = r.nextInt(proxLivre);
            Carta aux = cartas[0];
            cartas[0] = cartas[pos];
            cartas[pos] = aux;
        }
    }

    // Retira a carta que esta "em cima" do baralho e retorna
    // Podem considerar a que esta "em cima" como sendo a última do arranjo
    // Retorna null se o arranjo estiver vazio
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
}
