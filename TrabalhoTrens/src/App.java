import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Locomotiva> locomotivas = new ArrayList<>();
        ArrayList<Vagao> vagoes = new ArrayList<>();
        ArrayList<Trem> trens = new ArrayList<>();
        int escolha;

        for(int i=0;i<=30;i++){
            Random r = new Random();
            locomotivas.add(new Locomotiva((r.nextInt(100)*10/2), r.nextInt(i+10)));
            vagoes.add(new Vagao((r.nextInt(100)*10/2)));
        }

        // Scanner s = new Scanner(System.in);
        
        // System.out.println("Escolha uma ação a realizar: \n 1 - Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;");
        // escolha = s.nextInt();

        // switch(escolha){
        //     case 1:
        //         int idLocomotiva;
        //         System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
        //         Scanner i = new Scanner(System.in);
        //         idLocomotiva = i.nextInt();
        //         trens.add(new Trem(locomotivas.get(idLocomotiva)));
        //         i.close();
        //         break;
        //     case 2:
        //         break;
        //     case 3:
        //         break;
        //     case 4:
        //         break;
        //     default:
        //         break;
        // }



        Locomotiva l = new Locomotiva(500.00, 7);
        Vagao v = new Vagao(100);
        // Locomotiva l1 = new Locomotiva(450.00, 6);
        // Vagao v1 = new Vagao(70);
        Trem trem = new Trem(l);
        // Trem trem1 = new Trem(l1);
        // trem.engataLocomotiva(l1);
        trem.engataVagao(v);
        // // trem.engataLocomotiva(l);
        // // trem.engataVagao(v);
        // // trem.engataLocomotiva(l1);
        // // trem.engataVagao(v1);
        System.out.println(locomotivas.get(2).getId());
        System.out.println(trem.getQuantidadeVagoes());
        System.out.println(trem.getVagaoPosicao(0).getCapMax());
        // System.out.println(trem.getLocomotivaPosicao(1).getNroMaxVagoes());
    }
}
