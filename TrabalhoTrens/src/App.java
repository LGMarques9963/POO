import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        GaragemLocomotiva garagemLocomotiva = new GaragemLocomotiva();
        ArrayList<Vagao> vagoes = new ArrayList<>();
        
        ArrayList<Locomotiva> locomotivas = new ArrayList<>();
        ArrayList<Trem> trens = new ArrayList<>();
        int escolha;
        Trem tremTeste;

        for(int i=0;i<=30;i++){
            Random r = new Random();
            garagemLocomotiva.entraLocomotiva(new Locomotiva((r.nextInt(100)*10/2), r.nextInt(i+10)));
            vagoes.add(new Vagao((r.nextInt(100)*10/2)));
        }
        locomotivas = garagemLocomotiva.getLocomotivas();
        trens.add(new Trem(locomotivas.get(1)));
        tremTeste = trens.get(0);
        System.out.println(tremTeste.engataLocomotiva(locomotivas.get(2)));
        System.out.println(tremTeste.engataLocomotiva(locomotivas.get(2)));
        System.out.println(tremTeste.desengataLocomotiva());
        System.out.println(locomotivas.get(2).getTrem());
        //verififcar se não esta pasando uma caracter invalido
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Escolha uma ação a realizar: \n 1 -"+ 
            "Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;\n 0 - Sair");
            escolha = s.nextInt();
         switch(escolha){
             case 1:
             // verificar se locomotiva ja oi adicionada em outro trem
                 int idLocomotiva;
                 System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                 Scanner i = new Scanner(System.in);
                 idLocomotiva = i.nextInt();
                 System.out.println(locomotivas.get(idLocomotiva-1).toString());
                 trens.add(new Trem(locomotivas.get(idLocomotiva)));
                 idLocomotiva = 0;
                 break;
             case 2:
                int idTrem;
                Scanner l = new Scanner(System.in);
                System.out.println("Digite o id do Trem a ser editado: ");
                idTrem = l.nextInt();
                System.out.println(trens.get(idTrem-1).toString());
                Trem t = trens.get(idTrem);
                int opc = 0;
                l.reset();
                do{
                    System.out.println("Escolha uma ação a realizar: \n 1 - Inserir uma Locomotiva\n 2 - Inserir um Vagao"+
                            "\n 3 - Remover o ultimo Vagao \n 4 - Listar as Locomotivas Livres \n 5 - Listar vagões Livres \n 6 - Encerrar a Edição");
                    opc = l.nextInt();

                    switch(opc){
                        case 1:
                        //não pode repetir a mesma locomotivva, conferir se a locomotiva não está em uso
                            int idLoc;
                            System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                            idLoc = l.nextInt();
                            idLoc = idLoc-1;
                            t.engataLocomotiva(locomotivas.get(idLoc));
                            System.out.println("Locomotiva :"+locomotivas.get(idLoc).toString() + "\nAdicionada ao Trem "+
                            t.toString());
                            l.reset();
                        break;
                        case 2:
                        //conferir se o trem existe
                            int idVag;
                            System.out.println("Digite o id d0 Vagao a ser adicionada ao Trem");
                            idVag = l.nextInt();
                            idVag = idVag-1;
                            t.engataVagao(vagoes.get(idVag));
                            System.out.println("Vagao :"+vagoes.get(idVag).toString() + "\nAdicionada ao Trem "+
                            t.toString());
                        break;
                        case 3:
                            if(t.getQuantidadeVagoes() > 0){
                                System.out.println("Quantity:"+ t.getQuantidadeVagoes());
                                t.desengataVagao();
                                System.out.println("Quantity:"+ t.getQuantidadeVagoes());
                            }else if(t.getQntLocomotivas() >= 0){
                                System.out.println("Locomotiva: removida com sucesso");
                                System.out.print("Qnt: "+t.getQntLocomotivas());
                                t.desengataLocomotiva();
                                System.out.println(" | Qnt: "+t.getQntLocomotivas());
                                if(t.getQntLocomotivas() == 0){
                                    System.out.println(trens.size());
                                    trens.remove(t);
                                    System.out.println(trens.size());
                                    System.out.println("Trem Removido com sucesso.");
                                }
                            }
                        break;
                        case 4:
                        break;
                        case 5:
                        break;
                        case 6:
                        break;
                    }
                }while(opc != 6);
                break;
             case 3:
                for(int h = 0; h < trens.size()-1; h++){
                    System.out.println(trens.get(h));
                }
                 break;
             case 4:
                 break;
             default:
                if(escolha != 0)System.out.println("Caracter digitado invalido !");
                break;
         }
        }while(escolha != 0);



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
