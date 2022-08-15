public class App {
    public static void main(String[] args) throws Exception {
        Baralho b = new Baralho();
        b.embaralha();

        Deque maoJ1 = new Deque();
        Deque maoJ2 = new Deque();

        while(b.getQtdadeCartas()>0){
            Carta cj1 = b.topo();
            Carta cj2 = b.topo();
            System.out.println("Carta do jogador 1: "+cj1.toString());;
            System.out.println("Carta do jogador 2: "+cj2.toString());
            if(cj1.eMaiorQue(cj2)){
                maoJ1.insereTopo(cj1);
                maoJ1.insereTopo(cj2);
                System.out.println("Jogador 1 levou tudo");
            }else{
                maoJ2.insereTopo(cj1);
                maoJ2.insereTopo(cj2);
                System.out.println("Jogador 2 levou tudo");
            }

            System.out.println("Mao do jogador 1: "+maoJ1.getQtdadeCartas());
            System.out.println("Mao do jogador 2: "+maoJ2.getQtdadeCartas());

        }

    }
}
