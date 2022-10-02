//import java.util.Random;
import java.util.Scanner;

public class App {
    public static int lerOpcao(Scanner s){
        boolean isString;
        do{
            try{
                return s.nextInt();
            }catch(java.util.InputMismatchException e){
                System.out.println("Insira um valor inteiro");
                isString = true;
            }finally{
                s.nextLine();
            }  
        }while(isString);
        
        return -1;
    }
    public static void main(String[] args) throws Exception {
        
        GaragemTrem garagemTrem = new GaragemTrem();
        
        Garagem garagem = new Garagem();
        int escolha;
        Locomotiva locomotiva;
        Vagao vagao;
        Trem trem;

        Scanner s = new Scanner(System.in);
        
        garagem.adicionaElemento(new Locomotiva(4.5, 6));
        garagem.adicionaElemento(new Locomotiva(4.5, 6));
        garagem.adicionaElemento(new Locomotiva(4.5, 6));
        garagem.adicionaElemento(new Locomotiva(4.5, 6));
        garagem.adicionaElemento(new Vagao(1));
        garagem.adicionaElemento(new Vagao(1));
        garagem.adicionaElemento(new Vagao(1));
        garagem.adicionaElemento(new Vagao(1));
        /*for(int i=0;i<=30;i++){
            Random r = new Random();
            garagem.adicionaElemento(new Vagao(r.nextInt(50)*10/2));
        }*/

        do{
            System.out.println("\nEscolha uma acao a realizar: \n 1 - "+ 
                                "Criar um Trem;\n 2 - Editar um Trem;\n 3 - Listar todos os Trens;\n 4 - Desfazer um Trem;\n 0 - Sair\n");
            escolha = lerOpcao(s);

            switch(escolha){
                //Criar Trem
                case 1:
                    
                    locomotiva = null;

                    do{
                        System.out.println("Digite o id da locomotiva a ser adicionada ao Trem: ");
                        locomotiva = (Locomotiva) garagem.getElemento(lerOpcao(s));
                        if(locomotiva == null) System.out.println("Locomotiva não encontrada");
                        
                    }while(locomotiva == null);

                    garagemTrem.addTrem(new Trem(locomotiva));

                    break;

                //Editar Trem
                case 2:
                    trem = null;
                    
                    do{
                        System.out.println("Digite o id do Trem a ser editado: ");
                        trem = garagemTrem.getTrem(lerOpcao(s));
                        if(trem == null) System.out.println("Trem não encontrado");                  
                    }while(trem==null);

                    System.out.println("> "+trem+"\n");
                
                    int opcao = 0;
                    do{
                        
                        System.out.println("Escolha uma acao a realizar: \n 1 - Inserir uma Locomotiva\n 2 - Inserir um Vagao"+
                                "\n 3 - Remover o ultimo Item \n 4 - Listar as Locomotivas Livres \n 5 - Listar vagões Livres \n 6 - Encerrar a Edição");
                        try{     
                            opcao = lerOpcao(s);
                        }catch(java.util.InputMismatchException e){
                            System.out.println("Insera um caracter válido");
                        }
                        switch(opcao){
                            //inserir locomotiva
                            case 1:

                                System.out.println("Digite o id da locomotiva a ser adicionada ao Trem");
                                locomotiva = (Locomotiva) garagem.getElemento(lerOpcao(s));

                                if(locomotiva == null){ System.out.println("Locomotiva não localizada\n"); }

                                else if(trem.engataLocomotiva(locomotiva)){
                                    garagem.removeElemento(locomotiva);
                                    System.out.println("> "+trem);
                                    System.out.println("(Inserido) -> "+locomotiva.toString());
                                }else{
                                    System.out.println("Nao é possivel utilizar essa locomotiva\n");
                                }

                            break;
                            
                            //Insere Vagao
                            case 2:
                                System.out.println("Digite o id do Vagao a ser adicionada ao Trem:");
                                vagao = (Vagao) garagem.getElemento(lerOpcao(s));
                                
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
                                garagem.listarLocomotivas();
                                break;

                            //Listar todos os Vagões Livres
                            case 5:
                                System.out.println("\nListagem dos Vagoes Livres:\n");
                                garagem.listarVagoes();
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
                    
                    trem = garagemTrem.getTrem(lerOpcao(s));

                    if(trem==null) System.out.println("Trem não localizado!");

                }while(trem==null);

                System.out.println("> "+trem.toString());

                if(trem.removerTrem() && garagemTrem.removeTrem(trem)) System.out.println("(Removido Trem) -> "+trem);
                
                break;
            default:
                if(escolha != 0) System.out.println("Opção inválida!");
                break;
        }
        }while(escolha != 0);

        s.close();
        System.out.println("Encerrando o Programa...");
    }
}
