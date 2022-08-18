import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Cofrinho cofre = new Cofrinho();
        NomeMoeda nomeMoedas[] = NomeMoeda.values();
        NomeMoeda umReal = NomeMoeda.UmReal;
        NomeMoeda cinqCentavos = NomeMoeda.Cinquenta;

        final int TOTAL_INSERIR = 10;
        int contador = 0;

        for(int i = 0;i<TOTAL_INSERIR;i++){
            Random r = new Random();
            int id = r.nextInt(nomeMoedas.length);
            Moeda moeda = new Moeda(nomeMoedas[id]);
            cofre.insereMoeda(moeda);
            contador++;
        }
        
        System.out.println("Foram inseridas " + contador + " moedas no cofre. \nHá, no momento, " + cofre.getQtdeMoedas() + " moedas guardas.");
        System.out.println("Há " + cofre.getQtdeMoedasTipo(umReal) + " moedas de 1 real no cofre");
        System.out.println("Há " + cofre.getQtdeMoedasTipo(cinqCentavos) + " moedas de 50 centavos no cofre");
        System.out.println("Há " + cofre.getValorTotalCentavos() + " centavos no cofre");
        System.out.println("Há " + cofre.getValorTotalReais() + " reais no cofre");

        cofre.retira(); cofre.retira();

        System.out.println("Foram retiradas 2 moedas do cofre.\nAgora há " + cofre.getValorTotalCentavos() + " centavos no cofre");


    }
    
}
