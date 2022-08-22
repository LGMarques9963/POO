import java.util.ArrayList;

public class Cofrinho{
    private int CAPACIDADE;
    private ArrayList<Moeda> moedas;

    public Cofrinho(int CAPACIDADE){
        this.CAPACIDADE = CAPACIDADE;
        moedas = new ArrayList<>(CAPACIDADE);
    }
    public Cofrinho(){
        this.CAPACIDADE = 100;
        moedas = new ArrayList<>(CAPACIDADE);
    }

    public int getCapacidade(){
        return this.CAPACIDADE;
    }

    public boolean insereMoeda(Moeda moeda){
        if(moedas.size() >= CAPACIDADE){
            return false;
        }else{
            moedas.add(moeda);
            return true;
        }
    }

    public Moeda retira(){
        return moedas.remove(moedas.size()-1);
    }

    public int getQtdeMoedas(){
        return moedas.size();
    }

    public int getQtdeMoedasTipo(NomeMoeda nomeMoeda){
        int moedasTipo = 0;

        for(Moeda m:moedas){
            if(m.getNomeMoeda().equals(nomeMoeda)) moedasTipo++;
        }

        return moedasTipo;
    }

    public int getValorTotalCentavos(){
        int valor = 0;
        for(Moeda m:moedas) valor = valor + m.getValorCentavos();
        return valor;
    }

    public double getValorTotalReais(){
        double valor = 0;
        for(Moeda m:moedas) valor = valor + m.getValorReais();
        return valor;
    }

    public String toString(){
        String aux = "[";
        for(int i=0;i<=moedas.size();i++) aux += moedas.get(i).getNomeMoeda().name()+",";
        aux += moedas.get(moedas.size()-1).getNomeMoeda().name()+"]";
        return aux;
    }

}