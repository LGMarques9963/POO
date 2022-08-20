import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Cofrinho cofre = new Cofrinho();
        NomeMoeda nomeMoedas[] = NomeMoeda.values();
        NomeMoeda umReal = NomeMoeda.UmReal;
        NomeMoeda cinqCentavos = NomeMoeda.Cinquenta;
        Scanner s = new Scanner(System.in);
        
        int TOTAL_INSERIR = 10;
        int contador = 0;
        String escolha;

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

        
        
        /* EXERCÍCIO EXTRA */
        /* O CÓDIGO NÃO ESTÁ SAINDO DO LOOP DO WHILE, NÃO IDENTIFIQUEI O MOTIVO */
        
        Cofrinho cofreExtra = new Cofrinho();
        escolha = "";

        while(escolha.toUpperCase() != "Q"){
            System.out.println("Entre com o comando desejado (I = Inserir; R = Retirar; Q = Sair)");
            escolha = s.nextLine();

            switch(escolha.toUpperCase()){
                case "I":
                    System.out.println("Quantas moedas deseja inserir?");
                    TOTAL_INSERIR = s.nextInt();
                    contador = 0;

                    for(int i = 0;i<TOTAL_INSERIR;i++){
                        Random r = new Random();
                        int id = r.nextInt(nomeMoedas.length);
                        Moeda moeda = new Moeda(nomeMoedas[id]);
                        cofreExtra.insereMoeda(moeda);
                        contador++;
                    }
                    System.out.println("Foram inseridas " + contador + " moedas no cofre. \nHá, no momento, " + cofreExtra.getValorTotalReais() + " reais guardados.");
                    break;

                case "R":
                    System.out.println("Quantas moedas deseja retirar?");
                    TOTAL_INSERIR = s.nextInt();
                    contador = 0;
                    if(TOTAL_INSERIR > cofreExtra.getQtdeMoedas()){
                        System.out.println("Não há essa quantidade de moedas para retirar");
                    }else{
                        for(int i = 0;i<TOTAL_INSERIR;i++){
                            cofreExtra.retira();
                            contador++;
                        }
    
                        System.out.println("Foram retiradas " + contador + " moedas no cofre. \nHá, no momento, " + cofreExtra.getValorTotalReais() + " reais guardados.");
                    }
                    break;
                case "Q":
                    break;
                default:
                     System.out.println("Comando inválido!!");
                

            }
            
        }s.close();
        


    }
    
}
