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
            System.out.println("\nEscolha uma acao a realizar: \n 1 - "+ 
            "Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;\n 0 - Sair\n");
            escolha = s.nextInt();
         switch(escolha){
            //Criar Trem
             case 1:
             // verificar se locomotiva ja foi adicionada em outro trem
             // ta permitindo pegar a mesma locomotiva para cadastro em outros trens
                 int idLocomotiva;
                 System.out.println("Digite o id da locomotiva a ser adicionada ao Trem: ");
                 Scanner i = new Scanner(System.in);
                 idLocomotiva = i.nextInt();
                 idLocomotiva--;
                 //Verifica o Estado da Locomotiva
                 if(locomotivas.get(idLocomotiva).getEstado() == true){
                    trens.add(new Trem(locomotivas.get(idLocomotiva)));
                    locomotivas.get(idLocomotiva).setEstado(false);
                    System.out.println("Trem Criado com Sucesso");
                 }else{
                    System.out.println("Locomotiva ja esta em uso em outro trem");
                 }
                 break;
             case 2:
             //Editar Trem
                int idTrem = 0;
                Scanner l = new Scanner(System.in);
                System.out.println("Digite o id do Trem a ser editado: ");
                idTrem = l.nextInt();
                Trem t = null;
                //verifica o idTrem é o mesmo passado
                for(int z = 0; z < trens.size(); z++){
                    if(trens.get(z).getID() == idTrem){
                        t = trens.get(z);
                        break;
                    }
                }
                System.out.println("> "+t+"\n");
                int opc = 0;
                l.reset();
                do{
                    System.out.println("Escolha uma acao a realizar: \n 1 - Inserir uma Locomotiva\n 2 - Inserir um Vagao"+
                            "\n 3 - Remover o ultimo Item \n 4 - Listar as Locomotivas Livres \n 5 - Listar vagões Livres \n 6 - Encerrar a Edição");
                    opc = l.nextInt();

                    switch(opc){
                        //inserir locomotiva
                        case 1:
                            int idLoc;
                            System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                            idLoc = l.nextInt();
                            idLoc--;
                            //Verifica o estado da locomotiva
                            if(locomotivas.get(idLoc).getEstado() == true){
                                t.engataLocomotiva(locomotivas.get(idLoc));
                                locomotivas.get(idLoc).setEstado(false);
                                System.out.println("> "+t);
                                System.out.println("(Inserido) -> "+locomotivas.get(idLoc).toString());
                            }else{
                                System.out.println("Nao e possivel utilizar essa locomotiva");
                            }
                            l.reset();
                        break;
                        //Insere Vagao
                        case 2:
                            int idVag;
                            System.out.println("Digite o id do Vagao a ser adicionada ao Trem:");
                            idVag = l.nextInt();
                            idVag--;
                            t.engataVagao(vagoes.get(idVag));
                            System.out.println("> "+t);
                            System.out.println("(Inserido) ->"+vagoes.get(idVag).toString());
                        break;
                        //Remove Ultimo Item
                        case 3:
                        //verifica se é os vagoes estão vazios, seguido da locomotiva, caso não tenha mais locomotivas, desfaz o trem
                            if(t.getQuantidadeVagoes() > 0){
                                System.out.println("(Removido Vagao) -> "+t.getVagaoPosicao(t.getQuantidadeVagoes()-1));
                                t.desengataVagao();
                            }else if(t.getQntLocomotivas() >= 0){
                                System.out.println("(Removida Locomotiva) -> "+t.getLocomotivaPosicao(t.getQntLocomotivas()-1));
                                t.desengataLocomotiva();
                                if(t.getQntLocomotivas() == 0){
                                    System.out.println("(Removido Trem) ->"+t);
                                    trens.remove(t);
                                    opc = 6;
                                }
                            }
                        break;
                        //Listar Locomotivas Livres
                        case 4:
                        System.out.println("\nListagem das Locomotivas Livres:\n");
                            for(int z = 0; z < locomotivas.size(); z++){
                                if(locomotivas.get(z).getEstado() == true){
                                    System.out.println(locomotivas.get(z));
                                }
                            }
                        System.out.println("Fim !");
                        break;
                        //Listar todos os Vagões Livres
                        case 5:
                        System.out.println("\nListagem dos Vagoes Livres:\n");
                            for(int z = 0; z < vagoes.size(); z++){
                                if(vagoes.get(z).getEstado() == true){
                                    System.out.println(vagoes.get(z));
                                }
                            }
                        System.out.println("Fim !");
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
            System.out.println("Listagem dos Trens: ");
                for(int h = 0; h < trens.size(); h++){
                    System.out.println(trens.get(h));
                }
            System.out.println("Fim !");
            break;
             case 4:
             //Remover trem
                System.out.println("Digite o id do Trem a ser Removido: ");
                l = new Scanner(System.in);
                idTrem = l.nextInt();
                t = null;
                //Compara o id do Trem com o id passado
                for(int z = 0; z < trens.size(); z++){
                    if(trens.get(z).getID() == idTrem){
                        t = trens.get(z);
                        break;
                    }
                }
                System.out.println("> "+t.toString());
                if(t.getQuantidadeVagoes() != 0){
                    while(t.getQuantidadeVagoes() > 0){
                        t.desengataVagao();
                        if(t.getQuantidadeVagoes() == 0){
                            System.out.println("Todos Vagoes foram removidos com sucesso");
                        }
                    }
                }else if(t.getQntLocomotivas() != 0){
                    while(t.getQntLocomotivas() > 0){
                        t.desengataLocomotiva();
                        if(t.getQntLocomotivas() == 0){
                            System.out.println("Todas Locomotivas foram removidas com sucesso");
                            System.out.println("(Removido Trem) -> "+t);
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
        System.out.println("Encerrando o Programa...");
    }
}
