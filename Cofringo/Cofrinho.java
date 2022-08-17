public class Cofrinho{
    private final int CAPACIDADE = 500;
    private int proxLivre = 0;
    private Moeda moedas[];
    private int qtdeMoedas;

    public Cofrinho(){
        moedas = new Moeda[this.CAPACIDADE];
    }

    public int getCapacidade(){
        return this.CAPACIDADE;
    }

    public boolean insereMoeda(Moeda moeda){
        if(proxLivre>=CAPACIDADE){
            return false;
        }else{
            this.moedas[proxLivre] = moeda;
            this.qtdeMoedas++;
            this.proxLivre++;
            return true;
        }
    }

    public Moeda retira(){
        Moeda moedaRetirada;
        if(proxLivre <= 0){
            return null;
        }else{
            moedaRetirada = moedas[proxLivre-1];
            moedas[proxLivre] = null;
            proxLivre--;
            qtdeMoedas--;
            return moedaRetirada;
        }
    }

    public int getQtdeMoedas(){
        return this.qtdeMoedas;
    }

    public int getQtdeMoedasTipo(NomeMoeda nomeMoeda){
        int moedasTipo = 0;
        for(int i = 0;i<qtdeMoedas;i++){
            if (nomeMoeda == moedas[i].getNomeMoeda()){
                moedasTipo++;
            }
        }
        return moedasTipo;
    }

    public int getValorTotalCentavos(){
        int valor = 0;
        for(int i = 0;i<qtdeMoedas;i++){
            valor = valor + moedas[i].getValorCentavos();
        }
        return valor;
    }

    public double getValorTotalReais(){
        double valor = 0;
        for(int i = 0;i<qtdeMoedas;i++){
            valor = valor + moedas[i].getValorReais();
        }
        return valor;
    }
}