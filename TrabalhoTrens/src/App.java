import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Locomotiva> locomotivas = new ArrayList<>();
        ArrayList<Vagao> vagoes = new ArrayList<>();
        
        for(int i=0;i<=30;i++){
            Random r = new Random();
            locomotivas.add(new Locomotiva((r.nextInt(100)*10/2), r.nextInt(i+10)));
            vagoes.add(new Vagao((r.nextInt(100)*10/2)));
        }

        


        // Locomotiva l = new Locomotiva(500.00, 7);
        // Vagao v = new Vagao(100);
        // Locomotiva l1 = new Locomotiva(450.00, 6);
        // Vagao v1 = new Vagao(70);
        // Trem trem = new Trem(l);
        // Trem trem1 = new Trem(l1);
        // trem.engataLocomotiva(l1);
        // trem.engataVagao(v);
        // // trem.engataLocomotiva(l);
        // // trem.engataVagao(v);
        // // trem.engataLocomotiva(l1);
        // // trem.engataVagao(v1);
        // System.out.println(trem.getVagaoPosicao(1).getCapMax());
        // System.out.println(trem.getLocomotivaPosicao(1).getNroMaxVagoes());
    }
}
