import java.util.Scanner;

public class App{
    public static void main(String args[]){
        Placa placas[] = new Placa[5];
        Veiculo veiculos[] = new Veiculo[5];
        Scanner s = new Scanner(System.in);
        
        String opcao;
        placas[0] = new Placa("Brasil", "ABC1E23");
        placas[1] = new Placa("Brasil", "ABC2E23");
        placas[2] = new Placa("Brasil", "ABC3E23");
        placas[3] = new Placa("Brasil", "ABC4E23");
        placas[4] = new Placa("Brasil", "ABC5E23");
        
        for(int i=0;i<5;i++){
            veiculos[i] = new Veiculo(placas[i]);
            System.out.println(veiculos[i]);
        }
        System.out.println("Entre com o número de uma opção: \n 1 - Abastecer \n 2 - Dirigir \n 3 - Fim");
        opcao = s.nextLine();

        


        // Veiculo v = new Veiculo(p1);
        // System.out.println("Dados do veiculo antes de abastecer:");
        // System.out.println(v);
        // System.out.println("----------------");

        // v.abastece(65);
        // System.out.println("Dados do veiculo depois de abastecer:");
        // System.out.println(v);
        // System.out.println("----------------");

        // v.dirige(250);
        // System.out.println("Dados do veiculo depois de percorrer 250Km:");
        // System.out.println(v);
        // System.out.println("----------------");

        // Placa p2 = new Placa(null, "ABC3E45");
        // System.out.println(p2.getPais());
        }
}
