import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Cofrinho cofre = new Cofrinho();
        NomeMoeda nomeMoedas[] = NomeMoeda.values();
        
        for(int i = 0;i<50;i++){
            Random r = new Random();
            int id = r.nextInt(nomeMoedas.length);
            Moeda moeda = new Moeda(nomeMoedas[id]);
            cofre.insereMoeda(moeda);
        }
        
        System.out.println(cofre.getQtdeMoedas());
        System.out.println(cofre.getValorTotalCentavos());
        System.out.print(cofre.retira().getValorCentavos());

    }
    
}
