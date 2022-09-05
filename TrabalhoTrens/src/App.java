import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        GaragemLocomotiva garagemLocomotiva = new GaragemLocomotiva();
        GaragemVagoes garagemVagoes = new GaragemVagoes();
        GaragemTrem garagemTrem = new GaragemTrem();
        
        int escolha;
        Locomotiva locomotiva;
        Vagao vagao;
        Trem trem;

        for(int i=0;i<=30;i++){
            Random r = new Random();
            garagemLocomotiva.entraLocomotiva(new Locomotiva((r.nextInt(100)*(10/2)), r.nextInt(i+10)));
            garagemVagoes.entradaVagao(new Vagao(r.nextInt(50)*10/2));
        }

        
        //verififcar se não esta pasando uma caracter invalido
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("\nEscolha uma acao a realizar: \n 1 - "+ 
            "Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;\n 0 - Sair\n");
            escolha = s.nextInt();

            switch(escolha){
                //Criar Trem
                case 1:
                    System.out.println("Digite o id da locomotiva a ser adicionada ao Trem: ");
                    Scanner i = new Scanner(System.in);
                    locomotiva = garagemLocomotiva.getLocomotiva(i.nextInt());

                    garagemTrem.addTrem(new Trem(locomotiva));

                    break;

                //Editar Trem
                case 2:
                    Scanner l = new Scanner(System.in);
                    trem = null;
                    
                    do{
                        System.out.println("Digite o id do Trem a ser editado: ");
                        trem = garagemTrem.getTrem(l.nextInt());
                        if(trem == null) System.out.println("Trem não encontrado");
                        l.reset();                     
                    }while(trem==null);

                    System.out.println("> "+trem+"\n");
                
                    int opcao = 0;
                    do{
                        
                        System.out.println("Escolha uma acao a realizar: \n 1 - Inserir uma Locomotiva\n 2 - Inserir um Vagao"+
                                "\n 3 - Remover o ultimo Item \n 4 - Listar as Locomotivas Livres \n 5 - Listar vagões Livres \n 6 - Encerrar a Edição");
                                
                        opcao = l.nextInt();

                        switch(opcao){
                            //inserir locomotiva
                            case 1:

                                System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                                locomotiva = garagemLocomotiva.getLocomotiva(l.nextInt());

                                if(locomotiva == null){ System.out.println("Locomotiva não localizada\n"); }

                                else if(trem.engataLocomotiva(locomotiva)){
                                    garagemLocomotiva.removeLocomotiva(locomotiva);
                                    System.out.println("> "+trem);
                                    System.out.println("(Inserido) -> "+locomotiva.toString());
                                }else{
                                    System.out.println("Nao é possivel utilizar essa locomotiva\n");
                                }

                                l.reset();
                            break;
                            
                            //Insere Vagao
                            case 2:
                                System.out.println("Digite o id do Vagao a ser adicionada ao Trem:");
                                vagao = garagemVagoes.getVagao(l.nextInt());
                                
                                if(vagao == null) { System.out.println("Vagão não localizado\n"); }
                                else if(trem.engataVagao(vagao)){
                                    System.out.println("> "+trem);
                                    System.out.println("(Inserido) ->"+vagao.toString());
                                }

                            break;

                            //Remove Ultimo Item
                            case 3:
                            //verifica se é os vagoes estão vazios, seguido da locomotiva, caso não tenha mais locomotivas, desfaz o trem
                                if(trem.getQuantidadeVagoes() > 0){
                                    if(!trem.desengataVagao()) System.out.println("Erro ao desengatar vagao");
                                }else if(trem.getQntLocomotivas() >= 0){
                                    if(!trem.desengataLocomotiva()) System.out.println("Erro ao desengatar locomotiva");
                                    
                                    if(trem.getQntLocomotivas() == 0){
                                        if(garagemTrem.removeTrem(trem)) {
                                            System.out.println("(Removido Trem) ->"+trem);
                                            opcao = 6;
                                        }
                                    }
                                }
                            break;
                            
                            //Listar Locomotivas Livres
                            case 4:
                                System.out.println("\nListagem das Locomotivas Livres:\n");
                                garagemLocomotiva.listarLocomotivas();
                                break;

                            //Listar todos os Vagões Livres
                            case 5:
                                System.out.println("\nListagem dos Vagoes Livres:\n");
                                garagemVagoes.listarVagoes();
                            break;

                            default:
                                if(opcao != 6){
                                    System.out.println("Escolha uma opcao valida !");
                                }
                            break;
                        }
                    }while(opcao != 6);
                break;

            //Listar Trens
            case 3:
                System.out.println("Listagem dos Trens: ");
                garagemTrem.listarTrens();
            break;

            //Remover trem
            case 4:
                trem = null;

                do{

                    System.out.println("Digite o id do Trem a ser Removido: ");
                    l = new Scanner(System.in);
                    
                    trem = garagemTrem.getTrem(l.nextInt());

                    if(trem==null) System.out.println("Trem não localizado!");

                    l.reset();
                    
                }while(trem==null);

                System.out.println("> "+trem.toString());

                if(trem.removerTrem() & garagemTrem.removeTrem(trem)) System.out.println("(Removido Trem) -> "+trem);
                
                break;
             default:
                if(escolha != 0)System.out.println("Caracter digitado invalido !");
                break;
         }
        }while(escolha != 0);

        s.close();
        System.out.println("Encerrando o Programa...");
    }
}
