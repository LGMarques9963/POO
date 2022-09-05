import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        GaragemLocomotiva garagemLocomotiva = new GaragemLocomotiva();
        GaragemVagoes garagemVagoes = new GaragemVagoes();

        
        ArrayList<Trem> trens = new ArrayList<>();
        ArrayList<Locomotiva> locomotivas = new ArrayList<>();//<-Ta aqui o erro do id da Locomotiva
        ArrayList<Vagao> vagoes = new ArrayList<>();
        
        int escolha;

        for(int i=0;i<=30;i++){
            Random r = new Random();
            garagemLocomotiva.entraLocomotiva(new Locomotiva((r.nextInt(100)*10/2), r.nextInt(i+10)));//<-Ta aqui o erro do id da Locomotiva
            //vagoes.add(new Vagao((r.nextInt(50)*10/2)));
            garagemVagoes.entradaVagao(new Vagao(r.nextInt(50)*10/2));
        }
        locomotivas = garagemLocomotiva.getLocomotivas();
        vagoes = garagemVagoes.getVagoes();
        //verififcar se não esta pasando uma caracter invalido
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Escolha uma ação a realizar: \n 1 -"+ 
            "Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;\n 0 - Sair");
            escolha = s.nextInt();
         switch(escolha){
             case 1:
             // verificar se locomotiva ja oi adicionada em outro trem
             // ta permitindo pegar a mesma locomotiva para cadastro em outros trens
                 int idLocomotiva;
                 System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                 Scanner i = new Scanner(System.in);
                 idLocomotiva = i.nextInt();
                 if(locomotivas.get(idLocomotiva).getEstado() == true){
                    System.out.println(locomotivas.get(idLocomotiva-1).toString());//<-corrigir
                    trens.add(new Trem(locomotivas.get(idLocomotiva)));
                    locomotivas.get(idLocomotiva).setEstado(false);
                 }else{
                    System.out.println("Locomotiva ja esta em uso em outro trem");
                 }
                 idLocomotiva = 0;
                 break;
             case 2:
             //Editar Trem
                int idTrem = 0;
                Scanner l = new Scanner(System.in);
                System.out.println("Digite o id do Trem a ser editado: ");
                idTrem = l.nextInt();
                System.out.println(idTrem);
                idTrem--;
                System.out.println(trens.get(idTrem).toString());//<-
                Trem t = trens.get(idTrem);
                int opc = 0;
                l.reset();
                do{
                    System.out.println("Escolha uma ação a realizar: \n 1 - Inserir uma Locomotiva\n 2 - Inserir um Vagao"+
                            "\n 3 - Remover o ultimo Vagao \n 4 - Listar as Locomotivas Livres \n 5 - Listar vagões Livres \n 6 - Encerrar a Edição");
                    opc = l.nextInt();

                    switch(opc){
                        //inserir locomotiva
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
                        //Insere Vagao
                        case 2:
                        //conferir se o trem existe
                            int idVag;
                            System.out.println("Digite o id do Vagao a ser adicionada ao Trem");
                            idVag = l.nextInt();
                            idVag--;
                            t.engataVagao(vagoes.get(idVag));
                            System.out.println("Vagao :"+vagoes.get(idVag).toString() + "\nAdicionada ao Trem "+
                            t.toString());
                        break;
                        case 3:
                        //conferir se a locomotiva e vagao existe
                        //System.out.println(t.getLocomotivaPosicao(1).getId());
                            if(t.getQuantidadeVagoes() > 0){
                                System.out.println("Vagao id: "+t.getVagaoPosicao(t.getQuantidadeVagoes()-1).getId()+" removido com sucesso");
                                t.desengataVagao();
                            }else if(t.getQntLocomotivas() >= 0){
                                System.out.println("Locomotiva id: "+t.getLocomotivaPosicao(t.getQntLocomotivas()-1)+" removida com sucesso");
                                System.out.print("Qnt: "+t.getQntLocomotivas());
                                t.desengataLocomotiva();
                                System.out.println(" | Qnt: "+t.getQntLocomotivas());
                                if(t.getQntLocomotivas() == 0){
                                    trens.remove(t);
                                    System.out.println("Trem id: "+t.getID()+" Removido com sucesso.");
                                    opc = 6;
                                }
                            }
                        break;
                        //Listar Locomotivas Livres
                        case 4:
                            for(int z = 0; z < locomotivas.size(); z++){
                                if(locomotivas.get(z).getEstado() == true){
                                    System.out.println(locomotivas.get(z));
                                }
                            }
                        break;
                        //Listar todos os Vagões Livres
                        case 5:
                            for(int z = 0; z < vagoes.size(); z++){
                                if(vagoes.get(z).getEstado() == true){
                                    System.out.println(vagoes.get(z));
                                }
                            }
                        break;
                        default:
                            if(opc != 6){
                                System.out.println("Escolha uma opcao valida !");
                            }
                        break;
                    }
                }while(opc != 6);
                t = null;
                break;
            //Listar Trens
             case 3:
                for(int h = 0; h < trens.size(); h++){
                    System.out.println(trens.get(h));
                }
                 break;
             case 4:
             //Remover trem
                System.out.println("Digite o id do Trem a ser Removido: ");
                l = new Scanner(System.in);
                idTrem = l.nextInt();
                t = null;
                idTrem--;
                System.out.println(idTrem);
                for(int z = 0; z < trens.size(); z++){
                    System.out.println(z+ " - "+trens.get(z).getID());
                }
                //System.out.println(trens.get(idTrem));
                //System.out.println(trens.get(idTrem-1));
                //if(trens.size() == 1) idTrem++;
                t = trens.get(idTrem);//<--erro
                System.out.println(t.toString());
                if(t.getQuantidadeVagoes() != 0){
                    while(t.getQuantidadeVagoes() > 0){
                        t.desengataVagao();
                        if(t.getQuantidadeVagoes() == 0){
                            System.out.println("Todos Vagoes fora removidos com sucesso");
                        }
                    }
                }else if(t.getQntLocomotivas() != 0){
                    while(t.getQntLocomotivas() > 0){
                        t.desengataLocomotiva();
                        if(t.getQntLocomotivas() == 0){
                            System.out.println("Todas Locomotivas foram removidas com sucesso");
                            System.out.println("Trem id "+t.getID()+" removido com sucesso");
                            //t = null;
                            trens.remove(t);
                        }
                    }
                }
                
                 break;
             default:
                if(escolha != 0)System.out.println("Caracter digitado invalido !");
                break;
         }
        }while(escolha != 0);
    }
}
